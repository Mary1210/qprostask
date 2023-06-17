package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CategoriesPage extends PageBase{
    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    By PhonesLink = By.linkText("Phones");

    By LaptopsLink = By.linkText("Laptops");

    By MonitorsLink = By.linkText("Monitors");

    By addToCart = By.linkText("Add to cart");

    By Items = By.id("tbodyid");

    By Home =By.xpath("//a[contains(text(),'Home')]");

    By CartPage = By.linkText("Cart");


    public void OpenPhonesPage()
    {
        ScrollToElement(PhonesLink);
        clickButton(PhonesLink);
        ScrollToElement(By.linkText("Samsung galaxy s6"));
        wait.until(ExpectedConditions.presenceOfElementLocated(Items));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Samsung galaxy s6")));
    }

    public void OpenPhonesPage2()
    {
        ScrollToElement(PhonesLink);
        clickButton(PhonesLink);
        //ScrollToElement(By.linkText("Samsung galaxy s6"));
        wait.until(ExpectedConditions.presenceOfElementLocated(Items));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Samsung galaxy s6")));
    }
    public void OpenLaptopsPage()
    {
        ScrollToElement(LaptopsLink);
        clickButton(LaptopsLink);
        ScrollToElement(By.linkText("Sony vaio i5"));
        wait.until(ExpectedConditions.presenceOfElementLocated(Items));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sony vaio i5")));
    }

    public void OpenMonitorsPage()
    {
        ScrollToElement(MonitorsLink);
        clickButton(MonitorsLink);
        ScrollToElement(By.linkText("Apple monitor 24"));
        wait.until(ExpectedConditions.presenceOfElementLocated(Items));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Apple monitor 24")));
    }

    public void OpenCartPage() {
        clickButton(CartPage);
    }

    public void OpenHomePage() {
        clickButton(Home);
    }
    public void ClickonProduct(String productName)
    {
        WebElement element = driver.findElement(By.xpath("//div[@id='tbodyid']"));
        List<WebElement> AllItems = element.findElements(By.xpath("//div//div[@class='card-block']//a"));
     //   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='tbodyid']//a")));
        for (WebElement item : AllItems)
        {
            if (item.getText().contains("productName"));
            item.click();
            break;
        }
    }

    public void AddToCart()
    {
        clickButton(addToCart);
    }

    public String getItems() {
        return getText(Items);
    }


}
