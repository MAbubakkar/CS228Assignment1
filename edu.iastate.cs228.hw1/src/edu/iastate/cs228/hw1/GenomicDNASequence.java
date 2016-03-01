package edu.iastate.cs228.hw1;

import java.util.Arrays;

/*
 * @author Zac Schreck
*/


public class GenomicDNASequence extends DNASequence
{
	

	
	private char[] returnArr; // Private char array that is used in the extract exons method to return the extracted exons.
	
	/**
	 * Constructor that used the isValidLetter method from the DNASequence class to check if all the
	 * characters are valid letters, if if not it throws an IllegalArgumentException. If they are all valid
	 * it creates a new GenomicDNASequence.
	 * @param gdnaarr = Input char array to be made into the GenomicDNASequence.
	 */
	public GenomicDNASequence(char[] gdnaarr)
  {
		
    super(gdnaarr);
  }

	/**
	 * This method extracts exons from the GenomicDNASequence, using the input int array.
	 * It first checks to see if the int array has a length of 0 or an odd length, if it does have either, 
	 * it throws an IllegalArgumentException. If not, it checks to make sure all ints are valid positions, by using a helper method
	 * called validPos, and if they are not valid it throws an IllegalArgumentException. If they are valid, it then checks 
	 * to make sure that all ints are in order, by using the isInOrder helper method. If they are in order, it 
	 * then proceeds to extract exons, if not then it throws an IllegalArgumentException.
	 * It extracts the exons by checking the int array for the positions, given in pairs, and adds them 
	 * to a temporary string to concatenate, then after it extracts all, it turns the string into a 
	 * char array to return. 
	 * @param exonpos
	 * @return
	 */
  public char[] extractExons(int[] exonpos)
  {
	  
	  
		  if((exonpos.length == 0) || (exonpos.length % 2 == 1)){

			  throw new IllegalArgumentException(" Empty array or odd number of array elements");
		  }
		  
		  
		  if(validPos(exonpos) == false){
			  throw new IllegalArgumentException(" Exon position is out of bound");
		  }
		  
		  
		  if(isInOrder(exonpos) == false){
			  throw new IllegalArgumentException(" Exon positions are not in order");
		  }
		  
		  else{
		  
			  int i = 0; //Counter variable.
			  int j = 2; //Counter variable. 
			  String GDNAString = ""; //Temporary string used to concatenate the extracted exons before being made into a char array.
			  while(j < exonpos.length + 1){
				  char[] tempArr = Arrays.copyOfRange(seqarr, exonpos[i], exonpos[j-1]);
				  GDNAString = GDNAString + toString(tempArr);
				  i = i + 2;
				  j = j + 2;
			  }
			  
			  returnArr = GDNAString.toCharArray();
	  }
		  
	  return returnArr;
  }
  
  /**
   * This method checks every integer in the input int array to make sure they are valid positions.
   * It loops through the array, and makes sure that they are 0 or greater, and that they are not longer than 
   * the seqarr that they will be extracting from. 
   * @param validArr = Integer array to check validity for. 
   * @return True if all integers in the array are valid positions.
   */
  protected boolean validPos(int[] validArr){
		boolean tempBool = true; //Temporary boolean used just in this method, begins true and is made false if any 
								 //of the integers are not valid positions.
		for(int i = 0; i < validArr.length; i++){
			if((validArr[i] < 0) || (validArr[i] >= seqLength()) ){
				tempBool = false; //Made tempBool false and breaks the loop so that it can return false and not check anything else.
				break;
			}
		}
		
		return tempBool;
	  }
	  
  /**
   * Methos that checks to make sure all integers in the int array are in order. It just makes sure that
   * every integer is less than the one to its right by looping through each spot, if there is one. 
   * @param orderArr = Integer array to be checked. 
   * @return True if every integer is in order.
   */
  protected boolean isInOrder(int[] orderArr){
		boolean tempBool = true; //Temporary boolean used just in this method, begins true and is made false if any 
								 //of the integers are not valid positions.
		int j = 1;
		int i = 0;
		while(j < orderArr.length){
			if(orderArr[i] > orderArr[j]){
				tempBool = false; //Made tempBool false and breaks the loop so that it can return false and not check anything else.
				break;
			}
			i++;
			j++;
		}
		
		return tempBool;
	  }
  }


