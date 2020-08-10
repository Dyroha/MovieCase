package dyroha.Classes;

/** Represents a Movie
 * 
 * @author Dylan Hamilton
 * @version 1.1
 *
 */
public class Movie {
	private String id , name, year, rating, price;
	private String[] genre = new String[5];
	private int numberOfPurchases;
	
	/** Creates a Movie
	 * 
	 * @param id movie ID
	 * @param name movie name
	 * @param year movie's year of release
	 * @param genre String array of movie's genres
	 * @param rating movie rating
	 * @param price movie price
	 */
	public Movie(String id, String name, String year, String[] genre, String rating, String price) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.rating = rating;
		this.price = price;
	}
	
	/** Gets movie's ID
	 * 
	 * @return The ID
	 */
	public String getId() { 
		return id; 
	}

	/** Gets movie's name
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}
	
	/** Gets movie's year of release
	 * 
	 * @return The year
	 */
	public String getYear() {
		return year;
	}

	/** Gets movie's genres
	 * 
	 * @return The String array of movie's genres
	 */
	public String[] getGenre() {
		return genre;
	}

	/** Gets movie's rating
	 * 
	 * @return The rating
	 */
	public String getRating() {
		return rating;
	}

	/** Gets movie's price
	 * 
	 * @return The price
	 */
	public String getPrice() {
		return price;
	}

	/** Gets movie's number of purchases
	 * 
	 * @return The number of purchases
	 */
	public int getNumberOfPurchases() {
		return numberOfPurchases;
	}

	/** Sets the numberOfPurchases
	 * 
	 * @param numberOfPurchases The number of purchases
	 */
	public void setNumberOfPurchases(int numberOfPurchases) {
		this.numberOfPurchases = numberOfPurchases;
	}
	
	public String toString() {
		return name + " - " + rating + "/5 stars";
	}

}
