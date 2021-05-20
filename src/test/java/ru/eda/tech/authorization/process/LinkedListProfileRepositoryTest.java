package ru.eda.tech.authorization.process;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListProfileRepositoryTest {

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

    LinkedListProfileRepository linkedListProfileRepository = new LinkedListProfileRepository();

    @Test
    void savedIsSameAsFound() {

        linkedListProfileRepository.save(profile);
        assertEquals(profile, linkedListProfileRepository.find(technicalInformation.getId()));
    }

    @Test
    void findProfileByWrongId() {

        linkedListProfileRepository.save(profile);
        assertNull(linkedListProfileRepository.find(technicalInformation.getId() + 2));
    }

    @Test
    void findProfileInEmptyRepository() {
        assertNull(linkedListProfileRepository.find(1));
    }

}