package cars.details.tests;

		import cucumber.api.CucumberOptions;
		import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(format =
		{"pretty", "html:reports/CarsReport",
				"json:target/carsData.json"},tags={"@CarsVerification"},
		features="src/test/resources/")
public class TestRunner extends AbstractTestNGCucumberTests {

}