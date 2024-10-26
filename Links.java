package com.Framework;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		int count = 0;
		List<WebElement> links = driver.findElements(By.tagName("a"));
	for (WebElement link : links) {
		String attribute = link.getAttribute("href");
		if (attribute!=null) {
			if (attribute.startsWith("http")) {
				URL url = new URL(attribute);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpurlconnection = (HttpURLConnection)urlConnection;
				int code = httpurlconnection.getResponseCode();
				
					System.out.println("response code"+code+""+"links--->"+attribute);
					count++;
				}
				
				
			}
			
	
		}
	System.out.println("response code"+count);
	}
		
	}


