package ru.eda.tech.authorization.process;

public class Profile {
    private final TechnicalInformation technicalInformation;
    private final PersonalInformation personalInformation;

    public Profile(TechnicalInformation a, PersonalInformation b) {
        this.technicalInformation = a;
        this.personalInformation = b;
    }

    public TechnicalInformation getTechnicalInformation() {
        return technicalInformation;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    @Override
    public String toString() {
        return "Profile{" +
                technicalInformation +
                personalInformation +
                '}';
    }

    public static void main(String[] args) {
        TechnicalInformation a = new TechnicalInformation("shpikich", "12345", 125);
        PersonalInformation b = new PersonalInformation("Nikita", "Yushkov", 24,
                "Male", "y@gmail.com", "88005553535",
                "14031997");
        Profile profile = new Profile(a,b);
        System.out.println(profile);
    }
}

class TechnicalInformation {
    private final String username;
    private final String password;
    public final int id;

    @Override
    public String toString() {
        return "TechnicalInformation{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public TechnicalInformation(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
}

class PersonalInformation {
    public final String name;
    public final String surname;
    public final int age;
    public final String sex;
    private final String email;
    private final String phone;
    public final String DateOfBirth;

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
}
