package com.martin.erste.interview.service;

import java.util.List;

public record WordsCountHolder(List<String> words, int originalCount) {
	
	public int size() {
		return words.size();
	}

}
