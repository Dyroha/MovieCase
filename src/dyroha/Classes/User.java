package dyroha.Classes;

/** Represents a user
 * 
 * @author Dylan Hamilton
 * @version 1.1
 *
 */
public class User {
	private String userID, userName;
	private String[] viewed, purchaced;
	/** Represents the Movie a user is currently looking at
	 */
	private Movie currentViewing;
	
	/** Creates a user
	 * 
	 * @param userID The user's ID
	 * @param userName The user's name
	 * @param viewed A String array of movie IDs they have looked at
	 * @param purchaced A String array of movie IDs they have purchased
	 */
	public User(String userID,String userName, String[] viewed, String[] purchaced) {
		this.userID = userID;
		this.userName = userName;
		this.viewed = viewed;
		this.purchaced = purchaced;
	}
	
	/** Gets user's ID
	 * 
	 * @return userID A string representing the user's ID
	 */
	public String getUserID() {
		return userID;
	}
	
	/** Gets user's name
	 * 
	 * @return userName A string representing the user's name
	 */
	public String getUserName() {
		return userName;
	}
	
	/** Gets an array of the user's viewed movie IDs
	 * 
	 * @return viewed A String array representing the user's viewed movie IDs
	 */
	public String[] getViewed() {
		return viewed;
	}
	
	/** Gets an array of the user's purchased movie IDs
	 * 
	 * @return viewed A String array representing the user's purchased movie IDs
	 */
	public String[] getPurchaced() {
		return purchaced;
	}
	
	/** Gets the movie the user is currently looking at
	 * 
	 * @return The {@link dyroha.Classes.Movie Movie} which the user is currently looking at
	 */
	public Movie getCurrentViewing() {
		return currentViewing;
	}
	
	/** Sets the user's current missing movie
	 * 
	 * @param currentViewing The {@link dyroha.Classes.Movie Movie} the user is currently looking at
	 */
	public void setCurrentViewing(Movie currentViewing) {
		this.currentViewing = currentViewing;
	}
	
	public String toString() {
		return "User ID: " + userID + "\nUser Name: " + userName + "\n";
	}
	
}
