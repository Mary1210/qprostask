package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderDetailsPage extends PageBase{

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }


    By CartPage = By.linkText("Cart");

    By PlaceOrberBtn = By.xpath("//button[contains(text(),'Place Order')]");

    By Name = By.id("name");

    By Country = By.id("country");

    By City = By.id("city");

    By Card = By.id("card");

    By Month = By.id("month");

    By Year = By.id("year");

    By ConfirmationMessage = By.xpath("//div[contains(@class,'sweet-alert')]");

    By OkBtn = By.xpath("//button[contains(text(),'OK')]");

    By ProductName = By.xpath("//tbody[@id='tbodyid']//tr[@class='success']//descendant::td[2]");

    By Total= By.id("totalp");

    By PurchaseBtn =By.xpath("//button[@onclick='purchaseOrder()']");
    public void OpenCartPage()
    {
        clickButton(CartPage);
    }

    public void ClickPlaceOrderBtn() {
        clickButton(PlaceOrberBtn);
    }
    public void DeleteItemFromCart(String ProductName) {
        WebElement DeleteElement = driver.findElement(By.xpath(
                "//tbody[@id='tbodyid']//tr[@class='success']//following-sibling::td[contains(text(),'"+ ProductName+"')]//following-sibling::td//a[contains(@onclick, 'deleteItem')]"));
        DeleteElement.click();

    }

    public String getItemfromCart() {
        return getText(ProductName);
    }

    public  void InsertCustomerData(String name, String country, String city, String card, String month, String year)
    {
        setTextElementText(Name, name);
        setTextElementText(Country, country);
        setTextElementText(City, city);
        setTextElementText(Card, card);
        setTextElementText(Month,month);
        setTextElementText(Year, year);
        clickButton(PurchaseBtn);
    }

    public void ClickOkButton() {
        clickButton(OkBtn);
    }

    public String getConfirmationMessageTxt()
    {
        return getText(ConfirmationMessage);
    }

    public String getTotal() {
        return getText(Total);
    }


}
