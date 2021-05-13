package ru.eda.tech.authorization.process;

import java.util.LinkedList;

public class LinkedListProfileRepository implements ProfileRepository {

    private final LinkedList<Profile> profiles = new LinkedList<>();

    public LinkedList<Profile> getProfiles() {
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
