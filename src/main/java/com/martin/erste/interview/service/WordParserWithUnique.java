package com.martin.erste.interview.service;

import java.util.HashSet;
import java.util.Set;

public class WordParserWithUnique extends WordParser {	
	
	public WordParserWithUnique(Set<String> ignoredWordsFromFile) {
		super(ignoredWordsFromFile);
	}

	public WordParserWithUnique() {
		super();
	}

	/**
	 * 
	 * @param in the input word	 * 
	 * @return The holder which wraps the counts of word and also the count of original words.
	 */
	public WordsCountHolder getWords(String in) {		
		WordsCountHolder wordsList = super.getWords(in);		
		return new WordsCountHolder(wordsList.words(), new HashSet<>(wordsList.words()).size());		
	}	
	
}
