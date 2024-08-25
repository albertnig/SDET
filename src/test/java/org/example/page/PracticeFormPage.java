package org.example.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends BasePage {

    private By firstNameField = By.cssSelector("input#firstName");
    private By lastNameField = By.cssSelector("input#lastName");
    private By emailField = By.cssSelector("input#userEmail");
    private By genderMaleRadio = By.xpath("//input[@id='gender-radio-1']");
    private By mobileNumberField = By.id("userNumber");
    private By dateOfBirthField = By.id("dateOfBirthInput");
    private By subjectsInputField = By.id("subjectsInput");
    private By hobbySportsCheckbox = By.xpath("//input[@id='hobbies-checkbox-1']");
    private By hobbyReadingCheckbox = By.xpath("//input[@id='hobbies-checkbox-2']");
    private By uploadPictureField = By.id("uploadPicture");
    private By currentAddressField = By.id("currentAddress");
    private By stateDropdown = By.xpath("//input[@id='react-select-3-input']");
    private By cityDropdown = By.id("react-select-4-input");
    private By submitButton = By.id("submit");

    public PracticeFormPage(WebDriver driver) {
        super(driver, "https://demoqa.com/automation-practice-form");
    }

    @Step("Вводим имя: {0}")
    public void enterFirstName(String firstName) {
        fillTextField(firstNameField, firstName);
    }

    @Step("Вводим фамилию: {0}")
    public void enterLastName(String lastName) {
        fillTextField(lastNameField, lastName);
    }

    @Step("Вводим email: {0}")
    public void enterEmail(String email) {
        fillTextField(emailField, email);
    }

    @Step("Выбираем пол")
    public void chooseGender() {
        submitForm(genderMaleRadio, "Пол");
    }

    @Step("Вводим номер телефона: {0}")
    public void enterMobileNumber(String mobileNumber) {
        fillTextField(mobileNumberField, mobileNumber);
    }

    @Step("Вводим дату рождения: {0}")
    public void enterDateOfBirth(String dateOfBirth) {
        fillTextField(dateOfBirthField, dateOfBirth);
    }

    @Step("Выбираем предмет: {0}")
    public void selectSubject(String subject) {
        fillTextField(subjectsInputField, subject);
    }

    @Step("Выбираем хобби Спорт")
    public void chooseHobbySports() {
        submitForm(hobbySportsCheckbox, "Хобби");
    }

    @Step("Выбираем хобби Чтение")
    public void chooseHobbyReading() {
        submitForm(hobbyReadingCheckbox, "Хобби");
    }

    @Step("Загружаем картинку: {0}")
    public void uploadPicture(String filePath) {
        uploadFile(uploadPictureField, filePath);
    }

    @Step("Вводим текущий адрес: {0}")
    public void enterCurrentAddress(String currentAddress) {
        fillTextField(currentAddressField, currentAddress);
    }

    @Step("Выбираем штат: {0}")
    public void selectState(String state) {
        selectDropdownOption(stateDropdown, state);
    }

    @Step("Выбираем город: {0}")
    public void selectCity(String city) {
        selectDropdownOption(cityDropdown, city);
    }

    @Step("Нажимаем кнопку отправить")
    public void clickSubmit() {
        submitForm(submitButton, "Отправить");
    }
}
