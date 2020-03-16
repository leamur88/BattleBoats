/* This class contains the user facing boards

Written by osmun046 and leibo023
*/

public class UserBoard{
	String[][] userBoard;
	
	public UserBoard(String gamemode){
		if (gamemode.equals("standard")){
			String[][] userBoard = {{"-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-",}};
		}
	
		else if (gamemode.equals("expert")){
			String[][] userBoard = {{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",},
									{"-","-","-","-","-","-","-","-","-","-","-","-",}};
		}
	}

	public void updateCoordinate(int row, int col, String entry){
		userBoard[row][col] = entry;
	}

	 
	public void display() {  //Displays current board state. Void because it will use println()
		System.out.println(this.toString()); 
	}

	public String toString(){
		String boardResult = "";
		System.out.println("Hello");
		System.out.println(userBoard.length);
		System.out.println("Goodbye");
		for (int i = 0; i < userBoard.length; i++){
			boardResult+= "\n";
			for (int j = 0; j < userBoard.length; j++){
				boardResult += userBoard[i][j];
				}
		}
		return boardResult;
	}

		// for (int i = 0; i < userBoard.length; i++){
		//     for (int j = 0; j < userBoard.length; j++){
		//         boardResult += userBoard[i][j]; 
		//     }
		// }
		// return boardResult;

	public int getLength(){
		return userBoard.length;
	}

	public static void main(String[] args){
		UserBoard expertUserBoard = new UserBoard("expert");

		expertUserBoard.display();
	}
}
	