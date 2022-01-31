package com.WindowsHandling;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowsEx {
       
	WebDriver driver;
	
	@Test
	  public void test01() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver(); //---- main windows
		driver.get("file:///C:/Users/SAM/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		//driver.findElements(By.partialLinkText(""));
		String mainwin= driver.getWindowHandle();
		// we get 4 element
		List<WebElement> links=driver.findElements(By.partialLinkText("info"));
		// there are only one window in browser
		for(WebElement link:links) 
		
			link.click(); // this line execute for 4 times----child windows
			// there are 5 windows open in browser
			//driver.close(); ----main driver will be close
//			Thread.sleep(3000);
		Set<String> windows=driver.getWindowHandles();  // 5 values
			for(String name :windows) {
			System.out.println("id of main window"+name);
			 if(!name.equals(mainwin)) {
					 driver.switchTo().window(name);
		         System.out.println("url of close window"+ driver.getCurrentUrl());
				 System.out.println("Title of child window"+driver.getTitle());
				 driver.close();
				 Thread.sleep(3000);
				 }
				 else {
					 System.out.println("we are in main window");
				 }
			}
		}
	}
	

