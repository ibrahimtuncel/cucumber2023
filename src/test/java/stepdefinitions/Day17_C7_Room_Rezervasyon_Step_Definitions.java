package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.DefaultPage;
import pages.LoginPage;
import pages.RoomReservationPage;

import java.util.List;

public class Day17_C7_Room_Rezervasyon_Step_Definitions {
    LoginPage loginPage=new LoginPage();
    DefaultPage defaultPage=new DefaultPage();
    RoomReservationPage roomReservationPage=new RoomReservationPage();

    @Given("kullanici manager kullanici bilgilerini girer")
    public void kullanici_manager_kullanici_bilgilerini_girer(DataTable kullaniciBilgileri) {
    List<String>menajerkullaniciBilgileri =kullaniciBilgileri.row(1);
        //System.out.println(menajerkullaniciBilgileri);
        System.out.println(menajerkullaniciBilgileri.get(0));
        System.out.println(menajerkullaniciBilgileri.get(1));
        loginPage.username.sendKeys(menajerkullaniciBilgileri.get(0));
        loginPage.password.sendKeys(menajerkullaniciBilgileri.get(1));
    }
    @Given("kullanıcı oda rezervasyon sayfasını yönlendirilir")
    public void kullanıcı_oda_rezervasyon_sayfasını_yönlendirilir() {
        defaultPage.hotelManagement.click();
        defaultPage.roomReservation.click();
        roomReservationPage.addReservationRoom.click();
    }
    @Given("kullanıcı tum zorunlu alanları girer")
    public void kullanıcı_tum_zorunlu_alanları_girer(DataTable roomData) {
        List<String> testData = roomData.row(1);
        System.out.println(testData);

        Select select1 = new Select(roomReservationPage.IDHotelDropDown);
        select1.selectByVisibleText(testData.get(0));

        Select select2 = new Select(roomReservationPage.IDHotelRoomDropDown);
        select2.selectByVisibleText(testData.get(1));

        roomReservationPage.Price.sendKeys(testData.get(2));
        roomReservationPage.dateStart.sendKeys(testData.get(3));
        roomReservationPage.dateEnd.sendKeys(testData.get(4));
        roomReservationPage.adultAmount.sendKeys(testData.get(5));
        roomReservationPage.childAmount.sendKeys(testData.get(6));
        roomReservationPage.nameSurname.sendKeys(testData.get(7));
        roomReservationPage.phone.sendKeys(testData.get(8));
        roomReservationPage.email.sendKeys(testData.get(9));
        roomReservationPage.notes.sendKeys(testData.get(10));
    }
        @Given("kullanıcı approved checkbox’a click eder")
        public void kullanıcı_approved_checkbox_a_click_eder() {
            roomReservationPage.isApproved.click();
        }
        @Given("kullanıcı paid check box’a click eder")
        public void kullanıcı_paid_check_box_a_click_eder() {
            roomReservationPage.isPaid.click();
        }
        @Given("kullanıcı save button’una click eder")
        public void kullanıcı_save_button_una_click_eder() {
            roomReservationPage.saveButton.click();
        }
         @Then("kullanıcı success mesajını verify eder")
         public void kullanıcı_success_mesajını_verify_eder() throws InterruptedException {
        String mesaj=roomReservationPage.successMessage.getText();
        System.out.println(mesaj);
        //Assert.assertTrue(mesaj.contains("inserted successfully"));
        Assert.assertTrue(roomReservationPage.successMessage.isDisplayed());

        //???? Assert.assertEquals(mesaj,testData.get(11));
             Thread.sleep(2000);

        roomReservationPage.okButton.click();

    }

    }



