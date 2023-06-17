package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By Login = By.linkText("Log in");

    By Logout = By.linkText("Log out");

    By Username = By.id("loginusername");

    By Password = By.id("loginpassword");
    By LoginBtn = By.xpath("//button[contains(text(),'Log in')]");

    By WelcomeTxt = By.xpath("//a[@id='nameofuser']");


    public void Login(String username, String password)
    {
        clickButton(Login);
        wait.until(ExpectedConditions.presenceOfElementLocated(Username));
        setTextElementText(Username,username);
        setTextElementText(Password,password);
        clickButton(LoginBtn);
    }

    public String getWelcomeTxt() {
        wait.until(ExpectedConditions.presenceOfElementLocated(WelcomeTxt));
        return getText(WelcomeTxt);
    }

    public boolean LogoutisDisplayed() {
        return isElementDisplayed(Logout);
    }
}
