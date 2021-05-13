package ru.eda.tech.authorization.process;

import java.util.ArrayList;

public class ArrayListProfileRepository implements ProfileRepository {

    private final ArrayList<Profile> profiles = new ArrayList<>();

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    @Override
    public void save(Profile p) {
        profiles.add(p);
    }

    @Override
    public Profile find(long id) {
        if (id <= profiles.size() && id >= 0) return profiles.get((int) id);
        else return null;
    }
}
