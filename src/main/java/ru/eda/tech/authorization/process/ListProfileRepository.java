package ru.eda.tech.authorization.process;

import java.util.List;

public abstract class ListProfileRepository implements ProfileRepository {

    private final List<Profile> profiles;

    protected ListProfileRepository(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public void save(Profile profile) {
        profiles.add(profile);
    }

    @Override
    public Profile find(long id) {
        long index = -1;
        for (Profile profile : profiles) {
            if (profile.getTechnicalInformation().getId() == id) index = profiles.indexOf(profile);
        }
        if (index == -1) return null;
        else return profiles.get((int) index);
    }
}
