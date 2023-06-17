package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends PageBase{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    By SignUp = By.linkText("Sign up");

    By Username = By.id("sign-username");

    By Password = By.id("sign-password");
    By SignUpBtn = By.xpath("//button[contains(text(),'Sign up')]");

    By CloseBtn = By.xpath("//button[contains(text(),'Close')]");


    public void ClickSignup() {
        clickButton(SignUp);
    }
    public void Signup(String username, String password)
    {
        setTextElementText(Username,username);
        setTextElementText(Password,password);
        clickButton(SignUpBtn);
    }

    public void ClickCloseBtn() {
        clickButton(CloseBtn);
    }
}
