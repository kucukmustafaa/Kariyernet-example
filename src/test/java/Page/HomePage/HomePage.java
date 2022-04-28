package Page.HomePage;

import Page.RegisterPage.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Page.HomePage.HomePageElements.*;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public HomePage closePopup(){
        click(closePopupButton);
        return this;
    }

    public RegisterPage goToRegisterPage(){
        click(toRegisterPageButton);
        return new RegisterPage(driver,wait);
    }



}
