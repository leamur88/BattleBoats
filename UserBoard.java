/* This class contains the user facing boards

Written by osmun046 and leibo023
*/

public class UserBoard{
	public String[][] userBoard;
	
	public UserBoard(String gamemode){  //Constructor for the userBoard object. Creates userBoard size depending on gamemode difficulty
		if (gamemode.equals("standard")){
			this.userBoard = new String[8][8];
		}
	
		else if (gamemode.equals("expert")){
            this.userBoard = new String[12][12];
        }
            
        for (int i = 0; i < userBoard[0].length; i++){
            for (int j = 0; j < userBoard[0].length; j++){
                userBoard[i][j] = "[  ] ";
            }
        }
	}

    public void updateCoordinate(int row, int col, int entry){  //Helper method to update a coordinate on the userBoard
                                                                //Used in BattleBoats when a location is hit
		if (entry == 0){
			userBoard[row][col] = "[OO] ";
		}
		else if (entry == 1){
			userBoard[row][col] = "[XX] ";
		}
		else if ((entry == -1) || (entry == -2)){
			userBoard[row][col] = userBoard[row][col];
		}

		else{
			userBoard[row][col] = "ERROR";
		}
	}

	 
	public void display(){  //Displays current board state. Void because it will use println()
		System.out.println(this.toString()); 
	}

	public String toString(){  //toString method for the userBoard
		String boardResult = "";
	
		for (int i = 0; i < userBoard.length; i++){
			boardResult+= "\n";
			for (int j = 0; j < userBoard.length; j++){
				boardResult += userBoard[i][j];
			}
		}
		return boardResult;
	}

	public int getLength(){  //Returns the size of the userBoard
		return userBoard.length;
	}

	public static void main(String[] args){ //No longer used main test method
		// UserBoard expertUserBoard = new UserBoard("standard");

		// expertUserBoard.display();
	}
}
	