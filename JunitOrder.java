package com.Framework;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitOrder {
static WebDriver driver;
@BeforeClass
public static void beforeClass() {
driver = new ChromeDriver();
driver.get("https://www.omrbranch.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
}
@Before
public void beforeMethod() throws IOException {
long time = System.currentTimeMillis();
System.out.println(time);
TakesScreenshot tk =  (TakesScreenshot)driver;
File scr = tk.getScreenshotAs(OutputType.FILE);
File desc = new File ("C:\\Users\\kanch\\eclipse-workspace\\MavenProject\\ScreenShot\\greensBug.png");
FileUtils.copyFile(scr, desc);
}
@Test
public void test() throws InterruptedException {
WebElement txtusername = driver.findElement(By.id("email"));
txtusername.sendKeys("sugubsk@gmail.com");
String actname = txtusername.getAttribute("value");
Assert.assertEquals("verify username textbox","sugubsk@gmail.com" ,actname);
WebElement txtpassword = driver.findElement(By.id("pass"));
txtpassword.sendKeys("Greens@2020");
String actpswd = txtpassword.getAttribute("value");
Assert.assertEquals("verify password textbox","Greens@2020",actpswd);
WebElement btnlogin = driver.findElement(By.xpath("//button[@value='login']"));
btnlogin.click();
Thread.sleep(5000);
WebElement Welcome = driver.findElement(By.xpath("//a[contains(text(),'Welcome Sugumar')]"));
String text = Welcome.getText();
boolean msg = text.contains("Welcome");
Assert.assertTrue("verifytext", msg);
}
@After
public void afterMethod() throws IOException {
	long time = System.currentTimeMillis();
	System.out.println(time);
	TakesScreenshot tk =  (TakesScreenshot)driver;
	File scr = tk.getScreenshotAs(OutputType.FILE);
	File desc = new File ("C:\\Users\\kanch\\eclipse-workspace\\MavenProject\\ScreenShot\\greensBug.png");
	FileUtils.copyFile(scr, desc);
}
@AfterClass
public static void afterClass() {
	driver.quit();
}
}
