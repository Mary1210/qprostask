package Tests;

import Pages.CategoriesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CategoriesTest extends TestBase{
    CategoriesPage categories;

    @BeforeClass
    public void CategoriesTestBeforeClass() {
        categories = new CategoriesPage(driver);
    }

    @Test
    public void CheckCategoriesItems() {
        categories.OpenPhonesPage();
        Assert.assertTrue(categories.getItems().contains("Samsung galaxy s6"));
        Assert.assertTrue(categories.getItems().contains("Nokia lumia 1520"));
        Assert.assertTrue(categories.getItems().contains("Nexus 6"));
        categories.OpenCartPage();
        categories.OpenHomePage();
        categories.OpenLaptopsPage();
        Assert.assertTrue(categories.getItems().contains("Sony vaio i5"));
        Assert.assertTrue(categories.getItems().contains("Sony vaio i7"));
        Assert.assertTrue(categories.getItems().contains("MacBook air"));
        categories.OpenCartPage();
        categories.OpenHomePage();
        categories.OpenMonitorsPage();
        Assert.assertTrue(categories.getItems().contains("Apple monitor 24"));
        Assert.assertTrue(categories.getItems().contains("ASUS Full HD"));
    }
}
