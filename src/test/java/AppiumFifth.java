import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class AppiumFifth {
	public static AndroidDriver<MobileElement> driver = null;


	public static  void main(String[] args) throws MalformedURLException, InterruptedException {



		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.dialer");

		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".extensions.GoogleDialtactsActivity");
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();





		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.google.android.dialer:id/fab").click();
		Thread.sleep(3000);

		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_0));


		
		
		Thread.sleep(5000);
		
		
		
		


		

		driver.quit();

	}


}
