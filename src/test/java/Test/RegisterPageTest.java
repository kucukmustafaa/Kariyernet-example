package Test;

import Base.BaseTest;
import Page.HomePage.HomePage;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @Test(groups = {"regression","smoke"},description = "Başarılı üyelik oluşturma")
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


    @Test(groups = {"regression","smoke"},description = "Üyeliği bulunan mail adresi ile tekrar üye olma")
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


    @Test(groups = {"regression"},description = "Input alanlarının min karakter uzunluğu kontrolü")
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


    @Test(groups = {"regression"},description = "Input alanlarının max karakter uzunluğu kontrolü")
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

    @Test(groups = {"regression"},description = "Zorunlu Input alanları kontrolü")
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


    @Test(groups = {"regression"},description = "Kullanıcı üye olduktan sonra sistemden çıkıp  tekrardan login olması")
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





    @Test(groups = {"regression"},description = "Kullanıcının sadece zorunlu alanları doldurarak başarılı kayıt kontrolü")
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

    @Test(groups = {"regression"},description = "Geçersiz karakter içeren eposta ile üye olma")
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


    @Test(groups = {"regression"},description = "Geçersiz formatta eposta ile üye olma")
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

    @Test(groups = {"regression"},description = "Geçersiz karakter içeren eposta ile üye olma")
    public void test10() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                fillRegisterData("ali","veli","kariyer34random1234@gmail.com","Kariyer123").
                acceptServiceContract().
                clickRegisterButton();
    }




    @Test(groups = {"regression"},description = "Hizmet sözleşmesi ve popupları ve checkboxları kontrolü")
    public void test11() {

        new HomePage(getDriver(),wait).
                closePopup().
                goToRegisterPage().
                isRegisterPageOpen().
                isUserRegisterSuccess();

    }




}
