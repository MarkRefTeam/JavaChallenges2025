package org.example;

import org.example.validator.CommentValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentValidatorTest {

    CommentValidator validator = new CommentValidator();

    @Test
    void validCommentShouldReturnTrue() {
        assertTrue(validator.isValid("Hello, world!"));
    }

    @Test
    void invalidCommentShouldReturnFalse() {
        assertFalse(validator.isValid("<script>alert('XSS')</script>"));
    }

    @Test
    void nullCommentShouldReturnFalse() {
        assertFalse(validator.isValid(null));
    }
}