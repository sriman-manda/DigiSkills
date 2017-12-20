# DVLAtest
## Prerequisites:
Linux/MAC,
Java 1.8,
Maven

### How to execute all tests:
#### mvn test

### Execute tests by tags:
#### mvn test -Dcucumber.options="--tags @FilesVerification"
#### mvn test -Dcucumber.options="--tags @  @CarsVerification"

### Cucumber reports are generated in the reports folder
#### Cars report contain a few intentioned errors
