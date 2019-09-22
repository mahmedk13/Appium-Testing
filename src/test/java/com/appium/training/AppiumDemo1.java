package com.appium.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumDemo1 {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<WebElement> driver = null;
		
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		
		
		//AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		//service.start();
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		
		
		
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.rotate(ScreenOrientation.LANDSCAPE);
		
		driver.findElement(By.name("q")).sendKeys("Hello World!");
		
		Thread.sleep(5000);
		
		driver.quit();
		//service.stop();
		
		
	}

}
