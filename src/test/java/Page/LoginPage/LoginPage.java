package Page.LoginPage;

import Base.BasePage;

import Page.HomePage.HomePage;
import Utils.CustomLogger;
import Utils.DataStore;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import static Page.LoginPage.LoginPageElements.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private CustomLogger logger = new CustomLogger(LoginPage.class);


    public LoginPage isLoginPageOpen(){
        Assert.assertTrue(isDisplayed(emailTextBox) && isDisplayed(passwordTextBox));
        logger.info("Login sayfası başarılı şekilde açıldı.");
        return this;
    }

    public LoginPage login(String email,String password){
        write(emailTextBox,email);
        DataStore.put("login_email",email);
        write(passwordTextBox,password);
        DataStore.put("login_password",email);
        click(loginButton);
        return this;
    }


}
