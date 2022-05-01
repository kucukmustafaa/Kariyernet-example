package Page.HomePage;

import Base.BasePage;
import Page.RegisterPage.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.log4j.Logger;

import static Page.HomePage.HomePageElements.*;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private Logger logger = Logger.getLogger(HomePage.class);

    public HomePage closePopup(){
        logger.info("Ana sayfada popup kapatıldı.");
        return this;
    }

    public RegisterPage goToRegisterPage(){
        click(toRegisterPageButton);
        return new RegisterPage(driver,wait);
    }



}
