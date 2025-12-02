package com.martin.erste.interview.service;

import java.util.HashSet;
import java.util.List;

public record WordsCountHolder(List<String> words) {
	
	public int size() {
		return words.size();
	}
	
	public int uniqueCount() {
		return new HashSet<>(words()).size();
	}

}
