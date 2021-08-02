package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PagesStudentRegistrationForm;
import com.demoqa.utility.Attach;
import com.demoqa.utility.RandomArrayElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.DecimalFormat;

public class TestStudentRegistrationForm {
    Faker faker = new Faker();
    DecimalFormat dF = new DecimalFormat("00");
    RandomArrayElement rm = new RandomArrayElement();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = rm.getRandomGender();
    String mobileNumber = faker.phoneNumber().subscriberNumber(10);
    String month = rm.getRandomMonth();
    String year = faker.random().nextInt(1900, 2100).toString();
    String day = dF.format(faker.random().nextInt(1, 28));
    String subject = rm.getRandomSubject();
    String hobby = rm.getRandomHobby();
    String address = faker.address().fullAddress();
    String state = rm.getRandomState();
    String city = rm.getRandomCity(state);
    String picture = rm.getRandomPicture();

    @BeforeAll
    static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Attach.addVideo();
    }

    @Test
    void fakerTest() {
        PagesStudentRegistrationForm registrationForm = new PagesStudentRegistrationForm();

        registrationForm.openPage()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .gender(gender)
                .mobileNumber(mobileNumber)
                .dateOfBirth(month, year, day)
                .subject(subject)
                .hobbies(hobby)
                .picture(picture)
                .currentAddress(address)
                .states(state)
                .city(city)
                .clickSubmit();

        registrationForm
                .checkStudentName(firstName, lastName)
                .checkEmail(email)
                .checkGender(gender)
                .checkMobile(mobileNumber)
                .checkDateOfBirth(day, month, year)
                .checkSubject(subject)
                .checkHobby(hobby)
                .checkPicture(picture)
                .checkAddress(address)
                .checkStateAndCity(state, city);
    }
}