package be9.BT10.model;

public class ANZUser extends BaseUser {
    @Override
    public String getUserInfoToFile() {
        return name + "," + loginId + "," + password + "," + failedLoginAttempts + System.lineSeparator();
    }
}
