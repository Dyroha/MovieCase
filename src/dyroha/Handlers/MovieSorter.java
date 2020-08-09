package dyroha.Handlers;

import java.util.Arrays;
import java.util.Comparator;

import dyroha.Classes.Library;
import dyroha.Classes.Movie;

public class MovieSorter {

	public Library sortByRating(Library lib) {
		Arrays.sort(lib.getLibrary(), new Comparator<Movie>(){
			public int compare(Movie o1, Movie o2) {
				return o2.getRating().compareTo(o1.getRating());
			}
		});
		return lib;
	}
	
	public Library sortByMostBought(Library lib) {
		Arrays.sort(lib.getLibrary(), new Comparator<Movie>(){
			public int compare(Movie o1, Movie o2) {
				if (Integer.toString(o2.getNumberOfPurchaces()).compareTo(Integer.toString(o1.getNumberOfPurchaces())) == 0) {
					return o1.getName().compareTo(o2.getName()); 
				} else {
					return Integer.toString(o2.getNumberOfPurchaces()).compareTo(Integer.toString(o1.getNumberOfPurchaces()));
				}
			}
		});
		return lib;
	}
	
}
