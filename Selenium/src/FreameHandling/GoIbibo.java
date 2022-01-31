package FreameHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoIbibo {
       WebDriver driver;
  @Test
  public void Test01() throws Exception{
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.goibibo.com");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS );
	  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  WebDriverWait wait= new WebDriverWait(driver, 40);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("get_sign_in"))));
	  driver.findElement(By.id("get_sign_in")).click();//--- //div[@id='get_sign_in']    
	 // driver.switchTo().frame(driver.findElement(By.xpath("//input[@name='phone']")));
	  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8830102714");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
	  Thread.sleep(5000);
	 // failed attempt
	//input[contains(text(),'continue')]
	//input[@name='phone//following:: //input[contains(text(),'continue')]
	//input[@class='loginCont__btn']   
	//input[@name='phone//following:://input[@class='loginCont__btn'] 
	  
  }
       
       
       
       
       
       
}
