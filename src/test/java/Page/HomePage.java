package Page;

import Base.BasePage;
import Utils.CustomLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    private final By notificationPopupCloseButton=By.cssSelector("div[class='vl-close']");
    private final By toRegisterPageButton=By.cssSelector("a[href='https://www.kariyer.net/aday/uyeol']");
    private final By toLoginPageButton=By.cssSelector("a[href='https://www.kariyer.net/aday/uyeol']");
    private final By closePopupButton=By.xpath("//button[@title='Kapat']");

    private CustomLogger logger = new CustomLogger(HomePage.class);


    public HomePage closePopup(){
        click(closePopupButton);
        logger.info("Ana sayfada popup kapatıldı.");
        return this;
    }

    public RegisterPage goToRegisterPage(){
        click(toRegisterPageButton);
        return new RegisterPage(driver,wait);
    }



}
