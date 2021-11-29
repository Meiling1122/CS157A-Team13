package model;

public class StudentAccount {

	private int accountID;
	private String studentName;
	private int campusID;
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getCampusID() {
		return campusID;
	}
	public void setCampusID(int campusID) {
		this.campusID = campusID;
	}
}