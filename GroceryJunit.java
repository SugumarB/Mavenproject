package com.Framework;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class GroceryJunit extends BaseClass {
@BeforeClass
public static void beforeClass() {
      launchBrowser();
      webPageUrl("https://www.omrbranch.com/");
      windowMaximize();
      implictWait(30);
}
//@AfterClass
//public static void afterClass() {
//browserQuit();
//}
@Test
public void productOrder() throws IOException, InterruptedException {
WebElement username = findLocatorById("email");
elementSendKeys(username, getCellData("details", 0, 0));
WebElement password = findLocatorById("pass");
elementSendKeys(password, getCellData("details", 0, 1));
WebElement btnclick = findLocatorByXpath("//button[@value='login']");
elementClick(btnclick);
WebElement Wlcmnote = findLocatorByXpath("//a[@data-testid='username']");
String message = elementGetText(Wlcmnote);
System.out.println(message);
WebElement productsrch = findLocatorById("search");
elementSendKeys(productsrch, "Nuts");
WebElement click = findLocatorByXpath("//button[@type='submit']//i[1]");
elementClick(click);
Thread.sleep(5000);
WebElement searchresult = findLocatorByXpath("//h5[contains(@class,'sectionTitle font35')]");
String messages = elementGetText(searchresult);
System.out.println(messages);
Thread.sleep(5000);
WebElement addproduct = findLocatorByXpath("(//div[contains(@class,'addBtn justify-content-center')]//a)[1]");
elementClick(addproduct);
Thread.sleep(3000);
WebElement addvarientproduct = findLocatorById("cart-22");
elementClick(addvarientproduct);
Thread.sleep(5000);
WebElement gotocart = findLocatorByXpath("//a[contains(text(),'Go To Cart')]");
elementClick(gotocart);
WebElement addaddress = findLocatorByXpath("//div[contains(@class,'diffAddres addAddress')]");
elementClick(addaddress);
WebElement addresstype = findLocatorById("address_type");
selectOptionByText(addresstype,"Home");
WebElement firstname = findLocatorByName("first_name");
elementSendKeys(firstname, getCellData("details", 0, 2));
WebElement lastname = findLocatorByName("last_name");
elementSendKeys(lastname, getCellData("details", 0, 3));
WebElement mobno = findLocatorByName("mobile");
elementSendKeys(mobno, getCellData("details", 0, 4));
WebElement doorno = findLocatorByName("apartment");
elementSendKeys(doorno, getCellData("details", 0, 5));
WebElement address = findLocatorByName("address");
elementSendKeys(address, getCellData("details", 0, 6));
WebElement country = findLocatorByName("country");
selectOptionByText(country, "India");
WebElement state = findLocatorByName("state");
selectOptionByText(state, "Tamil Nadu");
WebElement city = findLocatorByName("city");
selectOptionByText(city, "Chennai");
WebElement zipcode = findLocatorByName("zipcode");
elementSendKeys(zipcode, getCellData("details", 0, 7));
WebElement saveaddress = findLocatorByXpath("//button[contains(@class,'saveAddress font18')]");
elementClick(saveaddress);
WebElement getupdatedaddress = findLocatorByXpath("//div[contains(@class,'diffAddres mb-md-0')]");
String printaddress = elementGetText(getupdatedaddress);
System.out.println(printaddress);
WebElement paymenttype = findLocatorById("payment_type");
selectOptionByText(paymenttype, "Debit Card");
WebElement Visa = findLocatorByXpath("//label[@for='visa_card']");
elementClick(Visa);
WebElement cardno = findLocatorByName("card_no");
elementSendKeys(cardno, "5555555555552222");
WebElement cardmonth = findLocatorByName("month");
selectOptionByText(cardmonth, "May");
 WebElement year = findLocatorByName("year");
 selectOptionByValue(year, "2026");
 WebElement cvvno = findLocatorByName("cvv");
 elementSendKeys(cvvno, "335");
 WebElement orderplace = findLocatorById("placeOrder");
 elementClick(orderplace);
 WebElement welcomeNote = findLocatorByXpath("//a[contains(text(),'Welcome Sugumar')]");
 elementClick(welcomeNote);
 WebElement Myaccount = findLocatorByXpath("//a[contains(text(),'My Account')]");
 elementClick(Myaccount);
 WebElement orderidlist = findLocatorById("v-pills-orders-tab");
 elementClick(orderidlist);
 WebElement orderdetails = findLocatorByXpath("(//a[contains(@class,'font16 colorTheme')])[3]");
 elementClick(orderdetails);
 WebElement orderid = findLocatorByXpath("(//p[contains(@class,'font18 color20')])[1]");
 String printorderid = elementGetText(orderid);
 System.out.println(printorderid);
}
}
