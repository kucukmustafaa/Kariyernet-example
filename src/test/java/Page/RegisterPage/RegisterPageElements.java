package Page.RegisterPage;

import org.openqa.selenium.By;

public class RegisterPageElements {

    public final static By nameTextBox=By.id("name");
    public final static By surnameTextBox=By.id("lastName");
    public final static By emailTextBox=By.id("email");
    public final static By passwordTextBox=By.id("password");
    public final static By serviceContactCheckBox=By.cssSelector("label[class='style-checkbox serviceContactLabel']");
    public final static By communicationContractCheckBox=By.id("communicationContract");
    public final static By explicitConsentContractCheckBox=By.id("explicitConsentContract");
    public final static By acceptContractButton=By.id("btnModalYesCallback");
    public final static By registerButton=By.xpath("//button[contains(@class,'btn-submit')]");


}
