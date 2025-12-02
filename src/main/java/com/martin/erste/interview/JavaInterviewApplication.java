package com.martin.erste.interview;

import java.util.Scanner;

import com.martin.erste.interview.service.WordParser;

public class JavaInterviewApplication {
	
	private WordParser wordParser;
	
	public JavaInterviewApplication(WordParser parser) {
		this.wordParser = parser;
	}
	
	public static void main(String args[]) {
		JavaInterviewApplication app = new JavaInterviewApplication(new WordParser());
		app.countWordsFromInput();
	}
	
	public void countWordsFromInput() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter text: ");
		String inputLine = s.nextLine();	
		System.out.println("Number of words: " + wordParser.getWordsCount(inputLine));		
	}	

}
