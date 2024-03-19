package com.appium.android.testing.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserExample extends BrowserBaseClass{

	
	@Test
	public void mobileBrowserTest() {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.xpath("(//li[@class='nav-item active'])[1]/a")).click();
	((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 1000)","");
	
	driver.findElement(By.xpath("//a[text()='Devops']")).click();
	driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
	((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 1000)","");
	String cartMsg = driver.findElement(By.xpath("//p[text()='This Product is already added to Cart']")).getText();
	Assert.assertEquals(cartMsg, "THIS PRODUCT IS ALREADY ADDED TO CART");

	}
}
