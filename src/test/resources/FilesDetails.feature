@FilesVerification
Feature: Read files from a folder and store file details

  @ReadAllFiles
  Scenario: Read all files from a folder and write a report with files details
    Given I read all files from path "src/main/resources/carsDataFiles"
    Then A report is created with all received details


  @FilesMimeType
  Scenario: I want to retreive all files which are suported by a mime type
    Given I read all files from path "src/main/resources/carsDataFiles"
    When I filter the files based on supported mime type "text/plain"
    Then A report is created listing only the supported files