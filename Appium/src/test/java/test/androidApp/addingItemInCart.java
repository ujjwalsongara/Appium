package test.androidApp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.NoSuchElementException;

public class addingItemInCart {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void addingItem() throws MalformedURLException, InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportArby1.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

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
            WebElement menu = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_menu"));
            menu.click();
            test.pass("Clicked on menu");


            Thread.sleep(7000);
            WebElement item = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivMenuItem\").instance(1)"));
            item.click();

            Thread.sleep(7000);
            WebElement item2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/btAddCart\").instance(1)"));
            item2.click();

            Thread.sleep(7000);
            WebElement addCart = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/clAddCart"));
            addCart.click();
            test.pass("addCart");


//            Thread.sleep(5000);
//            WebElement checkout = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
//            checkout.click();
//            test.pass("Clicked Checkout");

            Thread.sleep(5000);
            WebElement pickup = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_pickup"));
            pickup.click();
            test.pass("Selected Pickup");

            Thread.sleep(5000);
            WebElement proceed = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
            proceed.click();
            test.pass("Clicked Proceed");

            Thread.sleep(20000);
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
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"12\"))"
                        )
                );
                element.click();
                test.pass("Time '12' selected from picker");

            } catch (NoSuchElementException e) {
                test.fail("Value '12' not found in time picker");
                Assert.fail("Time picker failed");
            }

//            WebElement amPm = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"p.m.\")"));
//            amPm.click();
//            test.pass("Selected PM");

            Thread.sleep(5000);
            WebElement okBtn = driver.findElement(AppiumBy.id("android:id/button1"));
            okBtn.click();
            test.pass("Confirmed time");


            Thread.sleep(5000);
            WebElement proceedBut = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
            proceedBut.click();
            test.pass("proceed button");

//            Thread.sleep(40000);
//            WebElement el22 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/ivPlus"));
//            el22.click();
//            Thread.sleep(5000);
//            WebElement el23 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/ivPlus"));
//            el23.click();
//
//
//            Thread.sleep(5000);
//            WebElement item3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(11)"));
//            item3.click();
//
//            Thread.sleep(5000);
//            var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            var start = new Point(827, 1569);
//            var end = new Point (840, 893);
//            var swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//            WebElement el50 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(8)"));
//            el50.click();
//
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            start = new Point(475, 1589);
//            end = new Point (516, 811);
//            swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//            WebElement el24 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(0)"));
//            el24.click();
//            test.pass("proceed button");
//
//            WebElement el25 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(1)"));
//            el25.click();
//            test.pass("proceed button");
//
//            WebElement el26 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(2)"));
//            el26.click();
//            test.pass("proceed button");
//
//            WebElement el27 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(3)"));
//            el27.click();
//            test.pass("proceed button");
//
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(516, 1757);
//             end = new Point (504, 815);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//            WebElement el28 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(2)"));
//            el28.click();
//
//
//            WebElement el29 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(3)"));
//            el29.click();
//
//
//            WebElement el30 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(9)"));
//            el30.click();
//
//
//
//            WebElement el31 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(27)"));
//            el31.click();
//
//
//             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(455, 1868);
//             end = new Point (487, 582);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//            WebElement el = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(10)"));
//            el.click();
//
//            WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(22)"));
//            el2.click();
//
//            WebElement AddCart = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/clAddCart"));
//            AddCart.click();
//            test.pass("AddCart button");
//
//            WebElement neutral = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvNeutral"));
//            neutral.click();
//            test.pass("Neutral");
//
//             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(549, 725);
//             end = new Point (356, 1573);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//
//             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            var tapPoint = new Point(233, 2117);
//            var tap = new Sequence(finger, 1);
//            tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(tap));
//
//
//
//            Thread.sleep(5000);
//            WebElement el34 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/clAddCart"));
//            el34.click();
//
//            Thread.sleep(5000);
//            WebElement el35 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvNegative"));
//            el35.click();
//
//            Thread.sleep(5000);
//            WebElement el36 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvPositive"));
//            el36.click();
//
//             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(614, 1794);
//             end = new Point (623, 668);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(553, 1823);
//             end = new Point (557, 819);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//            Thread.sleep(5000);
//            WebElement el37 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/rbPaymentType\").instance(2)"));
//            el37.click();
//
//            Thread.sleep(5000);
//            WebElement el38 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
//            el38.click();
//


            Thread.sleep(40000);
            WebElement el23 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/ivPlus"));
            el23.click();

            Thread.sleep(5000);
            WebElement el24 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/ivPlus"));
            el24.click();

            Thread.sleep(5000);
            WebElement el25 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(11)"));
            el25.click();
//
//            Thread.sleep(5000);
//            final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            var start = new Point(549, 1696);
//            var end = new Point (598, 663);
//            var swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            start = new Point(479, 1745);
//             end = new Point (504, 1126);
//            swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//            WebElement el26 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(7)"));
//            el26.click();
//            WebElement el27 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(1)"));
//            el27.click();
//            WebElement el28 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(2)"));
//            el28.click();
//
//             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(520, 1982);
//            end = new Point (520, 995);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//            WebElement el29 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(2)"));
//            el29.click();
//            WebElement el30 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(3)"));
//            el30.click();
//            WebElement el31 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/ivPlus\").instance(4)"));
//            el31.click();
//
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(561, 1749);
//             end = new Point (565, 811);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//            WebElement el32 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(11)"));
//            el32.click();
//            WebElement el33 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(30)"));
//            el33.click();
//            WebElement el34 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/clAddCart"));
//            el34.click();
//            WebElement el35 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvNeutral"));
//            el35.click();
//            WebElement el36 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.FrameLayout\").instance(9)"));
//            el36.click();
//            WebElement el37 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(27)"));
//            el37.click();
//            WebElement el38 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/clAddCart"));
//            el38.click();
//            WebElement el39 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvNegative"));
//            el39.click();
//            WebElement el40 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvPositive"));
//            el40.click();
//
//             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            start = new Point(528, 1896);
//             end = new Point (532, 864);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(688, 1691);
//             end = new Point (598, 459);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement el41 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/rbPaymentType\").instance(2)"));
            el41.click();
            Thread.sleep(5000);
            WebElement el42 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
            el42.click();


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
