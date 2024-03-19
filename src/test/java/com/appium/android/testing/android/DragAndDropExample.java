package com.appium.android.testing.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragAndDropExample extends BaseClass {

	/**
	 * Method to drag and drop example
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void dragAndDropExample() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		System.out.println("Views clicked");
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Drag and Drop']")).click();
		WebElement dragObj = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

		dragAndDrop(dragObj,617, 553);
		Thread.sleep(2000);
		WebElement dropMessage = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text"));
		Assert.assertTrue(dropMessage.isDisplayed());
		
			

	}

}
