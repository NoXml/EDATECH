package ru.eda.tech.authorization.process;

import java.time.LocalDate;

public class Profile {
    private final TechnicalInformation technicalInformation;
    private final PersonalInformation personalInformation;

    public Profile(TechnicalInformation technicalInformation, PersonalInformation personalInformation) {
        this.technicalInformation = technicalInformation;
        this.personalInformation = personalInformation;
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
                "technicalInformation=" + technicalInformation +
                ", personalInformation=" + personalInformation +
                '}';
    }

    public static void main(String[] args) {
        TechnicalInformation a = new TechnicalInformation("shpikich", "12345", 125L);
        PersonalInformation b = new PersonalInformation("Nikita", "Yushkov", 24, PersonalInformation.Sex.Male,
                "y@gmail.com", "88005553535", LocalDate.of(1997, 3, 14));
        Profile profile = new Profile(a, b);
        System.out.println(profile);
    }
}
