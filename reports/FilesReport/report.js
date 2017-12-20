$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FilesDetails.feature");
formatter.feature({
  "line": 2,
  "name": "Read files from a folder and store file details",
  "description": "",
  "id": "read-files-from-a-folder-and-store-file-details",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@FilesVerification"
    }
  ]
});
formatter.before({
  "duration": 6069617,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Read all files from a folder and write a report with files details",
  "description": "",
  "id": "read-files-from-a-folder-and-store-file-details;read-all-files-from-a-folder-and-write-a-report-with-files-details",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@ReadAllFiles"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I read all files from path \"src/main/resources/carsDataFiles\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "A report is created with all received details",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "src/main/resources/carsDataFiles",
      "offset": 28
    }
  ],
  "location": "TestDataFiles.readAllFilesFromPath(String)"
});
formatter.result({
  "duration": 15937245,
  "status": "passed"
});
formatter.match({
  "location": "TestDataFiles.createReportWithAllReceivedDetails()"
});
formatter.write("Name   Extension   Size   Mime Type");
formatter.write("jpgFile      jpeg      8654      image/jpeg   ");
formatter.write("pdfFile      pdf      7945      application/pdf   ");
formatter.write("gifFile      gif      8704      image/gif   ");
formatter.write("docxFile      docx      21479      application/vnd.openxmlformats-officedocument.wordprocessingml.document   ");
formatter.write("CarsData1      xlsx      25874      application/vnd.openxmlformats-officedocument.spreadsheetml.sheet   ");
formatter.write("CarsData2      xlsx      25126      application/vnd.openxmlformats-officedocument.spreadsheetml.sheet   ");
formatter.write("gifFile2      gif      8704      image/gif   ");
formatter.write("csvFile      csv      27      text/plain   ");
formatter.write("CarsData3      xlsx      25258      application/vnd.openxmlformats-officedocument.spreadsheetml.sheet   ");
formatter.write("textFile      txt      1018      text/plain   ");
formatter.result({
  "duration": 3170439,
  "status": "passed"
});
formatter.before({
  "duration": 66445,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "I want to retreive all files which are suported by a mime type",
  "description": "",
  "id": "read-files-from-a-folder-and-store-file-details;i-want-to-retreive-all-files-which-are-suported-by-a-mime-type",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@FilesMimeType"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I read all files from path \"src/main/resources/carsDataFiles\"",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I filter the files based on supported mime type \"text/plain\"",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "A report is created listing only the supported files",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "src/main/resources/carsDataFiles",
      "offset": 28
    }
  ],
  "location": "TestDataFiles.readAllFilesFromPath(String)"
});
formatter.result({
  "duration": 16732055,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "text/plain",
      "offset": 49
    }
  ],
  "location": "TestDataFiles.filterFilesByMimeType(String)"
});
formatter.write("Supported files filtered by mime: text/plain");
formatter.result({
  "duration": 23627131,
  "status": "passed"
});
formatter.match({
  "location": "TestDataFiles.createReportWithSupportedFiles()"
});
formatter.write("csvFile.csv");
formatter.write("textFile.txt");
formatter.result({
  "duration": 1276320,
  "status": "passed"
});
});