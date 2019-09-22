package com.appium.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollDemo {
	
	List<MobileElement> list = driver.findElements(By.xpath("//android.widget.TextView[@text='Awesome Android - UI Libraries']"));
	MobileElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Awesome Android - UI Libraries']"));
	
	public void scrollDown(List<MobileElement> list, double startHeight, double startEnd, WebElement element) {
		while(list.size()==0) {

			Dimension dimension = driver.manage().window().getSize();
			
			Double scrollHeightStart = dimension.getHeight()*startHeight;
			Double scrollHeightEnd = dimension.getHeight()*startEnd;
			
			int scrollStart = scrollHeightStart.intValue();
			int scrollEnd = scrollHeightEnd.intValue();

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).
			moveTo(PointOption.point(0, scrollEnd)).release().perform();
			}
			
			System.out.println("I am outside while loop...going to click element");
			element.click();
	}
	
	public static AppiumDriver<MobileElement> driver = null;




	public static void main(String[] args) throws MalformedURLException, InterruptedException {




		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.vending");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".AssetBrowserActivity");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);





		Thread.sleep(105000);

		driver.findElement(By.id("com.android.vending:id/search_box_idle_text")).click();
		Thread.sleep(50000);
		System.out.println("2nd wait finished");

		driver.findElement(By.id("com.android.vending:id/search_box_text_input")).sendKeys("Api Demos");

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		
		Thread.sleep(30000);
		
		
		
		
		Thread.sleep(6000);
		
		driver.quit();
		
		
		
	
	}

}
