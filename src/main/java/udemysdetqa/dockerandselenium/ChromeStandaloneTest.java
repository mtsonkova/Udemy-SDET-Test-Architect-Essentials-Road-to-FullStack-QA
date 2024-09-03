package udemysdetqa.dockerandselenium;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeStandaloneTest {
    public static void main(String[] args) throws MalformedURLException {
        //RemoteWebDriver Class takes 2 paramenters
        //the url with the port where your tests are running
        //desired capabilities
        ChromeOptions chromeOptions = new ChromeOptions();
        //TODO Solve error Could not start a new session. Response code 500. Driver cannot start
        try {
            URL url = new URL("http://localhost:4444/wd/hub"); //wd stands for webdriver

            RemoteWebDriver driver = new RemoteWebDriver(url, chromeOptions);
            driver.get("https://www.guru99.com/");
            String title = driver.getTitle();
            System.out.println(title);

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
