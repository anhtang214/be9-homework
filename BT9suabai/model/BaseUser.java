package be9.BT9suabai.model;

public class BaseUser {
    public String name;
    public String loginId;  // username
    public String password;

    public String getUserInfoToFile() {
        return System.lineSeparator() + name + "," + loginId + "," + password;
    }
}
