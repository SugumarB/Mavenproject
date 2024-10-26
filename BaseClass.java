package com.Framework;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
 public static WebDriver driver;
Action action;
Select select;
//1.find URL
public static void webPageUrl(String url) {
	driver.get(url);
	}
//2.Maximize window
public static void windowMaximize() {
driver.manage().window().maximize();
	}
//3.insert Value in text box
public void elementSendKeys(WebElement element,String Value) {
element.sendKeys(Value);
}
//4. Click button
public void elementClick(WebElement element) {
element.click();
}
//5. Alert accept
public void alertAccept() {
	 Alert alert = driver.switchTo().alert();
	 alert.accept();
}	
//6. Alert dismiss
public void alertDismiss() {
	 Alert alert = driver.switchTo().alert();
	 alert.dismiss();
}
//7.Get text from webpage
public String getText(WebElement element) {
	String text = element.getText();
return text;
}
//8.GetInserted Value
public String getInsertValue(WebElement element,String Data ) {
String attribute = element.getAttribute(Data);
return attribute;
}
//9.close all window
public void webPageCloseCurrentWindow() {
	driver.quit();
}
//10.close current Window
public void webPageCloseAllWindow() {
driver.close();
}
//11.Get title
public String getWindowTitle() {
String title = driver.getTitle();
return title;
}
//12.Get entered Url
public String getEnteredUrl() {
String currentUrl = driver.getCurrentUrl();
return currentUrl;
}
//13.Dropdown select option by text
public void selectOptionByText(WebElement element, String text) {
select = new Select(element);
select.selectByVisibleText(text);
}
//14.Dropdown select option by value

public void selectOptionByValue(WebElement element, String text) {
	select = new Select(element);
	select.selectByValue(text);
}
//15.Dropdown select option by index
public void selectOptionByIndex(WebElement element, int index) {
	visibilityOfElement(element);
	select = new Select(element);
	select.selectByIndex(index);
}
//16.send value in textbox by Javascript
public void elementSendKeysJs(WebElement element ,String Data) {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].setAttribute('value','" + Data + "')");
}
//17. click button by Javascript
public void elementClickButtonJs(WebElement element) {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click",element);
}
//18.Launch chrome browser
public static void launchBrowser() {
	driver = new ChromeDriver();
}
//19.Switch to ChildWindow
public void switchToChildWindow(String name) {
	Set<String> all =driver.getWindowHandles();
	driver.switchTo().window(name);
}
//20.Switch to frame by index
public void switchFrameByIndex(int index) {
driver.switchTo().frame(index);
}
//21.switch to frame by drameid
public void switchFrameByFrameId(String value) {
driver.switchTo().frame(value);
}
//22.Find locator by Id
public WebElement findLocatorById(String attributeValue) {
WebElement findElement = driver.findElement(By.id(attributeValue));
return findElement;
}
//23.Find locator by name
public WebElement findLocatorByName(String attributeValue) {
WebElement findElement = driver.findElement(By.name(attributeValue));
return findElement;
}
//24.Find locator by classname
public WebElement findLocatorByClassName(String attributeValue) {
	WebElement findElement = driver.findElement(By.className(attributeValue));
return findElement;
}
//25.Find locator by Xpath
public WebElement findLocatorByXpath(String attributeValue) {
	WebElement findElement = driver.findElement(By.xpath(attributeValue));
	return findElement;
}
public void visibilityOfElement(WebElement element) {
   WebDriverWait webdriverwait = new WebDriverWait(driver, Duration.ofSeconds(60));
   webdriverwait.until(ExpectedConditions.visibilityOf(element));
}

public boolean elementIsDislayed(WebElement element) {
boolean displayed = element.isDisplayed();
return displayed;
}
public boolean elementIsSelected(WebElement element) {
boolean selected = element.isSelected();
return selected;
}
public boolean elementIsEnabled(WebElement element) {
boolean enabled = element.isEnabled();
return enabled;
}
public String getCellData(String SheetName,int rowName,int cellName) throws IOException {
String res="";
File file = new File("C:\\Users\\kanch\\eclipse-workspace\\MavenProject\\Excel\\Junit.xlsx");
FileInputStream stream = new FileInputStream(file);
Workbook workbook = new XSSFWorkbook(stream);
Sheet sheet = workbook.getSheet(SheetName);
Row row = sheet.getRow(rowName);
Cell cell = row.getCell(cellName);
CellType cellType = cell.getCellType();
switch (cellType) {
case STRING:
	res= cell.getStringCellValue();
	break;
case NUMERIC:
	if (DateUtil.isCellDateFormatted(cell)) {
		Date dateCellValue = cell.getDateCellValue();
		SimpleDateFormat date = new SimpleDateFormat("dd-MMMM-YYYY");
		res = date.format(dateCellValue);
		
	} else {
		double numericCellValue = cell.getNumericCellValue();
		long round = Math.round(numericCellValue);
		if (round==numericCellValue) {
			res = String.valueOf(round);
			
		} else {
res = String.valueOf(numericCellValue);
		}

	}

default:
	break;
}

return res;
}

public static void implictWait(int secs) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
}

public void implictWait() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

}
public static void browserQuit() {
	driver.quit();

}
//public void elementSendKeys(WebElement element, String data) {
//	visibilityOfElement(element);
//
//	if (elementIsEnabled(element) && elementIsDislayed(element)) {
//		element.sendKeys(data);
//	}
public String elementGetText(WebElement element) {
	visibilityOfElement(element);
	String text = "";

	if (elementIsDislayed(element)) {
		text = element.getText();
	}
	return text;
}
public void elementSendKeysEnter(WebElement element,String value,Keys enter) {
element.sendKeys(value,Keys.ENTER);
}
public void switchFrameByWebElement(WebElement element) {
driver.switchTo().frame(element);
}
}
