package com.appium.training;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DropdownDemo {
	
public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		AndroidDriver<WebElement> driver = null;
		File f = new File("C:\\Users\\mahme\\Downloads\\General-Store.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		
		
		
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		Thread.sleep(5000);
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));").click();
		Thread.sleep(5000);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Maroof");
		Thread.sleep(5000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.quit();
		
		
		
}	

}
