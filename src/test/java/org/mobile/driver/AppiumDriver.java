package org.mobile.driver;

import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.*;


public class AppiumDriver implements DriverSource {
    public static WebDriver ANDROID_DRIVER;

    @Override
    public  WebDriver newDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //capabilities.setCapability("autoGrantPermission", true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.android.dialer");
        capabilities.setCapability("appActivity", "com.android.dialer.app.DialtactsActivity");
        //capabilities.setCapability("appWaitForLaunch", false);
//
//        try{
//            Path apkFiles = (Path) Files.walk(Paths.get(System.getProperty("user.dir") + "/apps")).filter((p) -> {
//                return p.toString().endsWith(".apk");
//            }).distinct().findFirst().get();
//
//            System.out.println("APK: " + apkFiles);
//
//            if(apkFiles != null) {
//                capabilities.setCapability("app", apkFiles.toAbsolutePath().toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try{
            ANDROID_DRIVER = new AndroidDriver<>(new URL("http://0.0.0.0:4723"), capabilities);
        }catch (MalformedURLException e) {e.printStackTrace();}

        return ANDROID_DRIVER;
    }

    @Override
    public boolean takesScreenshots() { return true;}

}
