package edu.iastate.cs228.hw1;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;


public class SequenceTest {
	
	public String tMessage = "Should be true"; //String used throughout the class representing that the statement should be true.
	public String fMessage = "Should be false"; //String used throughout the class representing that the statement should be true.
	
	char [] testArr = {'a', 'b', 'c', 'd', 'e', 'f', 'h', 'i'}; //Char array used for multiple tests.
	
	Sequence a = new Sequence(testArr); //Creating a new sequence using the testArr.
	
	char[] testArr2 = Arrays.copyOf(a.getSeq(), a.getSeq().length); //New test array made by copying testArr.
	
	@Test
	public void testSequenceIsValidLetter() {
		assertEquals(tMessage, true, a.isValidLetter('a')); //Testing isValidLetter on a valid lowercase a.
		assertEquals(tMessage, true, a.isValidLetter('A')); //Testing isValidLetter on a valid uppercase A.
		assertEquals(fMessage, false, a.isValidLetter('.')); //Testing isValidLetter on an invalid period.
		
	}

	@Test
	public void testSequenceIsValidArr() {
		assertEquals(tMessage, true, a.isValidArr(testArr)); //Testing isValidArr on the testArr. Should be true.
		testArr[0] = '.';
		assertEquals(fMessage, false, a.isValidArr(testArr)); //Testing isValidArr on the testArr after altering index 0 to be a period. Should be false.
		testArr[0] = 'a';
	}
	
	@Test
	public void testSequenceSeqLength(){
		assertEquals(tMessage, 8, a.seqLength()); //Testing seqLength with the correct length. Should be true.
		assertEquals(fMessage, false, a.seqLength() == 9); //Testing seqLength with an incorrect length. Should be false.
	}
	
	@Test
	public void testSequenceGetSeq(){
		char[] testArr2 = Arrays.copyOf(a.getSeq(), a.getSeq().length); //New testArr2 as a copy of a.
		for(int i = 0; i < testArr2.length; i++) //Looping through the testArr2 and a to make sure they are the same.
		{
			assertEquals(testArr2[i], a.getSeq()[i]);
		}
		
		testArr2[0] = ',';
		assertFalse(testArr2[0] == a.getSeq()[0]); //Making sure that they are not the same after altering testArr2.
		testArr2[0] = 'a';
	}
	
	@Test
	public void testToString(){
		assertEquals(tMessage, a.toString(), "abcdefhi"); //Testing the normal toString method by comparing the toString, to what it should be.
		assertFalse(fMessage, a.toString().equals("ab"));
	}
	
	
	@Test
	public void testToString2(){
		assertEquals(tMessage, a.toString(testArr2), a.toString(testArr)); //Testing my toString helper method by same process as above.
		testArr2[0] = '.';
		assertEquals(fMessage, false, a.toString(testArr2) == a.toString(testArr)); //Testing again after altering testArr2.
		testArr2[0] = 'a';

	}
	
	@Test
	public void testEquals(){
		Sequence b = new Sequence(testArr); 
		testArr[0] = 'z';
		Sequence c = new Sequence(testArr);
		assertEquals(tMessage, true, a.equals(b)); //Testing equals method with a vs b, should be true.
		assertEquals(fMessage, false, a.equals(c)); //Testing equals method with a vs c, which is altered version of b, should be false.
	}
	
	@Test(expected=IllegalArgumentException.class) //Testing to make sure it throws an exception when making a Sequence with invalid character.
	public void testIAException()
	{
		char [] testArr2 = {'.', 'b', 'c', 'd', 'e', 'f', 'h', 'i'}; //Should throw exception because index 0 is invalid character.
		Sequence c = new Sequence(testArr2);	
	}
	
}
