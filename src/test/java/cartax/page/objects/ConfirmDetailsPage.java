package cartax.page.objects;

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
    private static String regNumber = null;
    private String URL = "https://cartaxcheck.co.uk/free-car-check/?vrm=";
    @Inject SeleniumCommands sc;

    @FindBy (xpath = "//dt[contains(text(),'Registration')]//following-sibling::dd") private WebElement registrationNumberElement;
    @FindBy (xpath = "//dt[contains(text(),'Make')]//following-sibling::dd") private WebElement makeElement;
    @FindBy (xpath = "//dt[contains(text(),'Colour')]//following-sibling::dd") private WebElement colourElement;
    @FindBy (xpath = "//dt[contains(text(),'Model')]//following-sibling::dd") private WebElement modelElement;

    @Inject
    public ConfirmDetailsPage(EventBrowser driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Override
    protected void load() {
        driver.get(URL + regNumber);
        sc.waitForTitleToBeDisplayed(regNumber, 5);
    }


    @Override
    protected void isLoaded() {
        Assert.assertTrue(driver.getCurrentUrl().equals(URL + regNumber),
                "Wrong URL was loaded, expected: " + URL + " Actual: " + driver.getCurrentUrl());
    }

    public void setUrl(String regNumber) {
        this.regNumber = regNumber;
    }
    public String getRegistrationNumber() {
        sc.waitForElementToBeDisplayed(registrationNumberElement, 5);
        return registrationNumberElement.getText();
    }

    public String getMake() {
        sc.waitForElementToBeDisplayed(makeElement, 5);
        return makeElement.getText();
    }

    public String getColour() {
        sc.waitForElementToBeDisplayed(colourElement, 5);
        return colourElement.getText();
    }

    public String getModel() {
        sc.waitForElementToBeDisplayed(modelElement, 5);
        return modelElement.getText();
    }
}
