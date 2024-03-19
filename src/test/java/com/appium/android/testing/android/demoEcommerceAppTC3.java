package com.appium.android.testing.android;

import java.time.Duration;
import java.util.Iterator;
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

public class demoEcommerceAppTC3 extends BaseClass {

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
		Thread.sleep(1000);

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
		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]"))
				.click();
		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]"))
				.click();
		System.out.println("Product added to cart");
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(500);
		WebElement cartTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		System.out.println(cartTitle.getText());
		waitForPageLoad(cartTitle, "text", "Cart");
		String totalAmt = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		String[] totalAmt1 = totalAmt.split(" ");
		System.out.println("totalAmt1[1]" + totalAmt1[1]);
		Double totalAmtInt = Double.parseDouble(totalAmt1[1]);
		int prodsSize = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		Double totalProdAmt = 0.0;
		for (int i = 0; i < prodsSize; i++) {

			String prodValue = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText();
			System.out.println(prodValue);
			String[] prodValueSplit = prodValue.split("\\$");
			Double productValInt = Double.parseDouble(prodValueSplit[1]);
			totalProdAmt += productValInt;

		}
		System.out.println("totalAmtInt: " + totalAmtInt);
		System.out.println("totalProdAmt: " + totalProdAmt);
		Assert.assertEquals(totalAmtInt, totalProdAmt, 0.001);


	}
}
