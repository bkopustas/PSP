import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class passwordCheckerTest {

    // Tests for checking password length
    @Test
    void passwordChecker_LengthTooShort(){
        assertFalse(passwordChecker.hasLengthRequirement("asd123", 8));
        //should return false, password is too short
    }

    @Test
    void passwordChecker_LengthCorrect(){
        assertTrue(passwordChecker.hasLengthRequirement("password123", 8));
        //should return true, password is longer or equal to required length
    }

    @Test
    void passwordChecker_LengthEmptyString(){
        assertFalse(passwordChecker.hasLengthRequirement("", 8));
        //should return false, no string provided
    }

    @Test
    void passwordChecker_Null(){
        assertFalse(passwordChecker.hasLengthRequirement(null, 8));
        //should return false, null
    }

    //Tests for checking if password has uppercase letter
    @Test
    void passwordChecker_UppercaseLetterNotFound(){
        assertFalse(passwordChecker.hasUppercaseLetter("password"));
        //should return false, Uppercase letter not found
    }

    @Test
    void passwordChecker_UppercaseLetterCorrect(){
        assertTrue(passwordChecker.hasUppercaseLetter("PassWord123"));
        //should return true, password contains at least 1 uppercase letter
    }

    //Tests for checking if password has special character
    @Test
    void passwordChecker_SpecialCharacterNotFound(){
        assertFalse(passwordChecker.hasSpecialCharacter("password"));
        //should return false, no Special character found
    }

    @Test
    void passwordChecker_SpecialCharacterFalse() {
        assertFalse(passwordChecker.hasSpecialCharacter("pass|word123"));
        //should return false, special character is invalid
    }

    @Test
    void passwordChecker_SpecialCharacterCorrect(){
        assertTrue(passwordChecker.hasSpecialCharacter("pass.word123"));
        //should return true, special character is valid
    }

}