package org.example;

import io.qameta.allure.*;
import org.example.page.PracticeFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;

@Epic("Automation Practice")
@Feature("Registration Form")
public class RegistrationFormTest {

    private WebDriver driver;
    private PracticeFormPage practiceFormPage;

    @BeforeClass
    @Step("Настройка WebDriver и переход на тестовую страницу")
    public void setUp() {
        String chromeDriverPath = Paths.get("chromedriver-win64", "chromedriver.exe").toAbsolutePath().toString();
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        practiceFormPage = new PracticeFormPage(driver);
    }

    @Test
    @Story("Заполнить и отправить форму регистрации")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Этот тест заполняет форму регистрации и отправляет ее.")
    public void fillPracticeForm() {
        practiceFormPage.openPage();
        practiceFormPage.enterFirstName("Albert");
        practiceFormPage.enterLastName("Nigm");
        practiceFormPage.enterEmail("albert.nigm@example.com");

        practiceFormPage.chooseGender();

        practiceFormPage.enterMobileNumber("1234567890");
        practiceFormPage.enterDateOfBirth("25 Aug 2024");

        practiceFormPage.selectSubject("Maths");

        practiceFormPage.chooseHobbySports();
        practiceFormPage.chooseHobbyReading();

        String picturePath = Paths.get("IMG_20220702_063234.jpg").toAbsolutePath().toString();
        practiceFormPage.uploadPicture(picturePath);

        practiceFormPage.enterCurrentAddress("123 Green Street, Kazan City");

        practiceFormPage.selectState("NCR");
        practiceFormPage.selectCity("Delhi");

        practiceFormPage.clickSubmit();
    }

    @AfterClass
    @Step("Завершение работы WebDriver")
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}


