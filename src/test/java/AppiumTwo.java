import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumTwo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AppiumDriver<?> driver = null;

		//File f = new File(".//app//selendroid-test-app-0.11.0.apk");
		AppiumDriverLocalService service = AppiumDriverLocalService.
				buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\mahme\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")).withArgument(GeneralServerFlag.LOCAL_TIMEZONE));

		service.start();


		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	//	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nokia");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");


		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Hello Appium!!!");
		driver.rotate(ScreenOrientation.LANDSCAPE);


		Thread.sleep(5000);

		driver.quit();
		service.stop();




	}



}
