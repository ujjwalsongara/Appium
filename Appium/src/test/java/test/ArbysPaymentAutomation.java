package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import lombok.var;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.*;
        import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;

public class ArbysPaymentAutomation {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void setup() throws MalformedURLException, InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportArby2.html");
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

            Thread.sleep(3000);
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


            Thread.sleep(10000);
            WebElement el15 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/ivCancel"));
            el15.click();

            Thread.sleep(5000);
            WebElement el38 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvFavourite"));
            el38.click();

            Thread.sleep(7000);
            WebElement el39 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btOrdedrNow"));
            el39.click();

            Thread.sleep(5000);
            WebElement timePicker = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/edt_time"));
            timePicker.click();
            test.pass("Opened time picker");

            try {
                WebElement element = driver.findElement(
                        MobileBy.AndroidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"11\"))"
                        )
                );
                element.click();
                test.pass("Time '11' selected from picker");

            } catch (NoSuchElementException e) {
                test.fail("Value '11' not found in time picker");
                Assert.fail("Time picker failed");
            }

//            WebElement amPm = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"p.m.\")"));
//            amPm.click();
//            test.pass("Selected PM");

            Thread.sleep(5000);
            WebElement okBtn = driver.findElement(AppiumBy.id("android:id/button1"));
            okBtn.click();
            test.pass("Confirmed time");

            Thread.sleep(7000);
            WebElement proceed2 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
            proceed2.click();
            test.pass("Clicked Proceed again");

            Thread.sleep(7000);
            WebElement el25 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_home"));
            el25.click();

            Thread.sleep(10000);
            WebElement el26 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_cart"));
            el26.click();

            Thread.sleep(50000);

            var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(381, 1749);
            var end = new Point (426, 962);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            test = extent.createTest("payment Flow Test").assignCategory("Regression");

            Thread.sleep(7000);
            WebElement el23 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/rbPaymentType\").instance(1)"));
            el23.click();

            Thread.sleep(3000);
            WebElement el24 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
            el24.click();

            test.pass("Final checkout completed");

            Thread.sleep(70000);


            WebElement el31 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ccNum\")"));
            el31.click();
//            WebElement el32 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ccName\")"));
            el31.sendKeys("test");

            Thread.sleep(5000);
            WebElement el33 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ccNum\")"));
            el33.click();
            el33.sendKeys("4111111111111111");

            Thread.sleep(5000);
            WebElement el34 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"expiry\")"));
            el34.click();
            el34.sendKeys("01/28");

            Thread.sleep(5000);
            WebElement el35 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"cvv\")"));
            el35.click();
            el35.sendKeys("081");

            Thread.sleep(5000);
            WebElement el36 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"zip\")"));
            el36.click();
            el36.sendKeys("m9zm9z");

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
             start = new Point(483, 1356);
             end = new Point (491, 831);
             swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));


             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
             start = new Point(471, 1446);
             end = new Point (471, 979);
             swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement el37 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(0)"));
            el37.click();

            Thread.sleep(5000);
            WebElement el48 = driver.findElement(AppiumBy.className("android.widget.Button"));
            el48.click();
















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

