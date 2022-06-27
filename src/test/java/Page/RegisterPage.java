package Page;

import Base.BasePage;

import Utils.CustomLogger;
import Utils.DataStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By nameTextBox=By.id("name");
    private final By surnameTextBox=By.id("lastName");
    private final By emailTextBox=By.id("email");
    private final By passwordTextBox=By.id("password");
    private final By serviceContactLabel=By.cssSelector("label[class='style-checkbox serviceContactLabel']");

    private final By serviceContactCheckBox=By.id("serviceContact");

    private final By acceptContractButton=By.id("btnModalYesCallback");
    private final By registerButton=By.xpath("//button[contains(@class,'btn-submit')]");

    private final By nameTextBoxErrorMessage=By.id("name-error");
    private final By surnameTextBoxErrorMessage=By.id("lastName-error");
    private final By emailTextBoxErrorMessage=By.id("email-error");
    private final By passwordTextBoxErrorMessage=By.id("password-error");

    private final By usernameTextLabel=By.cssSelector("div[class='name']>a>span");
    private final By exitButton=By.xpath("//div[@class='after-login']//a[text()='Çıkış']");



    private CustomLogger logger = new CustomLogger(RegisterPage.class);


    public RegisterPage isRegisterPageOpen(){
        Assert.assertTrue(isDisplayed(nameTextBox) && isDisplayed(passwordTextBox));
        logger.info("Üye kayıt sayfası başarılı şekilde açıldı.");
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
        logger.info("isim alanında hata mesajı başarılı şekilde çıkmıştır.");
        return this;
    }

    public RegisterPage verifySurnameErrorMessage(String message){
        String actualErrorMessage=getText(surnameTextBoxErrorMessage);
        Assert.assertEquals(actualErrorMessage,message);
        logger.info("soyisim alanında hata mesajı başarılı şekilde çıkmıştır.");
        return this;
    }

    public RegisterPage verifyEmailErrorMessage(String message){
        String actualErrorMessage=getText(emailTextBoxErrorMessage);
        Assert.assertEquals(actualErrorMessage,message);
        logger.info("email alanında hata mesajı başarılı şekilde çıkmıştır.");
        return this;
    }

    public RegisterPage verifyPasswordErrorMessage(String message){
        String actualErrorMessage=getText(passwordTextBoxErrorMessage);
        Assert.assertEquals(actualErrorMessage,message);
        logger.info("şifre alanında hata mesajı başarılı şekilde çıkmıştır.");
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

    public HomePage goToHomePage(){;
        return new HomePage(driver,wait);
    }

}
