# cost-delivery
This is a simple application to demo a computation of delivery


# Pre-requisites
```
Spring Boot 2.0.0 or later
Java 11
Maven 3.0.0 or later
```

### Installing

Copy/clone this entire folder to your Spring/bin dir
For first time running:
```
mvn install
```
For creating executable JAR:
```
mvn package
```
To run locally, go to delivery dir and run (still depends on the snapshot version)

```
mvn clean install && java -jar target/cost-delivery-0.0.1-SNAPSHOT.jar
```

## Usage
This app has a configuration where you can set the price per priority and the url/api key to request for the voucher
```
app.priority_1.multiplicand - for weight exceeds 50kg, this is set to 0 for now so the price will be 0
app.priority_2.multiplicand= for priority 2 
app.priority_3.multiplicand= for priority 3
app.priority_4.multiplicand= for priority 4
app.priority_5.multiplicand= for priority 5
app.voucher_url= url to request
app.voucher_apikey= apikey that will be used on the voucher request
```

## Deployment

Run this command to create a jar file with all its dependencies
```
mvn package
```
