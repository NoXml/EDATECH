package ru.eda.tech.authorization.process;

public class TechnicalInformation {
    private String username;
    private String password;
    private long id;

    public static class Builder {
        private final TechnicalInformation technicalInformation;

        public Builder() {
            technicalInformation = new TechnicalInformation();
        }

        public Builder withUsername(String username) {
            technicalInformation.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            technicalInformation.password = password;
            return this;
        }

        public Builder withId(long id) {
            technicalInformation.id = id;
            return this;
        }

        public TechnicalInformation build() {
            return technicalInformation;
        }

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
