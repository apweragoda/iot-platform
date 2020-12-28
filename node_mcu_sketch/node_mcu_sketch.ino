
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>

#include <ArduinoJson.h>

//network connection details
const char* ssid = "*****";
const char* password = "*****";

//seerver & REST endpoint details
const String host = "*****";
const String resourcePathWaterLevel = "/sensordata/waterlevel";
const String resourcePathFlowRate = "/sensordata/flowRate";

//json related properties
const size_t CAPACITY = JSON_OBJECT_SIZE(10);
StaticJsonDocument<CAPACITY> document;

void setup() {

  //initialize ESP8266 module
  initializeModule();
}

void loop() {

  //read and push data to server
  retrieveAndPushDataToServer();

  delay(10000);
}

//initialize ESP8266 module
void initializeModule() {

  Serial.begin(9600);

  Serial.println("initializing ESP8266 module...");

  WiFi.begin(ssid, password);

  Serial.println("connecting network...");

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.print("connected to WiFi network with IP address: ");
  Serial.println(WiFi.localIP());
}

//read and push data to server
void retrieveAndPushDataToServer(){

  retrieveSensorDataArduino();
}

//retrieve sensor data via Arduino
void retrieveSensorDataArduino() {

  if (Serial.available()) {

    String stream = Serial.readString();

    Serial.println("received via Arduino :: " + stream);

    if(validateWiFiStatus()) {

      //send data to server
      invokePostEndpoint(prepareEndpoint(stream), stream);
    }
    else {

      Serial.println("unable to connect WiFi network...");
    }
  }
  else {

    Serial.println("unable to read serial data via Arduino...");
  }
}

//check the Wifi connection status
boolean validateWiFiStatus() {

  if (WiFi.status() == WL_CONNECTED)
    return true;
  else
    return false;
}

//consume a POST endpoint
void invokePostEndpoint(String endpoint, String data) {

  Serial.println("invoking invokePostEndpoint(String endpoint, String data)...");

  HTTPClient http;

  http.begin(endpoint);

  //appending headers
  http.addHeader("Content-Type", "application/json");

  //invoking POST endpoint
  int httpResponseCode = http.POST(data);

  Serial.print("HTTP Response code: ");
  Serial.println(httpResponseCode);

  http.end();

  Serial.println("completed invoking invokePostEndpoint(String endpoint, String data)...");
}

//prepare & assemble POST enpoint
String prepareEndpoint(String stream) {

  Serial.println("invoking prepareEndpoint(String stream)...");

  String endpoint;

  deserializeJson(document, stream);

  if(document["dataType"] == "water_level") {

    endpoint = host + resourcePathWaterLevel;

    Serial.println("assembled endpoint::" + endpoint);

    return endpoint;

  }

  endpoint = host + resourcePathFlowRate;

  Serial.println("assembled endpoint::" + endpoint);
  Serial.println("completed invoking prepareEndpoint(String stream)...");

  return endpoint;
}
