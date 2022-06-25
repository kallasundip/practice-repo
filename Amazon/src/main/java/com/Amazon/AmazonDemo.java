package com.Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonDemo {
	
WebDriver driver;
	
	public void LaunchWebsite() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}

	public void Product() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		
		List<WebElement> brands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//span[@class='a-list-item']"));
		
		for (WebElement brand : brands) {
			
			String txt = brand.getText();
			
			if(txt.equals("OnePlus")) {
				
				brand.click();
				break;
			}
			System.out.println(brand.getText());
		}
		
		
		List<WebElement> results = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		
		for (WebElement result : results) {
			String ntxt = result.getText();
			
			if(ntxt.contains("OnePlus")) {
				
				System.out.println(ntxt+ " ------------ "+ " Is OnePluse Mobile");
			}
			else {
				System.err.println(ntxt+ " ------------ "+ " Is Not A OnePluse Mobile");
			
			}
			
			
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		AmazonDemo ad = new AmazonDemo();
		ad.LaunchWebsite();
		ad.Product();

	}

}
