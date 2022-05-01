package Page.RegisterPage;

import org.openqa.selenium.By;

public class RegisterPageElements {

    public final static By nameTextBox=By.id("name");
    public final static By surnameTextBox=By.id("lastName");
    public final static By emailTextBox=By.id("email");
    public final static By passwordTextBox=By.id("password");
    public final static By serviceContactLabel=By.cssSelector("label[class='style-checkbox serviceContactLabel']");
    public final static By serviceContactCheckBox=By.id("serviceContact");

    public final static By acceptContractButton=By.id("btnModalYesCallback");
    public final static By registerButton=By.xpath("//button[contains(@class,'btn-submit')]");

    public final static By nameTextBoxErrorMessage=By.id("name-error");
    public final static By surnameTextBoxErrorMessage=By.id("lastName-error");
    public final static By emailTextBoxErrorMessage=By.id("email-error");
    public final static By passwordTextBoxErrorMessage=By.id("password-error");

    public final static By usernameTextLabel=By.cssSelector("div[class='name']>a>span");
    public final static By exitButton=By.xpath("//div[@class='after-login']//a[text()='Çıkış']");






}
