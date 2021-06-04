import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ToolsQATests {
    private String baseURL = "https://demoqa.com/";

    //student data
    static private String firstName = "Ivan",
            lastName = "Ivanov",
            email = "1212@mail.com",
            gender = "Male",
            phoneNumber = "1234567890",
            yearBirth = "1992",
            monthBirth = "May",
            dayBirth = "30",
            firstSubjects = "Computer Science",
            seconSubjects = "English",
            sportHobby = "Sports",
            readingHobby = "Reading",
            musicHobby = "Music",
            pictureName = "test.jpg",
            currentAddress = "101 Roberts St. Neenah, WI 54956",
            stateName = "Haryana",
            cityName = "Karnal";

    private File file = new File("src/test/resources/" + pictureName);
    private Logger logger = LoggerFactory.getLogger(ToolsQATests.class);

    //form
    private SelenideElement studentForm = $("#userForm"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioButton = studentForm.$(byValue(gender)).parent(),
            phoneNumberInput = $("#userNumber"),
            dateOfBirthForm = $("#dateOfBirth"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            yearBirthLink = dateOfBirthForm.$(".react-datepicker__year-select"),
            monthBirthLink = dateOfBirthForm.$(".react-datepicker__month-select"),
            dayBirthLink = $$(".react-datepicker__day:not([class*=--outside])").findBy(text(dayBirth)),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            sportHobbyCheckBox = hobbiesCheckBox.find(byText("Sports")),
            readingHobbyCheckBox = hobbiesCheckBox.find(byText("Reading")),
            musicHobbyCheckBox = hobbiesCheckBox.find(byText("Music")),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state").$("input"),
            cityInput = $("#city").$("input"),
            submitButton = $("#submit");

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

    @BeforeAll
    public static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    protected void practiceFormTest() {
        logger.info("============== Open page =============");
        open(baseURL + "automation-practice-form/");

        logger.info("============== Fill in the form =============");
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        userEmailInput.setValue(email);
        genderRadioButton.click();
        phoneNumberInput.setValue(phoneNumber);
        dateOfBirthInput.click();
        yearBirthLink.selectOption(yearBirth);
        monthBirthLink.selectOption(monthBirth);
        dayBirthLink.click();
        subjectsInput.setValue(firstSubjects).pressEnter();
        subjectsInput.setValue(seconSubjects).pressEnter();
        sportHobbyCheckBox.click();
        readingHobbyCheckBox.click();
        musicHobbyCheckBox.click();
        uploadPictureButton.uploadFile(file);
        currentAddressInput.setValue(currentAddress);
        stateInput.setValue(stateName).pressEnter();
        cityInput.setValue(cityName).pressEnter();

        logger.info("============== Click 'Submit' button =============");
        submitButton.click();

        logger.info("============== Check the table =============");
        studentNameRow.shouldHave(text(firstName), text(lastName));
        studentEmailRow.shouldHave(text(email));
        genderRow.shouldHave(text(gender));
        mobileRow.shouldHave(text(phoneNumber));
        dateOfBirthRow.shouldHave(text(dayBirth), text(monthBirth), text(yearBirth));
        subjectsRow.shouldHave(text(firstSubjects), text(seconSubjects));
        hobbiesRow.shouldHave(text(sportHobby), text(readingHobby), text(musicHobby));
        pictureRow.shouldHave(text(pictureName));
        addressRow.shouldHave(text(currentAddress));
        stateAndCityRow.shouldHave(text(stateName), text(cityName));
    }
}
