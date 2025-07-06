package org.pwmanager.goldpass;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileStorage {
    private static String PASSWORDS_FILE = "passwords.dat";

    @SuppressWarnings("unchecked")
    public Map<String, String> loadPasswords() throws Exception {
        File file = new File(PASSWORDS_FILE);
        if (!file.exists()) return new HashMap<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                return (Map<String, String>) obj;
            }
            return new HashMap<>();
        }
    }

    public void savePasswords(Map<String, String> passwords) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PASSWORDS_FILE))) {
            oos.writeObject(passwords);
        }
    }

    public void setPasswordsFile(String path) {
        PASSWORDS_FILE = path;
    }
}