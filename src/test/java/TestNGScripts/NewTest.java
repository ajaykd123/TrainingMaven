package TestNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {

WebDriver driver;

//	@BeforeTest
//	// @BeforeMethod
//	public void setUp() {
////		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Automation\\chromedriver.exe");
////		driver = new ChromeDriver();
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//
//	}

	@Test(priority=2, groups="feature1")
	public void SeleniumSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(driver.getTitle(), "Google");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium tutorial");
		searchBox.submit();
		System.out.println(driver.getTitle());
		softAssert.assertEquals(driver.getTitle(), "Selenium tutorial - Google Search");
		softAssert.assertAll();
		driver.close();
	}

	//@Test(enabled=true)
	@Test(alwaysRun =true,dependsOnMethods="RFWSearchTest", groups="feature4")
	public void JavaSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java tutorial");
		searchBox.submit();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Java tutorial - Google Search");
		driver.close();
	}
	
	@Test(groups="feature2")
	public void RFWSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("RoboFramework tutorial");
		searchBox.submit();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "RoboFramework tutorial - Google Search");
		driver.close();
	}
	
	@Test(priority=1, groups="feature2")
	public void springSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Spring tutorial");
		searchBox.submit();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Spring tutorial - Google Search");
		driver.close();
	}

//	@AfterTest
//	public void teardown() {
//		driver.close();
//	}
}
