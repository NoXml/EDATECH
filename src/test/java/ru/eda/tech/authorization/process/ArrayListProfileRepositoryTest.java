package ru.eda.tech.authorization.process;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListProfileRepositoryTest {

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

    @Test
    void save() {
        ProfileRepository actual = new ArrayListProfileRepository();
        actual.save(profile);

        List<Profile> expected = new ArrayList<>();
        expected.add(profile);

        assertEquals(expected, actual);
    }

    @Test
    void find() {
    }
}