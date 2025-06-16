package test.androidApp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.var;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class arbyGooglePayPayment {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void googlePayPayment() throws MalformedURLException, InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportArbyGooglePayPayment.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        DesiredCapabilities capabilities = getAndroidDriver();


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

            test = extent.createTest("pickup Flow Test").assignCategory("Regression");

            Thread.sleep(20000);
            WebElement pickupBtn = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)"));
            pickupBtn.click();
            test.pass("Clicked on pickup");

            Thread.sleep(50000);
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

            Thread.sleep(7000);
            WebElement okBtn = driver.findElement(AppiumBy.id("android:id/button1"));
            okBtn.click();
            test.pass("Confirmed time");

            Thread.sleep(7000);
            WebElement proceed2 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
            proceed2.click();
            test.pass("Clicked Proceed again");

            test = extent.createTest("Menu Flow Test").assignCategory("Regression");


            Thread.sleep(50000);
            WebElement meals = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivMenuItem\").instance(1)"));
            meals.click();
            test.pass("Clicked on meals");

            Thread.sleep(7000);
            WebElement item = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/btAddCart\").instance(0)"));
            item.click();
            test.pass("Clicked on item add");

            Thread.sleep(90000);

            var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(418, 1802);
            var end = new Point(451, 762);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(7000);
            WebElement side = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivMaxMin\").instance(2)"));
            side.click();
            test.pass("Clicked on side");

            Thread.sleep(7000);
            WebElement fries = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(19)"));
            fries.click();
            test.pass("Clicked on fries add");

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(389, 1786);
            end = new Point(418, 762);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(9000);
            WebElement Beverage = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivMaxMin\").instance(1)"));
            Beverage.click();
            test.pass("Clicked on Beverage");

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(405, 1925);
            end = new Point(410, 1057);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(9000);
            WebElement shake = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(18)"));
            shake.click();
            test.pass("added item");

            Thread.sleep(7000);
            WebElement addCart = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/clAddCart"));
            addCart.click();
            test.pass("Clicked on AddCart");

            Thread.sleep(10000);
            WebElement viewCart = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvNegative"));
            viewCart.click();
            test.pass("Clicked on viewCart");

//            Thread.sleep(50000);
//            WebElement proceed2B = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
//            proceed2B.click();
//            test.pass("Clicked Proceed again");

//            Thread.sleep(9000);
//            WebElement el25 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_home"));
//            el25.click();
//
//            Thread.sleep(20000);
//            WebElement el26 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_cart"));
//            el26.click();

            Thread.sleep(90000);

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(381, 1749);
            end = new Point(426, 962);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));


            Thread.sleep(7000);
            WebElement payment = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/rbPaymentType\").instance(1)"));
            payment.click();
            test.pass("Clicked on payment");

            Thread.sleep(3000);
            WebElement checkout = driver.findElement(AppiumBy.id("com.google.android.gms:id/pay_button_view"));
            checkout.click();
            test.pass("Clicked on checkout");

            test = extent.createTest("Payment method").assignCategory("Regression");

            Thread.sleep(50000);
            WebElement googlePay = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Pay now\")"));
            googlePay.click();
            test.pass("Clicked on googlePay");

            Thread.sleep(70000);
            test.pass("Final checkout completed");

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    private static DesiredCapabilities getAndroidDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/apple/Downloads/Arby'sBuzzparadeSigned_noUnattendedCartPopup_webviewdebuggable.apk");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("ensureWebviewsHavePages", true);
        capabilities.setCapability("nativeWebScreenshot", true);
        capabilities.setCapability("newCommandTimeout", 3600);
        capabilities.setCapability("connectHardwareKeyboard", true);
        return capabilities;
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
