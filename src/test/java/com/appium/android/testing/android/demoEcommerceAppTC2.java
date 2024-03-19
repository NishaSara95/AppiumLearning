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

public class demoEcommerceAppTC2 extends BaseClass {



// TC2:  To select by scroll down to the product and selecting add to cart button and moving to Cart page and asserting the product 

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
		// Scrolling till the product Jordan 6 Rings is displayed using the below method
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
//		driver.findElement(AppiumBy
//			    .androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"))"));
		Thread.sleep(1000);
		int productItemsize = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i < productItemsize; i++) {
			String product = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();
			if (product.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				System.out.println("Product added to cart");
				Thread.sleep(1000);
			}

		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(1000);
		WebElement cartTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		System.out.println(cartTitle.getText());
		waitForPageLoad(cartTitle, "text", "Cart");
		String cartprodName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(cartprodName, "Jordan 6 Rings");
	}
}
