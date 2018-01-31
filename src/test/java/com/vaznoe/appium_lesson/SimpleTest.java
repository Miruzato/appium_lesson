package com.vaznoe.appium_lesson;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimpleTest {

    AppiumDriver driver;

    @Before
    public void init() throws MalformedURLException {
        driver = getAppiumDriver("Android", new URL("http://127.0.0.1:4723/wd/hub"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void myFirstTest() throws InterruptedException {

        driver.findElement(By.id("startUserRegistration")).click();
        WebElement inputUsername = driver.findElement(By.id("inputUsername"));
        inputUsername.clear();
        inputUsername.sendKeys("Musha");
        driver.findElement(By.id("inputEmail")).sendKeys("musha@gmail.com");
        driver.findElement(By.id("inputPassword")).sendKeys("12345");
        driver.findElement(By.id("inputName")).clear();
        driver.findElement(By.id("inputName")).sendKeys("Mr.King");
        driver.findElement(By.id("input_preferedProgrammingLanguage")).click();
        chooseProgrammingLanguage("Java");
        driver.findElement(By.id("input_adds")).click();
        driver.findElement(By.id("btnRegisterUser")).click();
        String emailData = driver.findElement(By.id("label_email_data")).getText();
        assertEquals("musha@gmail.com", emailData);
        driver.findElement(By.id("buttonRegisterUser")).click();

    }

    public void chooseProgrammingLanguage(String textValue) {
        List<WebElement> list = driver.findElements(By.id("text1"));
        list.stream().filter(e -> e.getText().equals(textValue)).findFirst().get().click();
    }

    private AppiumDriver getAppiumDriver(String platform, URL serverUrl) {
        return platform.equals("iOS") ? getIOSDriver(serverUrl) : getAndroidDriver(serverUrl);
    }

    private AppiumDriver getIOSDriver(URL serverUrl) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.UDID, "F97C79FE-5F55-4CE3-BA88-9351B7A9421F");

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");

        capabilities.setCapability("showXcodeLog", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");

        return new IOSDriver(serverUrl, capabilities);
    }

    private AppiumDriver getAndroidDriver(URL serverUrl) {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File app = new File(classpathRoot, "src/test/resources/selendroid-test-app.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "ellentubeQa");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "selendroid");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//        capabilities.setCapability("appPackage", "io.selendroid.testapp");
//        capabilities.setCapability("appActivity", ".HomeScreenActivity");
        return new AndroidDriver(serverUrl, capabilities);
    }
}
