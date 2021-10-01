package Validations;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Exceptions.InvalidPasswordCharsException;
import Exceptions.InvalidPasswordLengthException;
import Exceptions.PasswordMissingUppercaseLetterException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PasswordValidatorTest {

    private static final PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    public void validPassword() {
        String password = "123456A59a!@";
        assertDoesNotThrow(() -> passwordValidator.validate(password));
    }

    @Test
    public void validPasswordWithCustomSpecialChars() {
        String password = "123456Aa+";
        assertDoesNotThrow(() -> passwordValidator.validate(password));
    }

    /*@Test(expected = InvalidPasswordLengthException.class)
    public void invalidPasswordLength() {
        String password = "1Aa!";
        passwordValidator.validate(password);
    }*/

    @Test
    public void invalidPasswordLength() {
        String password = "1Aa!";
        Assertions.assertThrows(InvalidPasswordLengthException.class, () -> passwordValidator.validate(password));
    }
    /*@Test(expected = PasswordMissingUppercaseLetterException.class)
    public void invalidPasswordNoUppercase() {
        String password = "1@aaaaaaaaa";
        passwordValidator.validate(password);
    }*/

    @Test
    public void invalidPasswordNoUppercase () {
        String password = "1@aaaaaaaaa";
        Assertions.assertThrows(PasswordMissingUppercaseLetterException.class, () -> passwordValidator.validate(password));
    }

    /*@Test(expected = InvalidPasswordCharsException.class)
    public void invalidPasswordNoSpecialSymbols() {
        String password = "123456Aaa";
        passwordValidator.validate(password);
    }*/

    @Test
    public void invalidPasswordNoSpecialSymbols() {
        String password = "123456Aaa";
        Assertions.assertThrows(InvalidPasswordCharsException.class, () -> passwordValidator.validate(password));
    }
}
