package com.tron.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShapesTest {

	@Test
	void testComputeSquareArea() {
		Shapes shape=new Shapes();
		assertEquals(576, shape.computeSquareArea(24));
	}
}
