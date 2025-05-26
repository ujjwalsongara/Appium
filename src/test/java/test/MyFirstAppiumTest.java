package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Clock;
import java.time.Duration;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MyFirstAppiumTest {

    AndroidDriver driver;
//    ExtentReports extent;
//    ExtentTest test;

    @Test
    public void setup() throws MalformedURLException, InterruptedException {
        // Setup ExtentReports
//        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTest1Report.html");
//        extent = new ExtentReports();
//        extent.attachReporter(spark);

        // Setup Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 7 API VanillaIceCream");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("app", "/Users/pankajsonava/Downloads/Arby'sBuzzparadeSigned.apk");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("autoGrantPermissions", true);
//        capabilities.setCapability("appPackage", "com.buzzparade.arbysintl");
//        capabilities.setCapability("appActivity", "com.buzzparade.arbysintl");

        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        driver = new AndroidDriver(url, capabilities);

        Thread.sleep(2000);
        WebElement skipButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btnSkip"));
        skipButton.click();

        Thread.sleep(5000);

        WebElement AllowButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvPositive"));
        AllowButton.click();

        Thread.sleep(4000);
        WebElement threeDot = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_overflow"));
        threeDot.click();

        Thread.sleep(4000);
        WebElement loginButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/menu_login"));
        loginButton.click();

        Thread.sleep(2000);
        WebElement el8 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btnEmailLogin"));
        el8.click();

        Thread.sleep(2000);
        WebElement el9 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/login_name"));
        el9.click();
        el9.sendKeys("ujjwal@buzzparade.com");

        Thread.sleep(2000);

        WebElement el10 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/login_password"));
        el10.click();
        el10.sendKeys("Testpassword@12");

        Thread.sleep(2000);
        WebElement el11 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_SignIn"));
        el11.click();

        Thread.sleep(7000);
        WebElement el12 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_cart"));
        el12.click();
//        WebElement el12 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btnViewCart"));
//        el12.click();

        Thread.sleep(7000);
        WebElement el14 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvPositive"));
        el14.click();

        Thread.sleep(7000);
        WebElement el15 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
        el15.click();

        Thread.sleep(7000);
        WebElement el16 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_pickup"));
        el16.click();

        Thread.sleep(7000);
        WebElement el17 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
        el17.click();

        Thread.sleep(10000);
        WebElement el18 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btnConformStore"));
        el18.click();

        Thread.sleep(5000);
        WebElement el19 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/edt_time"));
        el19.click();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"2\"))")).click();
        // Set minute to 30
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"30\"))"
        )).click();

//        // Set Hour
//        driver.findElement(By.xpath("//*[@text='2']")).click();
//
//// Set Minute
//        driver.findElement(By.xpath("//*[@text='30']")).click();
        Thread.sleep(5000);
        WebElement el20 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"p.m.\")"));
        el20.click();

        Thread.sleep(5000);
        WebElement el21 = driver.findElement(AppiumBy.id("android:id/button1"));
        el21.click();

        Thread.sleep(5000);
        WebElement el22 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
        el22.click();

        Thread.sleep(5000);
        driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"com.buzzparade.arbysintl:id/rbPaymentType\"))"
                )
        );
        Thread.sleep(3000);
        WebElement el24 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
        el24.click();
        Thread.sleep(5000);

    }

}
