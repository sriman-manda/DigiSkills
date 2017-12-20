package dvla.page.objects;

import framework.SeleniumCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.google.inject.Inject;

import framework.EventBrowser;

public class HomePage extends LoadableComponent<HomePage> {

	private static final String URL = "https://vehicleenquiry.service.gov.uk/";
	private final WebDriver driver;
	@Inject SeleniumCommands sc;
	@Inject ConfirmDetailsPage cdp;
	@FindBy (css = "#Vrm") private WebElement regitrationNumberField;
	@FindBy (css = ".button") private WebElement continueButton;


	@Inject
	public HomePage(EventBrowser driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@Override
	protected void load() {
		driver.get(URL);
		sc.waitForElementToBeDisplayed(regitrationNumberField, 5);
	}


	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(URL),
				"Wrong URL was loaded, expected: " + URL + " Actual: " + driver.getCurrentUrl());
	}


	public void typeRegitrationNumber(String rgistrationNumber) {
		regitrationNumberField.clear();
		regitrationNumberField.sendKeys(rgistrationNumber);
	}


	public void clickContinueButton() {
		continueButton.click();
		cdp.get();
	}
}
