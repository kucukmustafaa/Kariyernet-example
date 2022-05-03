package Page.HomePage;

import Base.BasePage;
import Page.RegisterPage.RegisterPage;
import Utils.CustomLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.log4j.Logger;

import static Page.HomePage.HomePageElements.*;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private CustomLogger logger = new CustomLogger(HomePage.class);


    public HomePage closePopup(){
        click(closePopupButton);
        logger.info("Ana sayfada popup kapatıldı.");
        return this;
    }

    public RegisterPage goToRegisterPage(){
        click(toRegisterPageButton);
        return new RegisterPage(driver,wait);
    }



}
