package be9.BT9suabai.model;

public class CWUser extends BaseUser {
    public String phone;
    public String email;

    @Override
    public String getUserInfoToFile() {
		return super.getUserInfoToFile() + "," + phone + "," + email;
	}
}
