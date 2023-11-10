package com.unitTesting;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.arithmeticTest.AddingFunction;

// this is JUnit 4 so There is Before instead Before all.

public class ArethmeticTesting {
	
	private AddingFunction arethmatic = null; // declare the object as null at beginnig 
	
	@Before
	public void init() {  // 
		arethmatic = new AddingFunction(); // creating an object.
	}
	@After
	public void destroy() {
		arethmatic = null;  // nullyfying the object
	}
	
	@Test

	public  void testAddition () {
		
		int actualadditionResult = arethmatic.add1(4, 9);
		int expectedResult = 13;
		assertEquals(expectedResult, actualadditionResult);
	}
	@Test
		public void testMultiplication() {
		int actualResult = arethmatic.multiply(4, 9,  3);
		
		int expectedResult = 108;
		assertEquals(expectedResult, actualResult);
	}
	
	

}
