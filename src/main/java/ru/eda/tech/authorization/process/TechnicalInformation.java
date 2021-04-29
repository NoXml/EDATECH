package ru.eda.tech.authorization.process;

public class TechnicalInformation {
    private final String username;
    private final String password;
    private final long id;

    public TechnicalInformation(String username, String password, long id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TechnicalInformation{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
