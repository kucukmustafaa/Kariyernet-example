package Test;

import Base.BaseTest;
import Page.HomePage.HomePage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @Description("Başarılı üyelik oluşturma")
    @Test
    public void test1() {
        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","ali.veli@gmail.com","Kariyer34").
                acceptServiceContract().
                clickRegisterButton().
                isUserRegisterSuccess();
    }


    @Description("Üyeliği bulunan mail adresi ile tekrar üye olma ")
    @Test
    public void test2() {

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


    @Description("Input alanlarının min karakter uzunluğu kontrolü")
    @Test
    public void test3() {
        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("a","a","a","a").
                clickRegisterButton().
                verifyNameErrorMessage("Minumum 2 karakter giriniz").
                verifySurnameErrorMessage("Minumum 2 karakter giriniz").
                verifyEmailErrorMessage("Uygun E-posta adresi giriniz.").
                verifyPasswordErrorMessage("Şifren 8-20 karakter arasında olmalıdır. Büyük harf, küçük harf ve rakam içermelidir.");
    }


    @Description("Input alanlarının max karakter uzunluğu kontrolü")
    @Test
    public void test4() {
        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com","aaaDFS234aaaaaaaaaaaaaaaaaaaaaaaaaaaa").
                clickRegisterButton().
                verifyNameErrorMessage("Lütfen en fazla 20 karakter uzunluğunda bir değer giriniz.").
                verifySurnameErrorMessage("Lütfen en fazla 20 karakter uzunluğunda bir değer giriniz.").
                verifyEmailErrorMessage("Uygun E-posta adresi giriniz.").
                verifyPasswordErrorMessage("Şifren 8-20 karakter arasında olmalıdır. Büyük harf, küçük harf ve rakam içermelidir.");
    }

    @Description("Zorunlu Input alanları kontrolü")
    @Test
    public void test5() {
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


    @Description("Kullanıcı üye olduktan sonra sistemden çıkıp  tekrardan login olması")
    @Test
    public void test6() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","ali.veli3434@gmail.com","Kariyer34").
                acceptServiceContract().
                clickRegisterButton().
                isUserRegisterSuccess().
                goToHomePage();
    }





    @Description("Kullanıcının sadece zorunlu alanları doldurarak başarılı kayıt kontrolü")
    @Test
    public void test7() {
        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("Ali","Veli","ali.veli3434@gmail.com","4950Kariyer").
                acceptServiceContract().
                clickRegisterButton().
                isUserRegisterSuccess();

    }

    @Description("Geçersiz karakter içeren eposta ile üye olma")
    @Test
    public void test8() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","asf'^+'!'^!ASDA@kariyer.com","Kariyer34").
                acceptServiceContract().
                clickRegisterButton().
                isUserRegisterSuccess();
    }


    @Description("Geçersiz formatta eposta ile üye olma")
    @Test
    public void test9() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","kariyer@kariyer","Kariyer34").
                acceptServiceContract().
                clickRegisterButton().
                isUserRegisterSuccess().
                verifyEmailErrorMessage("Lütfen geçerli bir e-posta adresi giriniz.");

    }

    @Description("Geçersiz karakter içeren eposta ile üye olma")
    @Test
    public void test10() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","kariyer34random1234@gmail.com","Kariyer123").
                acceptServiceContract().
                clickRegisterButton();
    }




    @Description("Hizmet sözleşmesi ve popupları ve checkboxları kontrolü")
    @Test
    public void test11() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                isUserRegisterSuccess();

    }




}
