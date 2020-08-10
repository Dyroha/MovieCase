package dyroha.Movies;

import java.util.Scanner;

import dyroha.Classes.Library;
import dyroha.Classes.Movie;
import dyroha.Classes.User;
import dyroha.Handlers.MovieFileHandler;
import dyroha.Handlers.LibrarySorter;
import dyroha.Handlers.UserMovieRecomender;

public class Main {
	public static void main(String[] args) throws Exception {
		// Creates file handler for the text documents
		MovieFileHandler fileHandler = new MovieFileHandler("src/test");
		
		// creates list of movies from file
		Library library = fileHandler.getProducts();
		
		// instantiates movie sorter to get and sort through the movies
		LibrarySorter mSorter = new LibrarySorter();
		
		// while there is no user that is in session selected
		boolean noUser = true;
		while(noUser) {
			
			// creates a scanner to read the console input
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter User ID: ");
			
			// gets current user from user input id
			String userID = sc.nextLine();
			User currentUser = fileHandler.getUser(userID);
			
			// creates a movie recommender object for that user
			UserMovieRecomender movieRecomender = new UserMovieRecomender(currentUser, library);

			if (currentUser.getCurrentViewing() != null) {
				
				// prints a welcome message to console
				System.out.print("Hi " + currentUser.getUserName() 
					+ ",\nYou are currently looking at " + currentUser.getCurrentViewing() + "\n");
				
				// gets a list of similar movies to the current viewed movie
				Movie[] similarMovies = movieRecomender.getSimilar(currentUser.getCurrentViewing());
				// gets a few of them from at random
				Movie[] randomMovies = movieRecomender.getRandomMovies(similarMovies, 6);
				
				// prints out the random similar movies
				System.out.println("You may also like:");
				for (Movie m: randomMovies) {
					System.out.println(m);
				}
				
				// gets and prints out the 3 highest rated movies
				System.out.println("The highest rated movies currently are: ");
				Library libraryByRating = mSorter.sortByRating(library);
				for (int i = 0; i<3; i++) {
					System.out.println(libraryByRating.getLibrary()[i]);
				}
				
				// gets and prints the 3 most bought movies
				System.out.println("The most bought movies currently are: ");
				Library libraryByMostBought = mSorter.sortByMostBought(library);
				for (int i = 0; i<3; i++) {
					System.out.println(libraryByMostBought.getLibrary()[i]);
				}
				
				sc.close();
				
				// ends the loop
				noUser = false;
			} else {
				// if the user isn't found in current users it will print an error and restart the loop
				System.out.println("User not in session or unrecognised\nPick another user");
			}
		
		}
	}
}
