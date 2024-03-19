package com.appium.android.testing.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollGestureExample extends BaseClass {

	
	/** Method to scroll using height and width and to scroll tlll element is visible
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void scrollGesturesScrollToCordinatesExample() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		System.out.println("Views clicked");
		 //The Method to scroll tlll element is visible
		//ScrollIntoView("WebView");
		boolean canScrollMore=true;				
		while(canScrollMore) {
		  canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
		            ImmutableMap.builder()
		            .put("left", 100)
		            .put("top", 100)
		            .put("width", 200)
		            .put("height", 200)
		            .put("direction", "down")
		            .put("percent", 3.0)
		            .build()
		        );
		 
			Thread.sleep(200);
			
	}
	}
	
}
