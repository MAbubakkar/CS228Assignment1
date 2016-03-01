package edu.iastate.cs228.hw1;

import java.util.Arrays;

/*
 * @author Zac Schreck
*/

public class CodingDNASequence extends DNASequence
{
	
	/**
	 * Constructor method that creates a new CodingDNASequence of characters, from the input char array.
	 * It first uses DNASequence's isValidLetter method to check whether all characters are a, t, c, or g, 
	 * case insensitive. If they are all correct it creates a new CodingDNASequence. If not, it 
	 * throws a new IllegalArgumentException.
	 * @param cdnaarr Input char array to be checked and made into a CodingDNASequence.
	 */
  public CodingDNASequence(char[] cdnaarr)
  {
	  
    super(cdnaarr);
  }

  /**
   * This method checks the first 3 characters of the CodingDNASequence to see if they are atg, in that 
   * order, case insensitive. If they are, it returns true. If the CodingDNASequence is less than 3 characters, 
   * or starts with something else, then the method returns false.
   * @return
   */
  public boolean checkStartCodon()
  
  {
	  if(seqLength() < 3){
		  
		  return false;
	  }
	  else if(toString().substring(0, 3).toLowerCase().equals("atg"))
			  {
		  
		  return true;
	  }
	  
	  else {
		  
		  return false;
	  }

  }

  /**
   * This method translates the CodingDNASequence into a new char array. It first checks to see if 
   * the first 3 characters are a start codon by calling checkStartCodon. If this is false, it throws 
   * a RuntimeException. If the first 3 are a start codon, it translates the CodingDNASequence into 
   * a char array of characters that represent amino acids, by calling getAminoAcid on every three chars.
   * @return
   */
  public char[] translate()
  {
	  String tempStr = ""; //Temporary string used to concatenate the amino acids before being made into a char array.
	  
		  if(checkStartCodon() == false){
			  throw new RuntimeException(" No Start Codon");
		  }
		  
		  else{
			  int i = 0;
			  int j = 3;
			  while(j < seqLength() +1){
				  
				  if(getAminoAcid(toString().substring(i,j)) == '$'){
					  break;
				  }
				  
				  else{ 
					  tempStr = tempStr + getAminoAcid(toString().substring(i,j));
				  }
				  i = i + 3;
				  j = j + 3;
			  }
		  }
		  
		  return tempStr.toCharArray();
  }

  /**
   * This method gets the amino acids by looking at the given codon string. If the codon is not in the 
   * list of cases, it returns '$'. If it is in the case, it returns the char representation.
   * @param codon String to be checked for amino acid representation.
   * @return Char that represents the amino acid.
   */
  private char getAminoAcid(String codon)
  {
    if ( codon == null ) return '$';
    char aa = '$';
    switch ( codon.toUpperCase() )
    {
      case "AAA": aa = 'K'; break;
      case "AAC": aa = 'N'; break;
      case "AAG": aa = 'K'; break;
      case "AAT": aa = 'N'; break;

      case "ACA": aa = 'T'; break;
      case "ACC": aa = 'T'; break;
      case "ACG": aa = 'T'; break;
      case "ACT": aa = 'T'; break;

      case "AGA": aa = 'R'; break;
      case "AGC": aa = 'S'; break;
      case "AGG": aa = 'R'; break;
      case "AGT": aa = 'S'; break;

      case "ATA": aa = 'I'; break;
      case "ATC": aa = 'I'; break;
      case "ATG": aa = 'M'; break;
      case "ATT": aa = 'I'; break;

      case "CAA": aa = 'Q'; break;
      case "CAC": aa = 'H'; break;
      case "CAG": aa = 'Q'; break;
      case "CAT": aa = 'H'; break;

      case "CCA": aa = 'P'; break;
      case "CCC": aa = 'P'; break;
      case "CCG": aa = 'P'; break;
      case "CCT": aa = 'P'; break;

      case "CGA": aa = 'R'; break;
      case "CGC": aa = 'R'; break;
      case "CGG": aa = 'R'; break;
      case "CGT": aa = 'R'; break;

      case "CTA": aa = 'L'; break;
      case "CTC": aa = 'L'; break;
      case "CTG": aa = 'L'; break;
      case "CTT": aa = 'L'; break;

      case "GAA": aa = 'E'; break;
      case "GAC": aa = 'D'; break;
      case "GAG": aa = 'E'; break;
      case "GAT": aa = 'D'; break;

      case "GCA": aa = 'A'; break;
      case "GCC": aa = 'A'; break;
      case "GCG": aa = 'A'; break;
      case "GCT": aa = 'A'; break;

      case "GGA": aa = 'G'; break;
      case "GGC": aa = 'G'; break;
      case "GGG": aa = 'G'; break;
      case "GGT": aa = 'G'; break;

      case "GTA": aa = 'V'; break;
      case "GTC": aa = 'V'; break;
      case "GTG": aa = 'V'; break;
      case "GTT": aa = 'V'; break;

      case "TAA": aa = '$'; break;
      case "TAC": aa = 'Y'; break;
      case "TAG": aa = '$'; break;
      case "TAT": aa = 'Y'; break;

      case "TCA": aa = 'S'; break;
      case "TCC": aa = 'S'; break;
      case "TCG": aa = 'S'; break;
      case "TCT": aa = 'S'; break;

      case "TGA": aa = '$'; break;
      case "TGC": aa = 'C'; break;
      case "TGG": aa = 'W'; break;
      case "TGT": aa = 'C'; break;

      case "TTA": aa = 'L'; break;
      case "TTC": aa = 'F'; break;
      case "TTG": aa = 'L'; break;
      case "TTT": aa = 'F'; break;
      default:    aa = '$'; break;
    }
    return aa;
  }
}
