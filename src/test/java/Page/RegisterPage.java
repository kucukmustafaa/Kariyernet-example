package Page;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {


    final By nameTextBox=By.id("name");
    final By surnameTextBox=By.id("lastName");
    final By emailTextBox=By.id("email");
    final By passwordTextBox=By.id("password");
    final By serviceContactCheckBox=By.id("serviceContact");
    final By communicationContractCheckBox=By.id("communicationContract");
    final By explicitConsentContractCheckBox=By.id("explicitConsentContract");
    final By acceptContractButton=By.id("btnModalYesCallback");

    final By registerTextBox=By.className("btn-submit btn-primary btn-lg btn-block btn");



    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public RegisterPage isRegisterPageOpen(){



        return this;
    }






}
