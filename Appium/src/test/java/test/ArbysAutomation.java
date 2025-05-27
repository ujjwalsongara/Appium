package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.NoSuchElementException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.*;
        import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;

public class ArbysAutomation {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void setup() throws MalformedURLException, InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportArby.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 7");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
//        capabilities.setCapability("app", "/Users/pankajsonava/Downloads/Arby'sBuzzparadeSigned.apk");
        capabilities.setCapability("app","/Users/apple/Downloads/Arby'sBuzzparadeSigned_nounattendedcartblock.apk");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("autoGrantPermissions", true);

        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        driver = new AndroidDriver(url, capabilities);

        test = extent.createTest("Signup Flow Test").assignCategory("Regression");

        try {
            Thread.sleep(2000);
            test.info("Application started");

            WebElement skipButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btnSkip"));
            skipButton.click();
            test.pass("Clicked on Skip");

            Thread.sleep(5000);
            WebElement allowButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvPositive"));
            allowButton.click();
            test.pass("Clicked on Allow button");

            Thread.sleep(5000);
            WebElement threeDot = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_overflow"));
            threeDot.click();
            test.pass("Opened menu options");

            Thread.sleep(5000);
            WebElement loginButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/menu_login"));
            loginButton.click();
            test.pass("Clicked on Login");

            Thread.sleep(5000);
            WebElement el8 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btnEmailLogin"));
            el8.click();
            test.pass("Selected Email Login");

            Thread.sleep(5000);
            WebElement email = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/login_name"));
            email.sendKeys("ujjwal@buzzparade.com");
            test.pass("Entered email");

            Thread.sleep(5000);
            WebElement password = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/login_password"));
            password.sendKeys("Testpassword@12");
            test.pass("Entered password");

            Thread.sleep(5000);
            WebElement signIn = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_SignIn"));
            signIn.click();
            test.pass("Clicked on Sign In");

            Thread.sleep(10000);
            WebElement cart = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_cart"));
            cart.click();
            test.pass("Opened Cart");

            Thread.sleep(5000);
            WebElement continueCart = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvPositive"));
            continueCart.click();
            test.pass("Confirmed cart");

            Thread.sleep(5000);
            WebElement checkout = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
            checkout.click();
            test.pass("Clicked Checkout");

            Thread.sleep(5000);
            WebElement pickup = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_pickup"));
            pickup.click();
            test.pass("Selected Pickup");

            Thread.sleep(5000);
            WebElement proceed = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
            proceed.click();
            test.pass("Clicked Proceed");

            Thread.sleep(7000);
            WebElement confirmStore = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btnConformStore"));
            confirmStore.click();
            test.pass("Confirmed store");

            Thread.sleep(5000);
            WebElement timePicker = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/edt_time"));
            timePicker.click();
            test.pass("Opened time picker");

            try {
                WebElement element = driver.findElement(
                        MobileBy.AndroidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"1\"))"
                        )
                );
                element.click();
                test.pass("Time '1' selected from picker");

            } catch (NoSuchElementException e) {
                test.fail("Value '1' not found in time picker");
                Assert.fail("Time picker failed");
            }

            WebElement amPm = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"p.m.\")"));
            amPm.click();
            test.pass("Selected PM");

            Thread.sleep(5000);
            WebElement okBtn = driver.findElement(AppiumBy.id("android:id/button1"));
            okBtn.click();
            test.pass("Confirmed time");

            Thread.sleep(5000);
            WebElement proceed2 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
            proceed2.click();
            test.pass("Clicked Proceed again");

            Thread.sleep(7000);
            driver.findElement(
                    MobileBy.AndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"PaymentType\"))"
                    )
            );
            test.pass("Scrolled to Payment Type");

            Thread.sleep(5000);
            WebElement paymentOption = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/rbPaymentType\")"));
            paymentOption.click();
            test.pass("Selected payment method");

            Thread.sleep(5000);
            WebElement finalCheckout = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
            finalCheckout.click();
            test.pass("Final checkout completed");

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (extent != null) {
            extent.flush();
        }
    }
}

