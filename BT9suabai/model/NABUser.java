package be9.BT9suabai.model;

public class NABUser extends BaseUser {
    public String phone;

    @Override
    public String getUserInfoToFile() {
		return super.getUserInfoToFile() + "," + phone;
	}
}
