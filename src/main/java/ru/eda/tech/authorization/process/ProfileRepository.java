package ru.eda.tech.authorization.process;

public interface ProfileRepository {
    void save(Profile profile);

    Profile find(long id);
}
