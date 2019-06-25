# PHOTO ORGANIZER

The project allow organize photo data in file by date taken and location.

## Prerequisites
* Maven 3.3.9
* Java JDK 1.8
* Spring Boot 2.1.6

## Project
The photo-organizer project is composed by:

```
photo-organizer: Microservice based in SpringBoot that contain the logic and the rest service.
```

## Configuration 
Steps:
* Configure the file path in the property yuxi.settings.fileName in the file application.properties.
* Run the follow command from the root of the project:
 
```
mvn spring-boot:run
```

Test url:

```
http://localhost:8080/photos
```