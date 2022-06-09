package fact.it.demounittestsfaker.model;

import com.github.javafaker.Faker;
import fact.it.demounittestsfaker.exception.CountryCodeTooLongException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonTest {
    private static Faker faker;

    @BeforeAll
    static void beforeAll() {
        faker = new Faker();
    }

    @Test
    void personConstructs() {
        // Contruct a new person using a fake first name, last name,
        // email address and a country code consisting of 2 letters.
        Assertions.assertDoesNotThrow(() -> {
            new Person(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.internet().emailAddress(),
                    faker.country().countryCode2());
        });
    }

    @Test
    void personThrowsCountryCodeTooLongException() {
        // Contruct a new person using a fake first name, last name,
        // email address and a country code consisting of 3 letters.
        // This should throw an exception since the class expects 2 letters.
        Assertions.assertThrows(CountryCodeTooLongException.class, () -> {
            new Person(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.internet().emailAddress(),
                    faker.country().countryCode3());
        });
    }

    @Test
    void personFirstName()  {
        // Arrange
        Person person = new Person();
        String fakeFirstName = faker.name().firstName();

        // Act
        person.setFirstName(fakeFirstName);

        // Assert
        Assertions.assertSame(fakeFirstName, person.getFirstName());

        // Purely for demonstrative purposes, don't do
        // this in a real world unit test scenario.
        System.out.println(person);
    }

    @Test
    void personLastName()  {
        // Arrange
        Person person = new Person();
        String fakeLastName = faker.name().lastName();

        // Act
        person.setLastName(fakeLastName);

        // Assert
        Assertions.assertSame(fakeLastName, person.getLastName());

        // Purely for demonstrative purposes, don't do
        // this in a real world unit test scenario.
        System.out.println(person);
    }

    @Test
    void personEmailAddress()  {
        // Arrange
        Person person = new Person();
        String fakeEmailAddress = faker.internet().emailAddress();

        // Act
        person.setEmailAddress(fakeEmailAddress);

        // Assert
        Assertions.assertSame(fakeEmailAddress, person.getEmailAddress());

        // Purely for demonstrative purposes, don't do
        // this in a real world unit test scenario.
        System.out.println(person);
    }

    @Test
    void personCountryCode()  {
        // Arrange
        Person person = new Person();
        String fakeCountryCode = faker.country().countryCode2();

        // Act and assert
        Assertions.assertDoesNotThrow(() -> {
            person.setCountryCode(fakeCountryCode);
        });
        Assertions.assertSame(fakeCountryCode, person.getCountryCode());

        // Purely for demonstrative purposes, don't do
        // this in a real world unit test scenario.
        System.out.println(person);
    }

    @Test
    void personSetCountryCodeThrowsCountryCodeTooLongException()  {
        // Arrange
        Person person = new Person();
        String fakeCountryCode = faker.country().countryCode3();

        // Act and assert
        Assertions.assertThrows(CountryCodeTooLongException.class, () -> {
            person.setCountryCode(fakeCountryCode);
        });
        Assertions.assertSame(null, person.getCountryCode());

        // Purely for demonstrative purposes, don't do
        // this in a real world unit test scenario.
        System.out.println(person);
    }

}
