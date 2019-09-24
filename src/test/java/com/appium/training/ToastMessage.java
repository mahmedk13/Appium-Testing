package com.appium.training;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ToastMessage {
	
	 public static AndroidDriver<WebElement> driver;
	 public static String destDir;
	 public static DateFormat dateFormat;
	 public static String scrPath;
	
	
	//Method for Capturing Screenshot
	


		public static void takeScreenShot() {
			  // Set folder name to store screenshots.
			   destDir = "screenshots";
			  // Capture screenshot.
			  File scrFile = driver.getScreenshotAs(OutputType.FILE);
			  // Set date format to set It as screenshot file name.
			   dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			  // Create folder under project with name "screenshots" provided to destDir.
			  new File(destDir).mkdirs();
			  // Set file name using current date time.
			  String destFile = dateFormat.format(new Date()) + ".png";

			  try {
			   // Copy paste file at destination folder location
			   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			    scrPath = destDir+ "/" + destFile;
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			 }
		
	
		
		public static String OCR(String ImagePath)
		{
			 
	       
		      ITesseract instance = new Tesseract();  
		      instance.setDatapath("D:\\eclipse workspace\\AppiumLearning\\tessdata");

			//Tesseract in = new ReadImageText().getTesseractInstance("D:\\eclipse workspace\\AppiumLearning\\tessdata", "eng");

			String result = null;
			  File imageFile = new File(ImagePath);
		    //  ITesseract instance = new Tesseract();  
		      try {
		          result = instance.doOCR(imageFile);
		     
		      } catch (TesseractException e) {
		          System.err.println(e.getMessage());
		      }
			return result;
		  }


		public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		
		File f = new File("C:\\Users\\MA005KH\\Downloads\\Selendroid-Test-App-0-11-0\\selendroid-test-app-0.11.0.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability("automationName", "UiAutomator2");


		caps.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());

		
		driver= new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		System.out.println("driver initialized!!!");
		Thread.sleep(10000);
		
		//driver.findElementById("io.selendroid.testapp:id/buttonTest").click();
		driver.findElementById("io.selendroid.testapp:id/showToastButton").click();
		Thread.sleep(1500);
		takeScreenShot();
		Thread.sleep(5000);
		String text = OCR(scrPath);
		System.out.println("khan");
		System.out.println(text);
		
		
		
		
}
}
