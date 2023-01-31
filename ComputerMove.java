import java.util.Random;
/* 
    ____________________________________________________________________
    |   Class Name: ComputerMove                                        |
    |   Description: This is the class for Computer player to           |
    |                    generate moves.                                |
    |   Created on: 06-Dec-2021                                         |
    |___________________________________________________________________|
    
*/
// Extending Another class - INHERITANCE
public class ComputerMove extends DisplayFormatting {

   /**
	 * Constructor of this class, this constructor will get execute everytime this ComputerMove class is initialised
	 * @param - Nil
   *          
	 */
  public ComputerMove(){
  }

  /**
	 * Method to generate the input for the computer player
	 * @param - NO
	 * 			No param for this Method
	 */
  public int getMove(){
    int move =0;
	  try{		
      int min = 1;
      int max = 7;
      Random random = new Random();
      move = (int)Math.floor(Math.random()*(max-min+1)+min);
		  
	  }
	  catch(Exception e){
      //System.out.println(ANSI_RED+"Exception: Invalid input Try again"+ANSI_RESET);
	  }
    return move;
	}
}