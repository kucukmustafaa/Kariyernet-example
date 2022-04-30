package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected String selectBrowser = "chrome";
    protected WebDriverWait wait;
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private String HUB_ADDRESS="http://localhost:4444/wd/hub";


    @BeforeMethod
    public void setup () throws MalformedURLException {
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
