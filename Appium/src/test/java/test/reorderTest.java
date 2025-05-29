package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import lombok.var;
import org.openqa.selenium.By;
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
import java.util.Set;

public class reorderTest {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void reOrder() throws MalformedURLException, InterruptedException {

        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportArbyReOrder.html");
        extent =new ExtentReports();
        extent.attachReporter(spark);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 7");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("app", "/Users/apple/Downloads/Arby'sBuzzparadeSigned_nounattendedcartblock.apk");
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

            test = extent.createTest("Order History").assignCategory("Regression");

            Thread.sleep(10000);
            WebElement el14 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/action_track"));
            el14.click();

            Thread.sleep(5000);
            WebElement el15 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvFavItems"));
            el15.click();

            Thread.sleep(5000);
            WebElement el11 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/tvReOrder\").instance(0)"));
            el11.click();

            Thread.sleep(9000);
            WebElement el145 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/tvPositive"));
            el145.click();

            Thread.sleep(5000);
            WebElement pickup = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_pickup"));
            pickup.click();
            test.pass("Selected Pickup");

            Thread.sleep(5000);
            WebElement proceed = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btn_proceed"));
            proceed.click();
            test.pass("Clicked Proceed");


            Thread.sleep(10000);
            WebElement el5 = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/ivCancel"));
            el5.click();

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
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"7\"))"
                        )
                );
                element.click();
                test.pass("Time '7' selected from picker");

            } catch (NoSuchElementException e) {
                test.fail("Value '7' not found in time picker");
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



            Thread.sleep(10000);

            var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var start = new Point(455, 1872);
            var end = new Point (545, 745);
            var swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), start.getX(), start.getY()));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                    PointerInput.Origin.viewport(), end.getX(), end.getY()));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));

            Thread.sleep(5000);
            WebElement onlinePayment = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.buzzparade.arbysintl:id/rbPaymentType\").instance(1)"));
            onlinePayment.click();
            test.pass("Clicked onlinePayment ");

            Thread.sleep(5000);
            WebElement confirmButton = driver.findElement(AppiumBy.id("com.buzzparade.arbysintl:id/btCheckOut"));
            confirmButton.click();
            test.pass("Clicked confirm Button ");


            test = extent.createTest("Payment method").assignCategory("Regression");

            Set<String> contexts = driver.getContextHandles();
            for (String context : contexts) {
                System.out.println("Available context: " + context);
            }

// 3. Switch to WebView context
            for (String context : contexts) {
                if (context.contains("WEBVIEW")) {
                    driver.context(context);
                    break;
                }
            }

            Thread.sleep(50000);
//            WebElement cardHolderName = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ccName\")"));
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ccName\"]")).sendKeys("Test");

//            WebElement cardHolderName = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ccName\"]"));
//            cardHolderName.click();
//            cardHolderName.sendKeys("test");
            test.pass("Clicked cardHolderName ");

            Thread.sleep(5000);
//            WebElement cardNumber = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ccNum\")"));
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"ccNum\"]")).sendKeys("4111111111111111");
//            WebElement cardNumber = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ccNum\"]"));
//            cardNumber.click();
//            cardNumber.sendKeys("4111111111111111");
            test.pass("entered cardNumber");

            Thread.sleep(5000);
//            WebElement cardExpiry = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"expiry\")"));
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"expiry\"]")).sendKeys("12/28");

//            WebElement cardExpiry = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"expiry\"]"));
//            cardExpiry.click();
//            cardExpiry.sendKeys("12/28");
            test.pass("entered cardExpiry");

            Thread.sleep(5000);
//            WebElement cardCVV = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"cvv\")"));
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"cvv\"]")).sendKeys("128");

//            WebElement cardCVV = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"cvv\"]"));
//            cardCVV.click();
//            cardCVV.sendKeys("128");
            test.pass("entered cardCVV");

            Thread.sleep(5000);
//            WebElement cardZip = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"zip\")"));
            driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"zip\"]")).sendKeys("M14A12");

//            WebElement cardZip = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"zip\"]"));
//            cardZip.click();
//            cardZip.sendKeys("M14A12");
            test.pass("entered cardZip");

            Thread.sleep(5000);
            WebElement home = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"Generic\")"));
            home.click();
            test.pass("Clicked Home Button");

            Thread.sleep(5000);
            WebElement Done = driver.findElement(AppiumBy.className("android.widget.Button"));
            Done.click();
            test.pass("Clicked Done Button");



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