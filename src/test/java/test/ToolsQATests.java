package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class ToolsQATests extends TestBase {
    private RegistrationPage registrationPage = new RegistrationPage();

    private Faker faker = new Faker();

    //student data
    private String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            yearBirth = "1992",
            monthBirth = "May",
            dayBirth = "30",
            firstSubjects = "Computer Science",
            secondSubjects = "English",
            sportHobby = "Sports",
            readingHobby = "Reading",
            musicHobby = "Music",
            pictureName = "test.jpg",
            currentAddress = faker.address().fullAddress(),
            stateName = "Haryana",
            cityName = "Karnal";

    @Test
    void practiceFormTest() {
        logger.info("============== Open page =============");
        registrationPage.openPracticeFormPage();

        logger.info("============== Fill in the form =============");
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(email)
                .chooseGender(gender)
                .typePhoneNumber(phoneNumber)
                .chooseDateOfBirth(yearBirth, monthBirth, dayBirth)
                .typeSubjects(firstSubjects)
                .typeSubjects(secondSubjects)
                .chooseHobby(sportHobby)
                .chooseHobby(musicHobby)
                .chooseHobby(readingHobby)
                .uploadPicture(pictureName)
                .typeCurrentAddress(currentAddress)
                .chooseStateName(stateName)
                .chooseCityName(cityName);

        logger.info("============== Click 'Submit' button =============");
        registrationPage.clickSubmitButton();

        logger.info("============== Check the table =============");
        registrationPage.checkTableWithData(firstName, lastName, email, gender, phoneNumber, dayBirth, monthBirth,
                yearBirth, firstSubjects, secondSubjects, sportHobby, readingHobby, musicHobby, pictureName,
                currentAddress, stateName, cityName);
    }
}
