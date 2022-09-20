package org.example.libtests;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

public class EncryptionAndHashingTest {

    @Test
    public void pbkdf2Hashing() throws Exception
    {

        final String password = "HelloWorld";

        final SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        final KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        final SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        final SecretKey secretKey = factory.generateSecret(spec);

        final byte[] hash = secretKey.getEncoded();

    }
}
