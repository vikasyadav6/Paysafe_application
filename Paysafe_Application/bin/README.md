####################################
# Paysafe application for server monitoring
####################################


Application Requiremnts:

1. Send payload to server to start& stop 

Rest End Point : http://localhost:8080/golo/monitor

Data format:

{
"action" : "STOP",
"serverUrl" : "https://api.test.paysafe.com/accountmanagement/monitor",
"timeInterval" : "2000"
}

2. Gather all statistics related to application start and stop actions

Rest End Point : http://localhost:8080/golo/statistics

3. Spring Boot Actuator to monitor application

Rest End Point :  http://localhost:8080/health,  http://localhost:8080/trace
Technologies used:

1. Spring Boot
2. Rest Web Services

Tools required to run code:

1. IDE
2. Postman (To send http requests)
3. Java 1.8


  
