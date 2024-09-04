package udemysdetqa.dockerandselenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeStandaloneTest {
    // Test run successfully with this code
    //docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-chrome:latest

    private RemoteWebDriver driver;

    @Before
    public void init() throws MalformedURLException {
        // Define the URL of the Selenium Grid hub
        URL hubUrl = new URL("http://localhost:4444/wd/hub"); // Replace with your grid URL
        //URL hubUrl = new URL("https://172.17.0.2:4444/wd/hub");
        // Create ChromeOptions instance
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");

        // Create DesiredCapabilities instance for Chrome
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new RemoteWebDriver(hubUrl, capabilities);
    }
    @Test
    public void getTitle() {
        // Navigate to a website
        driver.get("https://guru99.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Guru99"));

        driver.quit();


    }


}
