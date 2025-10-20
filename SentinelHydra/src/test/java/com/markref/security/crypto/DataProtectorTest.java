package com.markref.security.crypto;

import com.markref.security.security.crypto.DataProtector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DataProtectorTest {

    @Test
    void encryptThenDecryptRoundTrip() throws Exception {
        DataProtector protector = new DataProtector();

        String original = "That is a secret message!";
        String token = protector.encrypt(original, null);

        assertNotEquals(original, token);

        String back = protector.decrypt(token, null);
        assertEquals(original, back);
    }

    @Test
    void exportImportKeyWorks() throws Exception {
        DataProtector a = new DataProtector();
        String keyB64 = a.exportKeyBase64();

        DataProtector b = new DataProtector(keyB64);

        String msg = "Hydra-256";
        String t = a.encrypt(msg, null);

        assertEquals(msg, b.decrypt(t, null));
    }
}