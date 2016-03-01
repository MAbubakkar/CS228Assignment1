package edu.iastate.cs228.hw1;

import junit.framework.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodingDNASequenceTest {

	
	public String tMessage = "Should be true"; //String used throughout the class representing that the statement should be true.
	public String fMessage = "Should be false"; //String used throughout the class representing that the statement should be false.
	
	char [] testArr = {'a', 't', 'g', 't', 'a', 'c', 'g', 't', 'a', 'c', 'g', 't'}; //Test array used to test methods in this class.
	
	CodingDNASequence a = new CodingDNASequence(testArr); //Construction of a new CodingDNASequence using the test array.
	
	@Test
	public void testCheckStartCodon(){
		assertEquals(tMessage, true, a.checkStartCodon()); //Checking the start codon of the CodingDNASequence a, should be true since it starts with atg.
		char[] testArr2 = {'a'};
		CodingDNASequence b = new CodingDNASequence(testArr2); 
		assertEquals(fMessage, false, b.checkStartCodon()); //Checking the start codon of CodingDNASequence b, should be false since it is only 1 character long.
		testArr[0] = 't';
		CodingDNASequence c = new CodingDNASequence(testArr);
		assertEquals(fMessage, false, c.checkStartCodon()); //Checking start codon of CodingDNASequence c, should be false since it starts with t, even though it is long enough.
		testArr[0] = 'a';
	}
	
	@Test
	public void testTranslate(){
		char [] testArr3 = {'a', 't', 'g', 'a', 'a', 'a', 'a', 'a', 'c', 'a', 'g', 't'};
		CodingDNASequence d = new CodingDNASequence(testArr3); 
		System.out.println(d.toString(d.translate()));
		assertEquals(tMessage, true, "MKNS".equals(d.toString(d.translate()))); //Testing Translate on CodingDNASequence d, should be "MKNS" and be true. 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIAException()
	{
		char [] testArr2 = {'a', 'b', 'g', 'g', 'a', 'b', 'g', 'a'};
		CodingDNASequence c = new CodingDNASequence(testArr2); //Constructing a new CodingDNASequence c, with invalid character b, should throw IllegalArgumentException.
	}
	
	@Test(expected=RuntimeException.class)
	public void testRTException(){
		char [] testArr2 = {'a', 'a', 'g', 'g', 'a', 'a', 'g', 'a'};
		CodingDNASequence c = new CodingDNASequence(testArr2);	
		c.translate(); //Testing translate on a valid CodingDNASequence, but doesn't have a start codon, so should throw RuntimeException.
	}

}
