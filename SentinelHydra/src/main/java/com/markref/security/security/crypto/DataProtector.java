package com.markref.security.security.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Objects;

public class DataProtector {

    private static final String CIPHER = "AES/GCM/NoPadding";
    private static final int KEY_BITS = 256;
    private static final int GCM_TAG_BITS = 128;
    private static final int GCM_IV_BYTES = 12;
    private static final SecureRandom RNG = new SecureRandom();

    private final SecretKey key;

    public DataProtector() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(KEY_BITS);
        this.key = keyGen.generateKey();
    }

    public DataProtector(String base64Key) {
        Objects.requireNonNull(base64Key, "base64Key is null");
        byte[] raw = Base64.getDecoder().decode(base64Key);
        this.key = new javax.crypto.spec.SecretKeySpec(raw, "AES");
    }

    public String exportKeyBase64() {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static DataProtector generate() throws Exception {
        return new DataProtector();
    }

    public static DataProtector fromBase64Key(String b64) {
        return new DataProtector(b64);
    }

    public String encrypt(String plaintext) throws Exception {
        return encrypt(plaintext, null);
    }

    public String decrypt(String token) throws Exception {
        return decrypt(token, null);
    }

    public String encrypt(String plaintext, byte[] aad) throws Exception {
        Objects.requireNonNull(plaintext, "plaintext is null");

        byte[] iv = new byte[GCM_IV_BYTES];
        RNG.nextBytes(iv);

        Cipher cipher = Cipher.getInstance(CIPHER);
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_BITS, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);

        if (aad != null) cipher.updateAAD(aad);

        byte[] ciphertext = cipher.doFinal(plaintext.getBytes(java.nio.charset.StandardCharsets.UTF_8));

        byte[] out = new byte[iv.length + ciphertext.length];
        System.arraycopy(iv, 0, out, 0, iv.length);
        System.arraycopy(ciphertext, 0, out, iv.length, ciphertext.length);

        return Base64.getEncoder().encodeToString(out);
    }

    public String decrypt(String token, byte[] aad) throws Exception {
        Objects.requireNonNull(token, "token is null");

        byte[] all = Base64.getDecoder().decode(token);
        if (all.length < GCM_IV_BYTES + 16) {
            throw new IllegalArgumentException("Invalid token length");
        }

        byte[] iv = new byte[GCM_IV_BYTES];
        byte[] ciphertext = new byte[all.length - GCM_IV_BYTES];
        System.arraycopy(all, 0, iv, 0, GCM_IV_BYTES);
        System.arraycopy(all, GCM_IV_BYTES, ciphertext, 0, ciphertext.length);

        Cipher cipher = Cipher.getInstance(CIPHER);
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_BITS, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, spec);

        if (aad != null) cipher.updateAAD(aad);

        byte[] plain = cipher.doFinal(ciphertext);
        return new String(plain, java.nio.charset.StandardCharsets.UTF_8);
    }
}
