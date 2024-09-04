package udemysdetqa.dockerandselenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeStandaloneTest {
    public static void main(String[] args) throws MalformedURLException {
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

        // Initialize RemoteWebDriver with hub URL and capabilities
        RemoteWebDriver driver = new RemoteWebDriver(hubUrl, capabilities);

        // Navigate to a website
        driver.get("https://guru99.com");
        String title = driver.getTitle();
        System.out.println(title);

        // Perform actions and validate the behavior

        // Close the browser
        driver.quit();

        //TODO Solve error on runtime. Chrome driver crashes.
        //Try to run the code after updating the docker image
    }


}
