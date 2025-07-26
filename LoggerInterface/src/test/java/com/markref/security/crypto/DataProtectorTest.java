package com.markref.security.crypto;

import com.markref.security.security.crypto.DataProtector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DataProtectorTest {

    @Test
    void testEncryptedDecrypt() throws Exception {
        DataProtector protector = new DataProtector();

        String original = "That is a secret message!";
        String encrypted = protector.encrypt(original);
        String decrypted = protector.decrypt(encrypted);

        assertNotEquals(original, encrypted);
        assertEquals(original, decrypted);
    }
}
