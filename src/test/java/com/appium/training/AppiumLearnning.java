package com.appium.training;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class AppiumLearnning {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		File f= new File("C:\\Users\\MA005KH\\Downloads\\General-Store.apk");
		
		
		AndroidDriver<MobileElement> driver = null;
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.MainActivity");

		caps.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		
		driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		System.out.println("driver initialized!!!");
	   
		Thread.sleep(6000);
		driver.findElement(By.id("android:id/text1")).click();


		Thread.sleep(7000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();
		Thread.sleep(5000);
		
		 driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

	     driver.hideKeyboard();

	     driver.findElement(By.xpath("//*[@text='Female']")).click();

	     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	     
		Thread.sleep(5000);

		 driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

		 driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	Thread.sleep(4000);
	
	
	WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

	TouchAction t=new TouchAction(driver);

	t.tap(ElementOption.element(checkbox)).perform();



	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();



	Thread.sleep(7000);

	Set<String> contexts=driver.getContextHandles();

	for(String contextName :contexts)

	{

	System.out.println(contextName);

	}
	
	Thread.sleep(5000);

	driver.context("WEBVIEW_com.androidsample.generalstore");

	driver.findElement(By.name("q")).sendKeys("hello");

	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	driver.pressKey(new KeyEvent(AndroidKey.BACK));

	driver.context("NATIVE_APP");


	driver.quit();











	

	




		
		
	
	}

}
