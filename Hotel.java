package com.Framework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Hotel extends BaseClass {

	public void travelBooking() throws IOException, InterruptedException, AWTException {
		launchBrowser();
		webPageUrl("https://www.omrbranch.com/");
		windowMaximize();
		implictWait(60);
		WebElement username = findLocatorById("email");
		elementSendKeys(username, getCellData("details", 0, 0));
		WebElement password = findLocatorById("pass");
		elementSendKeys(password, getCellData("details", 0, 1));
		WebElement btnlogin = findLocatorByXpath("//button[@value='login']");
		elementClick(btnlogin);
		WebElement welcomenote = findLocatorByXpath("//a[contains(text(),'Welcome Sugumar')]");
		String msg = elementGetText(welcomenote);
		System.out.println(msg);
		WebElement selectstate = findLocatorById("state");
		selectOptionByText(selectstate, "Karnataka");
		Thread.sleep(5000);
		WebElement selectcity = findLocatorByXpath(
				"//*[@id=\"searchform\"]/div/div[1]/div[2]/div/span[2]/span[1]/span/span[2]");
		elementClick(selectcity);
		WebElement listcity = findLocatorByXpath("/html/body/span/span/span[1]/input");
		elementSendKeys(listcity, "Mysuru");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		WebElement selectroom = findLocatorById("room_type");
		selectOptionByText(selectroom, "Deluxe");
		Thread.sleep(3000);
		WebElement checkin = findLocatorByXpath("(//div[@data-date-format='mm-dd-yyyy'])[1]");
		checkin.click();
		String chckinmonth = findLocatorByClassName("ui-datepicker-month").getText();
		String chckinyear = findLocatorByClassName("ui-datepicker-year").getText();
		while (!(chckinmonth.equals("June") && chckinyear.equals("2024"))) {
			findLocatorByXpath("//a[@data-handler='next']").click();
			chckinmonth = findLocatorByClassName("ui-datepicker-month").getText();
			chckinyear = findLocatorByClassName("ui-datepicker-year").getText();
		}
		findLocatorByXpath("//td[@data-handler='selectDay']/a[text()='19']").click();
		WebElement checkout = findLocatorByXpath("(//div[@data-date-format='mm-dd-yyyy'])[2]");
		checkout.click();
		String chckoutmonth = findLocatorByClassName("ui-datepicker-month").getText();
		String chckoutyear = findLocatorByClassName("ui-datepicker-year").getText();
		while (!(chckoutmonth.equals("June") && chckoutyear.equals("2024"))) {
			findLocatorByXpath("//a[@data-handler='next']").click();
			chckoutmonth = findLocatorByClassName("ui-datepicker-month").getText();
			chckoutyear = findLocatorByClassName("ui-datepicker-year").getText();
		}
		findLocatorByXpath("//td[@data-handler='selectDay']/a[text()='25']").click();
		Thread.sleep(5000);
		WebElement NoofRoom = findLocatorByXpath("//Select[@name='no_rooms']");
		selectOptionByValue(NoofRoom, "3");
		WebElement NoofAdults = findLocatorByXpath("//Select[@id='no_adults']");
		selectOptionByValue(NoofAdults, "3");
		WebElement Noofchild = findLocatorByXpath("//input[@name='no_child']");
		elementSendKeys(Noofchild, "3");
		WebElement switchframe = findLocatorByXpath("//iframe[@class='iframe']");
		switchFrameByWebElement(switchframe);
		WebElement search = findLocatorByXpath("//button[@id='searchBtn']");
		elementClick(search);
		WebElement selectHotel = findLocatorByXpath("//h5[text()='Select Hotel']");
		String printselectHotel = elementGetText(selectHotel);
		System.out.println(printselectHotel);
		System.out.println("Hotel booking name:");
		WebElement hotelname = findLocatorByXpath("//h5[text()='37th Crescent Hotel Deluxe']");
		String printhotelname = elementGetText(hotelname);
		System.out.println(printhotelname);
		System.out.println("Hotel booking price:");
		WebElement hotelprice = findLocatorByXpath("(//strong[@class='total-prize'])[2]");
		String printhotelprice = elementGetText(hotelprice);
		System.out.println(printhotelprice);
		WebElement continueBooking = findLocatorByXpath("(//a[@class='btn filter_btn'])[2]");
		elementClick(continueBooking);
		alertAccept();
		Thread.sleep(2000);
		WebElement Bookingfor = findLocatorByXpath("(//input[@name='booking_for'])[1]");
		elementClick(Bookingfor);
		WebElement selectsalutation = findLocatorByName("title");
		selectOptionByText(selectsalutation, "Mr.");
		WebElement firstname = findLocatorByName("first_name");
		elementSendKeys(firstname, getCellData("details", 2, 0));
		WebElement lastname = findLocatorByName("last_name");
		elementSendKeys(lastname, getCellData("details", 2, 1));
		WebElement phno = findLocatorById("user_phone");
		elementSendKeys(phno, getCellData("details", 2, 2));
		WebElement email = findLocatorByName("email");
		elementSendKeys(email, getCellData("details", 2, 3));
		WebElement GSTDetails = findLocatorById("gst");
		elementClick(GSTDetails);
		WebElement Registrationno = findLocatorById("gst_registration");
		elementSendKeys(Registrationno, getCellData("details", 2, 4));
		WebElement companyname = findLocatorByXpath("//input[@placeholder='Enter Company Name *']");
		elementSendKeys(companyname, getCellData("details", 2, 5));
		WebElement companyAddress = findLocatorByXpath("//input[@placeholder='Enter Company Address *']");
		elementSendKeys(companyAddress, getCellData("details", 2, 6));
		WebElement next = findLocatorById("step1next");
		elementClick(next);
		WebElement otherreq = findLocatorByXpath("//textarea[@class='form-control']");
		elementSendKeys(otherreq, getCellData("details", 2, 7));

		WebElement nextbutton = findLocatorByXpath("(//button[contains(@class,'stepbtn btn')])[2]");
		elementClick(nextbutton);
		WebElement paymentoption = findLocatorByXpath("//div[@class='credit-card pm']");
		elementClick(paymentoption);
		WebElement selectcardtype = findLocatorByXpath("(//div[contains(@class,'form-group input-group')]//select)[2]");
		selectOptionByText(selectcardtype, "Debit Card");
		WebElement cardtype = findLocatorByXpath("(//div[contains(@class,'form-group input-group')]//select)[3]");
		selectOptionByText(cardtype, "Visa");
		WebElement cardno = findLocatorByXpath("//input[@placeholder='Enter Card Number *']");
		elementSendKeys(cardno, getCellData("details", 0, 9));
		WebElement ournameoncard = findLocatorByXpath("//input[@placeholder='Enter Your Name On Card *']");
		elementSendKeys(ournameoncard, "sugumar");
		WebElement cardMonth = findLocatorByXpath("(//select[@class='form-control'])[1]");
		selectOptionByText(cardMonth, "September");
		Thread.sleep(3000);
		WebElement cardyear = findLocatorByXpath("(//select[@class='form-control valid'])[2]");
		selectOptionByIndex(cardyear, 10);
		WebElement cvv = findLocatorByXpath("//input[@placeholder='Enter Card CVV *']");
		elementSendKeys(cvv, getCellData("details", 0, 10));
		WebElement submitbutton = findLocatorByXpath("//button[@class='btn filter_btn']");
		elementClick(submitbutton);
		WebElement bookingconfimed = findLocatorByXpath("//h2[contains(text(),'Booking ')]");
		String message = getText(bookingconfimed);
		System.out.println(message);
		WebElement bokedhotelname = findLocatorByXpath(
				"//*[@id=\"page-wrapper\"]/section/div/div/div/div/div/div/p/strong");
		String htl = getText(bokedhotelname);
		System.out.println(htl);
		System.out.println("Modify checkin Date:");
		WebElement welcomeNote = findLocatorByXpath("//a[contains(text(),'Welcome Sugumar')]");
		elementClick(welcomeNote);
		WebElement Myaccount = findLocatorByXpath("//a[contains(text(),'My Account')]");
		elementClick(Myaccount);
		WebElement printbookings = findLocatorByXpath("//div[@class='col-md-5']//h4[1]");
		String printbook = getText(printbookings);
		System.out.println(printbook);
		WebElement editorder = findLocatorByXpath("(//button[@type='submit'])[1]");
		elementClick(editorder);
		WebElement editcheckin = findLocatorByXpath("(//div[@data-date-format='mm-dd-yyyy'])[1]");
		editcheckin.click();
		String editchckinmonth = findLocatorByClassName("ui-datepicker-month").getText();
		String editchckinyear = findLocatorByClassName("ui-datepicker-year").getText();
		while (!(editchckinmonth.equals("June") && editchckinyear.equals("2024"))) {
			findLocatorByXpath("//a[@data-handler='next']").click();
			editchckinmonth = findLocatorByClassName("ui-datepicker-month").getText();
			editchckinyear = findLocatorByClassName("ui-datepicker-year").getText();
		}
		findLocatorByXpath("//td[@data-handler='selectDay']/a[text()='20']").click();
		WebElement editcheckout = findLocatorByXpath("(//div[@data-date-format='mm-dd-yyyy'])[2]");
		editcheckout.click();
		String editchckoutmonth = findLocatorByClassName("ui-datepicker-month").getText();
		String editchckoutyear = findLocatorByClassName("ui-datepicker-year").getText();
		while (!(editchckoutmonth.equals("June") && editchckoutyear.equals("2024"))) {
			findLocatorByXpath("//a[@data-handler='next']").click();
			editchckoutmonth = findLocatorByClassName("ui-datepicker-month").getText();
			editchckoutyear = findLocatorByClassName("ui-datepicker-year").getText();
		}
		findLocatorByXpath("//td[@data-handler='selectDay']/a[text()='26']").click();
		WebElement editbooking = findLocatorByXpath("(//button[@type='submit'])[1]");
		elementClick(editbooking);
		System.out.println("cancel Order:");
		WebElement welcomeNotee = findLocatorByXpath("//a[contains(text(),'Welcome Sugumar')]");
		elementClick(welcomeNotee);
		WebElement Myaccountt = findLocatorByXpath("//a[contains(text(),'My Account')]");
		elementClick(Myaccountt);
		WebElement printbookingss = findLocatorByXpath("//h4[text()='Bookings (2)']");
		String printbooks = getText(printbookingss);
		System.out.println(printbooks);
		Thread.sleep(3000);
		WebElement cancelOrder = findLocatorByXpath("//a[contains(text(),'cancel)']");
		elementClick(cancelOrder);
		alertAccept();
	}

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		Hotel h = new Hotel();
		h.travelBooking();
	}

}
