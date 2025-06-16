package test.iosApp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class rewardCategoriesIOS {

    AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void payment() throws MalformedURLException, InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/AppiumTestReportIOSArbyRewardCategoriesIOS.html");
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

            test = extent.createTest("Rewards Flow Test").assignCategory("Regression");

            Thread.sleep(7000);
            WebElement Rewards = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]"));
            Rewards.click();
            test.pass("Clicked on Rewards");

            Thread.sleep(7000);
            WebElement signatureMeats = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]"));
            signatureMeats.click();
            test.pass("Clicked on signatureMeats");


            Thread.sleep(7000);
            WebElement redeemBtn = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Redeem\"`]"));
            redeemBtn.click();
            test.pass("Clicked on redeemBtn");

            Thread.sleep(7000);
            WebElement viewItem = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]"));
            viewItem.click();
            test.pass("Clicked on viewItem");


            Thread.sleep(7000);
            WebElement selectStore = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]"));
            selectStore.click();
            test.pass("Clicked on selectStore");

            Thread.sleep(5000);
            WebElement pickUp = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"ORDER PICKUP\"`]"));
            pickUp.click();
            test.pass("Clicked on orderPickUp");


            Thread.sleep(5000);
            WebElement proceed = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"PROCEED\"`]"));
            proceed.click();
            test.pass("Clicked on proceed");

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
                pickerWheel.sendKeys("4"); // Set the desired value
                test.pass("Time '4' selected from picker");

            } catch (NoSuchElementException e) {
                test.fail("Value '4' not found in time picker");
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

            Thread.sleep(5000);
            WebElement addCart = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]"));
            addCart.click();
            test.pass("Clicked on addCart");

            Thread.sleep(5000);
            WebElement viewCart = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"View cart\"`]"));
            viewCart.click();

            Thread.sleep(5000);
            WebElement CheckOut = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"CHECKOUT\"`]"));
            CheckOut.click();
            test.pass("Clicked on CheckOut");

            test = extent.createTest("Payment method").assignCategory("Regression");

            WebElement payWithCard = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"PAY WITH ANOTHER CARD\"`]"));
            payWithCard.click();
            test.pass("Clicked on payWithCard");

            Thread.sleep(10000);

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
