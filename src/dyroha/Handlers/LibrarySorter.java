package dyroha.Handlers;

import java.util.Arrays;
import java.util.Comparator;

import dyroha.Classes.Library;
import dyroha.Classes.Movie;

/** Sorts the {@link dyroha.Classes.Library Library} class' {@link dyroha.Class.Movie Movie} objects
 * 
 * @author Dylan Hamilton
 * @version 1.1
 */
public class LibrarySorter {
	
	/** Sorts the {@link dyroha.Classes.Library Library} by their ratings from highest to lowest
	 * 
	 * @param lib Represents a {@link dyroha.Classes.Library Library}
	 * @return sorted {@link dyroha.Classes.Library Library}
	 */
	public Library sortByRating(Library lib) {
		Arrays.sort(lib.getLibrary(), new Comparator<Movie>(){
			public int compare(Movie o1, Movie o2) {
				if (Integer.toString(o2.getNumberOfPurchases()).compareTo(Integer.toString(o1.getNumberOfPurchases())) == 0) {
					return o1.getName().compareTo(o2.getName()); 
				} else {
					return o2.getRating().compareTo(o1.getRating());
				}
			}
		});
		return lib;
	}
	
	/** Sorts the {@link dyroha.Classes.Library Library} by their "popularity" from most bought to least
	 * 
	 * @param lib Represents a {@link dyroha.Classes.Library Library}
	 * @return sorted {@link dyroha.Classes.Library Library}
	 */
	public Library sortByMostBought(Library lib) {
		Arrays.sort(lib.getLibrary(), new Comparator<Movie>(){
			public int compare(Movie o1, Movie o2) {
				if (Integer.toString(o2.getNumberOfPurchases()).compareTo(Integer.toString(o1.getNumberOfPurchases())) == 0) {
					return o1.getName().compareTo(o2.getName()); 
				} else {
					return Integer.toString(o2.getNumberOfPurchases()).compareTo(Integer.toString(o1.getNumberOfPurchases()));
				}
			}
		});
		return lib;
	}
	
}
