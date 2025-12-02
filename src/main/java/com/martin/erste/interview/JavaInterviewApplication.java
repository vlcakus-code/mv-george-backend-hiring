package com.martin.erste.interview;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

import com.martin.erste.interview.service.WordParser;
import com.martin.erste.interview.service.WordParserWithOrigins;
import com.martin.erste.interview.service.WordsCountHolder;
import com.martin.erste.interview.util.InterviewUtil;

public class JavaInterviewApplication {
	
	private final WordParser wordParser;	
	
	public JavaInterviewApplication(WordParser parser) {		
		this.wordParser = parser;		
	}
	
	public static void main(String args[]) {			
		InputStream inputStream = JavaInterviewApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");		
		Set<String> ignoredWordsFromFile = InterviewUtil.readLinesFromFile(inputStream);
		JavaInterviewApplication app = new JavaInterviewApplication(new WordParserWithOrigins(ignoredWordsFromFile));
		String param = (args != null && args.length > 0) ? args[0] : null;
		String line = app.getWordsFromInput(param);
		if(line == null) {
			try (Scanner lineScanner = new Scanner(System.in)) {
				System.out.print("Enter text: ");
				line = lineScanner.nextLine();					
			}
		}
		WordsCountHolder words = app.getWordParser().getWords(line);
		System.out.println("Number of words: " + words.size() + ", unique: " + words.originalCount());		
	}
	
	public String getWordsFromInput(final String param) {	
		if(param == null) {
			return null;
		}		
		InputStream inputStream = JavaInterviewApplication.class.getClassLoader().getResourceAsStream(param);	
		if(inputStream == null) {
			return null;
		}
		Set<String> wordsFromFile = InterviewUtil.readLinesFromFile(inputStream);
		StringBuilder allWords = new StringBuilder();
		wordsFromFile.stream().forEach(x -> allWords.append(" " + x));
		return allWords.toString();			
	}

	public WordParser getWordParser() {
		return wordParser;
	}	
}
