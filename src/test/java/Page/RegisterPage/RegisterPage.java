package Page.RegisterPage;

import Base.BasePage;
import Base.DataStore;
import Page.HomePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static Page.RegisterPage.RegisterPageElements.*;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public RegisterPage isRegisterPageOpen(){
        Assert.assertTrue(isDisplayed(nameTextBox) && isDisplayed(passwordTextBox));
        return this;
    }

    public RegisterPage fillRegisterData(String name,String surname,String email,String password){
        write(nameTextBox,name);
        DataStore.put("register_name",name);
        write(surnameTextBox,surname);
        DataStore.put("register_surname",surname);
        write(emailTextBox,email);
        DataStore.put("register_email",email);
        write(passwordTextBox,password);
        DataStore.put("register_password",password);
        return this;
    }

    public RegisterPage acceptServiceContract(){
        click(serviceContactLabel);
        click(acceptContractButton);
        return this;
    }

    public RegisterPage clickRegisterButton(){
        click(registerButton);
        return this;
    }

    public RegisterPage verifyNameErrorMessage(String message){
        String actualErrorMessage=getText(nameTextBoxErrorMessage);
        Assert.assertEquals(actualErrorMessage,message);
        return this;
    }

    public RegisterPage verifySurnameErrorMessage(String message){
        String actualErrorMessage=getText(surnameTextBoxErrorMessage);
        Assert.assertEquals(actualErrorMessage,message);
        return this;
    }

    public RegisterPage verifyEmailErrorMessage(String message){
        String actualErrorMessage=getText(emailTextBoxErrorMessage);
        Assert.assertEquals(actualErrorMessage,message);
        return this;
    }

    public RegisterPage verifyPasswordErrorMessage(String message){
        String actualErrorMessage=getText(passwordTextBoxErrorMessage);
        Assert.assertEquals(actualErrorMessage,message);
        return this;
    }


    public RegisterPage isUserRegisterSuccess(){
        String username=getText(usernameTextLabel);
        String name= (String) DataStore.get("register_name");
        String surname= (String) DataStore.get("register_surname");
        String exptectedUsername=name+" "+surname;
        Assert.assertTrue(exptectedUsername.equals(username));
        DataStore.put("register_username",username);
        return this;
    }

    public HomePage goToHomePage(){
        return new HomePage(driver,wait);
    }

}
