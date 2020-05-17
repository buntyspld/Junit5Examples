/**
 * 
 */
package com.saurabh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Saurabh naik
 *
 */
class MathUtilsTest {

	@Test
	void testAdd() {
		System.out.println("This test ran");
		MathUtils mathUtils=new MathUtils();
		int expected=2;
		int actual=mathUtils.add(1, 1);
		assertEquals(expected, actual,"This add method adds two numbers");
	}
	
	@Test
	void testComputeCirleRadius() {
		MathUtils mathUtils=new MathUtils();		
		
		assertEquals(314.1592653589793, mathUtils.computeCirleRadius(10),"Should return right circle area");
	}
	
	@Test
	void testDevide() {
		MathUtils mathUtils=new MathUtils();		
		assertThrows(ArithmeticException.class, ()->mathUtils.devide(1, 0),"Devide by 0");
		
	}

}
