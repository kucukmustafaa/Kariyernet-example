package Page.LoginPage;

import Base.BasePage;
import Base.DataStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import static Page.LoginPage.LoginPageElements.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LoginPage isLoginPageOpen(){
        Assert.assertTrue(isDisplayed(emailTextBox) && isDisplayed(passwordTextBox));
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
