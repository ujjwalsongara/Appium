package test;

import java.net.MalformedURLException;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class MyFirstAppium {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Pixel 7 API VanillaIceCream");
		capabilities.setCapability("platformname", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("app", "/Users/pankajsonava/Downloads/com-miui-calculator-315003003-70230966-ec423981671a2a7f8dc75626c6c33e21.apk");
		capabilities.setCapability("platformversion", "14");
		capabilities.setCapability("autoGrantPermissions", true);

		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url, capabilities);

		Thread.sleep(2000);
		System.out.println("Application Started");

		Thread.sleep(2000);

		WebElement el1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Signup\")"));
		el1.click();
		System.out.println("SignUp is " + el1 + "Clicked");
		Thread.sleep(2000);
		WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Name\")"));
		el2.click();
		el2.sendKeys("marksingh");
		System.out.println("Name is " + el2 + "Entered");

				
	}

}
