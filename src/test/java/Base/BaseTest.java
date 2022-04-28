package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected String selectBrowser = "chrome";
    protected WebDriverWait wait;
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private String HUB_ADDRESS="http://localhost:4444/wd/hub";


    @BeforeMethod
    @Parameters(value={"browser"})
    public void setup (String browser) throws MalformedURLException {
        if (true){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(OptionsManager.getChromeOptions()));
            wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30));
            driver.get().get("https://www.kariyer.net/");

        }else {
            if (selectBrowser.equals("chrome")){
                driver.set(new RemoteWebDriver(new URL(HUB_ADDRESS), OptionsManager.getChromeOptions()));


            }else {
                driver.set(new RemoteWebDriver(new URL(HUB_ADDRESS), OptionsManager.getFirefoxOptions()));


            }

        }

    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {

        getDriver().quit();
    }

    @AfterClass
    void terminate () {
        driver.remove();
    }





}
