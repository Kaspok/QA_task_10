package com.demoqa.utility;

public class RandomArrayElement {
    public String randomElement(String[] subject) {
        int n = (int) Math.floor(Math.random() * subject.length);
        return subject[n];
    }

    public String getRandomGender() {
        String[] genders = new String[]{"Male", "Female", "Other"};
        return randomElement(genders);
    }

    public String getRandomMonth() {
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        return randomElement(months);
    }

    public String getRandomSubject() {
        String[] subjects = new String[]{"Maths", "Chemistry", "Computer Science",
                "Accounting", "Arts", "Social Studies", "History"};
        return randomElement(subjects);
    }

    public String getRandomHobby() {
        String[] hobbies = new String[]{"Sports", "Reading", "Music"};
        return randomElement(hobbies);
    }

    public String getRandomState() {
        String[] states = new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return randomElement(states);
    }

    public String getRandomCity(String state) {
        String[][] cites = new String[][]{{"Delhi", "Gurgaon", "Noida"}, {"Agra", "Lucknow", "Merrut"},
                {"Karnal", "Panipat"}, {"Jaipur", "Jaiselmer"}};
        switch (state) {
            case "NCR":
                return randomElement(cites[0]);
            case "Uttar Pradesh":
                return randomElement(cites[1]);
            case "Haryana":
                return randomElement(cites[2]);
            case "Rajasthan":
                return randomElement(cites[3]);
            default:
                return null;
        }
    }

    public String getRandomPicture() {
        String[] pictures = new String[]{"ava.jpg", "ava1.jpg", "ava2.png"};
        return randomElement(pictures);
    }
}
