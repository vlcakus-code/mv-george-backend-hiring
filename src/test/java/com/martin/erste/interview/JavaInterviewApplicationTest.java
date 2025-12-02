package com.martin.erste.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.martin.erste.interview.service.WordParser;

public class JavaInterviewApplicationTest {
	
	private JavaInterviewApplication interviewApplication;
	
	@BeforeEach
    void setUp() {
		interviewApplication = new JavaInterviewApplication(new WordParser());        
    }
	

    @Test
    @DisplayName("Should return 0 for blank input")
    void shouldGetCorrectRecordsFromFileTest() {      
    	String result = interviewApplication.getWordsFromInput("test_in.txt");            
        assertEquals(" one two three", result);
    }
    

}
