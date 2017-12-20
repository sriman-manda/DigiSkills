package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class BrowserType {
    public static WebDriver createInstance(String browserName) {
        WebDriver driver;
        browserName = (browserName != null) ? browserName : "chrome";

        switch (Browser.valueOf(browserName.toUpperCase())) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                String hubURL = "http://localhost:4444/wd/hub";
                URL url = null;
                try {
                    url = new URL(hubURL);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    private static enum Browser {
        FIREFOX,
        CHROME,
        IE
    }
}
