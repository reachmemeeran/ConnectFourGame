import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
    ____________________________________________________________________
    |   Class Name: PlayerMove                                         |
    |   Description: This is the class for player to read the           |
    |                    input from the console                         |
    |   Created on: 06-Dec-2021                                         |
    |___________________________________________________________________|
    
*/
// Extending Another class - INHERITANCE
public class PlayerMove extends DisplayFormatting {

  // Private variables, these variables are accessible only within this class - Encapsulation
  private BufferedReader userInput; 

   /**
	 * Constructor of this class, this constructor will get execute everytime this HumanPlayer class is initialised
	 * @param - Nil
   *          
	 */
  public PlayerMove(){
    userInput = new BufferedReader(new InputStreamReader(System.in));
  }

  /**
	 * Method to read the input from the console
	 * @param - NO
	 * 			No param for this Method
	 */
  public int getMove(){
    String input = null;
    int move =0;
	  try{		
		  input = userInput.readLine();
      move = Integer.parseInt(input);
	  }
	  catch(Exception e){
      //System.out.println(ANSI_RED+"Exception: Invalid input Try again"+ANSI_RESET);
	  }
    return move;
	}
}