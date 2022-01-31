package FreameHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FrameHandleEx {
       WebDriver driver;
	@Test
	public void test01()throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		//Thread.sleep(10000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		WebDriverWait wait= new WebDriverWait(driver, 50);
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("i-icon-profile"))));	
		driver.findElement(By.id("i-icon-profile")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("signInLink")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));
		wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.id("mobileNoInp"))));
	    driver.findElement(By.id("mobileNoInp")).sendKeys("1234567890");
	}
}
