package be9.BT10.model;

public abstract class BaseUser {
    public String name;
    public String loginId;  // username
    public String password;
    public int failedLoginAttempts;

    public abstract String getUserInfoToFile();
}
