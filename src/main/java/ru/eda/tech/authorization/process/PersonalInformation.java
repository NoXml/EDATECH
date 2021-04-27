package ru.eda.tech.authorization.process;

public class PersonalInformation {
    public final String name;
    public final String surname;
    public final int age;
    public final String sex;
    private final String email;
    private final String phone;
    public final String DateOfBirth;

    public PersonalInformation(String name, String surname, int age, String sex, String email, String phone, String DateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.DateOfBirth = DateOfBirth;
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

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                '}';
    }
}
