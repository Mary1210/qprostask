package Tests;

import Pages.CategoriesPage;
import Pages.RegisterPage;
import data.ExcelReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;

public class RegisterPageTest extends TestBase {

    RegisterPage register;
    Alert alert;
    WebDriverWait wait;
    ExcelReader ER;

    CategoriesPage category;


    @BeforeClass
    public void RegisterPageTestBeforeClass() {
        register = new RegisterPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ER = new ExcelReader();
        category = new CategoriesPage(driver);
    }

    @DataProvider(name = "ExcelFileData")
    public Object[][] userRegisterData() throws IOException, IOException {
        return ER.getExcelData();
    }

    @Test(dataProvider = "ExcelFileData")
    public void UserRegisteration(String Name, String Password) {
        register.ClickSignup();
        register.Signup(Name,Password);
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Sign up successful"));
        alert.accept();
        register.ClickSignup();
        category.OpenHomePage();
    }
}
