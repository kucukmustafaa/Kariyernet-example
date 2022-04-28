package Page.RegisterPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Page.RegisterPage.RegisterPageElements.*;

public class RegisterPage extends BasePage {


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public RegisterPage isRegisterPageOpen(){
        isDisplayed(nameTextBox);
        isDisplayed(passwordTextBox);
        return this;
    }

    public RegisterPage fillRegisterData(String name,String surname,String email,String password){
        write(nameTextBox,name);
        write(surnameTextBox,surname);
        write(emailTextBox,email);
        write(passwordTextBox,password);
        return this;
    }

    public RegisterPage acceptServiceContract(){
        click(serviceContactCheckBox);
        click(acceptContractButton);
        return this;
    }


    public RegisterPage clickRegisterButton(){
        doubleClick(registerButton);
        waitSeconds(10);
        return this;
    }









}
