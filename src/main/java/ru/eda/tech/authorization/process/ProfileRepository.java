package ru.eda.tech.authorization.process;

public interface ProfileRepository {
    void save(Profile p);

    Profile find(long id);
}
