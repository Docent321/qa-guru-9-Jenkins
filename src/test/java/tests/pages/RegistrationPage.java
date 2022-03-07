package tests.pages;


import com.codeborne.selenide.SelenideElement;
import tests.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage<userMailInput> {
    // components
    private CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive"),
            userMailInput = $("#userEmail"),
            userNumberInput =  $("#userNumber"),
            userGenderClikc = $("#genterWrapper"),
            userjectsInput = $("#subjectsInput"),
            userHobbies = $("#hobbiesWrapper"),
            loadPicture = $("#uploadPicture"),
            useraddress =  $("#currentAddress"),
            setState = $("#react-select-3-input"),
            setCity = $("#react-select-4-input"),
            submitClick = $("#submit"),
            calendar =  $("#dateOfBirthInput");

    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userMailInput.setValue(email);
        return this;
    }


    public RegistrationPage setUserNumber (String number) {
        userNumberInput.setValue(number);
        return this;
    }


    public RegistrationPage setSubjects(String subjects) {
        userjectsInput.setValue(subjects).pressEnter();
        return this;

    }


    public RegistrationPage setGender (String userGender) {
        userGenderClikc.$(byText(userGender)).click();
        return this;
    }

    public RegistrationPage setHobbies (String hobbies) {
        userHobbies.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage loadPicture(String name) {
        loadPicture.uploadFromClasspath("ava.jpg");
        return this;
    }



    public  RegistrationPage setAddress (String address){
        useraddress.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        setState.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String City) {
        setCity.setValue(City).pressEnter();
        return this;
    }

    public RegistrationPage submitClick() {
        submitClick.click();
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendar.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }



    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

}
