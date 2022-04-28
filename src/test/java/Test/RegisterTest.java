package Test;

import Base.BaseTest;
import Page.HomePage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {




    @Test
    public void test1() {
        new HomePage(getDriver(),wait).
                        gotoLoginPage().
                        isRegisterPageOpen();


    }



}
