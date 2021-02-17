package sample.com.automation.webdriver;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverDemo {

	public static WebDriver driver = null;
	
	public String browser = "edge"; //This value can come from notepad
	
	@Test
	public void chromeTest1() {
		/*WebDriver manager is external dependency. It can be used to invoke driver.
		 * Using this we don't need to keep drivers in root.*/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	
	@Test
	public void chromeTest2() {
		/*WebDriver manager is external dependency. It can be used to invoke driver.
		 * Using this we don't need to keep drivers in root.*/
		
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();;
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();;
			driver = new EdgeDriver();
		} 
		
		driver.get("http://google.com");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
	
	@Test
	public void chromeTestWithSwitch() {
		/*WebDriver manager is external dependency. It can be used to invoke driver.
		 * Using this we don't need to keep drivers in root.*/
		
		// Do above example with switch 
		
		driver.get("http://google.com");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}

}
