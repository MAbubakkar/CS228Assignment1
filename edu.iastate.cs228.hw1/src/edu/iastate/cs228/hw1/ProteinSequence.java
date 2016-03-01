package edu.iastate.cs228.hw1;

/*
 * @author Zac Schreck
*/

public class ProteinSequence extends Sequence
{
	
	
	/**
	 * This constructor creates a new ProteinSequence from the given char array. If any of the characters
	 * in the array are found to be invalid by the overriding isValidLetter method, the constructor throws
	 * a new IllegalArgumentException with the name of the class.
	 * @param psarr = Char array to be made into a Protein Sequence.
	 * 
	 */
  public ProteinSequence(char[] psarr)
  {
    super(psarr);
  }

  
  /**
   * This method overrides the isValidLetter method in the Sequence class, and checks if the letter 
   * is valid by seeing if it is not in the list of 6 invalid characters.
   */
  @Override
  public boolean isValidLetter(char aa)
  {
	if((aa == 'B') || (aa == 'b') || (aa == 'J') || (aa == 'j') || (aa == 'O') || (aa == 'o') ||
			(aa == 'U') ||(aa == 'u') ||(aa == 'X') ||(aa == 'x') || (aa == 'Z') || (aa == 'z')){

	return false;
	}
	
	else{
		return true;
	}
   
  }
}
