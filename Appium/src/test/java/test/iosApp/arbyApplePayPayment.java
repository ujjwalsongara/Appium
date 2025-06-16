package test.iosApp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.var;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

public class arbyApplePayPayment {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void everyday2for$12() throws MalformedURLException, InterruptedException {

        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportArbyApplePayIOS.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 16 Plus");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "18.5");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/apple/Downloads/Arbys2.app");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("newCommandTimeout", 7000);
        capabilities.setCapability("enableApplePay", true);

        URL serverURL = new URL("http://127.0.0.1:4723/");
        IOSDriver driver = new IOSDriver(serverURL, capabilities);

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

            test = extent.createTest("pickUp Order Flow Test").assignCategory("Regression");


            Thread.sleep(7000);
            WebElement pickupBtn = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[2]"));
            pickupBtn.click();
            test.pass("Clicked on pickupBtn");

            Thread.sleep(5000);
            WebElement cross = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \" \"`]"));
            cross.click();
            test.pass("Clicked on cross");

            Thread.sleep(5000);
            WebElement favLocation = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"FAVOURITES\"`]"));
            favLocation.click();
            test.pass("Clicked on favLocation");

            Thread.sleep(5000);
            WebElement el18 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"ORDER NOW\"`]"));
            el18.click();
            test.pass("Clicked on checkout");

            Thread.sleep(5000);

            try {
                WebElement pickerWheel = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeImage[`name == \"dropdown\"`][2]"));
                pickerWheel.sendKeys("1"); // Set the desired value
                test.pass("Time '2' selected from picker");

            } catch (NoSuchElementException e) {
                test.fail("Value '2' not found in time picker");
                Assert.fail("Time picker failed");
            }

            Thread.sleep(5000);
            WebElement timeDrop = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeImage[`name == \"dropdown\"`][2]"));
            timeDrop.click();
            test.pass("Clicked on timeDrop");

            Thread.sleep(5000);
            WebElement confirmSelectTime = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CONFIRM\"`]"));
            confirmSelectTime.click();
            test.pass("Clicked on confirmSelectTime");

            Thread.sleep(5000);
            WebElement confirmTime = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CONFIRM\"`]"));
            confirmTime.click();
            test.pass("Clicked on confirmTime");


            test = extent.createTest("Menu Flow Test").assignCategory("Regression");

//            Thread.sleep(7000);
//            WebElement menu = driver.findElement(AppiumBy.accessibilityId("Menu"));
//            menu.click();
//            test.pass("Clicked on menu");

            Thread.sleep(7000);
            WebElement meals = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeImage"));
            meals.click();
            test.pass("Clicked on Meals");

            Thread.sleep(8000);
            WebElement viewItem = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]"));
            viewItem.click();
            test.pass("Clicked on view item");


            var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(210, 687);
            var end = new Point(213, 219);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(8000);
            WebElement side = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Forward\"`][2]"));
            side.click();
            test.pass("Clicked on Side item");

            Thread.sleep(8000);
            WebElement el14 = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther"));
            el14.click();
            test.pass("Clicked on item");


            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(199, 697);
            end = new Point(202, 229);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(8000);
            WebElement Beverage = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Forward\"`][3]"));
            Beverage.click();
            test.pass("Clicked on Beverage");

            Thread.sleep(8000);
            WebElement Shake = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[4]/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther"));
            Shake.click();
            test.pass("Clicked on Shake");

//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            start = new Point(216, 681);
//            end = new Point (219, 351);
//            swipe = new Sequence(finger, 1);
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//            driver.perform(Arrays.asList(swipe));

            Thread.sleep(6000);
            WebElement AddCart = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]"));
            AddCart.click();
            test.pass("Clicked on AddCart");

            Thread.sleep(9000);
            WebElement viewCart = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"View cart\"`]"));
            viewCart.click();
            test.pass("Clicked on viewCart");

            Thread.sleep(50000);

            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(227, 682);
            end = new Point(232, 412);
            swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement paymentMode = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \" \"`][6]"));
            paymentMode.click();
            test.pass("Clicked on paymentMode");

            Set<String> contextNames = driver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println(contextName);
            }
            driver.context((String) contextNames.toArray()[0]);

            driver.context("NATIVE_APP");
            System.out.println(driver.getPageSource());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement checkOutToApplePay = wait.until(
                    ExpectedConditions.presenceOfElementLocated(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Check out with Apple Pay\"`]"))
            );
            Thread.sleep(9000);
            checkOutToApplePay.click();
            test.pass("Clicked on checkOutToApplePay");

            Thread.sleep(7000);
            test = extent.createTest("Payment method").assignCategory("Regression");

//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            Map<String, Object> args = new HashMap<>();
//            args.put("action", "tap");
//            args.put("element", payElement.getId()); // if you somehow get the element
//            js.executeScript("mobile: performEditorAction", args);
//

            WebDriverWait waiti = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement payBtn = waiti.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("Pay with Passcode")
                    )
            );
            payBtn.click();
            test.pass("Clicked on payWithPassCode");
//
//            WebElement payWithCard = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"PAY WITH ANOTHER CARD\"`]"));
//            payWithCard.click();
//            test.pass("Clicked on payWithCard");
//
//            Set<String> contextNames = driver.getContextHandles();
//            for (String contextName : contextNames) {
//                System.out.println(contextName);
//            }
//            driver.context((String) contextNames.toArray()[0]);
//
//            driver.context("NATIVE_APP");
//            System.out.println(driver.getPageSource());
//
//
//            Thread.sleep(50000);
//            WebElement cardName = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == \"Name on Card\"`]"));
//            cardName.click();
//            cardName.sendKeys("test");
//            test.pass("enter cardName");
//
//            Thread.sleep(5000);
//            WebElement cardNumber = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == \"Card Number\"`]"));
//            cardNumber.click();
//            cardNumber.sendKeys("41111111111111111");
//            test.pass("enter card Number");
//
//            Thread.sleep(5000);
//            WebElement expiryDate = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == \"Expiry Date\"`]"));
//            expiryDate.sendKeys("12/28");
//            test.pass("enter expiryDate");
//
//            Thread.sleep(5000);
//            WebElement cvv = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == \"CVV\"`]"));
//            cvv.click();
//            cvv.sendKeys("128");
//            test.pass("enter cvv");
//
//            Thread.sleep(5000);
//            WebElement postalCode = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == \"Postal Code\"`]"));
//            postalCode.click();
//            postalCode.sendKeys("M14A12");
//            test.pass("enter postalCode");
//
//            Thread.sleep(5000);
//
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            start = new Point(258, 336);
//            end = new Point(259, 194);
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
//            WebElement done = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Done\"`][1]"));
//            done.click();
//            test.pass("Clicked on Done payment");
//
//            WebElement redone = driver.findElement(AppiumBy.accessibilityId("Done"));
//            redone.click();

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
