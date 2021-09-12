import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class emailValidatorTest {

    //Tests to check if email has @ symbol
    @Test
    void emailValidator_HasAtSymbolFalse(){
        assertFalse(emailValidator.hasAtSymbol("johnfish12gmail.com"));
        //should return false, email doesn't have @ symbol
    }

    @Test
    void emailValidator_EmptyString(){
        assertFalse(emailValidator.hasAtSymbol(""));
        //should return false, no email provided
    }

    @Test
    void emailValidator_Null(){
        assertFalse(emailValidator.hasAtSymbol(null));
        //should return false
    }

    @Test
    void emailValidator_HasAtSymbolTrue(){
        assertTrue(emailValidator.hasAtSymbol("josh.dun123@gmail.com"));
        //should return true, email has @ symbol
    }

    //Tests to check for invalid symbols
    @Test
    void emailValidator_HasInvalidSymbolTrue(){
        assertFalse(emailValidator.hasInvalidSymbol("emily£willis@gmail.com"));
        //should return false, £ symbol is invalid
    }

    @Test
    void emailValidator_HasInvalidSymbolFalse(){
        assertTrue(emailValidator.hasInvalidSymbol("johnny-bravo@mail.ru"));
        //should return true, - is valid
    }

    //Tests to check if domain and TLD are valid
    @Test
    void emailValidator_DomainInvalid(){
        assertFalse(emailValidator.domainValidator("john@.com"));
        //should return false, domain invalid
    }

    @Test
    void emailValidator_DomainValid(){
        assertTrue(emailValidator.domainValidator("john@mif.vu.lt"));
        //should return false, domain invalid
    }

    @Test
    void emailValidator_TopLevelDomainInvalid(){
        assertFalse(emailValidator.topLevelDomainValidator("michael@porche.4"));
    }

    @Test
    void emailValidator_TopLevelDomainValid(){
        assertTrue(emailValidator.topLevelDomainValidator("michael@nissan.com"));
    }
}