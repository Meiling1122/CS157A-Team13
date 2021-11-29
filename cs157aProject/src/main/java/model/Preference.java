package model;

public class Preference {

	enum OnlineChoice{
		YES, NO, BOTH
	}
	
	private int profileID;
	private String location;
	private OnlineChoice onlineOpt;
	
	public int getProfileID() {
		return profileID;
	}
	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public OnlineChoice getOnlineOpt() {
		return onlineOpt;
	}
	public void setOnlineOpt(OnlineChoice onlineOpt) {
		this.onlineOpt = onlineOpt;
	}
	
}