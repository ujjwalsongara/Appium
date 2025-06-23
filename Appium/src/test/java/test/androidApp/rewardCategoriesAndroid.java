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
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class rewardCategoriesAndroid {


    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void rewardCategories() throws MalformedURLException, InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportArbyRewardCategoriesAndroid.html");
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

            test = extent.createTest("Reward Categories Flow Test").assignCategory("Regression");

            Thread.sleep(50000);
            WebElement Reward = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/llWallet"));
            Reward.click();
            test.pass("Clicked on Reward");

            Thread.sleep(20000);
            var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(754, 1827);
            var end = new Point(577, 786);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(7000);
            WebElement signatureMeatsItem = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Signature Meats\")"));
            signatureMeatsItem.click();
            test.pass("Clicked on signature Meats");



            Thread.sleep(7000);
            List<WebElement> convertPointList = driver.findElements(AppiumBy.id("com.buzzparade.arbysintl:id/btRedeem"));

            if (!convertPointList.isEmpty()) {
                convertPointList.get(0).click();
                test.pass("Clicked on convertPoint Redeem button");
            } else {
                List<WebElement> redeemBtnList = driver.findElements(AppiumBy.id("com.buzzparade.arbysintl:id/btRedeem"));

                if (!redeemBtnList.isEmpty()) {
                    redeemBtnList.get(0).click();
                    test.pass("Clicked on fallback redeemBtn");
                } else {
                    test.fail("Neither el8 nor redeemBtn found.");
                }
            }

//            WebElement el8 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btRedeem"));
//            el8.click();
//            Thread.sleep(7000);
//            WebElement redeemBtn = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btRedeem"));
//            redeemBtn.click();
//            test.pass("Clicked on Redeem");

            Thread.sleep(7000);
            WebElement Viewitem = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/btAddCart\").instance(2)"));
            Viewitem.click();
            test.pass("added item");

            Thread.sleep(7000);
            WebElement selectStore = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/clAddCart"));
            selectStore.click();
            test.pass("Clicked on Select Store");

            Thread.sleep(5000);
            WebElement pickup = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_pickup"));
            pickup.click();
            test.pass("Selected Pickup");

            Thread.sleep(5000);
            WebElement proceed = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
            proceed.click();
            test.pass("Clicked Proceed");

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

                int currentHour = LocalTime.now().getHour();
                int nextHour = (currentHour + 1) % 12;
                if (nextHour == 0) nextHour = 12;

                String hourToSelect = String.valueOf(nextHour);

                WebElement element = driver.findElement(
                        MobileBy.AndroidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true))" +
                                        ".scrollIntoView(new UiSelector().text(\"" + hourToSelect + "\"))"
                        )
                );
                element.click();
                test.pass("Time '" + hourToSelect + "' selected from picker");

            } catch (NoSuchElementException e) {
                test.fail("Next hour time value not found in time picker");
                Assert.fail("Time picker failed");
            } catch (Exception e) {
                test.fail("Unexpected error while selecting time: " + e.getMessage());
                e.printStackTrace();
            }


//            try {
//                WebElement element = driver.findElement(
//                        MobileBy.AndroidUIAutomator(
//                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"11\"))"
//                        )
//                );
//                element.click();
//                test.pass("Time '11' selected from picker");
//
//            } catch (NoSuchElementException e) {
//                test.fail("Value '11' not found in time picker");
//                Assert.fail("Time picker failed");
//            }

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

            Thread.sleep(10000);
            WebElement addCart = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/clAddCart"));
            addCart.click();
            test.pass("Clicked on AddCart");

            Thread.sleep(50000);
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

            test = extent.createTest("checkout method").assignCategory("Regression");

            Thread.sleep(3000);
            WebElement checkout = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
            checkout.click();
            test.pass("Clicked on checkout");



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
