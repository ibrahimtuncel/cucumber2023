package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RoomReservationPage {
    public RoomReservationPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = ".hidden-480")
    public WebElement addReservationRoom;
    @FindBy(id = "IDUser")
    public WebElement IDHotelDropDown;
    @FindBy(id = "IDHotelRoom")
    public WebElement IDHotelRoomDropDown;
    @FindBy(id = "Price")
    public WebElement Price;
    @FindBy(id = "DateStart")
    public WebElement dateStart;
    //@FindBy(xpath = "//*[.=6]")
    //public WebElement startDay;

    @FindBy(id="DateEnd")
    public WebElement dateEnd;
   // @FindBy(xpath = "//*[.=10]")
    //public WebElement endDay;
    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;
    @FindBy(id = "ChildrenAmount")
    public WebElement childAmount;
    @FindBy(id = "ContactNameSurname")
    public WebElement nameSurname;
    @FindBy(id = "ContactPhone")
    public WebElement phone;
    @FindBy(id = "ContactEmail")
    public WebElement email;
    @FindBy(id = "Notes")
    public WebElement notes;
    @FindBy(id = "Approved")
    public WebElement isApproved;
    @FindBy(id = "IsPaid")
    public  WebElement isPaid;
    @FindBy(id = "btnSubmit")
    public WebElement saveButton;
    @FindBy(xpath ="//div[@class='bootbox-body']")
    public WebElement successMessage;
    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement okButton;

}
