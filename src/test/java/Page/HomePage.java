package Page;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    final By notificationPopupCloseButton=By.cssSelector("div[class='vl-close']");
    final By toRegisterPageButton=By.cssSelector("a[href='https://www.kariyer.net/aday/uyeol']");
    final By toLoginPageButton=By.cssSelector("a[href='https://www.kariyer.net/aday/uyeol']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public RegisterPage gotoLoginPage(){
        //click(notificationPopupCloseButton);
        return new RegisterPage(driver,wait);
    }



}
