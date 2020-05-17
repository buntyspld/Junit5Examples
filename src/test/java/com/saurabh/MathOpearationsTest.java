package com.saurabh;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(value = Lifecycle.PER_METHOD)
class MathOpearationsTest {

	MathOpearations mathOperations;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllinit() {
		System.out.println("This runs before all methods");
	}

	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		mathOperations = new MathOpearations();
		this.testInfo=testInfo;
		this.testReporter=testReporter;
		testReporter.publishEntry("Running "+testInfo.getDisplayName() +" with "+testInfo.getTags());
	}

	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up all resources");
	}

	@AfterAll
	static void cleanUpAfterAll() {
		System.out.println("Cleaning up all resources for all methods");
	}
	
	@Tag("Math")
	@Nested
	class AddTest {
		@DisplayName("add method for positive")
		@Test
		void testAddPositive() {
			assertEquals(2, mathOperations.add(1, 1), "This add method adds two positive numbers");
		}

		@DisplayName("add method for negative")
		@Test
		void testAddNegative() {
			assertEquals(-2, mathOperations.add(-1, -1), "This add method adds two negative numbers");
			int expected = -2;
			// int actual=mathUtils.add(1, -1);
			// assertEquals(expected,actual, "Expected value is "+expected+ " actual
			// computed "+actual);

		}
	}

	@Tag("Math")
	@DisplayName("add method")
	@Test
	void testAdd() {
		System.out.println("This test ran");
		int expected = 2;
		int actual = mathOperations.add(1, 1);
		assertEquals(expected, actual, "This add method adds two numbers");
	}

	@DisplayName("Circle area by radius")
	@Test
	@Tag("Circle")
	@RepeatedTest(value = 10)
	void testComputeCirleRadius() {
		// System.out.println("RepetitionInfo count "+info.getCurrentRepetition());
		assertEquals(314.1592653589793, mathOperations.computeCirleRadius(10), "Should return right circle area");
	}

	@Tag("Math")
	@DisplayName("devide by zero error")
	@Test
	// @EnabledOnOs(OS.LINUX)
	void testDevide() {
		// assumeTrue(value);
		assertThrows(ArithmeticException.class, () -> mathOperations.devide(1, 0), "Devide by 0");

	}

	@DisplayName("under developement, incomplete")
	@Test
	@Disabled
	void testTdd() {
		fail("nothing is here ");

	}

	@Tag("Math")
	@Test
	@DisplayName("Multiply values")
	void testMultiply() {
		assertAll(() -> assertEquals(4, mathOperations.multiply(2, 2)),
				() -> assertEquals(0, mathOperations.multiply(2, 0)),
				() -> assertEquals(16, mathOperations.multiply(4, 4)));

	}
}
