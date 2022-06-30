package application;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Date: April 9-2022
 * This is an application that will take in the site- 
 * https://www.gutenberg.org/files/1065/1065-h/1065-h.htm
 * -and will output the top 20 word occurrences in the poem on that site.
 * 
 * @author Joshua
 * @version 1.0
 *
 */
public class TextAnalyzer {
	
	/** Main method will read through the site, ignoring anything before the poem title or after the poem end.
	 * Will then add each word to an ArrayList, send the list into a HashMap, then print out then new list
	 * of word counts
	 * 
	 * @param args Begins main method
	 */
	public static void main(String[] args) {
		
		// Try Catch around entire process
		try {
			
			boolean matchFound = false; // Will allow or disallow lines to be read and input into list
			URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())); // This line can be changed into a file reader
																								 // with a path to the desired HTML file if one so wishes
			ArrayList<String> wordCollection = new ArrayList<String>();

			String line;
			while ((line = reader.readLine()) != null) {

				if ((line.length() > 0) && (line.contains("[ #45484 ]") || matchFound == true)) { // Ignores everything above [ #45484 ], right above the title
					line = line.toLowerCase().replaceAll("\\<[^>]*>", "").replace("[ #45484 ]", "") // Deletes [ #45484 ]
							.replaceAll(",", "").replace("&mdash", "").replace(";", " ")
							.replace("!", "").replace(".", "").replace("?", "")
							.replaceAll("â€?", "").replaceAll("™", "’").replaceAll("œ", "")
							.replace("˜", ""); // There's probably an easier way to do all of this but it works for now
					//System.out.println(line); // Print entire poem
					matchFound = true;

					// Put each word of line into the ArrayList
					if (line.length() > 2) {
						for (String word : line.split(" ")) {
							wordCollection.add(word.replaceAll("[^a-zA-Z0-9-’ ]", "")); // Gets rid of any extra "?" in ArrayList
						}
					}

					if ((line.length() > 0) && (line.contains("be lifted"))) {
						matchFound = false;
					}
				}
			}
			reader.close();
			//System.out.println(wordCollection); // Prints out ArrayList of each word in the order they are added

			// Convert to HashMap using countWords method
			Map<String, Integer> words = new HashMap<String, Integer>();
			countWords(wordCollection, words);
			
			// Organize result into descending order (Most frequently used word)
			List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(words.entrySet());
			Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			  public int compare( Map.Entry<String, Integer> entry1,
					  			  Map.Entry<String, Integer> entry2) {
			    return entry2.getValue().compareTo(entry1.getValue());
			  }
			});
			
			// Output entire result of organized list in descending order
			System.out.println(entries);
			// Output result of top 20
			for(int i = 0; i < 20; i++) {
			System.out.println(entries.get(i));
			}
			
			
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O Error: " + e.getMessage());
		}
	}
	
	/** This method takes in the HashMap and ArrayList, then counts the occurrence of words in the ArrayList,
	 * returning it to the main method.
	 * 
	 * @param wordCollection: Takes in an ArrayList of Strings called wordCollection from main method
	 * @param words: Takes in a Map of Strings/Integers called "words" from main method
	 * @return Will return the the map called Words to the main method
	 */
	static Map<String, Integer> countWords (ArrayList<String> wordCollection, Map<String, Integer> words) {
		for(int i = 0; i < wordCollection.size(); i++) {
			String word = wordCollection.get(i);
			Integer count = words.get(word);
			if (count != null) {
				count++;
			} else
				count = 1;
			words.put(word, count);
		}
		return words;
	}
}