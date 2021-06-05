package pages;

import com.codeborne.selenide.SelenideElement;
import common.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    String practiceFormPageUrl = "automation-practice-form/";

    //form
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesBox = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state").$("input"),
            cityInput = $("#city").$("input"),
            submitButton = $("#submit");

    private SelenideElement genderRadioButton(String gender) {
        return $("#genterWrapper").$(byValue(gender)).parent();
    }

    private SelenideElement hobbyCheckBox(String hobby) {
        return hobbiesBox.find(byText(hobby));
    }

    //table
    private SelenideElement tableBody = $(".table-responsive").find("tbody"),
            studentNameRow = tableBody.find(byText("Student Name")).sibling(0),
            studentEmailRow = tableBody.find(byText("Student Email")).sibling(0),
            genderRow = tableBody.find(byText("Gender")).sibling(0),
            mobileRow = tableBody.find(byText("Mobile")).sibling(0),
            dateOfBirthRow = tableBody.find(byText("Date of Birth")).sibling(0),
            subjectsRow = tableBody.find(byText("Subjects")).sibling(0),
            hobbiesRow = tableBody.find(byText("Hobbies")).sibling(0),
            pictureRow = tableBody.find(byText("Picture")).sibling(0),
            addressRow = tableBody.find(byText("Address")).sibling(0),
            stateAndCityRow = tableBody.find(byText("State and City")).sibling(0);


    public void openPracticeFormPage() {
        open(practiceFormPageUrl);
    }

    public void typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void typeUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
    }

    public void chooseGender(String gender) {
        genderRadioButton(gender).click();
    }

    public void typePhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
    }

    public void chooseDateOfBirth(String yearBirth, String monthBirth, String dayBirth) {
        new CalendarComponents().chooseDateOfBirth(yearBirth, monthBirth, dayBirth);
    }

    public void typeSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
    }

    public void chooseHobby(String hobby) {
        hobbyCheckBox(hobby).click();
    }

    public void uploadPicture(String pictureName) {
        uploadPictureButton.uploadFromClasspath("img/" + pictureName);
    }

    public void typeCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
    }

    public void chooseStateName(String stateName) {
        stateInput.setValue(stateName).pressEnter();
    }

    public void chooseCityName(String cityName) {
        cityInput.setValue(cityName).pressEnter();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void checkTableWithData(String firstName, String lastName, String email, String gender, String phoneNumber,
                                   String dayBirth, String monthBirth, String yearBirth, String firstSubjects,
                                   String secondSubjects, String sportHobby, String readingHobby, String musicHobby,
                                   String pictureName, String currentAddress, String stateName, String cityName) {
        studentNameRow.shouldHave(text(firstName), text(lastName));
        studentEmailRow.shouldHave(text(email));
        genderRow.shouldHave(text(gender));
        mobileRow.shouldHave(text(phoneNumber));
        dateOfBirthRow.shouldHave(text(dayBirth), text(monthBirth), text(yearBirth));
        subjectsRow.shouldHave(text(firstSubjects), text(secondSubjects));
        hobbiesRow.shouldHave(text(sportHobby), text(readingHobby), text(musicHobby));
        pictureRow.shouldHave(text(pictureName));
        addressRow.shouldHave(text(currentAddress));
        stateAndCityRow.shouldHave(text(stateName), text(cityName));
    }
}


