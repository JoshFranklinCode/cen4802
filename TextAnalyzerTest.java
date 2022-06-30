package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TextAnalyzerTest {

	@Test
	public void test() {
		ArrayList<String> wordCollection = new ArrayList<String>();
		Map<String, Integer> words = new HashMap<String, Integer>();
		Map<String, Integer> wordsTest = new HashMap<String, Integer>();
		TextAnalyzer textAnalyzer = new TextAnalyzer();
		
		wordCollection.add("Text");
		wordCollection.add("Goes");
		wordCollection.add("Here");
		
				
		wordsTest = textAnalyzer.countWords(wordCollection, words);
		assertTrue(words.equals(wordsTest));
	}

}
