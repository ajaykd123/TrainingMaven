package TestNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParamTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\hp\\Automation\\chromedriver.exe");
//		driver = new ChromeDriver();
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("chromium")) {
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	// parameter coming form testn.xml
	@Parameters({ "uname", "password" })
	@Test
	public void loginTest1_Parameter(String userName, String password) {
		driver.get("https://the-internet.herokuapp.com/login");
		WebElement uname = driver.findElement(By.name("username"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		uname.sendKeys(userName);
		pass.sendKeys(password);
		submit.click();
	}

	@Test(dataProvider = "loginData")
	public void loginTest2_DataProvider(String userName, String password) {
		driver.get("https://the-internet.herokuapp.com/login");
		WebElement uname = driver.findElement(By.name("username"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		uname.sendKeys(userName);
		pass.sendKeys(password);
		submit.click();
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		return new Object[][] { 
			new Object[] { "testUser1", "Password!" },
			new Object[] { "tom", "SecretPassword!" },
			new Object[] { "tomsmith", "SuperSecretPassword!" }, };
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
