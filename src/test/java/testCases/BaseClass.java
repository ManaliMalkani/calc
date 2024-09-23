package testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.android.AndroidDriver;
import org.utils.AppiumServerManager;

public class BaseClass extends ExtentReportDemo{

    public static AndroidDriver driver;



   /* @BeforeTest
    public void setup() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Pixel 6");
        capabilities.setCapability("platformname", "android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("platformversion", "14");
        //capabilities.setCapability("udid", "emulator-5554");

        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");


        capabilities.setCapability("appium:newCommandTimeout", 60);
        capabilities.setCapability("app", "\\Users\\mamalkani\\Documents\\Assignment\\Appium\\src\\resources/app");
        ;


        URL url = URI.create("http://127.0.0.1:4723/").toURL();

        driver = new AndroidDriver(url, capabilities);


    }

    //@Test
    //public void sample_test(){
       // driver.get("https://www.google.com");}

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }*/

}
