/* 
    ____________________________________________________________________
    |   Class Name: DisplayFormatting                                   |
    |   Description: This is the utility class and will be used         |
    |                 for formatting                                    |
    |   Created on: 06-Dec-2021                                         |
    |___________________________________________________________________|
    
*/
class DisplayFormatting{
  //ENCAPSULATION - Access via sub class / same package
  protected final String ANSI_RESET = "\u001B[0m";
  protected final String ANSI_RED = "\u001B[31m";
  protected final String ANSI_GREEN = "\u001B[32m";
  protected final String ANSI_YELLOW = "\u001B[33m";
  protected final String ANSI_BLUE = "\u001B[34m";
  protected final String ANSI_PURPLE = "\u001B[35m";
  protected final String ANSI_CYAN = "\u001B[36m";
  protected final String ANSI_RED_RESULT = "\u001b[41m";
  protected final String ANSI_YELLOW_RESULT = "\u001b[43m";

  public String getConnectedDetails(char howConnected){
    String connection = "";
    if(howConnected=='V'){
      connection = "Vertically";
    }else if(howConnected=='H'){
      connection = "Horizontally";
    }else if(howConnected=='D'){
      connection = "Diagonally";
    }else if(howConnected=='C'){
      connection = "Counter Diagonaly";
    }
    return connection;
  }
}