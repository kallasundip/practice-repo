package com.Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

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

		List<WebElement> brands = driver
				.findElements(By.xpath("//div[@id='brandsRefinements']//span[@class='a-list-item']"));

		for (WebElement brand : brands) {

			String txt = brand.getText();

			if (txt.equals("OnePlus")) {

				brand.click();
				break;
			}
			System.out.println(brand.getText());
		}

		List<WebElement> results = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		for (WebElement result : results) {
			String ntxt = result.getText();

			if (ntxt.contains("OnePlus")) {

				System.out.println(ntxt + " ------------ " + " Is OnePluse Mobile");
			} else {
				System.err.println(ntxt + " ------------ " + " Is Not A OnePluse Mobile");

			}
		}

		List<WebElement> prices = driver.findElements(By.xpath(
				"//div[@class='a-row a-size-base a-color-base']//span[@class='a-price']//span[@class='a-price-whole']"));
		System.out.println("------------------");

		for (WebElement price : prices) {

			String cost = price.getText();
			String replacecost = cost.replaceAll(",", "");
			int amount = Integer.parseInt(replacecost);

			if (amount >= 10000 && amount <= 45000) {
				System.out.println(amount);
			} else {
				System.err.println(amount);
			}
		}
		System.out.println();

		
	}

	public static void main(String[] args) {
		AmazonDemo ad = new AmazonDemo();
		ad.LaunchWebsite();
		ad.Product();

	}

}
