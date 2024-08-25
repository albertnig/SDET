package org.example.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    protected WebDriver driver;

    protected String url;

    public BasePage(WebDriver driver, String url) {

        this.driver = driver;
        this.url = url;
    }

    @Step("Заполнить текстовое поле: {1}")
    protected void fillTextField(By locator, String value) {
        WebElement field = driver.findElement(locator);
        field.sendKeys(value);
    }

    @Step("Загрузить файл: {1}")
    protected void uploadFile(By locator, String filePath) {
        WebElement uploadField = driver.findElement(locator);
        uploadField.sendKeys(filePath);
    }

    @Step("Выбрать опцию из выпадающего списка: {1}")
    protected void selectDropdownOption(By locator, String option) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.sendKeys(option);
        dropdown.sendKeys("\n");
    }

    @Step("Нажать на кнопку: {1}")
    protected void submitForm(By locator, String buttonName) {
        WebElement submitButton = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();
    }

    @Step("Открыть страницу по URL")
    public void openPage() {
        driver.get(url);
    }
}
