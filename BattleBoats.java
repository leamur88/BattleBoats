/* This class contains the main driver method and any helpers

Written by osmun046 and leibo023
*/

import java.util.Scanner;

public class BattleBoats{

private static int dronesRemaining;
private static int missilesRemaining;
private static int turns = 0;
private static boolean validInput = false;
private static int totalHealth;

public static void printBoard(String[][] originalBoard){  //Helper method to print original board
	String boardResult = ""; //For loops to print the original board
						for (int i = 0; i < originalBoard.length; i++){
							boardResult += "\n";
							for (int j = 0; j < originalBoard.length; j++){
								boardResult += originalBoard[i][j];
							}
						}
				System.out.println(boardResult);
}
public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	System.out.print("\n\n\nWELCOME TO BATTLE BOATS! \n************************\n \n"
						+ "| BattleBoats is a board game where you will attempt to sink all \n"
						+ "| of your opponents ships. You must use your smarts to strategically uncover \n"
						+ "| and sink all of your opponents vessels in the fewest moves possible. \n"
						+ "| \n"
						+ "| There are two difficulties, standard and expert. Expert has a \n"
						+ "| larger board and twice as many ships to sink! \n"
						+ "| \n"
						+ "| You have a number of tools at you disposal including the basic fire \n"
						+ "| function, the drone, ad missiles! (They go 'BOOM!') An explanation of \n"
						+ "| these functions are given below... \n"
						+ "| \n"
						+ "| >>>FIRE: Basic attack function. Will hit one square and tell you if there \n"
						+ "| was a boat there or not. You can use fire an unlimited number if times. \n"
						+ "| \n"
						+ "| >>>MISSILE: Missile hit a 3 by 3 square centered at the point you enter. \n"
						+ "| Like fire, it will show what boats were found in that square. In standard \n"
						+ "| mode you have only one missile available, in expert mode you have two. \n"
						+ "| \n"
						+ "| >>>DRONE: Drone allows you to scan one row or column of the board. When the \n"
						+ "| returns, it will tell you how many ships it found in that row or column. \n"
						+ "| The drone will count both sunk and unsunk ships. \n"
						+ "| \n"
						+ "| If you want to quit the game before it is done enter 'quit'.\n"
						+ "| \n"
						+ "| Ready to play? Here we go! \n \n");

	System.out.println("Choose your difficulty: 'standard' or 'expert'");
	String gamemode = s.next().trim().toLowerCase();

	while (validInput == false){  //Will loop until the gamemode is valid

		if (gamemode.equals("standard") || (gamemode.equals("expert"))){
			validInput = true;
		}
		else{
			System.out.println("Choose either standard or expert.");
			gamemode = s.next().trim().toLowerCase();  //Will strip whitespace and convert to all lowercase. Used on all string inputs.
		}
	}

	BattleBoatsBoard masterBoard = new BattleBoatsBoard(gamemode);  //Creates master board with gamemode input
	masterBoard.placeBoats();  //Places boats on the master board

	String [][] originalBoard;
	if (gamemode.equals("standard")){  //This block creates a string version of the master board to display at the end of the game
		originalBoard = new String[8][8];
	}
	else{
		originalBoard = new String[12][12];
	}
	for (int i = 0; i<masterBoard.board.length; i++){
		for (int j = 0; j<masterBoard.board.length; j++){
			if (masterBoard.board[i][j] == null){
				originalBoard[i][j] = "[  ] ";
			}
			else{
				originalBoard[i][j] = masterBoard.board[i][j].toString();
			}
		}
	}
	UserBoard userBoard = new UserBoard(gamemode);  //Creates a userBoard with the gamemode input

	if (gamemode.equals("standard")){  //Sets game variables according to gamemode input
		totalHealth = 17;
		dronesRemaining = 1;
		missilesRemaining = 1;
	}

	else if (gamemode.equals("expert")){
		totalHealth = 34;
		dronesRemaining = 2;
		missilesRemaining = 2;
	}

	boolean cont = true;

//MAIN WHILE LOOP CONTINUES WHILE THE GAME RUNS
	while (cont == true){  //Main continue boolean
		System.out.println("\n***********************************************************\n");
		System.out.println(">>>TURN " + (turns + 1) + "<<<");
		System.out.println("Missiles left: " + missilesRemaining);
		System.out.println("Drones left: " + dronesRemaining);
		System.out.println(userBoard);
		System.out.println();
		turns ++;

		System.out.println("Enter a action...");
		System.out.println("'fire', 'missile', 'drone', or 'quit'");

		String action = s.next().trim().toLowerCase();

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
					System.out.println("Point out of bounds, try again.\n");
				}
			}

			int result = masterBoard.fire(row, col);
			if (result == 0){
				System.out.println("\nMISS!");
				userBoard.updateCoordinate(row, col, result);
			}
			else if (result == 1){
				System.out.println("\nHIT!");
				userBoard.updateCoordinate(row, col, 1);
				totalHealth--;
				if (totalHealth < 1){
					System.out.println("Wow you are SO cool! You sunk all the ships! You managed this amazing feat in "+ turns+ " turns.");
					System.out.println("Here is the revealed board:");
					printBoard(originalBoard);
					cont = false;
				}
			}

			else if ((result == -1) || (result ==  -2)){
				turns++;
				System.out.println("\nPenalty! This spot has already been hit, one extra turn added.");
			}
		}


