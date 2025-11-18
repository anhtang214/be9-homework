package be9.BT10.model;

public class NABUser extends BaseUser {
    public String phone;

    @Override
    public String getUserInfoToFile() {
      return name + "," + loginId + "," + password + "," + phone + "," + failedLoginAttempts + System.lineSeparator();
    }
}
