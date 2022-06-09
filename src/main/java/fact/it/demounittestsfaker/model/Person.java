package fact.it.demounittestsfaker.model;

import fact.it.demounittestsfaker.exception.CountryCodeTooLongException;

public class Person {
    private String firstName;
    private String lastName;
    private String emailAddress;
    // 2-letter country code
    private String countryCode;

    public Person() {
    }

    public Person(String firstName, String lastName, String emailAddress, String countryCode) throws CountryCodeTooLongException {
        if (countryCode.length() > 2) throw new CountryCodeTooLongException();

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.countryCode = countryCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) throws CountryCodeTooLongException {
        if (countryCode.length() > 2) throw new CountryCodeTooLongException();
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
