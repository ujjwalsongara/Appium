package test.iosApp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

public class csatForIos {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void rateYourOrder() throws MalformedURLException, InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportArbyRateOrderiOS.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        IOSDriver driver = getIosDriver();

        test = extent.createTest("Signup Flow Test").assignCategory("Regression");

        try {

            Thread.sleep(2000);
            test.info("Application started");

            Thread.sleep(5000);
            WebElement skipButton = driver.findElement(AppiumBy.className("XCUIElementTypeButton"));
            skipButton.click();
            test.pass("Clicked on Skip");

            Thread.sleep(5000);
            WebElement threeDot = driver.findElement(AppiumBy.accessibilityId("Arby's International"));
            threeDot.click();
            test.pass("Opened menu options");

            Thread.sleep(7000);
            WebElement dot = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeNavigationBar[`name == \"Home\"`]/XCUIElementTypeButton[3]"));
            dot.click();
            test.pass("Selected Login");

            Thread.sleep(5000);
            WebElement signInButton = driver.findElement(AppiumBy.accessibilityId("SIGN IN / REGISTER"));
            signInButton.click();
            test.pass("signIn button");

            Thread.sleep(5000);
            WebElement emailButton = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]"));
            emailButton.click();
            test.pass("Selected Email Login");

            Thread.sleep(5000);
            WebElement email = driver.findElement(AppiumBy.className("XCUIElementTypeTextField"));
            email.click();
            email.sendKeys("ujjwal@buzzparade.com");
            test.pass("Entered email");

            Thread.sleep(5000);
            WebElement password = driver.findElement(AppiumBy.className("XCUIElementTypeSecureTextField"));
            password.click();
            password.sendKeys("Testpassword@12");
            test.pass("Entered password");

            Thread.sleep(5000);
            WebElement signIn = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"SIGN IN\"`]"));
            signIn.click();
            test.pass("Clicked on Sign In");

            test = extent.createTest("Track order Flow Test").assignCategory("Regression");

            Thread.sleep(7000);
            WebElement trackOrder = driver.findElement(AppiumBy.accessibilityId("Track Order"));
            trackOrder.click();
            test.pass("Clicked on trackOrder");

            Thread.sleep(6000);
            WebElement pastOrder = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Past Orders\"`]"));
            pastOrder.click();
            test.pass("Clicked on pastOrder");

            Thread.sleep(6000);

            var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(210, 751);
            var end = new Point(216, 402);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            test = extent.createTest("Rate your order Flow Test").assignCategory("Regression");

            Thread.sleep(6000);
            WebElement el9 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Rate this order\"`][1]"));
            el9.click();

            Thread.sleep(3000);
            Set<String> contextNames = driver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println(contextName);
            }
            driver.context((String) contextNames.toArray()[0]);

            driver.context("NATIVE_APP");
            System.out.println(driver.getPageSource());


            Thread.sleep(10000);
            WebElement el10 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"10\"`][2]"));
            el10.click();

             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
             start = new Point(49, 722);
             end = new Point (98, 392);
             swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            WebElement el12 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"main\"`]/XCUIElementTypeOther[34]"));
            el12.click();

              finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
             start = new Point(104, 726);
             end = new Point (110, 433);
             swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            WebElement el13 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"main\"`]/XCUIElementTypeOther[47]"));
            el13.click();

             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
             start = new Point(313, 735);
             end = new Point (346, 304);
             swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            WebElement el14 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Beverages\"`]"));
            el14.click();

             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
             start = new Point(265, 704);
             end = new Point (271, 324);
             swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));


             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
             start = new Point(306, 756);
             end = new Point (271, 180);
             swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));


             finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
             start = new Point(270, 719);
             end = new Point (289, 327);
             swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            WebElement el15 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"\"`][2]"));
            el15.click();
            WebElement el16 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"main\"`]/XCUIElementTypeOther[97]"));
            el16.click();


            Thread.sleep(50000);


        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    private static IOSDriver getIosDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 16 Pro");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "18.5");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/apple/Downloads/Arbys2.app");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("newCommandTimeout", 7000);

        URL serverURL = new URL("http://127.0.0.1:4723/");
        IOSDriver driver = new IOSDriver(serverURL, capabilities);
        return driver;
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
//Plus