package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;

public class RegisterationPage extends PageBase{

    public RegisterationPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.id("FirstName");
    By lastName =By.id("LastName");
    By email = By.xpath("(//input[@type=\"email\"])[1]");
    By confirmationEmail = By.id("ConfirmEmail");
    By userName = By.id("Username");
    By checkAvailabilityButton = By.id("check-availability-button");
    By myCompanyPrimarily = By.id("Details_CompanyIndustryId");


    public void fillFirstName(String firstname){
        sendKeys(firstName,firstname);
    }
    public void fillLastName(String lastname){
        sendKeys(lastName,lastname);
    }
    public void fillEmail(String email){
        sendKeys(this.email,email);
    }
    public void fillConfirmationEmail(String confrimEmail){
        sendKeys(confirmationEmail,confrimEmail);
    }
    public void fillUserName(String userName){
        sendKeys(this.userName, userName);
    }
    public void clickOnCheckButton(){
        clickOnElement(checkAvailabilityButton);
    }
    public void selectMyCompanyPrimarily(String value){
        selectfromDropDownList(myCompanyPrimarily,value);
    }
}
