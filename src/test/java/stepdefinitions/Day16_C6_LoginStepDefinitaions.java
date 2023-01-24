package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DefaultPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Day16_C6_LoginStepDefinitaions {
    LoginPage loginPage=new LoginPage();
    DefaultPage defaultPage=new DefaultPage();
    @Given("kullanici application sayfasindadir")
    public void kullanici_application_sayfasindadir() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));
        try{
            Thread.sleep(1000);
            loginPage.advancedLink.click();
            loginPage.proceedLink.click();
            Thread.sleep(1500);
        }catch (Exception e){
            System.out.println("Advanced Link gorunmedi");
        }

    }
    @Given("kullanici manager_id {string} girer")
    public void kullanici_manager_id_girer(String string) {
        loginPage.username.sendKeys(string);
    }
    @Given("kullanici manager_sifre {string} girer")
    public void kullanici_manager_sifre_girer(String string) {
       loginPage.password.sendKeys(string);
    }
    @Then("kullanici login buttonuna click eder")
    public void kullanici_login_buttonuna_click_eder() throws InterruptedException {
        loginPage.loginButton.click();
        Thread.sleep(2000);
    }

    @Then("kullanici {string} oldugunu very eder")
    public void kullanici_oldugunu_very_eder(String string) {
       Assert.assertEquals(defaultPage.hotelManagement.getText(),string);
    }
    /*@Then("kullanici application kapatir")
    public void kullanici_application_kapatir() {
        Driver.closeDriver();
    }*/

    @Given("kullanici admin_id {string} girer")
    public void kullanici_admin_id_girer(String string) {
       loginPage.username.sendKeys(string);
    }
    @Given("kullanici admin_sifre {string} girer")
    public void kullanici_admin_sifre_girer(String string) {
       loginPage.password.sendKeys(string);
    }

    @Given("kullanici applicationa excel admin ile login yapar")
    public void kullanici_applicationa_excel_admin_ile_login_yapar() {

    }
}
