package iOSAppTest;

import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class iosTests {








    public class iOSTestApp {

        private IOSDriver driver;

        public final static int TIMEOUT = 30;
        public final static int PAGE_LOAD_TIMEOUT = 20;

        @Before

        public void setUp() throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
        /*capabilities.setCapability ("platformName", "iOS");
        capabilities.setCapability     (  "platformVersion", "11.4");
        capabilities.setCapability  ( "deviceName", "iPhone 8");
        capabilities.setCapability  ("app", "/Users/mindspark/Downloads/TestApp.app");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/

            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "11.4");
            capabilities.setCapability("deviceName", "Apple TV (11.4)");
            // capabilities.setCapability ("automationName", "XCUITest");
            // capabilities.setCapability ("xcodeOrgId", "A3NC4V26F8");
            // capabilities.setCapability ("xcodeSigningId", "iPhone Developer");
            capabilities.setCapability("udid", "ca1b1cb4145163f502f84febc78a2bdb74624050");
            //capabilities.setCapability ("showXcodeLog", true);
            //capabilities.setCapability ("fullReset", true);
            //capabilities.setCapability ("printPageSourceOnFindFailure", true);
            //capabilities.setCapability ("showIOSLog", false);
            capabilities.setCapability("appName", "Project4");
            //capabilities.setCapability("showIOSLog", true);

            //capabilities.setCapability ("useNewWDA", false);
            //capabilities.setCapability ("clearSystemFiles", false);
            capabilities.setCapability("app", "/Users/ekwong/Downloads/Project5ipa/Project5.ipa");
            driver = new IOSDriver(new URL("http://10.0.0.31:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);


        }

        @After

        public void tearDown() {

            driver.quit();
        }

        @Test

        public void selectTestApp() throws InterruptedException {

        /*driver.findElement(By.name("IntegerA")).sendKeys("MindSpark");
        Thread.sleep(1000);
        driver.findElement(By.name("IntegerB")).sendKeys("Auticon");
        Thread.sleep(1000);
        driver.findElement(By.name("ComputeSumButton")).click();*/

      /*  Actions action = new Actions(driver);
        WebElement holdAndRelease = driver.findElement(By.xpath("//XCUIElementTypeSlider[@name=\"AppElem\"][0]"));
        action.clickAndHold(holdAndRelease).build().perform();
        action.moveToElement(holdAndRelease,200,500);
        Thread.sleep(2000);*/


            // driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Business']")).click();

        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap clickObject = new HashMap();
        pressObject.put("predicateString", "value == 'Start Game'");
        //scrollObject.put("direction", "down");
        js.executeScript("mobile: press", pressObject);
        Thread.sleep(3000);
    }*/

            WebElement startGame = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Start Game']"));



            Actions action = new Actions(driver);
            action.moveToElement(startGame).click(startGame).build().perform();


            Thread.sleep(3000);
        }
    }

}
