package be9.BT10suabai.model;

public class NABUser extends BaseUser {
    public String phone;

    public NABUser() {}

    public NABUser(String line) {
        String[] userInfo = line.split(",");
        this.name = userInfo[0];
        this.loginId = userInfo[1];
        this.password = userInfo[2];
        this.phone = userInfo[3];
        this.failedLoginAttempts = Integer.parseInt(userInfo[4]);
    }

    @Override
    public String getUserInfoToFile() {
      return name + "," + loginId + "," + password + "," + phone + "," + failedLoginAttempts + System.lineSeparator();
    }

    @Override
    public String toString() {
        return name + "," + loginId + "," + password + "," + phone;
    }
}
