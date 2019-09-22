package com.appium.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidDemo {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		 AndroidDriver<MobileElement> driver = null;

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.whatsapp");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Conversation");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(7000);
		
		driver.findElementById("com.whatsapp:id/eula_accept").click();
		driver.findElementById("com.whatsapp:id/registration_phone").sendKeys("9584817061");
		driver.findElementById("com.whatsapp:id/registration_submit").click();
		Thread.sleep(18000);
		
		
		try {
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		Thread.sleep(25000);
		driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
		Thread.sleep(7000);
		}catch(Exception e) {
			
		}
		
		try {
		driver.findElement(By.name("//android.widget.Button[@text='ALLOW']")).click();
		Thread.sleep(3000);

		driver.findElement(By.name("//android.widget.Button[@text='ALLOW']")).click();
		Thread.sleep(15000);
		}catch(Exception e) {
			
		}
		
		
		try {
			driver.findElement(By.name("//android.widget.Button[@text='SKIP']")).click();

		}catch(Exception e){
			
		}
		
		
		driver.findElementById("com.whatsapp:id/registration_name").sendKeys("Dummy");
		driver.findElementById("com.whatsapp:id/register_name_accept").click();
		Thread.sleep(15000);
		driver.findElementById("com.whatsapp:id/fab").click();
		
		Thread.sleep(4000);
		driver.findElementById("com.whatsapp:id/menuitem_search").click();
		driver.findElementById("com.whatsapp:id/search_src_text").sendKeys("Maroof");
		Thread.sleep(4000);

		
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(492, 376)).release().perform();
		Thread.sleep(4000);
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(driver.findElementById("com.whatsapp:id/voice_note_btn")))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform();

		
		

		




		
		
		
		driver.quit();
	}

}
