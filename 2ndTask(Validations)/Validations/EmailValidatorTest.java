package Validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Exceptions.EmailMissingEtaSignException;
import Exceptions.InvalidEmailCharsException;
import Exceptions.InvalidEmailDomainException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EmailValidatorTest {

    private static final EmailValidator emailValidator = new EmailValidator();



    @Test
    public void validEmail() {
        String email = "d@d.com";
        assertDoesNotThrow(() -> emailValidator.validate(email));
    }

    /*@Test(expected = EmailMissingEtaSignException.class)
    public void invalidEmailNoEta() {
        String email = "dd.com";
        emailValidator.validate(email);
    }*/

    @Test
    public void invalidEmailNoEta() {
        String email = "dd.com";
        Assertions.assertThrows(EmailMissingEtaSignException.class, () -> emailValidator.validate(email));
    }

    /*@Test(expected = InvalidEmailCharsException.class)
    public void invalidEmailSpecialChars() {
        String email = "[]@[].com";
        emailValidator.validate(email);
    }*/

    @Test
    public void invalidEmailSpecialChars() {
        String email = "[]@[].com";
        Assertions.assertThrows(InvalidEmailCharsException.class, () -> emailValidator.validate(email));
    }

    /*@Test(expected = InvalidEmailDomainException.class)
    public void invalidEmailDomain() {
        String email = "dd@dd.1a-";
        emailValidator.validate(email);
    }*/

    @Test
    public void invalidEmailTLDomain() {
        String email = "dd@dd.1a-";
        Assertions.assertThrows(InvalidEmailDomainException.class, () -> emailValidator.validate(email));
    }
//additional tests
    @Test
    public void invalidEmailDomain() {
        String email = "dd@d%d.com";
        Assertions.assertThrows(InvalidEmailCharsException.class, () -> emailValidator.validate(email));
    }
}
