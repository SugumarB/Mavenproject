package com.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Grocery {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.omrbranch.com/");
	driver.manage().window().maximize();
	WebElement txtname = driver.findElement(By.name("email"));
	txtname.sendKeys("sugubsk@gmail.com");
	WebElement txtpassword = driver.findElement(By.id("pass"));
	txtpassword.sendKeys("Greens@2020");
	WebElement btnclick = driver.findElement(By.xpath("//button[@value='login']"));
	btnclick.click();
	Thread.sleep(3000);
	WebElement fulltxt = driver.findElement(By.xpath("//a[contains(text(),'Welcome Sugumar')]"));
	String text = fulltxt.getText();
	System.out.println(text);
	WebElement serarch = driver.findElement(By.id("search"));
	serarch.sendKeys("nuts",Keys.ENTER);
//	WebElement search = driver.findElement(By.xpath("//button[@type='submit']//i[1]"));
//	search.click();
	WebElement searchresult = driver.findElement(By.xpath("//h5[text()='Search Result - nuts']"));
	String text2 = searchresult.getText();
	System.out.println(text2);
	Thread.sleep(2000);
	WebElement cartlist = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']"));
	cartlist.click();
	List<WebElement> carclose = driver.findElements(By.xpath("//i[@class='fa fa-close']"));
	if (carclose!=null) {
		for (WebElement x :carclose ) {
			x.click();
		}
		}else {
		
			System.out.println(" list of product not Available");
	}
	Thread.sleep(5000);
	WebElement closecart = driver.findElement(By.linkText("Close"));
	closecart.click();
	Thread.sleep(5000);
	WebElement addcart = driver.findElement(By.xpath("(//div[contains(@class,'addBtn justify-content-center')]//a)[1]"));
	addcart.click();
	Thread.sleep(2000);
	WebElement addvarientcart = driver.findElement(By.id("cart-22"));
	addvarientcart.click();
	Thread.sleep(5000);
	WebElement gotocart = driver.findElement(By.xpath("//a[contains(text(),'Go To Cart')]"));
	gotocart.click();
	WebElement AddAddress = driver.findElement(By.xpath("//div[contains(@class,'diffAddres addAddress')]"));
	AddAddress.click();
	WebElement adresstype = driver.findElement(By.id("address_type"));
	Select select = new Select(adresstype);
	select.selectByVisibleText("Home");
	WebElement Txtfirstname = driver.findElement(By.name("first_name"));
	Txtfirstname.sendKeys("sugumar");
	WebElement Txtlastname = driver.findElement(By.name("last_name"));
	Txtlastname.sendKeys("Balu");
	WebElement contactno = driver.findElement(By.name("mobile"));
	contactno.sendKeys("1234567890");
	WebElement houseno = driver.findElement(By.name("apartment"));
	houseno.sendKeys("839");
	WebElement Address = driver.findElement(By.name("address"));
	Address.sendKeys("Omr, Thoraipakkam");
	WebElement country = driver.findElement(By.name("country"));
	Select select1 = new Select(country);
	select1.selectByVisibleText("India");
	WebElement state = driver.findElement(By.name("state"));
	Select select2 = new Select(state);
	select2.selectByVisibleText("Tamil Nadu");
	WebElement city = driver.findElement(By.name("city"));
	Select select3= new Select(city);
	Thread.sleep(3000);
	select3.selectByVisibleText("Chennai");
	WebElement zipcode = driver.findElement(By.name("zipcode"));
	zipcode.sendKeys("432 679");
	WebElement Save = driver.findElement(By.xpath("//button[contains(@class,'saveAddress font18')]"));
	Save.click();
	WebElement updatedAddress = driver.findElement(By.xpath("//p[text()='839 Omr, Thoraipakkam, Chennai, India (432 67)']"));
	String text3 = updatedAddress.getText();
	System.out.println(text3);
	Thread.sleep(3000);
	WebElement paymentmethod = driver.findElement(By.id("payment_type")) ;
	Select s=new Select(paymentmethod);
	s.selectByVisibleText("Debit Card");
	WebElement Visa = driver.findElement(By.xpath("//label[@for='visa_card']"));
	Visa.click();
	WebElement cardno = driver.findElement(By.name("card_no"));
	cardno.sendKeys("5555555555552222");
	WebElement cardmonth = driver.findElement(By.name("month"));
	Select select5 = new Select(cardmonth);
	select5.selectByVisibleText("May");
	WebElement cardyear = driver.findElement(By.name("year"));
	Select select6 = new Select(cardyear);
	select6.selectByValue("2026");
	WebElement Cvv = driver.findElement(By.name("cvv"));
	Cvv.sendKeys("346");
	WebElement placeorder = driver.findElement(By.id("placeOrder"));
	placeorder.click();
	WebElement userdetails = driver.findElement(By.xpath("//a[contains(text(),'Welcome Sugumar')]"));
	userdetails.click();
	WebElement myaccount = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
	myaccount.click();
	WebElement orders = driver.findElement(By.id("v-pills-orders-tab"));
	orders.click();
	Thread.sleep(5000);
	WebElement orderdetails = driver.findElement(By.xpath("(//a[contains(@class,'font16 colorTheme')])[3]"));
	orderdetails.click();
	WebElement orderId = driver.findElement(By.xpath("(//p[contains(@class,'font18 color20')])[1]"));
	String text4 = orderId.getText();
	System.out.println(text4);
		
}
}
