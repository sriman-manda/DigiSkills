$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CarsVerifications.feature");
formatter.feature({
  "line": 2,
  "name": "Compare cars details from files against website",
  "description": "",
  "id": "compare-cars-details-from-files-against-website",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CarsVerification"
    }
  ]
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 4,
      "value": "#  Scenario: Read cars details from excell files and assert with website"
    },
    {
      "line": 5,
      "value": "#    Given I read all files from path \"src/main/resources/carsDataFiles\" with \"xlsx\" extension"
    },
    {
      "line": 6,
      "value": "#    When  I compare on DVLA website by registration number"
    },
    {
      "line": 7,
      "value": "#    Then The details should match"
    }
  ],
  "line": 9,
  "name": "Compare car details",
  "description": "",
  "id": "compare-cars-details-from-files-against-website;compare-car-details",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "I read registration details from \u003cactualCarDetails\u003e and verify match against \u003cexpectedCardetails\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I compare the details on cartaxcheck website",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "The details should match",
  "keyword": "Then "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "compare-cars-details-from-files-against-website;compare-car-details;",
  "rows": [
    {
      "cells": [
        "actualCarDetails",
        "expectedCardetails"
      ],
      "line": 15,
      "id": "compare-cars-details-from-files-against-website;compare-car-details;;1"
    },
    {
      "cells": [
        "src/main/resources/carsDataFiles/car_in.txt",
        "src/main/resources/carsDataFiles/car_output.txt"
      ],
      "line": 16,
      "id": "compare-cars-details-from-files-against-website;compare-car-details;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2017492693,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Compare car details",
  "description": "",
  "id": "compare-cars-details-from-files-against-website;compare-car-details;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@CarsVerification"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I read registration details from src/main/resources/carsDataFiles/car_in.txt and verify match against src/main/resources/carsDataFiles/car_output.txt",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I compare the details on cartaxcheck website",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "The details should match",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "src/main/resources/carsDataFiles/car_in.txt",
      "offset": 33
    },
    {
      "val": "src/main/resources/carsDataFiles/car_output.txt",
      "offset": 102
    }
  ],
  "location": "CarsTestsImplementation.readAllFilesFromPath(String,String)"
});
formatter.result({
  "duration": 142656785,
  "status": "passed"
});
formatter.match({
  "location": "CarsTestsImplementation.compareDVLAWebsiteByRegistrationNumber()"
});
formatter.write("Verify car with registration number: SG18HTN");
formatter.embedding("image/png", "embedded0.png");
formatter.write("Verify car with registration number: DN09HRM");
formatter.embedding("image/png", "embedded1.png");
formatter.write("Verify car with registration number: BW57BOF");
formatter.write("Colour does not match, file value: Black and Cartax: Red");
formatter.embedding("image/png", "embedded2.png");
formatter.write("Verify car with registration number: KT17DLX");
formatter.embedding("image/png", "embedded3.png");
formatter.result({
  "duration": 4996193466,
  "status": "passed"
});
formatter.match({
  "location": "CarsTestsImplementation.verifyDetailsMatch()"
});
formatter.result({
  "duration": 1023965,
  "error_message": "java.lang.AssertionError: Unmatched data found, verify the generated report! expected [true] but found [false]\n\tat org.testng.Assert.fail(Assert.java:96)\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\n\tat org.testng.Assert.assertTrue(Assert.java:44)\n\tat cars.details.tests.CarsTestsImplementation.verifyDetailsMatch(CarsTestsImplementation.java:89)\n\tat ✽.Then The details should match(CarsVerifications.feature:12)\n",
  "status": "failed"
});
formatter.write("BW57BOF: Colour does not match, file value: Black and Cartax: Red");
formatter.after({
  "duration": 612835,
  "status": "passed"
});
});