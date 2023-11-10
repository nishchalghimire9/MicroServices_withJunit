package com.unitTesting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.arithmeticTest.PalindromeCheck;

public class PalindromeTest {

	// this is used to testmultiple value /
	
	@ParameterizedTest
	@ValueSource(strings = {"liril", "madam", "racecar", "Nishchal"})
	public void TestIsPalindrome(String str) {
		PalindromeCheck palindromeCheck = new PalindromeCheck();
		boolean actual = palindromeCheck.isPalindrome(str);
		
		assertTrue(actual);
	}
	
	
}
