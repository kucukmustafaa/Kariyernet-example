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
                clickRegisterButton().
                verifyNameErrorMessage("Adını yazmalısın.").
                verifySurnameErrorMessage("Soyadını yazmalısın.").
                verifyEmailErrorMessage("E-posta adresini yazmalısın.").
                verifyPasswordErrorMessage("Şifreni yazmalısın.");
    }


    @Test
    public void test2() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","ali.veli@gmail.com","Kariyer34").
                acceptServiceContract().
                clickRegisterButton();
    }




}
