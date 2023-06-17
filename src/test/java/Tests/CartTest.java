package Tests;

import Pages.CategoriesPage;
import Pages.OrderDetailsPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class CartTest extends TestBase{

    OrderDetailsPage orderPage;
    CategoriesPage categories;
    WebDriverWait wait;
    Alert alert;

    @BeforeClass
    public void CartTestBeforeClass() {
        orderPage = new OrderDetailsPage(driver);
        categories = new CategoriesPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void AddItemToCart() throws InterruptedException {
        categories.OpenCartPage();
        categories.OpenHomePage();
        categories.OpenPhonesPage2();
        categories.ClickonProduct("Samsung galaxy s6");
        categories.AddToCart();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Product added"));
        alert.accept();
        orderPage.OpenCartPage();
        Assert.assertTrue(orderPage.getItemfromCart().contains("Samsung galaxy s6"));
    }

    @Test(priority=2)
    public void DeleteItemFromCart() {
        orderPage.OpenCartPage();
        orderPage.DeleteItemFromCart("Samsung galaxy s6");
        Assert.assertTrue(orderPage.getTotal().contains(""));
        Assert.assertTrue(orderPage.getItemfromCart().contains(""));
    }

    @Test (priority=3)
    public void CheckoutProcess() {
        categories.OpenHomePage();
        categories.OpenPhonesPage();
        categories.ClickonProduct("Samsung galaxy s6");
        categories.AddToCart();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Product added"));
        alert.accept();
        orderPage.OpenCartPage();
        orderPage.ClickPlaceOrderBtn();
        orderPage.InsertCustomerData("Mary","Alexandria","Alexandria", "123456789456", "12", "26");
        Assert.assertTrue(orderPage.getConfirmationMessageTxt().contains("Thank you for your purchase!"));
        Assert.assertTrue(orderPage.getConfirmationMessageTxt().contains("Amount: 360 USD"));
        Assert.assertTrue(orderPage.getConfirmationMessageTxt().contains("Card Number: 123456789456"));
        Assert.assertTrue(orderPage.getConfirmationMessageTxt().contains("Name: Mary"));
        orderPage.ClickOkButton();
    }
}
