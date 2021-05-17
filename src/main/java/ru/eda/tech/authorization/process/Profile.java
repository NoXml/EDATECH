package ru.eda.tech.authorization.process;

import java.time.LocalDate;
import java.util.List;

public class Profile {
    private final TechnicalInformation technicalInformation;
    private final PersonalInformation personalInformation;
    private static List<Profile> profiles;

    private Profile(Builder builder) {
        this.technicalInformation = builder.technicalInformation;
        this.personalInformation = builder.personalInformation;
    }

    public TechnicalInformation getTechnicalInformation() {
        return technicalInformation;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public static void main(String[] args) {
        TechnicalInformation technicalInformation = new TechnicalInformation.Builder()
                .withUsername("shpikich")
                .withPassword("12345678")
                .withId(0)
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
        Profile profile = new Profile.Builder()
                .withTechnicalInformation(technicalInformation)
                .withPersonalInformation(personalInformation)
                .build();
        System.out.println(profile);

        ProfileRepository arrayProfileRepository = new ArrayListProfileRepository();
        arrayProfileRepository.save(profile);
        System.out.println(arrayProfileRepository.find(0));

        ProfileRepository linkedProfileRepository = new LinkedListProfileRepository();
        linkedProfileRepository.save(profile);
        System.out.println(linkedProfileRepository.find(0));
    }

    public static class Builder {
        private TechnicalInformation technicalInformation;
        private PersonalInformation personalInformation;

        public Builder withTechnicalInformation(TechnicalInformation technicalInformation) {
            this.technicalInformation = technicalInformation;
            return this;
        }

        public Builder withPersonalInformation(PersonalInformation personalInformation) {
            this.personalInformation = personalInformation;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }

    }

    @Override
    public String toString() {
        return "Profile{" +
                "technicalInformation=" + technicalInformation +
                ", personalInformation=" + personalInformation +
                '}';
    }
}

