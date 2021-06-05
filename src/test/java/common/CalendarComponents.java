package common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponents {

    private SelenideElement dateOfBirthForm = $("#dateOfBirth"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            yearBirthLink = dateOfBirthForm.$(".react-datepicker__year-select"),
            monthBirthLink = dateOfBirthForm.$(".react-datepicker__month-select");

    private SelenideElement dayBirthLink(String dayBirth) {
        return $$(".react-datepicker__day:not([class*=--outside])").findBy(text(dayBirth));
    }

    public CalendarComponents chooseDateOfBirth(String yearBirth, String monthBirth, String dayBirth) {
        dateOfBirthInput.click();
        yearBirthLink.selectOption(yearBirth);
        monthBirthLink.selectOption(monthBirth);
        dayBirthLink(dayBirth).click();
        return this;
    }
}
