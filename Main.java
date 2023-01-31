/* 
    ____________________________________________________________________
    |   Class Name: Main                                                |
    |   Description: Up on execution of this class, this will explain   |
    |                 game and will ask user to select the mode         |
    |   Created on: 06-Dec-2021                                         |
    |                                                                   |
    |   OTHER CLASS:                                                    |
    |       1. MyConnectFour - Implementation of Two player mode game   |
    |       2. MyConnectFourComputer - Implementation of a game with    |
    |                                       Computer                    |
    |       3. PlayerMove - Reads the user input - used for selecting   |
    |                       the mode and placing the counter position   |
    |       4. ComputerMove - First started with Random then created    |
    |                         an manipulation in placing the counter    |
    |                         Hence this class is not used now.         |
    |       5. MyBoard - Implementation of board display and placing    |
    |                       the counter                                 |
    |       6. MyConnectConnection - Class for Validating the connection|
    |       7. DisplayFormatting - Class for formatting the console     |
    |                                   output < Added some Colors>     |
    |___________________________________________________________________|
    
*/
class Main {
  public static void main(String[] args) {
    // These variables are used to color the sysout in the console
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_BLUE = "\u001B[34m";
    final PlayerMove player = new PlayerMove();

    System.out.println("#########################################################");
    System.out.println(ANSI_BLUE+"Welcome to Connect 4"+ANSI_RESET);
    System.out.println(ANSI_BLUE+"This is a two player game "+ANSI_RESET+ANSI_RED+"(TWO PLAYERS OR ONE PLAYER WITH COMPUTER) "+ANSI_RESET+ANSI_BLUE+" in two Modes, You can select your mode"+ANSI_RESET);
    System.out.println("#########################################################");
    System.out.println(ANSI_BLUE+"MODE -1: Two players can play it. First person is red player(r) and the Second Person is yellow player(y)"+ANSI_RESET);
    System.out.println(ANSI_BLUE+"MODE -2: A player can play against intelligent computer. Player is red player(r) and the Computer is yellow player(y)"+ANSI_RESET);
    System.out.println("#########################################################");
    System.out.println(ANSI_BLUE+"To play the game type in the number of the column you want to drop you counter in"+ANSI_RESET);
		System.out.println(ANSI_BLUE+"A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally"+ANSI_RESET);
    boolean validChoice = false;
		while(!validChoice){
      System.out.println("*********************************************************");
      System.out.println(ANSI_RED+"Enter your MODE (1/2): "+ANSI_RESET);

      try{			
        // Read the input from the user and parse it to Integer
        int userChoice = player.getMove();

        if(userChoice==1){
          // Two player mode
          new MyConnectFour();
          validChoice = true;
        }else if(userChoice==2){
          // One Player with the computer mode
          new MyConnectFourComputer();
          validChoice = true;
        }else{
          System.out.println(ANSI_RED+"INVALID CHOICE SELECT 1 or 2 to PROCEED"+ANSI_RESET);
          validChoice = false;
        }
      }catch(Exception e){
        System.out.println(ANSI_RED+"Exception: Invalid input Try again "+ANSI_RESET);
      }
    }
  }
}