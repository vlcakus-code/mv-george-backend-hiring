package com.martin.erste.interview;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

import com.martin.erste.interview.service.WordParser;
import com.martin.erste.interview.util.InterviewUtil;

public class JavaInterviewApplication {
	
	private final WordParser wordParser;	
	
	public JavaInterviewApplication(WordParser parser) {		
		this.wordParser = parser;		
	}
	
	public static void main(String args[]) {	
		InputStream inputStream = JavaInterviewApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");		
		Set<String> ignoredWordsFromFile = InterviewUtil.readIgnoredWordsFromFile(inputStream);
		JavaInterviewApplication app = new JavaInterviewApplication(new WordParser(ignoredWordsFromFile));
		app.countWordsFromInput();
	}
	
	public void countWordsFromInput() {
		try (Scanner lineScanner = new Scanner(System.in)) {
			System.out.print("Enter text: ");
			String inputLine = lineScanner.nextLine();	
			System.out.println("Number of words: " + wordParser.getWordsCount(inputLine));
		}		
	}	

}
