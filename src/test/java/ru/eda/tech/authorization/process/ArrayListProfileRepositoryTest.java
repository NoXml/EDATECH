package ru.eda.tech.authorization.process;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListProfileRepositoryTest {

    ArrayListProfileRepository arrayListProfileRepository = new ArrayListProfileRepository();

    @Test
    void savedIsSameAsFound() {

        TechnicalInformation technicalInformation = new TechnicalInformation.Builder()
                .withUsername("TestUsername1")
                .withPassword("11111111")
                .withId(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE))
                .build();
        PersonalInformation personalInformation = new PersonalInformation.Builder()
                .withName("TestName1")
                .withSurname("TestSurname1")
                .withAge(24)
                .withGender(Gender.Male)
                .withEmail("testusername1@gmail.com")
                .withPhone("111-11-11")
                .withDateOfBirth(LocalDate.of(1997, 3, 14))
                .build();
        Profile profile = new Profile.Builder()
                .withTechnicalInformation(technicalInformation)
                .withPersonalInformation(personalInformation)
                .build();

        arrayListProfileRepository.save(profile);

        assertEquals(profile, arrayListProfileRepository.find(technicalInformation.getId()));
    }

    @Test
    void findProfileByWrongId() {

        TechnicalInformation technicalInformation = new TechnicalInformation.Builder()
                .withUsername("TestUsername2")
                .withPassword("22222222")
                .withId(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE))
                .build();
        PersonalInformation personalInformation = new PersonalInformation.Builder()
                .withName("TestName2")
                .withSurname("TestSurname2")
                .withAge(20)
                .withGender(Gender.Female)
                .withEmail("testusername2@gmail.com")
                .withPhone("222-22-22")
                .withDateOfBirth(LocalDate.of(2001, 2, 12))
                .build();
        Profile profile = new Profile.Builder()
                .withTechnicalInformation(technicalInformation)
                .withPersonalInformation(personalInformation)
                .build();

        arrayListProfileRepository.save(profile);

        assertNull(arrayListProfileRepository.find(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE)));
    }

    @Test
    void findProfileInEmptyRepository() {

        assertNull(arrayListProfileRepository.find(ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE)));
    }
}