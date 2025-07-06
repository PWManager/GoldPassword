package org.pwmanager.goldpass;

import java.util.Map;

public class PasswordManager {
    private CryptoEngine cryptoEngine;
    private FileStorage fileStorage;
    private Map<String, String> passwords;

    public PasswordManager() {
        this.cryptoEngine = new CryptoEngine();
        this.fileStorage = new FileStorage();
    }

    public void initialize() throws Exception {
        cryptoEngine.loadOrGenerateKey();
        passwords = fileStorage.loadPasswords();
    }

    public boolean savePassword(String sitename, String password) {
        String site = sitename.trim();
        if (site.isEmpty() || password.isEmpty()) return false;

        try {
            String encrypted = cryptoEngine.encrypt(password);
            passwords.put(site, encrypted);
            fileStorage.savePasswords(passwords);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String generatePassword(int length) {
        return cryptoEngine.generatePassword(length);
    }

    public boolean deletePassword(String sitename) {
        String site = sitename.trim();
        if (!passwords.containsKey(site)) return false;

        passwords.remove(site);
        try {
            fileStorage.savePasswords(passwords);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String viewPasswords() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : passwords.entrySet()) {
            try {
                String decrypted = cryptoEngine.decrypt(entry.getValue());
                sb.append(entry.getKey()).append(" : ").append(decrypted).append("\n");
            } catch (Exception e) {
                e.printStackTrace();
                sb.append(entry.getKey()).append(" : [DECRYPTION ERROR]\n");
            }
        }
        return sb.toString();
    }

    public void setPasswordsFile(String path) {
        fileStorage.setPasswordsFile(path);
    }

    public void setKeyFile(String path) {
        cryptoEngine.setKeyFile(path);
    }
}