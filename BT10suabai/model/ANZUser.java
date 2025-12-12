package be9.BT10suabai.model;

public class ANZUser extends BaseUser {
    public ANZUser() {}

    public ANZUser(String line) {
        String[] userInfo = line.split(",");
        this.name = userInfo[0];
        this.loginId = userInfo[1];
        this.password = userInfo[2];
        this.failedLoginAttempts = Integer.parseInt(userInfo[3]);
    }
    
    @Override
    public String getUserInfoToFile() {
        return name + "," + loginId + "," + password + "," + failedLoginAttempts + System.lineSeparator();
    }

    @Override
    public String toString() {
        return name + "," + loginId + "," + password;
    }
}
