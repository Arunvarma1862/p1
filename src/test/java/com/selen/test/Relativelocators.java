package com.selen.test;


import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Relativelocators {
	public static void main(String[] args) 
	
	{

		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();

		options.addArguments("Start-maximized");
		
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		/*options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
		  options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		  options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));*/
		WebDriver driver = new EdgeDriver(options);
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://github.com/login");
		
		// above
		WebElement nameEditBox=  driver.findElement(By.xpath("//input[@id='login_field']"));
		String text2=  driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(text2);
		
		// below
		WebElement pass= driver.findElement(By.xpath("//label[normalize-space(text())='Password']"));
        WebElement text3 = driver.findElement(with(By.tagName("input")).below(pass));
		text3.sendKeys("hello");
		System.out.println(text3.getAttribute("value"));

	
	   // leftOf	
	    WebElement account=	driver.findElement(By.xpath("//a[text()='Privacy']"));
	    String text4=  driver.findElement(with(By.tagName("a")).toLeftOf(account)).getText();
	    System.out.println(text4);
	   
	   // RightOf	
	   
	   WebElement account2  =  driver.findElement(By.xpath("//a[text()='Terms']"));
	   String text5=  driver.findElement(with(By.tagName("a")).toRightOf(account2)).getText();
	   System.out.println(text5);
	   
	   
	   driver.quit();
	}

}

