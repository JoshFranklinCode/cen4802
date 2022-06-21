package cen4802;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void addMethodTest() {
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.addMethod(2, 2)); // Should return 4
		assertTrue((calculator.addMethod(2, 2) > 3) && (calculator.addMethod(2, 2) < 5));
	}
	
	@Test
	void subMethodTest() {
		Calculator calculator = new Calculator();
		assertEquals(0, calculator.subMethod(2, 2));
		assertTrue((calculator.subMethod(2, 2) > -1) && (calculator.subMethod(2, 2) < 1));
	}
	
	@Test
	void mulMethodTest() {
		Calculator calculator = new Calculator();
		assertEquals(4, calculator.mulMethod(2, 2));
		assertTrue((calculator.mulMethod(2, 2) > 3) && (calculator.mulMethod(2, 2) < 5));
	}
	
	@Test
	void divMethodTest() {
		Calculator calculator = new Calculator();
		assertEquals(1, calculator.divMethod(2, 2));
		assertTrue((calculator.divMethod(2, 2) > 0) && (calculator.divMethod(2, 2) < 2));
	}

}
