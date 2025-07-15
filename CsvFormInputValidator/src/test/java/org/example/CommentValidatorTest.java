package org.example;

import org.example.validator.CommentValidator;
import org.example.validator.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentValidatorTest {

    Validator<String> validator = new CommentValidator();

    @Test
    void validCommentShouldReturnTrue() {
        assertTrue(validator.validate("Hello, world!"));
    }

    @Test
    void invalidCommentShouldReturnFalse() {
        assertFalse(validator.validate("<script>alert('XSS')</script>"));
    }

    @Test
    void nullCommentShouldReturnFalse() {
        assertFalse(validator.validate(null));
    }
}