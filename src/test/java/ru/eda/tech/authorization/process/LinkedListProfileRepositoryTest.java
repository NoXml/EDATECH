package ru.eda.tech.authorization.process;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListProfileRepositoryTest {

    LinkedListProfileRepository linkedListProfileRepository = new LinkedListProfileRepository();

    @Test
    void savedIsSameAsFound() {

        TechnicalInformation technicalInformation = new TechnicalInformation.Builder()
                .withUsername("TestUsername3")
                .withPassword("33333333")
                .withId(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE))
                .build();
        PersonalInformation personalInformation = new PersonalInformation.Builder()
                .withName("TestName3")
                .withSurname("TestSurname3")
                .withAge(30)
                .withGender(Gender.Male)
                .withEmail("testusername3@gmail.com")
                .withPhone("333-33-33")
                .withDateOfBirth(LocalDate.of(1987, 4, 25))
                .build();
        Profile profile = new Profile.Builder()
                .withTechnicalInformation(technicalInformation)
                .withPersonalInformation(personalInformation)
                .build();

        linkedListProfileRepository.save(profile);

        assertEquals(profile, linkedListProfileRepository.find(technicalInformation.getId()));
    }

    @Test
    void findProfileByWrongId() {

        TechnicalInformation technicalInformation = new TechnicalInformation.Builder()
                .withUsername("TestUsername4")
                .withPassword("44444444")
                .withId(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE))
                .build();
        PersonalInformation personalInformation = new PersonalInformation.Builder()
                .withName("TestName4")
                .withSurname("TestSurname4")
                .withAge(18)
                .withGender(Gender.Female)
                .withEmail("testusername4@gmail.com")
                .withPhone("444-44-44")
                .withDateOfBirth(LocalDate.of(2003, 5, 4))
                .build();
        Profile profile = new Profile.Builder()
                .withTechnicalInformation(technicalInformation)
                .withPersonalInformation(personalInformation)
                .build();

        linkedListProfileRepository.save(profile);

        assertNull(linkedListProfileRepository.find(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE)));
    }

    @Test
    void findProfileInEmptyRepository() {

        assertNull(linkedListProfileRepository.find(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE)));
    }

}