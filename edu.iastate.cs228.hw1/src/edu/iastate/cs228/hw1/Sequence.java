package edu.iastate.cs228.hw1;

/*
 * @author Zac Schreck
*/

public class Sequence
{
	
	/**
	 * Seqarr is the character array that is created any time a Sequence, or class that extends sequence 
	 * is constructed.
	 */
  protected char[] seqarr;
   
  protected boolean isValidArr; //This is a boolean that I am using in my helper method, isValidArr.
  
  protected String X = ""; //String that will denote the class name of the constructor,
  						   //used for throwing the constructor exception.
  
/**
 * The Sequence constructor first assigns the class name to the variable X, then checks if 
 * sarr is a valid array. If sarr is a valid array, seqarr is created by copying sarr. If not, then 
 * an exception is thrown stating that there is an invalid sequence letter for the class.  
 * @param sarr = char array that is the parameter for creating a new Sequence.
 */
  public Sequence(char[] sarr)
  {
	  X = this.getClass().getName();

    	if(isValidArr(sarr) != true){
    			throw new IllegalArgumentException("Invalid sequence letter for class " + X);
    	}
    		
    	seqarr = new char[sarr.length];
    	for(int i = 0; i < sarr.length; i++){
    		seqarr[i] = sarr[i];
    		}
    }

    	
  /**
   * isValidArr checks the input array for validity, by looping through the array, and checking each
   * character for whether it is a valid letter or not. If a letter is valid, the loop breaks and the 
   * method returns false. If all letters are valid, the method returns true.  
   * @param vArr = input array to check for validity.
   * @return true or false, depending on if it is a valid array.
   * 
   */
  public boolean isValidArr(char[] vArr){
	  
	    for(int i = 0; i < vArr.length; i++){
	    	if(isValidLetter(vArr[i])){
	    		isValidArr = true;
	    	}
	    	else{
	    		isValidArr = false;
	    		break; //Breaking after one character is found to be invalid, so the boolean can't be changed back to true.
	    	}
	    }
	    
		return isValidArr;
  }
  

  /**
   * This method checks the current length of seqarr, and returns it as an int.  
   * @return Int value which is the current length of the seqarr.
   * This method checks the current length of seqarr, and returns it as an int. 
   */
  public int seqLength()
  {
	  
	return seqarr.length;
  }
  
  
  /**
   * This method loops through seqarr, and copies every spot into a new array to return.
   * @return Copy of seqarr in form of char array.
   */
  public char[] getSeq()
  {
	//Making a deep copy of seqarr to return.
	char[] temparr = new char[seqarr.length];
	for(int i = 0; i < seqarr.length; i++){
		temparr[i] = seqarr[i];
	}
	
	return temparr;
  }

  /**
   * This method loops through seqarr and adds each character to a temporary String to be returned.
   * @return String representation of seqarr. 
   */
  public String toString()
  {
	String resultString = ""; //Temporary String of which the method adds the characters from the array.
	for(int i = 0; i < seqarr.length; i++){
		resultString = resultString + seqarr[i];
	}
	
	return resultString;
  }
  
  /**
   * This method loops through the input array and adds each character to a temporary String to be returned
   * @param input = input char array to be represented as a string.
   * @return String representation of the input char array.
   */
  public String toString(char [] input){
	  String returned = ""; //Temporary String of which the method adds the characters from the array.
	  for(int i = 0; i < input.length; i++){
		  returned = returned + input[i];
	  }
	  
	  return returned;
  }

  /**
   * This method checks to see if this or the input are null, if they are it returns false.
   * It then checks to see if the objects are of the same class name, if they aren't it returns false.
   * It concatenates them to strings, if they are not equal it returns false.
   * If they are not null, of the same type, and have the same string representation, then it returns true.
   * @param Object to be compared to 'this'.
   *  */
  public boolean equals(Object obj)
  { 	
	  
	  if (((this == null) || (obj == null) || (obj.getClass().getName() != this.getClass().getName())) && (this.toString().toLowerCase() != obj.toString().toLowerCase())){
			  
		  return false;
	  }

	  else if (((this != null) && (obj != null)) && (obj.getClass().getName() == this.getClass().getName()) && this.toString().toLowerCase().equals(obj.toString().toLowerCase())){
		  return true;
	  }
	  
	  else{
		  return false;
	  }
	  
  }
  
  /**
   * This method checks to see if the given char is a letter a-z either uppercase or lowercase,
   * if it is then it returns true. If not, it returns false. 
   * @param let = char to be checked.
   * @return True or false depending on the validity of the character.
   * 
   */
  public boolean isValidLetter(char let)
  {
	  if(Character.isUpperCase(let) || Character.isLowerCase(let)){
		  return true;
	  }
	  else{
		  return false;
	  }
  }

}
