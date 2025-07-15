package org.example;

import org.example.validator.EmailValidator;
import org.example.validator.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {

    Validator<String> validator = new EmailValidator();

    @Test
    void validEmailShouldReturnTrue() {
        assertTrue(validator.validate("something@email.com"));
    }

    @Test
    void nullEmailShouldReturnFalse() {
        assertFalse(validator.validate(null));
    }

    @Test
    void emailWithoutAtShouldReturnFalse() {
        assertFalse(validator.validate("something.com"));
    }
}
