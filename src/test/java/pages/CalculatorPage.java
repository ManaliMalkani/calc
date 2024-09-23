package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class CalculatorPage {
    AndroidDriver driver;

    public CalculatorPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
    public WebElement digitOne;
    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    public WebElement digitTwo;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
    public WebElement digitThree;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
    public WebElement digitFour;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_5")
    public WebElement digitFive;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_6")
    public WebElement digitSix;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_7")
    public WebElement digitSeven;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_8")
    public WebElement digitEight;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_9")
    public WebElement digitNine;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_0")
    public WebElement digitZero;

    @AndroidFindBy(accessibility = "plus")
    public WebElement addButton;

    @AndroidFindBy(accessibility = "minus")
    public WebElement minusButton;

    @AndroidFindBy(accessibility = "divide")
    public WebElement divideButton;

    @AndroidFindBy(accessibility = "multiply")
    public WebElement multiplyButton;

    @AndroidFindBy(accessibility = "clear")
    public WebElement clearButton;

    @AndroidFindBy(accessibility = "equals")
    public WebElement equalsButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public WebElement result;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_preview")
    public WebElement resultPreview;

    public void clickDigit(int digit) {
        switch (digit) {
            case 1:
                digitOne.click();
                break;
            case 2:
                digitTwo.click();
                break;
            case 3:
                digitThree.click();
                break;
            case 4:
                digitFour.click();
                break;
            case 5:
                digitFive.click();
                break;
            case 6:
                digitSix.click();
                break;
            case 7:
                digitSeven.click();
                break;
            case 8:
                digitEight.click();
                break;
            case 9:
                digitNine.click();
                break;
            case 0:
                digitZero.click();
                break;
        }
    }

    public void arithmeticOperation(String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                addButton.click();
                break;
            case "-":
               minusButton.click();
                break;
            case "*":
                multiplyButton.click();
                break;
            case "/":
                divideButton.click();
                break;
        }
    }

    public void clickAdd() {
        addButton.click();
    }

    public void clickEquals() {
        equalsButton.click();
    }

    public String getResultText() {
        return result.getText();
    }

    public String getResultError() {
        return resultPreview.getText();
    }
}


