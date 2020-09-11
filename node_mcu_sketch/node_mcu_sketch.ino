
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>

const char* ssid = "**********";
const char* password = "**********";

char* server = "http://**********/sensordata/waterlevel";

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
      invokePostEndpoint(server, stream);
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
void invokePostEndpoint(char* server, String data) {

  HTTPClient http;

  http.begin(server);

  //appending headers
  http.addHeader("Content-Type", "application/json");

  //invoking POST endpoint
  int httpResponseCode = http.POST(data);

  Serial.print("HTTP Response code: ");
  Serial.println(httpResponseCode);

  http.end();
}
