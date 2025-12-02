package com.martin.erste.interview.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WordParser Tests")
class WordParserTest {

    private WordParser wordParser;

    @BeforeEach
    void setUp() {
        wordParser = new WordParser();
    }

    @Test
    @DisplayName("Should count words correctly")
    void shouldCountWordsCorrectlyTest() {
        
        String input = "Hello 	world";      
        int result = wordParser.getWordsCount(input);       
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Should return 0 for null input")
    void shouldReturnZeroForNullInputTest() {       
        int result = wordParser.getWordsCount(null);       
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 0 for blank input")
    void shouldReturnZeroForBlankInputTest() {      
        int result = wordParser.getWordsCount("    		");       
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Should return 0 for blank input")
    void shouldReturnCorrectFroInputWithNumbers() {      
        int result = wordParser.getWordsCount("ad4Avd454c445rtty6");       
        assertEquals(4, result);
    }
    
}
