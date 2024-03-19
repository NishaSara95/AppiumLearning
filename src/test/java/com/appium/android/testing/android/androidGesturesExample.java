package com.appium.android.testing.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class androidGesturesExample extends BaseClass {

	
	/** Method is for long Click Gestures
	 * 
	 */
	
	@Test
	public void longGesturesExample() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		System.out.println("Views clicked");
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		WebElement peopleNameElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		
		longPressAction(peopleNameElement);
		String sampleMenuText = driver.findElement(By.xpath("//android.widget.TextView")).getText();
		Assert.assertEquals(sampleMenuText, "Sample menu");
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView")).isDisplayed());
	}
	

	
}
