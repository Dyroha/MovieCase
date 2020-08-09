package dyroha.Movies;

import java.io.IOException;
import java.util.Scanner;

import dyroha.Classes.Library;
import dyroha.Classes.Movie;
import dyroha.Classes.User;
import dyroha.Handlers.MovieFileHandler;
import dyroha.Handlers.MovieSorter;
import dyroha.Handlers.UserMovieRecomender;

public class Main {
	public static void main(String[] args) throws IOException {
		// Creates file handler for the text documents
		MovieFileHandler fileHandler = new MovieFileHandler("src/test");
		
		// creates list of movies from file
		Library library = fileHandler.getProducts();
		
		// instantiates movie sorter to get and sort through the movies
		MovieSorter mSorter = new MovieSorter();
		
		// gets current user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User ID: ");
		String userID = sc.nextLine();
		User currentUser = fileHandler.getUser(userID);
		
		// creates a movie recommender object for that user
		UserMovieRecomender movieRecomender = new UserMovieRecomender(currentUser, library);
		
		if (currentUser.getCurrentViewing() != null) {
			System.out.print("Hi " + currentUser.getUserName() 
				+ "\nYou are currently looking at " + currentUser.getCurrentViewing().toString() + "\n");
			
			Movie[] similarMovies = movieRecomender.getSimilar(currentUser.getCurrentViewing());
			Movie[] randomMovies = movieRecomender.getRandomMovies(similarMovies, 6);
			System.out.println("You may also like:");
			for (Movie m: randomMovies) {
				System.out.println(m.toString());
			}
		}
		
		System.out.println("The highest rated movies currently are: ");
		Library libraryByRating = mSorter.sortByRating(library);
		for (int i = 0; i<3; i++) {
			System.out.println(libraryByRating.getLibrary()[i].toString());
		}
		
		System.out.println("The most bought movies currently are: ");
		Library libraryByMostBought = mSorter.sortByMostBought(library);
		for (int i = 0; i<3; i++) {
			System.out.println(libraryByMostBought.getLibrary()[i].toString());
		}
		
		sc.close();
	}
}
