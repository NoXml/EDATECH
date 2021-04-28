package ru.eda.tech.authorization.process;

import java.time.LocalDate;

public class PersonalInformation {
    public final String name;
    public final String surname;
    public final int age;

    public enum Sex {
        Male, Female;
    }

    public Sex sex;
    private final String email;
    private final String phone;
    public final LocalDate dateOfBirth;

    public PersonalInformation(String name, String surname, int age, Sex sex, String email, String phone, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", DateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
