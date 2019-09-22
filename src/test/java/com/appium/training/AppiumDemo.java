package com.appium.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppiumDemo {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<WebElement> driver = null;
		
		DesiredCapabilities caps = new DesiredCapabilities();
		/*
		 * caps.setCapability("deviceName", "emulator-5554");
		 * caps.setCapability("platformName", "Android");
		 */
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		//WebDriverManager.chromedriver().setup();

		
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Hello Appium!!!");
		driver.rotate(ScreenOrientation.LANDSCAPE);


		Thread.sleep(5000);

		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
	}

}
