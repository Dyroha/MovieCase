package dyroha.Classes;

public class Movie {
	private String id , name, year, rating, price;
	private String[] genre = new String[5];
	private int numberOfPurchaces;
	

	public Movie(String[] info) {
		this.id = info[0];
		this.name = info[1];
		this.year = info[2];
		for (int i = 0; i <= 4; i++) {
			genre[i] = info[i+3];
		}
		this.rating = info[8];
		this.price = info[9];
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
