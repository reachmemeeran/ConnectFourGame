/* 
    ____________________________________________________________________
    |   Class Name: MyConnectFourComputer                               |
    |   Description: This is the business layer for the one person with |
    |                 computer mode, where one person can interact      |
    |                 with computer and play the game                   |
    |   Created on: 06-Dec-2021                                         |
    |___________________________________________________________________|
    
*/
// Extending Another class - INHERITANCE
public class MyConnectFourComputer extends DisplayFormatting{
	// Private variables, these variables are accessible only within this class - Encapsulation
  private MyConnectConnection connection;
  private MyBoard myBoard;
  private PlayerMove player;
  private ComputerMove computerMove;
	
  /**
	 * Constructor of this class, this constructor will get execute everytime this class is initialised (depends on the game mode)
   *
	 * @param - No
   *
	 */
	public MyConnectFourComputer(){
		myBoard = new MyBoard();
		player = new PlayerMove();
    computerMove = new ComputerMove();
		playGame();
	}
	
  /**
	 * Method for executing the game
   * This Method is Called when player select the mode-2 to play with the computer
   * The decision(Win/Loose/Draw) is made in this method
	 * @param - NO
	 * 			No param for this Method
	 */
	private void playGame(){
    System.out.println("You Made a GREAT CHOICE!!!");
		System.out.println(ANSI_CYAN+"Welcome to Connect 4 Come and Let play with Intelligent Computer"+ANSI_RESET);
    System.out.println("This is a Player "+ANSI_RED+"red"+ANSI_RESET+" play with the Computer");
		System.out.println("Player is "+ANSI_RED+"Red"+ANSI_RESET+", Computer is "+ANSI_YELLOW+"Yellow"+ANSI_RESET);
		System.out.println("");
    //Print the Board in the beginning of the game
		myBoard.printBoard();
		boolean win = false;
    boolean firstPlayerMoved=false;
    char howConnected = 0;
    boolean isFull = true;
    int move = 0;
		while(!win){
      try{
        //Check if the board is available for further play
        isFull = myBoard.isBoardFull();	
        if(!isFull){
          // Read the input from the user and parse it to Integer
          move = player.getMove();
          howConnected = 0;
          if((move<1 || move>7) && !firstPlayerMoved){
            System.out.println(ANSI_RED+"Exception: Invalid input Try again with Valid Numbers from 1 to 7"+ANSI_RESET);
          }else if(myBoard.isColumnFull(move)){
            System.out.println(ANSI_RED+"You can't play this Move as this column is already full! Try other than "+move+ANSI_RESET);
          }else if(!firstPlayerMoved){
            // player 1
            // Place the player move in the board
            myBoard.placeCounter('r',move);
            connection = new MyConnectConnection(myBoard.board);
            // This check will ensure if the connection is met in anyways like Horizontal, Vertical or Diagonal
            howConnected = connection.validateConnection('r');
            // Print the Board in the console again once after the counter is placed.
		        myBoard.printBoard();
            firstPlayerMoved=true;
            // haswon refer that this player won the game
            if(howConnected!=0){
              win = true;
              System.out.println(ANSI_CYAN+"############################################"+ANSI_RESET);
              System.out.println(ANSI_GREEN+"CONGRATULATIONS Red Player, You Have Won!!! By Connecting it "+ANSI_RESET+ANSI_CYAN+getConnectedDetails(howConnected)+ANSI_RESET);
              System.out.println(" ");
              myBoard.printFinalBoard(connection.getiArray(),connection.getjArray());
              System.out.println(ANSI_CYAN+"############################################"+ANSI_RESET);
            }
          }
        }else{
          // There is no space in the board then its a Draw
          win = true;
          System.out.println(ANSI_CYAN+"############################################"+ANSI_RESET);
          System.out.println(ANSI_GREEN+"Match Drawn!!! No more places left to play"+ANSI_RESET);
          System.out.println(ANSI_CYAN+"############################################"+ANSI_RESET);
        }
        isFull = myBoard.isBoardFull();	
        if(!isFull){
          if(firstPlayerMoved && !win){
            //player Computer
            // Place the computer move in the board without Random lib
            myBoard.placeCounterForComputer(move);
            //int compMove = computerMove.getMove();
            //myBoard.placeCounter('y',compMove);
            howConnected = 0;
            connection = new MyConnectConnection(myBoard.board);
            // This check will ensure if the connection is met in anyways like Horizontal, Vertical or Diagonal
            howConnected = connection.validateConnection('y');
            // Print the Board in the console again once after the counter is placed.
		        myBoard.printBoard();
            firstPlayerMoved=false;
            // haswon refer that this player won the game
            if(howConnected!=0){
              win = true;
              System.out.println(ANSI_CYAN+"############################################"+ANSI_RESET);
              System.out.println(ANSI_RED+"Red Player, You lost to the COMPUTER!!! Computer Won by Connecting it "+ANSI_RESET+ANSI_CYAN+getConnectedDetails(howConnected)+ANSI_RESET);
              System.out.println(" ");
              myBoard.printFinalBoard(connection.getiArray(),connection.getjArray());
              System.out.println(ANSI_CYAN+"############################################"+ANSI_RESET);
            }
          }
        }else{
          // There is no space in the board then its a Draw
          win = true;
          System.out.println(ANSI_CYAN+"############################################"+ANSI_RESET);
          System.out.println(ANSI_GREEN+"Match Drawn!!! No more places left to play"+ANSI_RESET);
          System.out.println(ANSI_CYAN+"############################################"+ANSI_RESET);
        }
      }catch(Exception e){
        System.out.println(ANSI_RED+"Exception: Invalid input Try again"+ANSI_RESET);
		  }
		}
	}
}
