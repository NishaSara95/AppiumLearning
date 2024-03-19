package com.appium.android.testing.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeExample extends BaseClass {

	/**
	 * Method to swipe from left or right
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void swipeGestureExample() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		System.out.println("Views clicked");
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		WebElement photoGallery = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']"));
		photoGallery.click();
		WebElement image1 = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertTrue(image1.getAttribute("focusable").equals("true"));
		SwipeGesture(image1, "left");
		Assert.assertEquals(image1.getAttribute("focusable"), "false");

	}

}
