import java.util.Scanner;

public class BattleBoats{

	private static int dronesRemaining;
	private static int missilesRemaining;
	private static int turns = 0;
	private static boolean validInput = false;
	private static int totalHealth;

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to BattleBoats!");
		System.out.println("Choose your difficulty: 'standard' or 'expert'");
		String gamemode = s.nextLine();
		
		while (validInput == false) {
			
			if (gamemode.equals("standard") || (gamemode.equals("expert"))){
				validInput = true;
			}
			else{
				System.out.println("Choose either standard or expert.");
				gamemode = s.nextLine();
			}
		}
		BattleBoatsBoard masterBoard =  new BattleBoatsBoard(gamemode);
		masterBoard.placeBoats();
		BattleBoatsBoard originalBoard = new BattleBoatsBoard(gamemode);
		for (int i =0; i<masterBoard.board.length; i++){
			for (int j =0; j<masterBoard.board.length; j++){
				originalBoard.board[i][j] = masterBoard.board[i][j];
			}
		}
		UserBoard userBoard =  new UserBoard(gamemode);
		masterBoard.placeBoats();
		
		if (gamemode.equals("standard")){
			totalHealth = 17;
		}
		else{
			totalHealth = 34;
		}
		
		boolean cont = true;

		while (cont == true){
			System.out.println(userBoard);
			turns ++;

			System.out.println("Turn count: " + turns);
			System.out.println("Select a action...");
			System.out.println("'fire', 'missile', 'drone', or 'quit'");

			String action = s.nextLine();

			if (action.equals("fire")){
				
				boolean inBounds = false;
				int row = -1;
				int col = -1;

				while (inBounds ==  false){
					System.out.println("Enter a row to fire on... (between 0 and " + (userBoard.getLength()-1)+")");
					row = s.nextInt();
					System.out.println("Enter a column to fire on... (between 0 and " + (userBoard.getLength()-1)+")");
					col = s.nextInt();
					if ((0 <= row) && (row < userBoard.getLength()) && (0 <= col) && (col < userBoard.getLength())){
						inBounds  = true;
					}
					else{
						System.out.println("Point outside of bounds, try again");
					}
				}
				
				int result = masterBoard.fire(row,col);
				if (result == 0){
					System.out.println("Miss!");
					userBoard.updateCoordinate(row,col,0);
				}
				else if (result == 1){
					System.out.println("Hit!");
					userBoard.updateCoordinate(row,col,1);
					totalHealth --;
					if (totalHealth < 1){
						System.out.println("Wow you're so cool you beat the game!!! You managed this amazing feat in "+ turns+ " turns.");
						System.out.println("Here is the revealed board:");
						System.out.println(masterBoard);
						cont = false;
					}
				}
				else if ((result == -1) || (result ==  -2)){
					turns ++;
					System.out.println("Penalty! This spot has already been hit, one extra turn added.");
					
				}

			}

			else if (action.equals("missile")){
				boolean inBounds = false;
				int row = -1;
				int col = -1;

				while (inBounds ==  false){
					System.out.println("Enter a row to fire on... (between 0 and " + (userBoard.getLength()-1)+")");
					row = s.nextInt();
					System.out.println("Enter a column to fire on... (between 0 and " + (userBoard.getLength()-1)+")");
					col = s.nextInt();
					if ((0 <= row) && (row < userBoard.getLength()) && (0 <= col) && (col < userBoard.getLength())){
						inBounds  = true;
					}
					else{
						System.out.println("Point outside of bounds, try again");
					}
				}
				int [] results = masterBoard.missile(row,col);
				int damageDone = 0;

				for (int i=0; i < results.length; i++){
					if (results[i]==-3){
						continue;
					}
					switch (i){
						case 0:
						userBoard.updateCoordinate(row,col,results[i]);
						break;

						case 1:
						userBoard.updateCoordinate(row,col+1,results[i]);
						break;

						case 2:
						userBoard.updateCoordinate(row,col-1,results[i]);
						break;

						case 3:
						userBoard.updateCoordinate(row+1,col,results[i]);
						break;

						case 4:
						userBoard.updateCoordinate(row+1,col+1,results[i]);
						break;

						case 5:
						userBoard.updateCoordinate(row+1,col-1,results[i]);
						break;

						case 6:
						userBoard.updateCoordinate(row-1,col+1,results[i]);
						break;

						case 7:
						userBoard.updateCoordinate(row-1,col,results[i]);
						break;

						case 8:
						userBoard.updateCoordinate(row-1,col-1,results[i]);
						break;
					}
					if (results[i]==1){
						damageDone ++;
					}

				}
				totalHealth -= damageDone;
				if (totalHealth < 1){
						System.out.println("Wow you're so cool you beat the game!!! You managed this amazing feat in "+ turns+ " turns.");
						System.out.println("Here is the revealed board:");
						System.out.println(masterBoard);
						cont = false;
					}


			}

			else if (action.equals("drone")){

			}

			else if (action.equals("quit")){

			}

			else{
				System.out.println("Please select a vaild input");
				turns --;
			}


		}
	}
}
