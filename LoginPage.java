package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  extends  PageBase{



    By userName = By.xpath("//*[@name=\"username\"]");
    By password =By.xpath("//input[@type=\"password\"]");
    By loginButton = By.xpath("//button[@type=\"submit\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String name){
        sendKeys(userName,name);
    }

    public void fillPassword(String password){
        sendKeys(this.password,password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
}

