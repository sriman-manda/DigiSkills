package data.tests;

		import cucumber.api.CucumberOptions;
                import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(format =
        {"pretty", "html:reports/FilesReport",
                "json:target/filesData.json"},tags={"@FilesVerification"},
        features="src/test/resources/")
public class TestRunner extends AbstractTestNGCucumberTests {

}