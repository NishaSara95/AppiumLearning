package com.appium.android.testing.android;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import jdk.internal.org.jline.utils.Log;



public class demoEcommerceAppTC4 extends BaseClass {

	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement nameText;

	@FindBy(how = How.ID, using = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopBtn;

/** TC: 3 To select  2 products and added to cart add assert the total price matches with  adding the price of each product 
 * 
 * @throws InterruptedException
 */

	@Test
	public void enterValidLogin() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nisha");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]"))
				.click();
		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]"))
				.click();
		System.out.println("Product added to cart");
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")).click();
		longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
		String termsTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Terms Of Conditions']")).getText();
		Assert.assertEquals(termsTitle, "Terms Of Conditions");
		driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(9000);
		Set<String> contexts = driver.getContextHandles();
		
		for (String contextName : contexts) {
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(9000);

	
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}
}
