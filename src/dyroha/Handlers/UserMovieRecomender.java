package dyroha.Handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dyroha.Classes.Library;
import dyroha.Classes.Movie;
import dyroha.Classes.User;

/** A class that recommends a user movies
 * 
 * @author Dylan Hamilton
 * @version 1.0
 */
public class UserMovieRecomender {
	private Movie[] watchedMovies, unwatchedMovies;
	private Movie currentViewing;
	
	/** Creates a UserMovieRecomender
	 * 
	 * @param user Represents a {@link dyroha.Classes.User User} Object
	 * @param lib Represents a {@link dyroha.Classes.Library Library} Object
	 */
	public UserMovieRecomender(User user, Library lib) {
		currentViewing = user.getCurrentViewing();
		// creates Movie array of purchased movies from the user's viewed parameter
		List<Movie> seenMovies = new ArrayList<>();
		for(String movieID: user.getPurchaced()) {
			Movie movie = lib.getMovie(movieID);
			seenMovies.add(movie);
		}
		this.watchedMovies = seenMovies.toArray(new Movie[seenMovies.size()]);
		
		// creates Movie array of all of the movies the user has not purchased
		List<Movie> unseenMovies = new ArrayList<>(Arrays.asList(lib.getLibrary()));
		for (Movie m : this.watchedMovies) {
			for (int i = 0; i < unseenMovies.size(); i++) {
				if (m.equals(unseenMovies.get(i))) {
					unseenMovies.remove(i);
					break;
				}
			}
		}
		this.unwatchedMovies = unseenMovies.toArray(new Movie[unseenMovies.size()]);
	}
	
	/** Gets user's watched movies
	 * 
	 * @return watchedMovies An array of {@link dyroha.Classes.Movie Movies}
	 */
	public Movie[] getWatchedMovies() {
		return watchedMovies;
	}

	/** Gets user's unwatched movies
	 * 
	 * @return unwatchedMovies An array of {@link dyroha.Classes.Movie Movies}
	 */
	public Movie[] getUnwatchedMovies() {
		return unwatchedMovies;
	}

	/** Get's the {@link dyroha.Classes.Movie Movie} the user is currently looking at
	 * 
	 * @return currentViewing {@link dyroha.Classes.Movie Movie}
	 */
	public Movie getCurrentViewing() {
		return currentViewing;
	}

	/** Gets an array of a certain size of random {@link dyroha.Classes.Movie Movies}. 
	 * If the number supplied is greater than the length of array supplied it will return all of the movies supplied.
	 * 
	 * @param movies An array of {@link dyroha.Classes.Movie Movies}
	 * @param number An Integer representing the number of movies to return
	 * @return An array of {@link dyroha.Classes.Movie Movies}
	 */
	public Movie[] getRandomMovies(Movie[] movies, int number) {
		if (number > movies.length) { return movies; }
		Movie[] randomMovies = new Movie[number];
		Movie randomMovie = null;
		int count = 0;
		while (count < number) {
			int randomInt = (int)(movies.length * Math.random());
			randomMovie = movies[randomInt];
			boolean canAdd = true;
			for (int i = 0; i < randomMovies.length; i++) {
				if(randomMovie.equals(randomMovies[i])) {
					canAdd = false;
					break;
				}
			}
			if(canAdd && !randomMovie.getId().equals(this.currentViewing.getId())) {
				randomMovies[count] = randomMovie; 
				count++;
			}
		}
		return randomMovies;
	}
	
	/** Gets an array of {@link dyroha.Classes.Movie Movies} that both have not been watched and have at least one of the same genre tags.
	 * 
	 * @param movie Represents a {@link dyroha.Classes.Movie Movie}
	 * @return An array of {@link dyroha.Classes.Movie Movies}
	 */
	public Movie[] getSimilar(Movie movie) {
		List<Movie> similarMoviesList = new ArrayList<>();
		for (String genre : movie.getGenre()) {
			for (Movie cMovie : unwatchedMovies) {
				for (String g: cMovie.getGenre()) {
					if (genre.equals(g)) {
						similarMoviesList.add(cMovie);
						break;
					}
				}
			}
		}
		Movie[] returnMovies = new Movie[similarMoviesList.size()];
		return similarMoviesList.toArray(returnMovies);
	}
}
