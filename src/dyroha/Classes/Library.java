package dyroha.Classes;

public class Library {
	private Movie[] library;
	
	public Library(Movie[] lib) {
		library = lib;
	}
	
	public Movie[] getLibrary() {
		return library;
	}
	
	public Movie getMovie(String id) {
		boolean success = false;
		Movie movie = null;
		for (Movie m: library) {
			if (m.getId().equals(id)) { movie = m; success = true; }
		}
		if (success) {return movie; }
		else {throw new IllegalArgumentException("Error: Invalid ID"); }
	}
}
