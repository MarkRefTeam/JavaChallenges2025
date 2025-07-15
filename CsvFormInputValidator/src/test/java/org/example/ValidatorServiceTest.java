package org.example;

import org.junit.jupiter.api.Test;

import static org.example.validator.ValidatorService.isValid;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorServiceTest {

    @Test
    void allValidInputsShouldReturnTrue() {
        assertTrue(isValid("john_doe", "john@example.com", "Nice comment!"));
    }

    @Test
    void oneInvalidInputShouldReturnFalse() {
        assertFalse(isValid("john@", "invalid", "<script>"));
    }
}
