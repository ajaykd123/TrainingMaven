package TestNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportTest {

	WebDriver driver;
	ExtentSparkReporter spark;
	ExtentReports reports;
	ExtentTest extentTest;

	@BeforeTest
	public void setUpRport() {
		reports = new ExtentReports();
		spark = new ExtentSparkReporter("target/extentReport.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] {
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.AUTHOR,
						ViewName.DEVICE,
						ViewName.EXCEPTION,
						ViewName.LOG
				})
				.apply();
		reports.attachReporter(spark);
	}

	@BeforeMethod
	public void setUp() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Automation\\chromedriver.exe");
//		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void MovieSearchTest() {
		extentTest = reports.createTest("Movie search");
		driver.get("https://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("movie tutorial");
		searchBox.submit();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "movie tutorial - Google Search");

	}

	@Test
	public void ReportSearchTest() {
		extentTest = reports.createTest("Movie search");
		driver.get("https://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Report tutorial");
		searchBox.submit();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Report tutorial - Google Search");

	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			
		}
		driver.close();
	}

	@AfterTest
	public void finishReports() {
		reports.flush();
	}
}
