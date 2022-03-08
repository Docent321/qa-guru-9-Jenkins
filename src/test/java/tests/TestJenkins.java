package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;


public class TestJenkins {


    RegistrationPage registrationPage = new RegistrationPage();

    String
            firstName = "Alex",
            lastName = "Donskov",
            email = "alex@mail.com",
            userNumber = "1231231231",
            day = "12",
            month = "July",
            year = "2001",
            userGender = "Other",
            subjects = "Math",
            hobbies = "Sports",
            loadPicture = "ava.jpg",
            address = "Some address 1",
            state = "NCR",
            City = "Delhi";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://AlexDonskov:1234AD!@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    void successFillTest() {

        step("Open home page", () -> {
            registrationPage.openPage();
        });

        step("Enter name", () -> {
            registrationPage.setFirstName(firstName);
        });

        step("Enter lastname", () -> {
            registrationPage.setLastName(lastName);
        });

        step("Enter email", () -> {
            registrationPage.setUserEmail(email);
        });

        step("Enter user number", () -> {
            registrationPage.setUserNumber(userNumber);
        });

        step("Select gender", () -> {
            registrationPage.setGender(userGender);
        });

        step("Select  birthdate", () -> {
            registrationPage.setBirthDate(day, month, year);
        });

        step("Enter subjects", () -> {
            registrationPage.setSubjects(subjects);
        });

        step("Enter hobbies", () -> {
            registrationPage.setHobbies(hobbies);
        });

        step("Load picture", () -> {
            registrationPage.loadPicture(loadPicture);
        });

        step("Enter address", () -> {
            registrationPage.setAddress(address);
        });

        step("Select state", () -> {
            registrationPage.setState(state);
        });

        step("Select city", () -> {
            registrationPage.setCity(City);
        });

        step("submit click", () -> {
            registrationPage.submitClick();
        });


        step("Form check", () -> {
            registrationPage
                    .checkForm("Student Name", firstName + " " + lastName)
                    .checkForm("Student Email", email)
                    .checkForm("Gender", userGender)
                    .checkForm("Mobile", userNumber)
                    .checkForm("Date of Birth", day + " " + month + "," + year)
                    .checkForm("Subjects", subjects)
                    .checkForm("Hobbies", hobbies)
                    .checkForm("Picture", loadPicture)
                    .checkForm("Address", address)
                    .checkForm("State and City", state + " " + City);
        });

    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
