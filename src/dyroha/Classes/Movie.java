package dyroha.Classes;

public class Movie {
	private String id , name, year, rating, price;
	private String[] genre = new String[5];
	private int numberOfPurchaces;
	
	public Movie(String id, String name, String year, String[] genre, String rating, String price) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.rating = rating;
		this.price = price;
	}
	
	public String getId() { 
		return this.id; 
	}

	public String getName() {
		return this.name;
	}
	
	public String getYear() {
		return this.year;
	}


	public String[] getGenre() {
		return this.genre;
	}


	public String getRating() {
		return this.rating;
	}


	public String getPrice() {
		return this.price;
	}

	public int getNumberOfPurchaces() {
		return this.numberOfPurchaces;
	}

	public void setNumberOfPurchaces(int numberOfPurchaces) {
		this.numberOfPurchaces = numberOfPurchaces;
	}
	
	public String toString() {
		return name + " Rated: " + rating;
	}

}
