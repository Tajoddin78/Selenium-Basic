package com.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AA {
public static void main(String[] args) {
	System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("file:///C:/Users/SAM/Downloads/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//button")).click();    //dynamic path
	driver.findElement(By.xpath("//div/aside/section/ul/li[3]/a")).click();   // dynamic path
	String txt = driver.findElement(By.xpath("//td[2]")).getText();  //dynamic path
	System.out.println(txt);
	
	
}

}
