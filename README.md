## Sample Project API

Simple project to create armies with aleatories troops.

This project is a maven project that uses Java 11 and the [Micronaut Framework](https://micronaut.io).

## Requirements
-   [Install the JDK 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html).
- Setup the JAVA_HOME environment variable.

## Start up application
Run the following command on the root directory: ./mvnw mn:run

## Availabe endpoints

### POST /army/factory/one

Used to create one Army

Payload: `{
    "name": "Army 01",
    "numberOfSoldiers": 1000
}`

### POST /army/factory/many

Used to create many Armies

Payload: `{
    "numberOfArmies": 100,
    "numberOfSoldiers": 1000
}`
