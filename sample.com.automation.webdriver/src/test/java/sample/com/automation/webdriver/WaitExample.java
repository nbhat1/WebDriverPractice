package sample.com.automation.webdriver;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WaitExample {
	
	WebDriver driver = null;
	
	/*Implicit wait are used to wait for an element to be present in DOM.It only check if element is present in DOM. It does not check if element is active or visible or clickable. */
	@Test
	public static void implicitWaitExample() {
		//System.setProperty("webdriver.geco.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\gecodriver.exe");
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10L,TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("element1")));
        
        //driver.quit();

	}
	
	/*Explicit wait are used when element is present but its either not visible or clickable.So implicit wait will be pass but since element is not 
	 * active or visible test will fail so we have to use explicit wait.*/
	@Test
	public void explicitWait() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("ajdasjd");;
		//driver.findElement(By.name("SubmitLogin")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10); //10 is always second
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
		
		//driver.close();
	}
	
	/*Explicit wait are used when element is present but its either not visible or clickable.So implicit wait will be pass but since element is not 
	 * active or visible test will fail so we have to use explicit wait.*/
	@Test
	public void FluentWait() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("ajdasjd");;
		//driver.findElement(By.name("SubmitLogin")).click();
		
		//Implement Fluent Wait here
		
		Wait wait = new FluentWait(driver)
				.pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class)
				.withMessage("user defined messgae timed out after 10 seconds");
	
		
		

	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
}