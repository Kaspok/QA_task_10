package com.demoqa.pages;

import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class PagesStudentRegistrationForm {
    @Step("Открываем форму StudentRegistrationForm")
    public PagesStudentRegistrationForm openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    @Step("Заполняем поле FirstName значением {firstName}")
    public PagesStudentRegistrationForm firstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    @Step("Заполняем поле LastName значением {lastName}")
    public PagesStudentRegistrationForm lastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    @Step("Заполняем поле Email значением {email}")
    public PagesStudentRegistrationForm email(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    @Step("Выбираем в Gender значение {gender}")
    public PagesStudentRegistrationForm gender(String gender) {
        switch (gender) {
            case "Male":
                $("#genterWrapper").$(byText("Male")).click();
                break;
            case "Female":
                $("#genterWrapper").$(byText("Female")).click();
                break;
            case "Other":
                $("#genterWrapper").$(byText("Other")).click();
                break;
        }
        return this;
    }

    @Step("Заполняем поле Mobile(10 Digits) значением {mobileNumber}")
    public PagesStudentRegistrationForm mobileNumber(String mobileNumber) {
        $("#userNumber").setValue(mobileNumber);
        return this;
    }

    @Step("Заполняем поле Date of Birth, день - {day}, месяц - {month}, год - {year}")
    public PagesStudentRegistrationForm dateOfBirth(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__month-select").selectOption(month);
        $("#dateOfBirth-wrapper").$(".react-datepicker__year-select").selectOptionByValue(year);
        $("#dateOfBirth-wrapper").$(format(".react-datepicker__day--0%s", day)).click();
        return this;
    }

    @Step("Заполняем поле Subjects значением {subject}")
    public PagesStudentRegistrationForm subject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбираем в Hobbies значение {hobby}")
    public PagesStudentRegistrationForm hobbies(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    @Step("Заполняем поле Current Address значением {address}")
    public PagesStudentRegistrationForm currentAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    @Step("Заполняем поле State значением {state}")
    public PagesStudentRegistrationForm states(String state) {
        $("#state").$("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    @Step("Заполняем поле City значением {city}")
    public PagesStudentRegistrationForm city(String city) {
        $("#city").$("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    @Step("Загружаем изображение в Picture - {file}")
    public PagesStudentRegistrationForm picture(String file) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + file));
        return this;
    }

    @Step("Нажимаем на кнопку Submit")
    public PagesStudentRegistrationForm clickSubmit() {
        $("#submit").scrollTo().click();
        return this;
    }

    @Step("Проверяем, что поле Student Name имеет значение {firstName} {lastName}")
    public PagesStudentRegistrationForm checkStudentName(String firstName, String lastName) {
        $x("//td[text()='Student Name']/following::td")
                .shouldHave(text(firstName + " " + lastName));
        return this;
    }

    @Step("Проверяем, что поле Student Email имеет значение {email}")
    public PagesStudentRegistrationForm checkEmail(String email) {
        $x("//td[text()='Student Email']/following::td").shouldHave(text(email));
        return this;
    }

    @Step("Проверяем, что в Gender выбрано значение {gender}")
    public PagesStudentRegistrationForm checkGender(String gender) {
        $x("//td[text()='Gender']/following::td").shouldHave(text(gender));
        return this;
    }

    @Step("Проверяем, что поле Mobile имеет значение {mobile}")
    public PagesStudentRegistrationForm checkMobile(String mobile) {
        $x("//td[text()='Mobile']/following::td").shouldHave(text(mobile));
        return this;
    }

    @Step("Проверяем, что поле Date of Birth имеет значение {day} {month},{year} ")
    public PagesStudentRegistrationForm checkDateOfBirth(String day, String month, String year) {
        $x("//td[text()='Date of Birth']/following::td").shouldHave(text(day + " " + month + "," + year));
        return this;
    }

    @Step("Проверяем, что поле Subject имеет значение {subject}")
    public PagesStudentRegistrationForm checkSubject(String subject) {
        $x("//td[text()='Subjects']/following::td").shouldHave(text(subject));
        return this;
    }

    @Step("Проверяем, что поле Hobbies имеет значение {hobby}")
    public PagesStudentRegistrationForm checkHobby(String hobby) {
        $x("//td[text()='Hobbies']/following::td").shouldHave(text(hobby));
        return this;
    }

    @Step("Проверяем, что поле Picture имеет значение {picture}")
    public PagesStudentRegistrationForm checkPicture(String picture) {
        $x("//td[text()='Picture']/following::td").shouldHave(text(picture));
        return this;
    }

    @Step("Проверяем, что поле Address имеет значение {address}")
    public PagesStudentRegistrationForm checkAddress(String address) {
        $x("//td[text()='Address']/following::td").shouldHave(text(address));
        return this;
    }

    @Step("Проверяем, что поле State and City имеет значение {state} {city}")
    public PagesStudentRegistrationForm checkStateAndCity(String state, String city) {
        $x("//td[text()='State and City']/following::td").shouldHave(text(state + " " + city));
        return this;
    }
}
