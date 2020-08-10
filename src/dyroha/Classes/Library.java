package dyroha.Classes;

import java.util.Arrays;

/** A class to store a library of {@link dyroha.Classes.Movie Movies}
 * 
 * @author Dylan Hamilton
 * @version 1.0
 */
public class Library {
	
	/** Represents an array of {@link dyroha.Classes.Movie Movies}
	 */
	private Movie[] library;
	
	/** Creates Library object
	 * 
	 * @param lib Represents an array of {@link dyroha.Classes.Movie Movies}
	 */
	public Library(Movie[] lib) {
		library = lib;
	}
	
	/** Gets the contents of the Library
	 * 
	 * @return library The array of {@link dyroha.Classes.Movie Movies} that is in the Library
	 */
	public Movie[] getLibrary() {
		return library;
	}
	
	/** Searches the Library for a movie by it's id
	 * 
	 * @param id The id of the Movie
	 * @return {@link dyroha.Classes.Movie Movies} searched for
	 */
	public Movie getMovie(String id) {
		boolean success = false;
		Movie movie = null;
		for (Movie m: library) {
			if (m.getId().equals(id)) { movie = m; success = true; }
		}
		if (success) {return movie; }
		else {throw new IllegalArgumentException("Error: Invalid ID"); }
	}
	
	public String toString() {
		return Arrays.toString(library);
	}
}
