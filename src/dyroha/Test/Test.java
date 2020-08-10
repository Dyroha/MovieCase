package dyroha.Test;

import java.util.Arrays;

import dyroha.Classes.*;
import dyroha.Handlers.MovieFileHandler;

public class Test {
	private static MovieFileHandler fileHandler = new MovieFileHandler("src/test");
	
	public static void main(String[] args) throws Exception {
		Library lib = fileHandler.getProducts();
		User current = fileHandler.getUser("1");
		System.out.println(current.getUserID() + " " + current.getUserName() + " " + Arrays.toString(current.getViewed()) 
			+ " " + Arrays.toString(current.getPurchaced()) + " " + current.getCurrentViewing().toString());
		
	}

}
