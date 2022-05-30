package helpers.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage {
    private final SelenideElement plus = $(AppiumBy.id("com.google.android.calculator:id/op_add"));
    private final SelenideElement minus = $(AppiumBy.id("com.google.android.calculator:id/op_sub"));
    private final SelenideElement mul = $(AppiumBy.id("com.google.android.calculator:id/op_mul"));
    private final SelenideElement div = $(AppiumBy.id("com.google.android.calculator:id/op_div"));
    private final SelenideElement point = $(AppiumBy.id("com.google.android.calculator:id/dec_point"));

    private final SelenideElement result = $(AppiumBy.id("com.google.android.calculator:id/result_final"));
    private final SelenideElement clear = $(AppiumBy.id("com.google.android.calculator:id/clr"));
    private final SelenideElement equal = $(AppiumBy.id("com.google.android.calculator:id/eq"));

    private final SelenideElement one = $(AppiumBy.id("com.google.android.calculator:id/digit_1"));
    private final SelenideElement two = $(AppiumBy.id("com.google.android.calculator:id/digit_2"));
    private final SelenideElement three = $(AppiumBy.id("com.google.android.calculator:id/digit_3"));
    private final SelenideElement four = $(AppiumBy.id("com.google.android.calculator:id/digit_4"));
    private final SelenideElement five = $(AppiumBy.id("com.google.android.calculator:id/digit_5"));
    private final SelenideElement six = $(AppiumBy.id("com.google.android.calculator:id/digit_6"));
    private final SelenideElement seven = $(AppiumBy.id("com.google.android.calculator:id/digit_7"));
    private final SelenideElement eight = $(AppiumBy.id("com.google.android.calculator:id/digit_8"));
    private final SelenideElement nine = $(AppiumBy.id("com.google.android.calculator:id/digit_9"));
    private final SelenideElement zero = $(AppiumBy.id("com.google.android.calculator:id/digit_0"));

    @Step("Нажать на кнопку '{digit}'")
    public CalculatorPage clickDigit(int digit) {
        if (digit < 0) {
            minus
                .click();
        }

        getElementByNumber(Math.abs(digit))
            .click();

        return this;
    }

    @Step("Нажать на кнопку '+'")
    public CalculatorPage clickPlus() {
        plus
            .click();

        return this;
    }

    @Step("Нажать на кнопку '-'")
    public CalculatorPage clickMinus() {
        minus
            .click();

        return this;
    }

    @Step("Нажать на кнопку '*'")
    public CalculatorPage clickMulti() {
        mul
            .click();

        return this;
    }

    @Step("Нажать на кнопку '/'")
    public CalculatorPage clickDiv() {
        div
            .click();

        return this;
    }

    @Step("Нажать на кнопку '='")
    public CalculatorPage clickEqual() {
        equal
            .click();

        return this;
    }

    @Step("Результат должен быть равен {value}")
    public CalculatorPage checkResult(String value) {
        result
            .shouldHave(Condition.text(value));

        return this;
    }

    private SelenideElement getElementByNumber(int number) {
        switch (number) {
            case 1:
                return one;
            case 2:
                return two;
            case 3:
                return three;
            case 4:
                return four;
            case 5:
                return five;
            case 6:
                return six;
            case 7:
                return seven;
            case 8:
                return eight;
            case 9:
                return nine;
            case 0:
                return zero;
            default:
                return null;
        }
    }
}