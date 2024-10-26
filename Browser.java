package com.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://omrbranch.com/");
	driver.manage().window().maximize();
 WebElement txtusername = driver.findElement(By.xpath("//input[@id='email']"));
 txtusername.sendKeys("abc@gmail.com");
 WebElement txtpassword = driver.findElement(By.xpath("//input[@id='pass']"));
 txtpassword.sendKeys("passcode@123");
 WebElement loginclick = driver.findElement(By.xpath("//button[@type='submit']"));
 loginclick.click();
}
	

}
