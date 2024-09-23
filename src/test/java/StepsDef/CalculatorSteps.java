package StepsDef;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CalculatorPage;
import testCases.BaseClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class CalculatorSteps extends BaseClass  {
    private CalculatorPage calculatorPage;

    File app = new File("src/resources/app/Calculator.apk");

    private static ExtentReports extent;
    private static ExtentTest test;


   @Before
    public void setup() throws MalformedURLException {

        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        test = extent.createTest("Calculator Test", "Testing the Google Calculator app");
    }

    @Given("the calculator app is open")
    public void the_calculator_app_is_open() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Pixel 6");
        capabilities.setCapability("platformname", "android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("platformversion", "14");
        //capabilities.setCapability("udid", "emulator-5554");

        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("appium:newCommandTimeout", 60);
       // capabilities.setCapability("app", "/Users/mamalkani/Documents/Assignment/Appium/src/resources/app/Calculator.apk");
        capabilities.setCapability("app", app.getAbsolutePath());

        URL url = URI.create("http://127.0.0.1:4723/").toURL();

        driver = new AndroidDriver(url, capabilities);

        calculatorPage = new CalculatorPage(driver);

        test.pass("Calculator app opened successfully");
    }

    @When("I input {int} {string} {int}")
    public void iInput(int firstNum, String operation, int secondNum) {
        calculatorPage.clickDigit(firstNum);
        calculatorPage.arithmeticOperation(operation);
        calculatorPage.clickDigit(secondNum);
        test.pass(String.format("Performed %8s operation of %d and %d", operation, firstNum, secondNum));
    }

    @And("I press {string}")
    public void iPress(String arg0) {
        calculatorPage.clickEquals();
        test.pass(String.format("Calculating the Result"));
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expected) {
        String resultText = calculatorPage.getResultText();
        Assert.assertEquals(resultText, String.valueOf(expected));
        test.pass(String.format("Validated that result is %8s", expected));
    }



    @When("I input {int} \\/ {int}")
    public void iInput(int firstNum, int secondNum) {
        calculatorPage.clickDigit(firstNum);
        calculatorPage.arithmeticOperation("/");
        calculatorPage.clickDigit(secondNum);
        test.pass(String.format("Performed The division operation of dividing number by 0 of %d and %d",firstNum, secondNum));
    }

    @Then("the result should be an error message {string}")
    public void theResultShouldBeAnErrorMessage(String expectedMessage) {
        String resultText = calculatorPage.getResultError();
        Assert.assertEquals(resultText, String.valueOf(expectedMessage));
        test.pass(String.format("Validated that result is %8s", expectedMessage));
    }

    @After
    public void tearDown() {
        //driver.close();
        driver.quit();
        extent.flush();
    }
}
