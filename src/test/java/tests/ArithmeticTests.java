package tests;

import helpers.pageObject.CalculatorPage;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Арифметические тесты")
public class ArithmeticTests extends BaseTest {


    @CsvSource(value = {
        "1 | 1 | 2",
        "-1 | 0 | −1",
        "0 | 0 | 0",
        "-1 | -1 | −2",
        "-1 | 1 | 0",
    },
        delimiter = '|'
    )
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @Tag("plus")
    @Feature("Функции сложения")
    void additionTests(int firstDigit, int secondDigit, String result) {
        new CalculatorPage()
            .clickDigit(firstDigit)
            .clickPlus()
            .clickDigit(secondDigit)
            .clickEqual()
            .checkResult(result);
    }

    @CsvSource(value = {
        "1 | 1 | 0",
        "-1 | 0 | -1",
        "0 | 0 | 0",
        "-1 | -1 | 0",
        "-1 | 1 | -2",
    },
        delimiter = '|'
    )
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @Tag("minus")
    @Feature("Функции вычитания")
    void subtractionTests(int firstDigit, int secondDigit, String result) {
        new CalculatorPage()
            .clickDigit(firstDigit)
            .clickMinus()
            .clickDigit(secondDigit)
            .clickEqual()
            .checkResult(result);
    }

    @CsvSource(value = {
        "1 | 1 | 1",
        "-1 | 0 | 0",
        "0 | 0 | 0",
        "-1 | -1 | 1",
        "-1 | 1 | -1",
    },
        delimiter = '|'
    )
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @Tag("multi")
    @Feature("Функции умножения")
    void multiplicationTests(int firstDigit, int secondDigit, String result) {
        new CalculatorPage()
            .clickDigit(firstDigit)
            .clickMulti()
            .clickDigit(secondDigit)
            .clickEqual()
            .checkResult(result);
    }


    @CsvSource(value = {
        "1 | 1 | 1",
        "25 | 5 | 5",
        "0 | 4 | 0",
        "-1 | -1 | 1",
        "5 | 2 | 2.5",
    },
        delimiter = '|'
    )
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @Tag("div")
    @Feature("Функции деления")
    void divisionTests(int firstDigit, int secondDigit, String result) {
        new CalculatorPage()
            .clickDigit(firstDigit)
            .clickDiv()
            .clickDigit(secondDigit)
            .clickEqual()
            .checkResult(result);
    }
}