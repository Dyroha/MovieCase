package dyroha.Handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dyroha.Classes.Library;
import dyroha.Classes.Movie;
import dyroha.Classes.User;

public class UserMovieRecomender {
	private Movie[] watchedMovies, unwatchedMovies;
	private Movie currentViewing;
	
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
	
	public Movie[] getWatchedMovies() {
		return watchedMovies;
	}

	public Movie[] getUnwatchedMovies() {
		return unwatchedMovies;
	}

	public Movie getCurrentViewing() {
		return currentViewing;
	}

	public Movie[] getRandomMovies(Movie[] similarMovies, int number) {
		if (number > similarMovies.length) { number = similarMovies.length; }
		Movie[] randomMovies = new Movie[number];
		Movie randomMovie = null;
		int count = 0;
		while (count < number) {
			int randomInt = (int)(similarMovies.length * Math.random());
			randomMovie = similarMovies[randomInt];
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
