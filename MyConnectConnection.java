import java.util.ArrayList; 
import java.util.List; 
/* 
    ____________________________________________________________________
    |   Class Name: MyConnectConnection                                 |
    |   Description: This is the utility class and will be called up on |
    |                 from the classes MyConnectFour.java and           |
    |                 MyConnectFourComputer.java to validate the board  |
    |   Created on: 06-Dec-2021                                         |
    |___________________________________________________________________|
    
*/
// Extending Another class - INHERITANCE
public class MyConnectConnection {

  // Private variables, these variables are accessible only within this class - Encapsulation
  private char[][] board;
  List<Integer> iArray = new ArrayList<>();
  List<Integer> jArray = new ArrayList<>();

  /**
	 * Constructor of this class, this constructor will get execute everytime this connection class is initialised
	 * @param - board
   *          Board instance
	 */
  MyConnectConnection(char[][] board) {
    this.board=board;
  }

  /**
	 * Method to validate all sort of connections such as 
   *      Vertical, Horizontal , Diagonal and Counter Diagonal
	 * @param - player
	 * 			char to identify the player (r or y)
	 */
  public char validateConnection(char player){
    // check Horizontal
    char howConnected=0;
    int count=0;
    iArray = new ArrayList<>();
    jArray = new ArrayList<>();
    for(int i=0; i<board.length; i++){
      for(int j=0; j<board[i].length; j++){
        if(board[i][j] == player){
          count = count + 1;
          iArray.add(i);
          jArray.add(j);
          if(count >= 4){
            howConnected='H';
            return howConnected;
          }
        }
        else{
          count = 0;
          iArray = new ArrayList<>();
          jArray = new ArrayList<>();
        }
      }
      count = 0;
      iArray = new ArrayList<>();
      jArray = new ArrayList<>();
    }

    iArray = new ArrayList<>();
    jArray = new ArrayList<>();
    // check Vertical
    for(int i=0; i<board[0].length; i++){
      for(int j=0; j<board.length; j++){
        if(board[j][i] == player){
          count = count + 1;
          iArray.add(j);
          jArray.add(i);
          if(count >= 4){
            howConnected='V';
            return howConnected;
          }
        }
        else{
          count = 0;
          iArray = new ArrayList<>();
          jArray = new ArrayList<>();
        }
      }
      count = 0;
      iArray = new ArrayList<>();
      jArray = new ArrayList<>();
    }

    iArray = new ArrayList<>();
    jArray = new ArrayList<>();
    // check Diagonal
    for(int i=0; i<board.length-3; i++){
      for(int j=0; j<board[i].length-3; j++){
        int element = board[i][j];
        if(element == player &&
            element == board[i + 1][j + 1] && 
            element == board[i + 2][j + 2] && 
            element == board[i + 3][j + 3]){
              howConnected='D';
              iArray.add(i);
              iArray.add(i+1);
              iArray.add(i+2);
              iArray.add(i+3);
              jArray.add(j);
              jArray.add(j+1);
              jArray.add(j+2);
              jArray.add(j+3);
              return howConnected;
        }
      }
    }

    iArray = new ArrayList<>();
    jArray = new ArrayList<>();
    // check Counter Diagonal
    for(int i=0; i<board.length-3; i++){
      for(int j=3; j<board[i].length; j++){
        int element = board[i][j];
        if(element == player &&
            element == board[i + 1][j - 1] && 
            element == board[i + 2][j - 2] && 
            element == board[i + 3][j - 3]){
              howConnected='C';
              iArray.add(i);
              iArray.add(i+1);
              iArray.add(i+2);
              iArray.add(i+3);
              jArray.add(j);
              jArray.add(j-1);
              jArray.add(j-2);
              jArray.add(j-3);
              return howConnected;
        }
      }
    }
    return howConnected;
  }

  public List<Integer> getiArray(){
    return iArray;
  }

  public List<Integer> getjArray(){
    return jArray;
  }
}