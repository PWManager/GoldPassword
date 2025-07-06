package org.pwmanager.goldpass;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.SecureRandom;
import java.util.Base64;

public class CryptoEngine {
    private static String KEY_FILE = "crypt.key";
    private SecretKey secretKey;
    private SecureRandom secureRandom = new SecureRandom();

    public void loadOrGenerateKey() throws Exception {
        File keyFile = new File(KEY_FILE);
        if (keyFile.exists()) {
            try (FileInputStream fis = new FileInputStream(keyFile)) {
                byte[] keyBytes = new byte[(int) keyFile.length()];
                fis.read(keyBytes);
                secretKey = new SecretKeySpec(keyBytes, "AES");
            }
        } else {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256, secureRandom);
            secretKey = keyGen.generateKey();
            try (FileOutputStream fos = new FileOutputStream(KEY_FILE)) {
                fos.write(secretKey.getEncoded());
            }
        }
    }

    public String encrypt(String str) throws Exception {
        if (secretKey == null) throw new IllegalStateException("Secret key not initialized");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
    }

    public String decrypt(String str) throws Exception {
        if (secretKey == null) throw new IllegalStateException("Secret key not initialized");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(str)), "UTF-8");
    }

    public String generatePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(secureRandom.nextInt(chars.length())));
        }
        return password.toString();
    }

    public void setKeyFile(String path) {
        KEY_FILE = path;
    }
}