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

        double start = System.currentTimeMillis();
        for(int i = 0; i < 100; i++) {

            // https://docs.oracle.com/javase/7/docs/api/javax/crypto/spec/PBEKeySpec.html
            final String password = "HelloWorld";

            final SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            final KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
            //final String algorithm = "PBKDF2WithHmacSHA1";
            final String algorithm = "SHA1";
            final SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
            final SecretKey secretKey = factory.generateSecret(spec);

            final byte[] hash = secretKey.getEncoded();

            // we need to save the 'salt' and 'hash' of the password for a user.

        }
        double stop = System.currentTimeMillis();

        System.out.println((stop - start)/1000d);
    }

    @Test
    public void myFirstStream()
    {



    }


}
