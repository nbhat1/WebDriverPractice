package sample.com.automation.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElements {

	WebDriver driver = null;
	
	
	@Test
	public void testWebElement() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(100, 400)); //Set window size.
		driver.manage().window().setPosition(new Point(600, 500)); // Move window 
		driver.manage().window().setPosition(new Point(200, 100)); // Move window 
		driver.manage().window().setPosition(new Point(500, 400)); // Move window 
		driver.get("http://udemy.com");
		//WebElement userName = driver.findElement(By.id("gsdhjfgds"));
		
	}
}