//MISSLE
		else if (action.equals("missile")){
			if (missilesRemaining > 0){
				boolean inBounds = false;
				int row = -1;
				int col = -1;

				while (inBounds ==  false){//Simply checks if initial missile spot is in bounds
					System.out.println("Enter a row to fire on... (between 0 and " + (userBoard.getLength()-1)+")");
					row = s.nextInt();
					System.out.println("Enter a column to fire on... (between 0 and " + (userBoard.getLength()-1)+")");
					col = s.nextInt();
					if ((0 <= row) && (row < userBoard.getLength()) && (0 <= col) && (col < userBoard.getLength())){
						inBounds  = true;
					}
					else{
						System.out.println("Point outside of bounds, try again stupid.\n");
					}
				}

				int [] results = masterBoard.missile(row,col);
				int damageDone = 0;

				for (int i = 0; i < results.length; i++){
					if (results[i] == -3){//This catches all of the inidicies whose location is not in bounds
						continue;
					}
					switch (i){//Each index in the missileResults array is associated with a position relative to the row and col the missile was asssigned to.
						case 0:
						userBoard.updateCoordinate(row, col, results[i]);
						break;

						case 1:
						userBoard.updateCoordinate(row, col+1, results[i]);
						break;

						case 2:
						userBoard.updateCoordinate(row, col-1, results[i]);
						break;

						case 3:
						userBoard.updateCoordinate(row+1, col, results[i]);
						break;

						case 4:
						userBoard.updateCoordinate(row+1, col+1, results[i]);
						break;

						case 5:
						userBoard.updateCoordinate(row+1, col-1, results[i]);
						break;

						case 6:
						userBoard.updateCoordinate(row-1, col+1, results[i]);
						break;

						case 7:
						userBoard.updateCoordinate(row-1, col, results[i]);
						break;

						case 8:
						userBoard.updateCoordinate(row-1, col-1, results[i]);
						break;
					}
					if (results[i] == 1){
						damageDone ++;
					}
				}

				totalHealth -= damageDone;
				missilesRemaining --;
				System.out.println("\nYou now have " + missilesRemaining + " missiles remaining.");
				if (totalHealth < 1){
						System.out.println("Wow you are SO cool! You sunk all the ships! You managed this amazing feat in "+ turns+ " turns.");
						System.out.println("Here is the revealed board:");
						printBoard(originalBoard);
						cont = false;
				}
			}
			else{
				System.out.println("You have no more missles remaining, silly.");
			}
		}

//DRONE
		else if (action.equals("drone")){
			String direction = "";
			int index = -1;
			boolean droneCont = true;

			while (droneCont = true){
				if (dronesRemaining > 0){

					boolean validDirection = false;
					while (validDirection == false){
						System.out.println("Would you like to scan a 'row' or 'column'?");
						direction = s.next().trim().toLowerCase();
						if (direction.equals("row") || direction.equals("column")){
						validDirection = true;
						}
						else{
							System.out.println("Enter 'row' or 'column'.");
						}
					}

					boolean validIndex = false;
					while (validIndex == false){
						System.out.println("What " + direction + " would you like to scan? (between 0 and " + (userBoard.getLength() - 1) + ")");
						index = s.nextInt();
						if (index > 0 && index <= userBoard.getLength()){
							validIndex = true;
						}
						else {
						System.out.println("Must be between 1 and " + (userBoard.getLength() - 1) +".");
						}
					}

						if (direction.equals("row")){
							System.out.println("\n" + masterBoard.drone("row", index) + " ships were found in this " + direction + " (hit or unhit).");
							droneCont = false;
							dronesRemaining --;
							System.out.println("\nYou now have " + dronesRemaining + " drones remaining.");
							break;
						}

						else if (direction.equals("column")){
							System.out.println("\n" + masterBoard.drone("column", index) + " ships were found in this " + direction + " (hit or unhit).");
							droneCont = false;
							dronesRemaining --;
							System.out.println("\nYou now have " + dronesRemaining + " drones remaining.");
							break;
						}
					}

				else{
					System.out.println("You have no more drones remaining, you imbecile!");
					droneCont = false;
					turns --;
					break;
				}
			}
		}

//QUIT
		else if (action.equals("quit")){
			System.out.println("You lose! HAHAHHAHAH!");
			System.out.println("It took you " + turns + " turns to finally give up! \n");
			System.out.println("Here is the original board: \n");
			printBoard(originalBoard);
			System.out.println();
			cont = false;
		}

//INVALID INPUT
		else{
			System.out.println("Please enter a vaild input.");
			turns --;
		}
		}
		s.close();
	}

}
