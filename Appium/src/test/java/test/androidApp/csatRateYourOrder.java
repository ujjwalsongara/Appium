package test.androidApp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.var;
import org.openqa.selenium.NoSuchElementException;
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
import java.util.Map;
import java.util.Set;

public class csatRateYourOrder {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

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

    @Test
    public void RateYourOrder() throws MalformedURLException, InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportArbycsatRateYourOrder.html");
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

            test = extent.createTest("Track Order").assignCategory("Regression");

            Thread.sleep(10000);
            WebElement trackOrder = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_track"));
            trackOrder.click();
            test.pass("Clicked trackOrder");

            Thread.sleep(5000);
            WebElement pastOrder = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvFavItems"));
            pastOrder.click();
            test.pass("clicked pastOrder");

            test = extent.createTest("RateYourOrder").assignCategory("Regression");

            var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(414, 1843);
            var end = new Point(410, 1065);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));


            Thread.sleep(20000);
            WebElement rateYourOrder = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvRateOrder"));
            rateYourOrder.click();
            test.pass("clicked On rate Your Order");

            Set<String> contextNames = driver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println(contextName);
            }
            driver.context((String) contextNames.toArray()[0]);

            driver.context("NATIVE_APP");
            System.out.println(driver.getPageSource());

            Thread.sleep(50000);
            WebElement rateNum = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"9\")"));
            rateNum.click();
            test.pass("clicked on rateNum");

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(143, 1945);
            end = new Point(270, 881);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement overAll = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"EXTREMELY SATISFIED\")"));
            overAll.click();
            test.pass("clicked on overAll");

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(192, 1892);
            end = new Point(213, 1229);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));


            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(168, 1843);
            end = new Point(217, 889);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(3000);
            WebElement product = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"EXTREMELY SATISFIED\")"));
            product.click();
            test.pass("rate on product");

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(139, 1798);
            end = new Point(291, 958);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement productYouPurchased = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Beverages\")"));
            productYouPurchased.click();
            test.pass("rate on product You Purchased");


            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(709, 1749);
            end = new Point(680, 700);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));


            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(811, 1646);
            end = new Point(790, 999);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement serviceYouReceived = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"EXTREMELY SATISFIED\")"));
            serviceYouReceived.click();
            test.pass("rate on service You Received");


            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(905, 1900);
            end = new Point(926, 684);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement cleanliness = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"EXTREMELY SATISFIED\")"));
            cleanliness.click();
            test.pass("rate on cleanliness");

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(778, 1405);
            end = new Point(836, 508);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement cleanlinesss = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"EXTREMELY SATISFIED\")"));
            cleanlinesss.click();
            test.pass("rate on cleanliness");

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(778, 1405);
            end = new Point(836, 508);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement feedbackText = driver.findElement(AppiumBy.className("android.widget.EditText"));
            feedbackText.click();
            feedbackText.sendKeys("Hello, thanks");
            test.pass("feedback Text");

            driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));

            Thread.sleep(5000);
            WebElement no = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"\").instance(1)"));
            no.click();


//            Thread.sleep(5000);
//            WebElement yes = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"\").instance(1)"));
//            yes.click();
//            driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));

//             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(336, 1720);
//             end = new Point (324, 623);
//             swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//             start = new Point(246, 1683);
//             end = new Point (283, 491);
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
//            WebElement gender = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"\").instance(2)"));
//            gender.click();
//            test.pass("Clicked on Gender");
//
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            start = new Point(246, 1683);
//            end = new Point (283, 491);
//            swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));
//
//            Thread.sleep(5000);
//            WebElement age = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"txtothers_34627\")"));
//            age.click();
//            age.sendKeys("55");
//            test.pass("enter Age");
//
//            driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));


            Thread.sleep(9000);
            WebElement submitBtn = driver.findElement(AppiumBy.accessibilityId("SUBMIT"));
            submitBtn.click();
            test.pass("clicked on Submit");

            Thread.sleep(70000);

            try {
                WebElement thankYouText = driver.findElement(
                        AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Thank You!\")")
                );

                Assert.assertTrue(thankYouText.isDisplayed(), "'Thank You!' screen is displayed");
                test.pass("Feedback confirmation screen is displayed successfully");

            } catch (NoSuchElementException e) {
                test.fail("'Thank You!' text not found. Feedback screen verification failed.");
                Assert.fail("Feedback screen not found.");
            }

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
