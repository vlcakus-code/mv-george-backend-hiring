package com.martin.erste.interview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordParser {		
	
	private final Set<String> ignoredWords;
	 
	public WordParser(Set<String> ignoredWords) {
		this.ignoredWords = ignoredWords;		
	}
	
	public WordParser() {
		this.ignoredWords = null;		
	}		
	
	/**
	 * 
	 * @param in the input word	 * 
	 * @return The holder which wraps the counts of word and also the count of original words.
	 */
	public WordsCountHolder getWords(String in) {
		List<String> result = new ArrayList<String>();
		if(in == null || in.isBlank()) {
			return new WordsCountHolder(new ArrayList<>());		}		
		String[] words = in.replaceAll("[^a-zA-Z-]", " ").split("\\s+");
		
		for(String word : words) {			
			if((ignoredWords == null || !ignoredWords.contains(word)) && word.length() > 0 && !"-".equals(word)) {
				result.add(word);				
			}
		}		
		return new WordsCountHolder(result);		
	}	
	
}
