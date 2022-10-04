package com.selen.test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImages {
	public static void main(String[] args) throws Exception  {

	//	verifyBrokenImagesUsingSelenium();
		verifyBrokenImagesUsingjsoup();
	
	}

	/*public static void verifyBrokenImagesUsingSelenium() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.theworldsworstwebsiteever.com/");
		driver.manage().window().maximize();

		List<WebElement> images=  driver.findElements(By.tagName("img"));
		int brokenimages=0;

		for (WebElement image : images) {

			String imagesrc=image.getAttribute("src");      // image address

			if(imagesrc==null || imagesrc.isEmpty()) {
				System.out.println("it is not broken image");
				continue;

			}

			


			try {
                 URL link = new URL(imagesrc);       //url connection send a request to the server  
				HttpURLConnection http =  (HttpURLConnection)link.openConnection();
				http.setConnectTimeout(5000);
				http.connect();
				if(http.getResponseCode()>=400) {
					System.err.println(http.getResponseCode()+imagesrc+" "+ "is broken image");
					brokenimages++;
				}
				else 
					System.out.println(http.getResponseCode()+imagesrc+""+" is not broken image");

				http.disconnect();
			}
			catch(Exception e) {
				System.err.println(imagesrc);
			}

		}
		System.out.println(brokenimages);
		driver.quit();




	}*/
	public static void verifyBrokenImagesUsingjsoup() throws Exception {


		Document doc = Jsoup.connect("https://www.theworldsworstwebsiteever.com/").get();
	
		Elements images = doc.select("img");
		for (Element image : images) {
	      String imagesrc= image.attr("src");
	      
	      if(!imagesrc.startsWith("http"))
	    	  imagesrc="https://www.theworldsworstwebsiteever.com/"+imagesrc;
		
		   
			try {
				URL link = new URL(imagesrc);            //url connection  we send a request to the server
				HttpURLConnection http =  (HttpURLConnection)link.openConnection();
				http.setConnectTimeout(5000);
				http.connect();
				if(http.getResponseCode()>=400) {
					System.err.println(http.getResponseCode()+imagesrc+" "+ "is broken image");
					
				}
				else 
					System.out.println(http.getResponseCode()+imagesrc+""+" is not broken image");

				http.disconnect();
			}
			catch(Exception e) {
				System.err.println(imagesrc);
			}

			
			
		}
		
	}

	}
