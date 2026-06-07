package com.tron.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

class TestBeforeAfter {
	
	//apply before all to static method
	//this method is executed once at the starting (even before This class is instantiated)
	@BeforeAll
	static void beforeAll()
	{
		System.out.println("Before all test");
	}
	
	@AfterAll
	static void afterAll()
	{
		System.out.println("After all test");
	}
	
	Shapes shape;

	//init method is called before every test method below
	@BeforeEach
	void init()
	{
		shape=new Shapes();
		System.out.println("Before test");
	}

	@RepeatedTest(3)
	void testComputerSquareArea(RepetitionInfo info) {
		if(info.getCurrentRepetition()==1)
			assertEquals(78.5, shape.computeCircleArea(5));
		if(info.getCurrentRepetition()==2)
			assertEquals(175.5, shape.computeCircleArea(10));
		if(info.getCurrentRepetition()==3)
			assertEquals(200.5, shape.computeCircleArea(15));
	}
	
	@Test
	void testComputerCircleArea() {
		String str="java";
		assumeTrue(str.length()<5);
		//only if the expression in assumeTrue is true below statements will be executed.
		assertEquals(78.5, shape.computeCircleArea(5));
	}
	
	@AfterEach
	void destroy() {
		System.out.println("After test");
	}
}
