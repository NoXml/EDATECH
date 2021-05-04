package ru.eda.tech.authorization.process;

import java.time.LocalDate;

public class Profile {
    private final TechnicalInformation technicalInformation;
    private final PersonalInformation personalInformation;

    private Profile(TechnicalInformation technicalInformation, PersonalInformation personalInformation) {
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
        TechnicalInformation technicalInformation = new TechnicalInformation.Builder()
                .withUsername("shpikich")
                .withPassword("12345678")
                .withId(125L)
                .build();
        PersonalInformation personalInformation = new PersonalInformation.Builder()
                .withName("Nikita")
                .withSurname("Yushkov")
                .withAge(24)
                .withGender(Gender.Male)
                .withEmail("y@gmail.com")
                .withPhone("88005553535")
                .withDateOfBirth(LocalDate.of(1997, 3, 14))
                .build();
        Profile profile = new Profile(technicalInformation, personalInformation);
        System.out.println(profile);
    }
}
