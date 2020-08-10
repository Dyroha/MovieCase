package dyroha.Classes;

public class User {
	private String userID, userName;
	private String[] viewed, purchaced;
	private Movie currentViewing;
	
	public User(String userID,String userName, String[] viewed, String[] purchaced) {
		this.userID = userID;
		this.userName = userName;
		this.viewed = viewed;
		this.purchaced = purchaced;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String[] getViewed() {
		return viewed;
	}
	
	public String[] getPurchaced() {
		return purchaced;
	}
	
	public Movie getCurrentViewing() {
		return currentViewing;
	}

	public void setCurrentViewing(Movie currentViewing) {
		this.currentViewing = currentViewing;
	}
	
	public String toString() {
		return "User ID: " + userID + "\nUser Name: " + userName + "\n";
	}
	
}
