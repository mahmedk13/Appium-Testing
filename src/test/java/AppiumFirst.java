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
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumFirst {
	public static AppiumDriver<MobileElement> driver = null;


	public static  void main(String[] args) throws MalformedURLException, InterruptedException {


		//File f = new File(".\\app\\selendroid-test-app-0.11.0.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0.0");

		//caps.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.whatsapp");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.whatsapp.registration.EULA");
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);




		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		MobileElement button = driver.findElement(By.id("com.whatsapp:id/eula_accept"));
		button.click();

		MobileElement phone = driver.findElement(By.id("com.whatsapp:id/registration_phone"));
		phone.sendKeys("9584817061");
		driver.hideKeyboard();
		


		TouchAction action = new TouchAction((PerformsTouchActions)driver);
		action.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(300, 400))).perform();
		action.tap(PointOption.point(300, 400)).perform();
		action.tap(TapOptions.tapOptions().withElement(ElementOption.element(phone)));
		action.tap(ElementOption.element(phone)).perform().release();




		Thread.sleep(5000);

		driver.quit();

	}


}
