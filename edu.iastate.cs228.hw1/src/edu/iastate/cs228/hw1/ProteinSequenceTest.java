package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProteinSequenceTest {

	public String tMessage = "Should be true"; //String used throughout the class representing that the statement should be true.
	public String fMessage = "Should be false"; //String used throughout the class representing that the statement should be false.
	
	char [] testArr = {'a', 'c', 'g', 't', 'a', 'c', 'g', 't', 'a', 'c', 'g', 't'}; //Test array used for testing in this class.
	
	ProteinSequence a = new ProteinSequence(testArr); //New ProteinSequence made from testArr.
	
	@Test
	public void testIsValidLetter(){
		assertEquals(tMessage, true, a.isValidLetter('a')); //Testing if a is a valid letter, should be true.
		assertEquals(fMessage, false, a.isValidLetter('b')); //Testing if b is a valid letter, should be false.
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIAException()
	{
		char [] testArr2 = {'a', 't', 'g', 'g', 'a', 'b', 'g', 'a'}; //New testArr2 with an invalid letter b, should throw exception when constructed.
		ProteinSequence c = new ProteinSequence(testArr2);	
	}
	
}
