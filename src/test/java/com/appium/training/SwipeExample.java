package com.appium.training;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeExample {
	
	AndroidDriver<WebElement> driver = null;

	public void swipeScreen(WebElement element, double startPercentage, double endPercentage) {
		//WebElement clockScreen = driver.findElementById("com.google.android.deskclock:id/cities");
		
		int screenSize = element.getSize().getHeight();
		
		Double screenStart = element.getSize().getWidth()*startPercentage;
		Double screenEnd = element.getSize().getWidth()*endPercentage;
		
		
		int start = screenStart.intValue();
		int end = screenEnd.intValue();
		
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(start, screenSize)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).
		moveTo(PointOption.point(end, screenSize)).release().perform();
		
		
	}
	
public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		AndroidDriver<WebElement> driver = null;
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.deskclock");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.deskclock.DeskClock");
		
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		
		

		
		
		Thread.sleep(5000);
		
		
		driver.quit();
		service.stop();



}
}
