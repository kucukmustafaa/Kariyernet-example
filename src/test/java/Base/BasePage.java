package Base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static HashMap<String,String> dataList=new HashMap<>();

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void storeData(String key,String value) {
        dataList.put(key,value);
    }

    public String getData(String key){
        return dataList.get(key);
    }

    protected void click(By by){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        try {
            element.click();
            System.out.println(by.toString()+" elementine tiklandi.");
        }catch (Exception e){
            System.out.println(by.toString()+" elementine tiklanamadi.");
        }
    }

    protected void write(By by,String text){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        try {
            element.sendKeys(text);
            System.out.println(by.toString()+" elementine "+text+" degeri yazildi..");
        }catch (Exception e){
            System.out.println(by.toString()+" elementine "+text+ "degeri yazilmadi.");
        }
    }

    protected void enter(By by){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.sendKeys(Keys.ENTER);
    }


    protected void tab(By by){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.sendKeys(Keys.TAB);
    }

    protected void waitSeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
            System.out.println(seconds+" saniye bekleniyor.");
        } catch (Exception e){
            System.out.println("bekleme gerceklesmedi.");
        }
    }

    protected String getText(By by){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    protected WebElement getElement(By by){
        WebElement element=null;
        try {
            element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            e.printStackTrace();
        }
        return element;
    }

    protected void clickWithOnFocus(By by){
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        try {
            element.click();
            System.out.println(by.toString()+" elementine onFocus ile tiklandi.");
        }catch (Exception e){
            System.out.println(by.toString()+" elementine onFocus ile tiklanamadi.");
        }
    }

    protected List<WebElement> getElementList(By by){
        List<WebElement> elementList = null;
        try {
            elementList=this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            System.out.println(by.toString()+" elementin listesi geldi.");
        }catch (Exception e){
            System.out.println(by.toString()+" element listesi gelmedi..");
        }
        return elementList;
    }

    protected void hover(By by){
        Actions actions=new Actions(driver);
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        actions.moveToElement(element).build().perform();
    }

    protected String getPageTitle(){
        return driver.getTitle();
    }

    protected boolean isDisplayed(By by){
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
    }

    protected int getRandomNumber(int limit){
        Random random=new Random();
        int randomNumber=random.nextInt(limit);
        return randomNumber;
    }

    protected void changeWindow(int windowNumber){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(windowNumber));
    }

    protected void doubleClick(By by){
        Actions actions=new Actions(driver);
        WebElement element=this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        try {
            actions.doubleClick(element).perform();
            System.out.println(by.toString()+" elementine tiklandi.");
        }catch (Exception e){
            System.out.println(by.toString()+" elementine tiklanamadi.");
        }
    }











}
