package be9.BT10.model;

public class CWUser extends BaseUser {
    public String phone;
    public String email;

    @Override
    public String getUserInfoToFile() {
      return name + "," + loginId + "," + password + "," + phone + "," + email + "," + failedLoginAttempts + System.lineSeparator();
    }
}
