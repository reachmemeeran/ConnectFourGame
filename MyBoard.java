import java.util.List; 
/* 
    ____________________________________________________________________
    |   Class Name: MyBoard                                             |
    |   Description: This is the utility class and will be called up on |
    |                 from the classes MyConnectFour.java and           |
    |                 MyConnectFourComputer.java to build the board     |
    |   Created on: 06-Dec-2021                                         |
    |___________________________________________________________________|
    
*/
// Extending Another class - INHERITANCE
public class MyBoard extends DisplayFormatting{

  // Private variables, these variables are accessible only within this class - Encapsulation
  char[][] board;
  private int incPosition = 0;
  private int lastMove=0;
  private int firstI = -1;
  private int secondI = -1;
  private int thirdI = -1;
  private int fourthI = -1;

  private int firstJ = -1;
  private int secondJ = -1;
  private int thirdJ = -1;
  private int fourthJ = -1;


  /**
	 * Constructor of this class, this constructor will get execute everytime this board class is initialised
	 * @param - board
   *          Board instance
	 */
  MyBoard() {
    this.board = new char[6][7];
  }

  /**
	 * Method to print the board in the console
	 * @param - NO
	 * 			No param for this Method
	 */
  void printBoard(){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
        if(board[i][j] == 'r'){
        System.out.print("| "+ANSI_RED+"r"+ANSI_RESET+" ");
        }
        else if(board[i][j] == 'y'){
          System.out.print("| "+ANSI_YELLOW+"y"+ANSI_RESET+" ");
        }
        else{
          System.out.print("|   ");
        }
			}
			System.out.println("|");
		}
    System.out.println("  1   2   3   4   5   6   7  ");
	}

  /**
	 * Method to print the board in the console
	 * @param - iArray
	 * 			array of value of i
   * @param - jArray
	 * 			array of value of j
	 */
  void printFinalBoard(List<Integer> iArray, List<Integer> jArray){
    firstI = iArray.get(0);
    secondI = iArray.get(1);
    thirdI = iArray.get(2);
    fourthI = iArray.get(3);

    firstJ = jArray.get(0);
    secondJ = jArray.get(1);
    thirdJ = jArray.get(2);
    fourthJ = jArray.get(3);

		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
        if(board[i][j] == 'r'){
          if((i==firstI && j==firstJ) || (i==secondI && j==secondJ)
           || (i==thirdI && j==thirdJ) || (i==fourthI && j==fourthJ)) {
                System.out.print("|"+ANSI_RED_RESULT+" r "+ANSI_RESET);
          }else{
            System.out.print("| "+ANSI_RED+"r"+ANSI_RESET+" ");
          }
        }
        else if(board[i][j] == 'y'){
          if((i==firstI && j==firstJ) || (i==secondI && j==secondJ)
           || (i==thirdI && j==thirdJ) || (i==fourthI && j==fourthJ)){
                System.out.print("|"+ANSI_YELLOW_RESULT+" y "+ANSI_RESET);
          }else{
            System.out.print("| "+ANSI_YELLOW+"y"+ANSI_RESET+" ");
          }
        }
        else{
          System.out.print("|   ");
        }
			}
			System.out.println("|");
		}
    System.out.println("  1   2   3   4   5   6   7  ");
	}

  /**
	 * Method to check if the column is playable
	 * @param - move
	 * 			move is the column to validate
	 */
  boolean isColumnFull(int move){
    boolean isColumnFull=true;
		try{		
      for(int i=0; i<board.length; i++){
        if(board[i][move-1] != 'r' && board[i][move-1] != 'y'){
          return false;
        }
      }
		}
		catch(Exception e){
			System.out.println(ANSI_RED+"Exception in isColumnFull Method: "+e+ANSI_RESET);
		}
    return isColumnFull;
	}
  
  /**
	 * Method to check if the board is playable
	 * @param - NO
	 * 			No param for this Method
	 */
  boolean isBoardFull(){
    boolean isfull=true;
		try{		
		  for(int i=0; i<board.length; i++){
        for(int j=0; j<board[i].length; j++){
          if(board[i][j] != 'r' && board[i][j] != 'y'){
            return false;
          }
        }
      }
		}
		catch(Exception e){
			System.out.println(ANSI_RED+"Exception in isBoardFull Method: "+e+ANSI_RESET);
		}
    return isfull;
	}

  // This Method is called whenever we need to place the player move in the Board
  /**
	 * Method to check if the board is playable
	 * @param - player
	 * 			char to identify the player (r or y)
   * @param - position
	 * 			int position in which the counter to be placed
	 */
  void placeCounter(char player, int position){
		boolean placed = false;
    for(int i=board.length-1; i>=0; i--){
      if(!placed){
        if(board[i][position-1] == 'r' || board[i][position-1] == 'y'){
          // skip
        }
        else{
          board[i][position-1] = player;
          placed = true;
          break;
        }
      }
    }
	}

  /**
	 * Method to place the counter for the computer player
	 * @param - Move
	 * 			Gets the player input and manipulate the computer move accordingly
	 */
  void placeCounterForComputer(int move){
    boolean isPlaced=false;
    if(incPosition>=board.length-2){
      incPosition=1;
    }else if(move==2 && incPosition%2==0){
      incPosition=move-1;
    }else if(move==5 && incPosition%2!=0){
      incPosition=move-2;
    }else if(move==3 && incPosition%2==0){
      incPosition=move+1;
    }else if(move==6 && incPosition%2!=0){
      incPosition=move+1;
    }else if(move==4 && incPosition%2==0){
      incPosition=move+3;
    }else if(move==7 && incPosition%2==0){
      incPosition=move-1;
    }else{
      incPosition+=3;
    }
    if(lastMove==move){
      incPosition=move;
    }
    while(!isPlaced){
      for(int i=board.length-1; i>=0; i--){
        // if(move%2==0 && incPosition%2==0){
        //   incPosition=move-1;
        // }else if(move==5 || move ==7){
        //   incPosition=move-2;
        // }
        if(isColumnFull(incPosition)){
          for(int k=1; k<7; k++){
            if(!isColumnFull(k)){
              incPosition=k;
            }
          }
        }
        if(board[i][incPosition-1] == 'r' || board[i][incPosition-1] == 'y'){
          // skip
        }else{
          board[i][incPosition-1] = 'y';
          isPlaced=true;
          break;
        }
        // if(i==0 && !isPlaced){
        //   if(incPosition==7){
        //     incPosition=1;
        //   }else{
        //     incPosition++;
        //   }
        // }
      }
      if(!isPlaced){
        incPosition=1;
      }
    }
    lastMove=move;
	}
}