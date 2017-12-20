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
formatter.before({
  "duration": 1801888810,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Read cars details from excell files and assert with website",
  "description": "",
  "id": "compare-cars-details-from-files-against-website;read-cars-details-from-excell-files-and-assert-with-website",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I read all files from path \"src/main/resources/carsDataFiles\" with \"xlsx\" extension",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I compare on DVLA website by registration number",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "The details should match",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "src/main/resources/carsDataFiles",
      "offset": 28
    },
    {
      "val": "xlsx",
      "offset": 68
    }
  ],
  "location": "CarsTestsImplementation.readAllFilesFromPath(String,String)"
});
formatter.result({
  "duration": 1115581981,
  "status": "passed"
});
formatter.match({
  "location": "CarsTestsImplementation.compareDVLAWebsiteByRegistrationNumber()"
});
formatter.write("Verify car with registration number: LR09 UOA");
formatter.embedding("image/png", "embedded0.png");
formatter.write("Verify car with registration number: WM54 FDN");
formatter.embedding("image/png", "embedded1.png");
formatter.write("Verify car with registration number: BD55 FNU");
formatter.write("Colour does not match, file value: SILVER and DVLA: BLUE");
formatter.embedding("image/png", "embedded2.png");
formatter.write("Verify car with registration number: YJ63 ZGK");
formatter.embedding("image/png", "embedded3.png");
formatter.write("Verify car with registration number: CK64 GWJ");
formatter.embedding("image/png", "embedded4.png");
formatter.write("Verify car with registration number: CK64 GWJ");
formatter.write("Make Number does not match, file value: AUDI and DVLA: DACIA");
formatter.embedding("image/png", "embedded5.png");
formatter.result({
  "duration": 8311523654,
  "status": "passed"
});
formatter.match({
  "location": "CarsTestsImplementation.verifyDetailsMatch()"
});
formatter.result({
  "duration": 1158723,
  "error_message": "java.lang.AssertionError: Unmatched data found, verify the generated report! expected [true] but found [false]\n\tat org.testng.Assert.fail(Assert.java:96)\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\n\tat org.testng.Assert.assertTrue(Assert.java:44)\n\tat cars.details.tests.CarsTestsImplementation.verifyDetailsMatch(CarsTestsImplementation.java:92)\n\tat ✽.Then The details should match(CarsVerifications.feature:7)\n",
  "status": "failed"
});
formatter.write("BD55 FNU: Colour does not match, file value: SILVER and DVLA: BLUE");
formatter.write("CK64 GWJ: Make Number does not match, file value: AUDI and DVLA: DACIA");
formatter.after({
  "duration": 1255640,
  "status": "passed"
});
});