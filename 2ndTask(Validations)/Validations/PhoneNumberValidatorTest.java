package Validations;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Exceptions.InvalidPhoneNumberCharsException;
import Exceptions.InvalidPhoneNumberLengthException;
import Exceptions.InvalidPhoneNumberPrefixException;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PhoneNumberValidatorTest {

    private static final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();

    @Test
    public void validPhoneNumber() {
        String phoneNumber = "862121212";
        assertDoesNotThrow(() -> phoneNumberValidator.validate(phoneNumber));
    }


    @Test
    public void validNormalizedPhoneNumber() {
        String phoneNumber = "+37062121212";
        assertDoesNotThrow(() -> phoneNumberValidator.validate(phoneNumber));
    }

    @Test
    public void phoneNumberValidWithCustomRule() {
        String phoneNumber = "+441237379541";
        assertDoesNotThrow(() -> phoneNumberValidator.differentCountryNumbers(phoneNumber));
    }

    /*@Test(expected = InvalidPhoneNumberPrefixException.class)
    public void invalidPhoneNumberPrefix() {
        String phoneNumber = "+37562121212";
        phoneNumberValidator.validate(phoneNumber);
    }*/
    @Test
    public void invalidPhoneNumberPrefix() {
        String phoneNumber = "+37562121212";
        Assertions.assertThrows(InvalidPhoneNumberPrefixException.class, () -> phoneNumberValidator.differentCountryNumbers(phoneNumber));
    }

    /*@Test(expected = InvalidPhoneNumberLengthException.class)
    public void invalidPhoneNumberLength() {
        String phoneNumber = "+3706212121";
        phoneNumberValidator.validate(phoneNumber);
    }*/

    @Test
    public void invalidPhoneNumberLength() {
        String phoneNumber = "+3706212121";
        Assertions.assertThrows(InvalidPhoneNumberLengthException.class, () -> phoneNumberValidator.differentCountryNumbers(phoneNumber));
    }

    /*@Test(expected = InvalidPhoneNumberCharsException.class)
    public void invalidPhoneNumberBadChars() {
        String phoneNumber = "+3706212121A";
        phoneNumberValidator.validate(phoneNumber);
    }*/

    @Test
    public void invalidPhoneNumberBadChars() {
        String phoneNumber = "+3706212121A";
        Assertions.assertThrows(InvalidPhoneNumberCharsException.class, () -> phoneNumberValidator.validate(phoneNumber));
    }
}
