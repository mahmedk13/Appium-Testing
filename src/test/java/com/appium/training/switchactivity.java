package com.appium.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class switchactivity {
	
	public static String clockPkg = "com.google.android.deskclock";
	public static String clockActivity = "com.android.deskclock.DeskClock";
	
	public static String dialerPkg = "com.google.android.apps.messaging";
	public static String dialerActivity = ".ui.ConversationListActivity";

	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		

		AndroidDriver<WebElement> driver = null;
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME	, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.messaging");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.ConversationListActivity");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		Thread.sleep(5000);
		driver.findElementByAccessibilityId("Start new conversation").click();
		Thread.sleep(5000);
		String activity =driver.currentActivity();
		System.out.println(activity);


		
		driver.startActivity(new Activity(clockPkg, clockActivity));
		
		WebElement clockScreen;
		try {
		 clockScreen = driver.findElementById("com.google.android.deskclock:id/cities");
		}catch(Exception e) {
			clockScreen=driver.findElementById("com.google.android.deskclock:id/alarm_recycler_view");
		}
		
		int screenSize = clockScreen.getSize().getHeight();
		System.out.println(screenSize);
		
		System.out.println("screen start "+clockScreen.getSize().getWidth());
		
		Double screenStart = clockScreen.getSize().getWidth()*0.2;
		Double screenEnd = clockScreen.getSize().getWidth()*0.95;
		
		
		int start = screenStart.intValue();
		int end = screenEnd.intValue();
		
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(end, screenSize)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).
		moveTo(PointOption.point(start, screenSize)).release().perform();
		
		
		Thread.sleep(5000);

		
		String xyz =driver.getAutomationName();
		System.out.println(xyz);
		driver.startActivity(new Activity(dialerPkg,activity));
		
		
		Thread.sleep(5000);

		driver.quit();

		
	}

}
