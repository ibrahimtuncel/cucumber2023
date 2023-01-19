package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.KeyFactorySpi;

public class Day15_C1_GoogleSearchStepDefinitions {
 // java kodlari step definition kismina gelecek
    GooglePage googlePage=new GooglePage();
 @Given("kullanici google sayfasindadir")
 public void kullanici_google_sayfasindadir() {
     Driver.getDriver().get(ConfigReader.getProperty("google_url"));
 }

 @Given("kullanici Iphone u arar")
    public void kullanici_ıphone_u_arar() {
    googlePage.googleSearch.sendKeys("Iphone"+ Keys.ENTER);
    }
    @Then("kullanici sonuclarda Iphone oldugunu verify eder")
    public void kullanici_sonuclarda_ıphone_oldugunu_verify_eder() {
    boolean title=Driver.getDriver().getPageSource().contains("Iphone");
        Assert.assertTrue(title);
    }
    @Then("kullanici application u kapatir.")
    public void kullanici_application_u_kapatir() {
    Driver.closeDriver();
    }

    @Given("kullanici caydanlik u arar")
    public void kullanici_caydanlik_u_arar() {
        googlePage.googleSearch.sendKeys("caydanlik"+ Keys.ENTER);
    }

    @Then("kullanici sonuclarda caydanlik oldugunu verify eder")
    public void kullanici_sonuclarda_caydanlik_oldugunu_verify_eder() {
        boolean title2=Driver.getDriver().getPageSource().contains("caydanlik");
        Assert.assertTrue(title2);
    }

    @Given("kullanici cicek'i arar")
    public void kullanici_cicek_i_arar() {
        googlePage.googleSearch.sendKeys("cicek"+ Keys.ENTER);
    }
    @Then("kullanici sonuclarda cicek oldugunu verify eder")
    public void kullanici_sonuclarda_cicek_oldugunu_verify_eder() {
        boolean title3=Driver.getDriver().getPageSource().contains("cicek");
        Assert.assertTrue(title3);
    }
    @Then("kullanici application kapatir")
    public void kullanici_application_kapatir() {

    }
    @Given("kullanici volkswagen'i arar")
    public void kullanici_volkswagen_i_arar() {
        googlePage.googleSearch.sendKeys("volkswagen"+ Keys.ENTER);
    }
    @Then("kullanici sonuclarda volkswagen oldugunu verify eder")
    public void kullanici_sonuclarda_volkswagen_oldugunu_verify_eder() {
        boolean title4=Driver.getDriver().getPageSource().contains("volkswagen");
        Assert.assertTrue(title4);

       // Driver.closeDriver();
    }

    @Given("kullanici {string} arar")
    public void kullanici_arar(String string) {

     googlePage.googleSearch.sendKeys(string+ Keys.ENTER);
    }
    @Then("kullanici sonuclarda {string} oldugunu verify eder")
    public void kullanici_sonuclarda_oldugunu_verify_eder(String string) {
        boolean title5=Driver.getDriver().getPageSource().contains(string);
        Assert.assertTrue(title5);
        }
   /*
    @Then("kullanici application kapatir")
    public void kullanici_application_kapatir() {
        Driver.closeDriver();
    }
    */








}
