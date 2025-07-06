package org.pwmanager.goldpass;

public class GoldPassword {
    private PasswordManager passwordManager;

    public GoldPassword() {
        this.passwordManager = new PasswordManager();
    }

    public void initialize() throws Exception {
        passwordManager.initialize();
    }

    public boolean savePassword(String sitename, String password) {
        return passwordManager.savePassword(sitename, password);
    }

    public String generatePassword(int length) {
        return passwordManager.generatePassword(length);
    }

    public boolean deletePassword(String sitename) {
        return passwordManager.deletePassword(sitename);
    }

    public String viewPasswords() {
        return passwordManager.viewPasswords();
    }

    public void setPasswordsFile(String path) {
        passwordManager.setPasswordsFile(path);
    }

    public void setKeyFile(String path) {
        passwordManager.setKeyFile(path);
    }
}