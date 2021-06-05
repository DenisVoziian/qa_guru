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
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeUserEmail(email);
        registrationPage.chooseGender(gender);
        registrationPage.typePhoneNumber(phoneNumber);
        registrationPage.chooseDateOfBirth(yearBirth, monthBirth, dayBirth);
        registrationPage.typeSubjects(firstSubjects);
        registrationPage.typeSubjects(secondSubjects);
        registrationPage.chooseHobby(sportHobby);
        registrationPage.chooseHobby(musicHobby);
        registrationPage.chooseHobby(readingHobby);
        registrationPage.uploadPicture(pictureName);
        registrationPage.typeCurrentAddress(currentAddress);
        registrationPage.chooseStateName(stateName);
        registrationPage.chooseCityName(cityName);

        logger.info("============== Click 'Submit' button =============");
        registrationPage.clickSubmitButton();

        logger.info("============== Check the table =============");
        registrationPage.checkTableWithData(firstName, lastName, email, gender, phoneNumber, dayBirth, monthBirth,
                yearBirth, firstSubjects, secondSubjects, sportHobby, readingHobby, musicHobby, pictureName,
                currentAddress, stateName, cityName);
    }
}
