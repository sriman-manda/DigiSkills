package dvla.page.objects;

import com.google.inject.Inject;
import framework.EventBrowser;
import framework.SeleniumCommands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class ConfirmDetailsPage extends LoadableComponent<ConfirmDetailsPage> {
    private final WebDriver driver;
    private static final String URL = "https://vehicleenquiry.service.gov.uk/ConfirmVehicle";
    @Inject SeleniumCommands sc;

    @FindBy(css = ".reg-mark") private WebElement registrationNumberElement;
    @FindBy (css = "ul[class='list-summary margin-bottom-2'] li+li strong") private WebElement makeElement;
    @FindBy (css = "ul[class='list-summary margin-bottom-2'] li+li+li strong") private WebElement colourElement;

    @Inject
    public ConfirmDetailsPage(EventBrowser driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        sc.waitForElementToBeDisplayed(registrationNumberElement, 5);
    }

    @Override
    protected void isLoaded() {
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(URL),
                "Wrong URL was loaded, expected: " + URL + " Actual: " + driver.getCurrentUrl());
    }


    public String getRegistrationNumber() {
        return registrationNumberElement.getText();
    }


    public String getMake() {
        return makeElement.getText();
    }


    public String getColour() {
        return colourElement.getText();
    }
}
