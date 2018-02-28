package sample.com.automation.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait {

	public static void main(String[] args) {
		System.setProperty("webdriver.geco.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\gecodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10L,TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("element1")));

	}
}