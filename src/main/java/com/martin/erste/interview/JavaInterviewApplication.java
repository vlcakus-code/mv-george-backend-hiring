package com.martin.erste.interview;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

import com.martin.erste.interview.service.WordParser;
import com.martin.erste.interview.util.InterviewUtil;

public class JavaInterviewApplication {
	
	private final WordParser wordParser;
	private final Set<String> ignoredWords;
	
	public JavaInterviewApplication(WordParser parser, Set<String> ignoredWords) {
		this.wordParser = parser;
		this.ignoredWords = ignoredWords;
	}
	
	public static void main(String args[]) {	
		InputStream inputStream = JavaInterviewApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");		
		JavaInterviewApplication app = new JavaInterviewApplication(new WordParser(), InterviewUtil.readIgnoredWordsFromFile(inputStream));
		app.countWordsFromInput();
	}
	
	public void countWordsFromInput() {
		try (Scanner lineScanner = new Scanner(System.in)) {
			System.out.print("Enter text: ");
			String inputLine = lineScanner.nextLine();	
			System.out.println("Number of words: " + wordParser.getWordsCount(inputLine, ignoredWords));
		}		
	}	

}
