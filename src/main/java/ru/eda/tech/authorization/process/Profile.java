package ru.eda.tech.authorization.process;

public class Profile {
    private final TechnicalInformation technicalInformation;
    private final PersonalInformation personalInformation;

    private Profile(Builder builder) {
        this.technicalInformation = builder.technicalInformation;
        this.personalInformation = builder.personalInformation;
    }

    public TechnicalInformation getTechnicalInformation() {
        return technicalInformation;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public static class Builder {
        private TechnicalInformation technicalInformation;
        private PersonalInformation personalInformation;

        public Builder withTechnicalInformation(TechnicalInformation technicalInformation) {
            this.technicalInformation = technicalInformation;
            return this;
        }

        public Builder withPersonalInformation(PersonalInformation personalInformation) {
            this.personalInformation = personalInformation;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }

    }

    @Override
    public String toString() {
        return "Profile{" +
                "technicalInformation=" + technicalInformation +
                ", personalInformation=" + personalInformation +
                '}';
    }
}

