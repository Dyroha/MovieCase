package dyroha.Handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import dyroha.Classes.*;
/** This class reads the files and creates the User array, Library object and gets the currently viewed movie for a user
 * 
 * @author Dylan Hamilton
 *
 */
public class MovieFileHandler {
	private File users, products, currentUserSession;
	private Library library;

	/** Creates the File users, products, and currentUserSession if they exist in the directory.
	 * 
	 * @param fileDirectory The directory the files are stored in
	 */
	public MovieFileHandler(String fileDirectory) {
		File folder = new File(fileDirectory);
		for (File file: folder.listFiles()) {
			switch (file.getName()) {
				case "Users.txt":
					this.users = file;
					break;
				case "Products.txt":
					this.products = file;
					break;
				case "CurrentUserSession.txt":
					this.currentUserSession = file;
					break;
				default:
					break;
			}
		}
	}
	
	/** Gets the users from the file and creates a list of them
	 * 
	 * @return A list of the users
	 * @throws IOException if the file couldn't be found
	 */
	public User getUser(String id) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(users));
		User user = null;
		String st;
		String[] parts;
		while ((st = br.readLine()) != null && !st.isEmpty()) {
			parts = st.split(", ");
			if (parts[0].equals(id)) {
				user = new User(parts[0],parts[1], parts[2].split(";"), parts[3].split(";"));
				break;
			}
		}
		br.close();
		getCurrentViewing(user);
		return user;
	}
	
	/** Gets the products from the file and creates a list of them and makes them into a {@link dyroha.Classes.Library library} object
	 * 
	 * @return {@link dyroha.Classes.Library library} object of the movies currently in the file
	 * @throws IOException if the file couldn't be found
	 */
	public Library getProducts() throws IOException {
		ArrayList<Movie> movies = new ArrayList<>();
		String st;
		String[] parts;
		
		//gets all of the products from the Products.txt file
		BufferedReader br1 = new BufferedReader(new FileReader(products));
		while ((st = br1.readLine()) != null && !st.isEmpty()) {
			parts = st.split(",");
			movies.add(new Movie(parts[0], parts[1], parts[2], Arrays.copyOfRange(parts, 3, 8), parts[8], parts[9]));
		}
		br1.close();
		Library lib = new Library(movies.toArray(new Movie[movies.size()]));
		
		// adds the number of purchases to each movie from reading the User.txt file
		BufferedReader br2 = new BufferedReader(new FileReader(users));
		String[] movieIds;
		while ((st = br2.readLine()) != null && !st.isEmpty()) {
			parts = st.split(", ");
			movieIds = parts[3].split(";");
			for(String id : movieIds) {
				for(Movie movie: lib.getLibrary()) {
					if (movie.getId().equals(id)) {
						movie.setNumberOfPurchaces(movie.getNumberOfPurchaces()+1);
						break;
					}
				}
			}
		}
		br2.close();
		this.library = lib;
		return lib;
	}
	
	/**
	 * 
	 * @param user user find and add the current viewing movie to
	 * @throws IOException if the file couldn't be found
	 */
	private void getCurrentViewing(User user) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(currentUserSession));
		String st;
		String[] parts;
		while ((st = br.readLine()) != null && !st.isEmpty()) {
			parts = st.split(", ");
			if (parts[0].equals(user.getUserID())) { user.setCurrentViewing(library.getMovie(parts[1])); break;}
		}
		br.close();
	}
	
}
