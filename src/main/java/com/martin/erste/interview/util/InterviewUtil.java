package com.martin.erste.interview.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class InterviewUtil {

	private InterviewUtil() {

	}

	public static Set<String> readIgnoredWordsFromFile(InputStream inputStream){
		if(inputStream == null) {
			return new HashSet<String>();
		}
		Set<String> ignoredWords = new HashSet<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					ignoredWords.add(line.trim());
				}
			}

		} catch (IOException e) {
			throw new RuntimeException("Failed to read ignored words from file", e);
		}
		return ignoredWords;
	}

}
