package be9.BT10suabai.model;

public class BaseUser {
    public String name;
    public String loginId;  // username
    public String password;
    public int failedLoginAttempts;

    public BaseUser() {}

    public BaseUser(String username, String password) {
        this.loginId = username;
        this.password = password;
    }

    public String getUserInfoToFile() {
        return name + "," + loginId + "," + password + System.lineSeparator();
    }
}
