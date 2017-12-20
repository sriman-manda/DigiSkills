package cars.details.tests;

import data.operations.FilesDataStore;
import data.operations.ReadFiles;
import dvla.page.objects.ConfirmDetailsPage;
import dvla.page.objects.HomePage;
import framework.CarDataStructure;
import framework.EventBrowser;
import framework.FilesOperations;
import framework.SeleniumCommands;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Guice;
import com.google.inject.Inject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;

@Guice
public class CarsTestsImplementation {

	@Inject HomePage hp;
	@Inject EventBrowser eb;
	@Inject SeleniumCommands sc;
	@Inject ReadFiles rf;
	@Inject ConfirmDetailsPage cdp;
	@Inject	FilesOperations fo;

	private static List<CarDataStructure> allCarsData = new ArrayList<>();
	private static List<String> errors = new ArrayList<>();
	private static Scenario scenario;

	@Before
	public void beforeScenario(Scenario scenario) {
		this.scenario = scenario;
	}


	@Given("^I read all files from path \"([^\"]*)\" with \"([^\"]*)\" extension$")
	public void readAllFilesFromPath(String filesPath, String fileType) {
		List<FilesDataStore> fd = rf.getFilesDetailsByExtension(fileType, filesPath);
		for(int i = 0; i < fd.size(); i++) {
			List<CarDataStructure> carDetailsFromOneFile = fo.getCarsDetailsFromExcellFile(fd.get(i).getFilePath());
			for(int j = 0; j < carDetailsFromOneFile.size(); j++) {
				allCarsData.add(carDetailsFromOneFile.get(j));
			}
		}
		Assert.assertTrue(allCarsData.size() > 0, "No car details have been found!");
	}


	@When("^I compare on DVLA website by registration number$")
	public void compareDVLAWebsiteByRegistrationNumber() {
		for(int i = 0; i < allCarsData.size(); i++) {

			String carColour = allCarsData.get(i).getColour();
			String registrationNumber = allCarsData.get(i).getRegistrationNumber();
			String carMake = allCarsData.get(i).getMake();

			typeCarDetails(registrationNumber);
			scenario.write("Verify car with registration number: " + registrationNumber);

			if (!cdp.getColour().equalsIgnoreCase(carColour)) {
				String colourError = "Colour does not match, file value: " + carColour + " and DVLA: " + cdp.getColour();
				errors.add(registrationNumber + ": " + colourError);
				scenario.write(colourError);
			}

			if (!cdp.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
				String registrationNumberError = "Registration Number does not match, file value: " + registrationNumber + " and DVLA: " + cdp.getRegistrationNumber();
				errors.add(registrationNumberError);
				scenario.write(registrationNumber);
			}

			if (!cdp.getMake().equalsIgnoreCase(carMake)) {
				String makeError = "Make Number does not match, file value: " + carMake + " and DVLA: " + cdp.getMake();
				errors.add(registrationNumber + ": " + makeError);
				scenario.write(makeError);
			}
			scenario.embed(sc.getScreenShot(), "image/png");
		}
	}


	@Then("^The details should match$")
	public void verifyDetailsMatch() {
		Assert.assertTrue(errors.size() == 0,
				"Unmatched data found, verify the generated report!");
	}


	@After
	public void finish(Scenario scenario) {
		for(int i = 0; i < errors.size(); i++) {
			scenario.write(errors.get(i));
		}
	}


	private void typeCarDetails(String registrationNumber) {
		hp.get();
		hp.typeRegitrationNumber(registrationNumber);
		hp.clickContinueButton();
	}
}
