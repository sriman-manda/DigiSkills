@CarsVerification
Feature: Compare cars details from files against website

  Scenario: Read cars details from excell files and assert with website
    Given I read all files from path "src/main/resources/carsDataFiles" with "xlsx" extension
    When  I compare on DVLA website by registration number
    Then The details should match
