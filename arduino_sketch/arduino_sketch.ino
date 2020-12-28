
#include <LiquidCrystal.h>
#include <Servo.h>
#include <ArduinoJson.h>

LiquidCrystal lcd(50, 51, 10, 11, 12, 13);

const size_t CAPACITY = JSON_OBJECT_SIZE(10);

StaticJsonDocument<CAPACITY> document;

//ultrasonic sensor
const String utrDataType = "water_level";
const String utrSensorId = "SNSR_009";
//flow rate sensor
const String frtDataType = "flow_rate";
const String frtSensorId = "SNSR_003";

//struct for holding tramnsmission data
struct TransmissionData {double sensorReading; bool alarmStatus; int damnStatus; String dataType; String sensorId;};

const int ledGreenPin = 3;
const int ledRedPin = 4;

const int authBtnPin = 5;

const int utrEchoPin = 6;
const int utrTriggerPin = 7;

const int frtPin = 2;
volatile int pulseCount; 

const int motorPin = 8;

const int buzzerPIn = 9;

const unsigned long buzzerDuration = 3000;

const double crticalWaterLevel = 10.0;

int iterations = 1;

Servo motorInstance; 

void setup() {

 Serial.begin(9600);
 Serial1.begin(9600);

 initializeComponents();

}

void loop() {

 //default LED indicator level setting
 triggerIndicators(0, HIGH);
 triggerIndicators(1, LOW);

 //detect water level
 observeWaterLevel();

 delay(2000);

//detect flow rate
 //observeWaterLeakage();

 delay(5000);

 //reset iterations
 resetIteration();

}

//initializing all connected components
void initializeComponents() {

 Serial.println("Initializing Components...");

 initializeIndicators();
 initializeAuthButton();
 initializeLcdDisplay();
 initializeSonar();
 initializeBuzzer();
 //initializeFlowRateSensor();

}

//initializing the LED indicators
void initializeIndicators() {

  Serial.println("Initializing LED Indicators...");

  pinMode(ledRedPin, OUTPUT);
  pinMode(ledGreenPin, OUTPUT);
  
}

//controlling LED indicators
void triggerIndicators(int indicator, int status) {

  if(indicator == 0) {

    digitalWrite(ledGreenPin, status);
    
  } else if(indicator == 1) {

    digitalWrite(ledRedPin, status);
  }
}

//initializing the push button
void initializeAuthButton() {

  Serial.println("Initializing Authentication Button...");

  pinMode(authBtnPin, INPUT);
  
}

//get push button state
int getAuthButtonState() {

  return digitalRead(authBtnPin);
}

//initializing the Ultrasonic sensor
void initializeSonar() {

 Serial.println("Initializing Sonar Sensor...");

 pinMode(utrTriggerPin, OUTPUT);
 pinMode(utrEchoPin, INPUT);
 
}

//observe water level in the water stream
void observeWaterLevel() {

  Serial.println("Observing water Level...");

  unsigned long timeTaken;
  double distance;
  double total = 0;

  //multiple ultrasonic readings and calculating the average
  while(iterations <= 5) {

    digitalWrite(utrTriggerPin, HIGH);
  
    delayMicroseconds(10);
  
    digitalWrite(utrTriggerPin, LOW);
  
    timeTaken = pulseIn(utrEchoPin, HIGH);

    distance = (timeTaken * 0.034)/2;

    Serial.println("Water Level Reading " + String(iterations) + " : " + String(distance, 6)); 

    //iterative distance
    total = total + distance; 

    iterations++;

    delay(1000);
    
  }

  //average ultrasonic reading
  total = total/5.0; 

  Serial.println("Average Water Level = " + String(total, 6));

  lcdDisplay(total, 0);

  //send data to NodeMCU
  assembleAndTransmitNodeMcu({total, false, -1, utrDataType, utrSensorId});

  //exceed critical water level
  if(total <= crticalWaterLevel) {

    //green led off
    triggerIndicators(0, LOW);
    
    //red led on
    triggerIndicators(1, HIGH);
    
    buzzerWarning();
    
    lcdDisplay(total, 1);

    Serial.println("Waiting for user permission to proceed!");

    //send data to NodeMCU
    assembleAndTransmitNodeMcu({total, true, 0, utrDataType, utrSensorId});

    //waiting for the user input
    while(true) {

      if(getAuthButtonState() == HIGH) {

        Serial.println("User Permission Granted!");

        //turn motor on
        triggerMotor(45);

        triggerIndicators(1, LOW);
        triggerIndicators(0, HIGH);

        //send data to NodeMCU
        assembleAndTransmitNodeMcu({total, true, 1, utrDataType, utrSensorId});

        break;
        
      }
      
    }
    
  }
   
}

