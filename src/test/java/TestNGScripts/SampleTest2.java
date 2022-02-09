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

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest2 {
	WebDriver driver;

//	@BeforeTest
//	// @BeforeMethod
//	public void setUp() {
//		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Automation\\chromedriver.exe");
////		driver = new ChromeDriver();
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//
//	}

	@Test(groups="feature1")
	public void AppiumSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Appium tutorial");
		searchBox.submit();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Appium tutorial - Google Search");
		driver.close();

	}

	@Test(groups="feature3")
	public void cucumberSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("cucumber tutorial");
		searchBox.submit();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "cucumber tutorial - Google Search");
		driver.close();
	}
	
	@Test(threadPoolSize=2, invocationCount=6, timeOut=3000)
	public void ThreadTest() {
		long id = Thread.currentThread().getId();
		System.out.println(id);
	}

//	@AfterTest
//	public void teardown() {
//		driver.close();
//	}
}
