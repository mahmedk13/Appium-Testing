package com.appium.training;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class PressKeyPadExample {
	
public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		AndroidDriver<WebElement> driver = null;
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME	, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.dialer");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".extensions.GoogleDialtactsActivity");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		Thread.sleep(5000);
		
		driver.findElementById("com.google.android.dialer:id/fab").click();
		
		Thread.sleep(3000);
		
		 driver.pressKey(new KeyEvent(AndroidKey.H));
		 driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
		 driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
		 driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 driver.pressKey(new KeyEvent(AndroidKey.H));


		
		
		driver.findElementByAccessibilityId("dial").click();
		
		driver.quit();




}
}
