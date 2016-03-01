package edu.iastate.cs228.hw1;

/*
 * @author Zac Schreck
*/

public class DNASequence extends Sequence
{
	/**
	 * Constructor that creates a new DNA Sequence from the given char array. The array is first checked
	 * for validity, using the overriding isValidLetter, to see if the characters are a, c, g, or t. 
	 * They can be either uppercase or lowercase. If any letter is not valid, it throws a new IllegalArgumentException.
	 * @param dnaarr input char array to be made into a DNASequence.
	 */
	public DNASequence(char[] dnaarr)
  {
	  
	super(dnaarr);
  }

	/**
	 * Method that overrides the isValidLetter method from Sequence, and checks each letter to see if it 
	 * is an a, c, g, or t, case insensitive. If one or more is not, it returns false. If all are valid, 
	 * it returns true.
	 */
	@Override
	public boolean isValidLetter(char let)
	{
	  if((let == 'a') || (let == 'A') || (let == 'c') || (let == 'C')
		|| (let == 'g') || (let == 'G') || (let == 't') || (let == 'T')){
		  
		  return true;
	  }
	  else{
		  
		  return false;
	  }
  }
}
