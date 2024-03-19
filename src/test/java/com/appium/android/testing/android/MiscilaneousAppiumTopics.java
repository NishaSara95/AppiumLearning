package com.appium.android.testing.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscilaneousAppiumTopics extends BaseClass{
	
	
	
	/** Method to rotate the device to landscape, copy in clipboard and pressing ENTER, HOME or BACK button
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException 
	 * 
	 *App Package: "io.appium.android.apis"
	 *App Activity: "io.appium.android.apis.preference.PreferenceDependencies"
	 */
	@Test
	public void appiumOtherActivitiesExample() throws MalformedURLException, InterruptedException {
		

		// Directly jumping to the page activity where we need to perfom the testing by injecting startActivity event in Js
		//Command to retrieve activity name and package name: adb shell dumpsys window | find "mCurrentFocus"
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		WebElement wifiCheckbox = driver.findElement(AppiumBy.id("android:id/checkbox"));
		if(!wifiCheckbox.isSelected())
			wifiCheckbox.click();
		DeviceRotation landscapeDirection= new DeviceRotation(0, 0, 90);
		driver.rotate(landscapeDirection);
		DeviceRotation HorizonDirection= new DeviceRotation(0, 0, 90);
		driver.rotate(HorizonDirection);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		String wifiSettingsTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifiSettingsTitle, "WiFi settings");
		WebElement editTxt = driver.findElement(AppiumBy.className("android.widget.EditText"));
		editTxt.clear();
		driver.setClipboardText("Nisha_Wifi");
		editTxt.sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		editTxt.sendKeys("_Wifi");
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
	
	
	
	
}
