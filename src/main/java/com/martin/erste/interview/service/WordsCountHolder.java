package com.martin.erste.interview.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;

public record WordsCountHolder(List<String> words) {
	
	public int size() {
		return words.size();
	}
	
	public int uniqueCount() {
		return new HashSet<>(words()).size();
	}
	
	public double averageWordLength() {
		int totalLength = 0;
		for(String x : words) {
			totalLength += x.length();
		}		
		double average = (double) totalLength/words.size();
		return BigDecimal.valueOf(average)
				.setScale(2, RoundingMode.HALF_UP)
				.doubleValue();		
	}

}
