package JavaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JavaScriptEx {
	static WebDriver driver;
	RemoteWebElement re;
	public void WaitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void moveAndClick(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click(element).build().perform();
	}
	
	
	public static void scrollingToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	@Test
	public void test01() throws Exception{
		WebElement uname, pass;
		RemoteWebDriver rwd;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("file:///C:/Users/SAM/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		//driver.navigate().to("");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		RemoteWebDriver d;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		System.out.println(driver.getCurrentUrl());
		System.out.println("URL printed by JS "+js.executeScript("return document.URL;"));
		
		System.out.println(driver.getTitle());
		System.out.println("title printed by JS " +js.executeScript("return document.title;"));
		
		// changing title by js
	     js.executeScript("document.title='updated title';");
	     System.out.println(driver.getTitle());
	     
	     driver.navigate().refresh();
	   //refreshing browser by js
	     js.executeScript("history.go(0);");
	     
	   //clicking element by js
	     js.executeScript("arguments[0].click();", uname=driver.findElement(By.id("email")));
	     
	     js.executeScript("document.getElementById('email').value='kiran@gmail.com';");

	     //clicking element by js

	     js.executeScript("arguments[0].click();", pass=driver.findElement(By.id("password")));

	     // using sendkeys by js

	     js.executeScript("document.getElementById('password').value='123456';");
	     
	  // creating alert by js
	     js.executeScript("alert('hello world');");
	     Alert al = driver.switchTo().alert();
	     System.out.println(al.getText());
	     Thread.sleep(5000);
	     al.accept();
	     
	   //  driver.navigate().to("");
	   //navigating to other url by js
	     js.executeScript("window.location='https://www.amazon.in/'");
	     Thread.sleep(10000);
	     driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	     Thread.sleep(15000);
	     WebElement footer_Logo=driver.findElement(By.xpath("//a[@href='/ref=footer_logo']"));
	     js.executeScript("arguments[0].scrollIntoView(true);", footer_Logo);
	     scrollingToView(footer_Logo);
	     System.out.println(driver.getTitle());
	    // driver.navigate().to("");
	     
	     
	}
}
