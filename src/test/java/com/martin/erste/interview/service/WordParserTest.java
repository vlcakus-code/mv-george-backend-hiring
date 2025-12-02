package com.martin.erste.interview.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WordParser Tests")
class WordParserTest {

    private WordParser wordParser;
    private WordParser wordParserWithIgnoredWords;

    @BeforeEach
    void setUp() {
        wordParser = new WordParser();
        wordParserWithIgnoredWords = new WordParser(Set.of("ignore1", "ignore2", "i"));
        
    }

    @Test
    @DisplayName("Should count words correctly")
    void shouldCountWordsCorrectlyNoIgnoredWordsTest() {
        
        String input = "Hello 	world";      
        int result = wordParser.getWordsCount(input);       
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Should return 0 for null input")
    void shouldReturnZeroForNullInputNoIgnoredWordsTest() {       
        int result = wordParser.getWordsCount(null);       
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 0 for blank input")
    void shouldReturnZeroForBlankInputNoIgnoredWordsTest() {      
        int result = wordParser.getWordsCount("    		");       
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Should return 0 for blank input")
    void shouldReturnCorrectFroInputWithNumbersNoIgnoredWordsTest() {      
        int result = wordParser.getWordsCount("ad4Avd454c445rtty6");       
        assertEquals(4, result);
    }
    
    
    
    
}
