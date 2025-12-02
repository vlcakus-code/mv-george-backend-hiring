package com.martin.erste.interview.service;

public class WordParser {		
	
	/**
	 * 
	 * @param in the input word
	 * @return number of words in the input based on requirements in docs folder
	 */
	public int getWordsCount(String in) {
		if(in == null || in.isBlank()) {
			return 0;			
		}		
		String[] words = in.replaceAll("\\d", " ").split("\\s+");
		return words.length;	
	}
}
