package org.example;

import org.example.validator.EmailValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {

    EmailValidator validator = new EmailValidator();

    @Test
    void validEmailShouldReturnTrue() {
        assertTrue(validator.isValid("something@email.com"));
    }

    @Test
    void nullEmailShouldReturnFalse() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void emailWithoutAtShouldReturnFalse() {
        assertFalse(validator.isValid("something.com"));
    }
}
