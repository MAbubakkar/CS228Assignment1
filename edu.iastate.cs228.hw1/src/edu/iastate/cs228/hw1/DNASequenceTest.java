package edu.iastate.cs228.hw1;

import junit.framework.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class DNASequenceTest {
	
	public String tMessage = "Should be true"; //String used throughout the class representing that the statement should be true.
	public String fMessage = "Should be false"; //String used throughout the class representing that the statement should be false.
	
	char [] testArr = {'a', 'c', 'g', 't'}; //Creating a test array with valid characters.
	
	DNASequence a = new DNASequence(testArr); //Constructing a new DNASequence using the test array.
	
	@Test
	public void testIsValidLetter(){
		assertEquals(tMessage, true, a.isValidLetter(testArr[0])); //Testing if index 0 is a valid letter, should be true since it is 'a'.
		testArr[0] = 'z';
		assertEquals(fMessage, false, a.isValidLetter(testArr[0])); //Testing if index 0 of the altered array is valid, should be false since it is a 'z'.
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIAException()
	{
		char [] testArr2 = {'a', 'b', 'g', 'g', 'a', 'b', 'g', 'a'}; //New test array with an invalid letter 'b' in it.
		DNASequence c = new DNASequence(testArr2); //Testing construction of a new DNASequence with the array that has an invalid letter. Should throw IllegalArgumentException.
	}
	
}
