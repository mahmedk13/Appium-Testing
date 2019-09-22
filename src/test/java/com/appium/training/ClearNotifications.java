package com.appium.training;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ClearNotifications {
	
public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<WebElement> driver = null;
		
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.nexuslauncher");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".NexusLauncherActivity");
		
		
		//AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		//service.start();
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		driver.openNotifications();
		
		WebElement clearAll = driver.findElementByXPath("//android.widget.Button[@text='CLEAR ALL']");
		clearAll.click();
		
		driver.quit();
		


}
}