//reset iteration level for the ultrasonic readings
void resetIteration() {

  Serial.println("Resetting Iteration Level...");

   iterations = 1;
}

//initializing the Buzzer
void initializeBuzzer(){

  Serial.println("Initializing Buzzer...");

  pinMode(buzzerPIn, OUTPUT);
  
}


//functioning the Buzzer
void buzzerWarning() {

  Serial.println("Triggering Buzzer!");
    
  tone(buzzerPIn, 3000, buzzerDuration);     
  
}

//initializing the LCD display
void initializeLcdDisplay() {

  Serial.println("Initializing LCD Display...");

  lcd.begin(16, 2);
  
  lcd.print("Detecting Water Level...");
}

//functioning the LCD  display
void lcdDisplay(double total, int state) {

  Serial.println("Invoking LCD Display...");

  lcd.clear();

  if(state == 0) {

    lcd.setCursor(0, 0);
    lcd.print("Water Level");
    lcd.setCursor(0, 1);
    lcd.print(total);

    
  } 
  else if (state == 1) {

    lcd.setCursor(0, 0);
    lcd.print("Critical Level");
    lcd.setCursor(0, 1);
    lcd.print(total);
  }
  
}

//functioning the Motor
void triggerMotor(int rotationSpeed) {

  Serial.println("Functioning Motor...");

  motorInstance.attach(motorPin);

  motorInstance.write(rotationSpeed);

  delay(500);

  motorInstance.detach();
  
}

//send data to NodeMCU
void assembleAndTransmitNodeMcu(TransmissionData transmissionData){

  JsonObject requestBody = document.to<JsonObject>();

  if(transmissionData.dataType == utrDataType) {

    requestBody["dataType"] = transmissionData.dataType;
    requestBody["sensorId"] = transmissionData.sensorId;
    requestBody["waterLevel"] = transmissionData.sensorReading;
    requestBody["alarmStatus"] = transmissionData.alarmStatus;
    requestBody["damnStatus"] = transmissionData.damnStatus;
  }
  else {

    requestBody["dataType"] = transmissionData.dataType;
    requestBody["sensorId"] = transmissionData.sensorId;
    requestBody["flowRate"] = transmissionData.sensorReading;
    requestBody["alarmStatus"] = transmissionData.damnStatus;
  }

  Serial.print("data to be transmitted to NodeMCU :: ");
  serializeJson(document, Serial);
  Serial.println();

  serializeJson(document, Serial1);
  
}

//initialize flow rate sensor
void  initializeFlowRateSensor() {

  Serial.println("Initializing FlowRate Sensor...");

  pinMode(frtPin, INPUT_PULLUP); 
  
  attachInterrupt(digitalPinToInterrupt(frtPin), pulseCounter, RISING); 
}


//observe water leakage
void observeWaterLeakage(){

  Serial.println("Observing Flow Rate...");
   
  pulseCount = 0;

  interrupts();
  
  delay(1000);
    
  noInterrupts();

  Serial.println("pulse count::::" + pulseCount);

  //calculating water flow rate in ml per minute
  double flowRate = (pulseCount * 2.22 * 60);

  Serial.println("flow rate::::" + String(flowRate, 6));

  /*if() {
    
  }*/
  
  //assembleAndTransmitNodeMcu({flowRate, false, -1, frtDataType, frtSensorId});

}

void pulseCounter() {
    pulseCount++;
}
