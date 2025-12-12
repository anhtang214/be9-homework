package be9.BT10suabai.model;

public class CWUser extends BaseUser {
    public String phone;
    public String email;

    public CWUser() {}

    public CWUser(String line) {
        String[] userInfo = line.split(",");
        this.name = userInfo[0];
        this.loginId = userInfo[1];
        this.password = userInfo[2];
        this.phone = userInfo[3];
        this.email = userInfo[4];
        this.failedLoginAttempts = Integer.parseInt(userInfo[5]);
    }

    @Override
    public String getUserInfoToFile() {
      return name + "," + loginId + "," + password + "," + phone + "," + email + "," + failedLoginAttempts + System.lineSeparator();
    }

    @Override
    public String toString() {
        return name + "," + loginId + "," + password + "," + phone;
    }
}
