package ru.eda.tech.authorization.process;

public class TechnicalInformation {
    private final String username;
    private final String password;
    private final long id;

    private TechnicalInformation(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.id = builder.id;
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

    public static class Builder {
        private String username;
        private String password;
        private long id;

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public TechnicalInformation build() {
            return new TechnicalInformation(this);
        }

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
