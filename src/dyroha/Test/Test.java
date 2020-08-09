package dyroha.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dyroha.Classes.Library;
import dyroha.Classes.Movie;
import dyroha.Handlers.MovieFileHandler;

public class Test {
	private static MovieFileHandler fileHandler = new MovieFileHandler("src/test");
	
	public static void main(String[] args) throws IOException {
		Library library = fileHandler.getProducts();
		List<String> genres= new ArrayList<>();
		
		for (Movie m : library.getLibrary()) {
			for (String g : m.getGenre()) {
				boolean isIn = false;
				for (int i = 0; i<genres.size(); i++) {
					if (g.equals(genres.get(i))) {
						isIn = true;
						break;
					}
				}
				if (!isIn) {
					genres.add(g);
				}
			}
		}
		String[] g = new String[genres.size()];
		genres.toArray(g);
		Arrays.sort(g);
		System.out.print("{");
		for (String i : g) {
			System.out.print(" \"" + i.toString() + "\",");
		}
		System.out.print("}");
	}

}
