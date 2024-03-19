package com.appium.android.testing.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseClass{
	
	
	
	/** Method to open the demo app and do basic Click and send key operations	
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException 
	 */
	@Test
	public void appiumBasicApp() throws MalformedURLException, InterruptedException {
		
		Thread.sleep(5000);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		System.out.println("Preference clicked");
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		WebElement wifiCheckbox = driver.findElement(AppiumBy.id("android:id/checkbox"));
		if(!wifiCheckbox.isSelected())
			wifiCheckbox.click();
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		String wifiSettingsTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifiSettingsTitle, "WiFi settings");
		WebElement editTxt = driver.findElement(AppiumBy.className("android.widget.EditText"));
		editTxt.clear();
		editTxt.sendKeys("Nisha_Wifi");
		driver.findElement(By.id("android:id/button1")).click();
		
	}
	
	
	
	
}
