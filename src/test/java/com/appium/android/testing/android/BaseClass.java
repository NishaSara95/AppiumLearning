package com.appium.android.testing.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AppiumDriverLocalService serviceBuilder;

	public AndroidDriver driver;

	/**
	 * This method shows the basics of appium adding the UI automator 2 and adding
	 * the desired capabilities
	 * 
	 * @throws MalformedURLException Using Url class to add the default port url of
	 *                               appium Using UIAutomator2Options for adding the
	 *                               device onfiguration such as Device name,
	 *                               apkfile and other details etc
	 */

	@BeforeClass
	public void configAppiumServer() throws MalformedURLException {
		// Starting server by automation using Class AppiumServiceBuilder by using its
		// method withApiumJs
		serviceBuilder = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C://Users//Windows 11//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(30)).
				
				build();
		serviceBuilder.start();
		// Configuring the mobile device name and apk file using UIAutomator2Options so
		// the server communicates to that mobile and perform operation
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("NishaAndroidEmulator"); // Emulator
		//options.setDeviceName("Android Device");  // Real device
		options.setChromedriverExecutable("C://Users//Windows 11//Documents//chromedriver_win32//chromedriver.exe");

		// This apk path link is for api demo app
		// options.setApp(
		// "C://Users//Windows 11//eclipse-workspace//Workspace
		// 2//Appium_Learning//src//test//resources//ApiDemos-debug.apk");
		// This apk path link is for ecommerce demo app
		options.setApp(
				"C://Users//Windows 11//eclipse-workspace//Workspace 2//Appium_Learning//src//test//resources//General-Store.apk");

		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver(url, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}

	/**
	 * Common method for Long press gestures
	 * 
	 * @param element
	 */
	public void longPressAction(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
	}

	/**
	 * Common method for Scroll till element is visible
	 * 
	 * @param value
	 */

	public void ScrollIntoView(String value) {
		String selectorExpression = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + value + "\"));";
		driver.findElement(AppiumBy.androidUIAutomator(selectorExpression));
	}

	/**
	 * Common method to swipe gesture left or right
	 * 
	 * @param ele
	 * @param direction
	 */
	public void SwipeGesture(WebElement ele, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));
	}

	/**
	 * Common method for dragging and dropping using element Id , X and Y
	 * coordinates
	 * 
	 * @param ele
	 * @param x
	 * @param y
	 */
	public void dragAndDrop(WebElement ele, int x, int y) {

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "endX", x, "endY", y));
	}

	
	/** Common method to wait for Page load
	 * 
	 * @param ele
	 * @param text
	 * @param value
	 */
	public void waitForPageLoad(WebElement ele, String text, String value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, text, value));

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
		serviceBuilder.stop();
	}

}
