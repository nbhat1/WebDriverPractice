package sample.com.automation.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverDemo {
	
	@Test
	public void firefoxTest(){
		WebDriver driver;
		System.setProperty("webdriver.geco.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\gecodriver.exe");
		driver = new FirefoxDriver();
		String baseUrl = "http://www.google.com";
		driver.get(baseUrl);
		//driver.close();
		System.out.println("Test");
	}
	
	@Test
	public void chromeTest(){
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
		String baseURL = "https://letskodeit.teachable.com/p/practice";
		driver = new ChromeDriver();
		driver.get(baseURL);
	//Implicit wait
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("cars")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.partialLinkText("Forgot"));
	//driver.findElement(By.tagName(name))
		driver.close();
	}

}
