package com.psp.psp13.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @ParameterizedTest
    @ValueSource(strings = {"email@email.com", "xd@mail.com"})
    void isEmailValid_Test(String string){
        User user = new User();
        assertTrue(user.isEmailValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"P@Ssword123", "$tr0ng1P@ssw0rd"})
    void isPasswordValid_Test(String string){
        User user = new User();
        assertTrue(user.isPasswordValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+37062756733", "861122855"})
    void isNumberValid_Test(String string){
        User user = new User();
        assertTrue(user.isPhoneNumberValid(string));
    }

    @Test
    void UserFields_Test(){
        User user = new User( "Vardenis","Pavardenis","861234567","email@email.com","Architektu g. 143","Password@123");
        assertAll(
                () -> assertEquals("Vardenis", user.getName()),
                () -> assertEquals("Pavardenis", user.getSurname()),
                () -> assertEquals("861234567", user.getPhoneNumber()),
                () -> assertEquals("email@email.com", user.getEmail()),
                () -> assertEquals("Architektu g. 143", user.getAddress()),
                () -> assertEquals("Password@123", user.getPassword()));
    }


}