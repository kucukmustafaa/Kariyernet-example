package Test;

import Base.BaseTest;
import Page.HomePage.HomePage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {


    @Test
    public void test1() {


        new HomePage(getDriver(),wait).
                        closePopup().
                        goToRegisterPage().
                        isRegisterPageOpen().
                        fillRegisterData("","","","").
                        clickRegisterButton();

    }





}
