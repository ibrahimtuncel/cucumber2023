package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.DataTablePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class DataTablePageHomework {
    DataTablePage dataTablePage=new DataTablePage();
    @Given("When kullanıcı datatables adresine gider")
    public void when_kullanıcı_datatables_adresine_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("data_table_url"));
    }
    @Given("kullanıcı new button’a Click eder")
    public void kullanıcı_new_button_a_click_eder() {
    dataTablePage.newButton.click();
    }
    @Given("kullanici {string}  firstname girer")
    public void kullanici_firstname_girer(String firstname) {
    dataTablePage.firstName.sendKeys(firstname);
    }
    @Given("kullanici {string}  lastname girer")
    public void kullanici_lastname_girer(String string) {
        dataTablePage.lastName.sendKeys(string);
    }
    @Then("kullanici {string}  position girer")
    public void kullanici_position_girer(String string) {
    dataTablePage.position.sendKeys(string);
    }
    @Given("kullanici {string}  office girer")
    public void kullanici_office_girer(String string) {
        dataTablePage.office.sendKeys(string);
    }

    @Given("kullanici {string}  extension girer")
    public void kullanici_extension_girer(String string) {
    dataTablePage.extension.sendKeys(string);
    }
    @Given("kullanici {string}  start_date girer")
    public void kullanici_start_date_girer(String string) {
    dataTablePage.startDate.sendKeys(string);
    }
    @Given("kullanici {string}  salary girer")
    public void kullanici_salary_girer(String salary) {
    dataTablePage.salary.sendKeys(salary);
    }
    @When("kullanıcı create buttona click eder")
    public void kullanıcı_create_buttona_click_eder() {

        dataTablePage.createButton.click();
    }
    @When("kullanıcı {string} firstname arar")
    public void kullanıcı_firstname_arar(String firstName) {
    dataTablePage.searchBox.sendKeys(firstName+ Keys.ENTER);

    }
    @Then("name fields’in {string} firstname içerdiğini verify eder")
    public void name_fields_in_firstname_içerdiğini_verify_eder(String firstName) {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(firstName));
    }

    @When("kullanıcı tüm fields girer firstname verryf eder")
    public void kullanıcı_tüm_fields_girer_firstname_verryf_eder(DataTable dataTable) {
        /*List<String> dataTable1 = dataTable.row(1);
        System.out.println(dataTable1);
        dataTablePage.firstName.sendKeys(dataTable1.get(0));
        dataTablePage.lastName.sendKeys(dataTable1.get(1));
        dataTablePage.position.sendKeys(dataTable1.get(2));
        dataTablePage.office.sendKeys(dataTable1.get(3));
        dataTablePage.extension.sendKeys(dataTable1.get(4));
        dataTablePage.startDate.click();
        ReusableMethods.waitFor(2);
        dataTablePage.startDate.sendKeys(dataTable1.get(5));
        dataTablePage.salary.sendKeys(dataTable1.get(6));

        dataTablePage.searchBox.sendKeys(dataTable1.get(0)+ Keys.ENTER);
        ReusableMethods.waitFor(2);
        Assert.assertTrue(dataTablePage.nameField.getText().contains(dataTable1.get(0)));*/

        List<Map<String,String>> dataTable2=dataTable.asMaps(String.class,String.class);
        System.out.println(dataTable2);
        for(Map<String,String>dataBilgi:dataTable2){
            System.out.println(dataBilgi);
            dataTablePage.newButton.click();
            dataTablePage.firstName.sendKeys(dataBilgi.get("firstname"));
            dataTablePage.lastName.sendKeys(dataBilgi.get("lastname"));
            dataTablePage.position.sendKeys(dataBilgi.get("position"));
            dataTablePage.office.sendKeys(dataBilgi.get("office"));
            dataTablePage.extension.sendKeys(dataBilgi.get("extension"));
            dataTablePage.startDate.click();
            ReusableMethods.waitFor(1);
            dataTablePage.startDate.sendKeys(dataBilgi.get("start_date"));
            dataTablePage.salary.sendKeys(dataBilgi.get("salary"));
            dataTablePage.createButton.click();
            ReusableMethods.waitFor(1);
            dataTablePage.searchBox.sendKeys(dataBilgi.get("firstname")+Keys.ENTER);
            Assert.assertTrue(dataTablePage.nameField.getText().contains(dataBilgi.get("firstname")));
            ReusableMethods.waitFor(1);
            Driver.getDriver().navigate().refresh();
            ReusableMethods.waitFor(1);

        }
    }

    ExcelUtil excelUtil;
    List<Map<String, String>> testData;
    @Given("kullanıcı excel ile tum field girer verify yapar")
    public void kullanıcı_excel_ile_tum_field_girer_verify_yapar() {
        String path = "./src/test/resources/TestData/data_tables_homework.xlsx";
        String sheetName = "data_tables_sheet";
        excelUtil = new ExcelUtil(path, sheetName);

        testData = excelUtil.getDataList();
        System.out.println(testData);

        for (Map<String, String> eachData : testData) {//eachData represent each username-password pairs
            System.out.println(eachData);
            Driver.getDriver().get(ConfigReader.getProperty("data_table_url"));
            dataTablePage.newButton.click();
        dataTablePage.firstName.sendKeys(eachData.get("firstname"));
        dataTablePage.lastName.sendKeys(eachData.get("lastname"));
        //dataTablePage.position.sendKeys(eachData.get(excelUtil.getCellData(0,2)));
            dataTablePage.position.sendKeys(eachData.get("position"));
        //dataTablePage.office.sendKeys(eachData.get(excelUtil.getCellData(0,3)));
            dataTablePage.office.sendKeys(eachData.get("office"));
        dataTablePage.extension.sendKeys(eachData.get("extension"));
            dataTablePage.startDate.click();
            ReusableMethods.waitFor(2);
            dataTablePage.dataDay.click();
        dataTablePage.salary.sendKeys(eachData.get("salary"));
            ReusableMethods.waitFor(1);
            dataTablePage.createButton.click();
            dataTablePage.searchBox.sendKeys(eachData.get("firstname")+ Keys.ENTER);
            Assert.assertTrue(dataTablePage.nameField.getText().contains(eachData.get("firstname")));

        }
    }
}
