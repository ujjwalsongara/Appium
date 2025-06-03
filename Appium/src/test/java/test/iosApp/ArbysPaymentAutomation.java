package test.iosApp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

import io.appium.java_client.MobileBy;
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

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;

public class ArbysPaymentAutomation {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void setup() throws MalformedURLException, InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportIOSArby2.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 16 Plus");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "18.5");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/apple/Downloads/Arbys2.app");
        capabilities.setCapability("autoAcceptAlerts", true);
//        capabilities.setCapability("ios"," /Users/apple/Downloads/Arbys.app");
//        capabilities.setCapability("bundleId", "com.buzzparade.arbysinternational");
//        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("newCommandTimeout", 7000);
//        capabilities.setCapability("udid", "A9864702-9691-4A3C-B34B-F60C2A3099A2");  // Required for real devices


        URL serverURL = new URL("http://127.0.0.1:4723/");
        IOSDriver driver = new IOSDriver(serverURL, capabilities);

//        URL url = URI.create("http://127.0.0.1:4723/").toURL();
//        driver = new AndroidDriver(url, capabilities);

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
//
//            driver.context("NATIVE_APP");
//            driver.executeScript("mobile:activeAppInfo");

            Thread.sleep(5000);
            WebElement el3 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeNavigationBar[`name == \"Home\"`]/XCUIElementTypeButton[3]"));
            el3.click();

            Thread.sleep(5000);
            WebElement el4 = driver.findElement(AppiumBy.accessibilityId("SIGN IN / REGISTER"));
            el4.click();

            Thread.sleep(5000);
            WebElement el5 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]"));
            el5.click();
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

//            Thread.sleep(50000);
//            WebElement el9 = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[5]"));
//            el9.click();

//            Thread.sleep(5000);
//            WebElement el9 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \" \"`]"));
//            el9.click();

            Thread.sleep(6000);
            WebElement el10 = driver.findElement(AppiumBy.accessibilityId("Cart"));
            el10.click();

            Thread.sleep(5000);
            WebElement el11 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"SKIP\"`]"));
            el11.click();

//            Thread.sleep(5000);
//            WebElement el12 = driver.findElement(AppiumBy.accessibilityId("OK"));
//            el12.click();

            Thread.sleep(5000);
            WebElement el13 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CHECKOUT\"`]"));
            el13.click();

            Thread.sleep(5000);
            WebElement el14 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"ORDER PICKUP\"`]"));
            el14.click();

            Thread.sleep(5000);
            WebElement el15 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"PROCEED\"`]"));
            el15.click();

            Thread.sleep(5000);
            WebElement el16 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \" \"`]"));
            el16.click();

            Thread.sleep(5000);
            WebElement el17 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"FAVOURITES\"`]"));
            el17.click();

            Thread.sleep(5000);
            WebElement el18 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"ORDER NOW\"`]"));
            el18.click();

            Thread.sleep(5000);
            WebElement el19 = driver.findElement(AppiumBy.accessibilityId("11:43 AM"));
            el19.click();

            Thread.sleep(5000);
            WebElement el20 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeImage[`name == \"dropdown\"`][2]"));
            el20.click();

            Thread.sleep(5000);
            WebElement el21 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CONFIRM\"`]"));
            el21.click();

            Thread.sleep(5000);
            WebElement el22 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CONFIRM\"`]"));
            el22.click();

            final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(227, 682);
            var end = new Point (232, 412);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement el23 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \" \"`][5]"));
            el23.click();

            Thread.sleep(5000);
            WebElement el24 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CHECKOUT\"`]"));
            el24.click();


            Thread.sleep(50000);


//
//
//
//            Thread.sleep(6000);
//            WebElement skipButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btnSkip"));
//            skipButton.click();
//            test.pass("Clicked on Skip");
//
//            Thread.sleep(5000);
//            WebElement allowButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvPositive"));
//            allowButton.click();
//            test.pass("Clicked on Allow button");
//
//            Thread.sleep(5000);
//            WebElement threeDot = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_overflow"));
//            threeDot.click();
//            test.pass("Opened menu options");
//
//            Thread.sleep(5000);
//            WebElement loginButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/menu_login"));
//            loginButton.click();
//            test.pass("Clicked on Login");
//
//            Thread.sleep(5000);
//            WebElement el8 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btnEmailLogin"));
//            el8.click();
//            test.pass("Selected Email Login");
//
//            Thread.sleep(5000);
//            WebElement email = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/login_name"));
//            email.sendKeys("ujjwal@buzzparade.com");
//            test.pass("Entered email");
//
//            Thread.sleep(5000);
//            WebElement password = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/login_password"));
//            password.sendKeys("Testpassword@12");
//            test.pass("Entered password");
//
//            Thread.sleep(5000);
//            WebElement signIn = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_SignIn"));
//            signIn.click();
//            test.pass("Clicked on Sign In");
            Thread.sleep(10000);

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

