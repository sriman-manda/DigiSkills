@CarsVerification
Feature: Compare cars details from files against website

#  Scenario: Read cars details from excell files and assert with website
#    Given I read all files from path "src/main/resources/carsDataFiles" with "xlsx" extension
#    When  I compare on DVLA website by registration number
#    Then The details should match

    Scenario Outline: Compare car details
      Given I read registration details from <actualCarDetails> and verify match against <expectedCardetails>
      When I compare the details on cartaxcheck website
      Then The details should match

      Examples:
        | actualCarDetails                            | expectedCardetails                           |
        | src/main/resources/carsDataFiles/car_in.txt | src/main/resources/carsDataFiles/car_output.txt |
