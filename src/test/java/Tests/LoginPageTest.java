package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{
    LoginPage login;

    @BeforeClass
    public void LoginPageBeforeClass() {
        login = new LoginPage(driver);
    }

    @Test
    public void UserLogin()
    {
        login.Login("Mary123","12345678");
        Assert.assertTrue(login.LogoutisDisplayed());
        Assert.assertEquals("Welcome Mary123", login.getWelcomeTxt());
    }
}
