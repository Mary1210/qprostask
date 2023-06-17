package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import utilities.Helper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"})
	public static void openBrowser()  {
		String filePath = System.getProperty("user.dir") + "/src/test/java/configFiles/config.properties";
		Properties p = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(filePath);
			p.load(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browserName = p.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeoptions);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		String url=  p.getProperty("testurl");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterSuite
	public static void quitDriver() {
		driver.quit();
	}

	@AfterMethod
	public void screenshotOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
