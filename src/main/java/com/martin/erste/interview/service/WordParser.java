package com.martin.erste.interview.service;

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
	 * @param in the input word
	 * @param exceptions The set of 'words' which are not words.
	 * @return number of words in the input based on requirements in docs folder
	 */
	public int getWordsCount(String in) {
		
		if(in == null || in.isBlank()) {
			return 0;			
		}		
		String[] words = in.replaceAll("[^a-zA-Z]", " ").split("\\s+");
		int result = 0;
		for(String word : words) {
			
			if((ignoredWords == null || !ignoredWords.contains(word)) && word.length() > 0) {
				result++;
			}
		}
		
		return result;	
	}	
	
}
