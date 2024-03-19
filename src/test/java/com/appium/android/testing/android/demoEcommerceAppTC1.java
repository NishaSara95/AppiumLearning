package com.appium.android.testing.android;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import jdk.internal.org.jline.utils.Log;

public class demoEcommerceAppTC1 extends BaseClass {

	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement nameText;

	@FindBy(how = How.ID, using = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopBtn;

/*
 *  TC: 1  To select Lets cart button and assert the toast message
 *  To select the country from dropdown by scrolling to the country and entering Name and clicking on Lets shop button
 */
	

	@Test
	public void enterValidLogin() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		ScrollIntoView("Australia");
		driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Australia\"]"))
				.click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nisha");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(1000);
	}
}
