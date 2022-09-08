package com.selen.test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	public static void main(String[] args) throws MalformedURLException  {
		
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		

		List<WebElement> links=	driver.findElements(By.tagName("a"));

		int brokenLinks=0;

		for (WebElement webEle : links)
		{
			String url=	webEle.getAttribute("href");
			if(url==null || url.isEmpty())
			{
				System.out.println("url is empty");
				continue;

			}

			URL link = new URL(url);
			
			try {
				HttpURLConnection http = (HttpURLConnection) link.openConnection();
				if(http.getResponseCode()>=400) 
				{

					System.out.println(http.getResponseCode()+url+"  is "+"brokenlink");
					brokenLinks++;
				}
				else
				{
					System.out.println(http.getResponseCode()+url+" is "+ " valid link");
				}
			}
			catch(Exception e) 
			{

			}
		}
		System.out.println(brokenLinks);
		driver.close();






	}    
}
