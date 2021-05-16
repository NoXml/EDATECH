package ru.eda.tech.authorization.process;

import java.util.List;

public abstract class ListProfileRepository implements ProfileRepository {

    public List<Profile> profileRepository;

    @Override
    public void save(Profile profile) {
        profileRepository.add(profile);
    }

    @Override
    public Profile find(long id) {
        if (id <= profileRepository.size() && id >= 0) return profileRepository.get((int) id);
        else return null;
    }
}
