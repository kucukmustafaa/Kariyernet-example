package Page;

import Base.BasePage;

import Utils.CustomLogger;
import Utils.DataStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public final By emailTextBox=By.id("username");
    public final By passwordTextBox=By.id("pass");
    public final By rememberMeButton=By.cssSelector("input[data-test='remember-me-checkbox']");
    public final By loginButton=By.cssSelector("button[data-test='login-button']");


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
