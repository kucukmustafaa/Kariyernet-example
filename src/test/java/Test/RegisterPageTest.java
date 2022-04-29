package Test;

import Base.BaseTest;
import Page.HomePage.HomePage;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {


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
                clickRegisterButton().
                isUserRegisterSuccess();
    }

    @Test
    public void test3() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","ali.veli3434@gmail.com","Kariyer34").
                acceptServiceContract().
                clickRegisterButton().
                isUserRegisterSuccess();
    }
    @Test
    public void test4() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","ali.veli3434@gmail.com","Kariyer34").
                acceptServiceContract().
                clickRegisterButton().
                isUserRegisterSuccess().
                verifyEmailErrorMessage("E-Posta adresi başka bir hesap tarafından kullanılıyor.");

    }

    @Test
    public void test5() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","ali.veli3434@gmail.com","Kariyer34").
                acceptServiceContract().
                clickRegisterButton().
                isUserRegisterSuccess();

    }

}
