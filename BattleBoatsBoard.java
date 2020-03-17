/* This class contains all functions and methods used by BattleBoatsGame class

Written by osmun046 and leibo023
*/

public class BattleBoatsBoard{
		Boats[][] board;
		int totalShots = 0;
		int turns = 0;
		int shipsRemaining;
		String gamemode;

		public BattleBoatsBoard(String gamemode){ //Constructor. Makes a square board 8 by 8 or 12 by 12 depending on difficulty string given
				this.gamemode = gamemode;
				if (gamemode.equals("standard")){
						board = new Boats[8][8];
				}

				else if (gamemode.equals("expert")){
						board = new Boats[12][12];
				}
		}

		public String toString(){  //toString for master board. Used at the end of the game or when quitting
				String boardResult = "";

				for (int i = 0; i < board.length; i++){
						boardResult+= "\n";
						for (int j = 0; j < board.length; j++){
								if (!(board[i][j] instanceof Boats)){
									boardResult += "[  ] ";
								}
								else{
								 boardResult += board[i][j];
								}

						}
				}
				return boardResult;
		}

		public Boats getBoat(int row, int col){  //Helper to return a boat object. Used for debugging mostly.
			return this.board[row][col];
		}

		public void placeBoats() {  //Randomly places boats on board
									//First checks gamemode to determine how many boats should be placed.
									//Randomly chooses a point, orentation, and direction to build the boat.
									//If the boat leaves the board or overlaps another boat, a new point, orentation, and direction are chosen
				//Version for standard mode
				if (this.gamemode.equals("standard")){
						Boats boat5a = new Boats(5, "a");
						Boats boat4a = new Boats(4, "a");
						Boats boat3a = new Boats(3, "a");
						Boats boat3b = new Boats(3, "b");
						Boats boat2a = new Boats(2, "a");

						Boats[] boatSizes = {boat5a, boat4a, boat3a, boat3b, boat2a};

						for (int i =0; i < boatSizes.length; i++){
								boolean fits = false;

								while (fits == false){
										int x = (int)Math.floor(Math.random() * 8.0);
										int y = (int)Math.floor(Math.random() * 8.0);

										boolean horizontal = true;
										if (Math.random() < 0.5){
												horizontal = false;
										}

										boolean left = true;
										if (Math.random() < 0.5){
												left = false;
										}

										boolean inTheWay = false;

										if (horizontal && left){ //Horizontal and left
												if (((x+1) - boatSizes[i].getLength()) >= 0){//Checks if boat can fit on board

													for (int k=0; k<boatSizes[i].getLength(); k++){

														if (board[y][x-k] instanceof Boats){ //check if different boat is in the way
															inTheWay = true;
															break;
														}
													}

													if (!inTheWay){
														fits = true;
														for (int j=0; j<boatSizes[i].getLength(); j++){
															board[y][x-j]=boatSizes[i];
														}
													}
												}
										}

										else if (horizontal && !left){  //Horizontal and right
											if (x + boatSizes[i].getLength() <= 8){

												for (int k=0; k<boatSizes[i].getLength(); k++){
													if (board[y][x+k] instanceof Boats){ //check if different boat is in the way
														inTheWay = true;
														break;
													}
												}

												if (!inTheWay){
													fits = true;
													for (int j=0; j<boatSizes[i].getLength(); j++){
															board[y][x+j]=boatSizes[i];
													}
												}
											}
										}

										else if (!horizontal && left){  //Vertical and up
											if ((y+1) - boatSizes[i].getLength() >= 0){

													for (int k=0; k<boatSizes[i].getLength(); k++){
														if (board[y-k][x] instanceof Boats){
															inTheWay = true;
															break;
														}
													}
													if (!inTheWay){
														fits = true;
														for (int j=0; j<boatSizes[i].getLength(); j++){
															board[y-j][x]=boatSizes[i];
														}
													}

											}
										}

										else if (!horizontal && !left){  //Vertical and down
											if (y + boatSizes[i].getLength() <= 8){

													for (int k=0; k<boatSizes[i].getLength(); k++){
														if (board[y+k][x] instanceof Boats){
															inTheWay = true;
															break;
														}
													}
													if (!inTheWay){
														fits = true;
														for (int j=0; j<boatSizes[i].getLength(); j++){
															board[y+j][x]=boatSizes[i];
														}
													}
											}
										}
								}
						}
				}

				//Version for expert mode
				if (this.gamemode.equals("expert")){
						Boats boat5a = new Boats(5, "a");
						Boats boat5b = new Boats(5, "b");
						Boats boat4a = new Boats(4, "a");
						Boats boat4b = new Boats(4, "b");
						Boats boat3a = new Boats(3, "a");
						Boats boat3b = new Boats(3, "b");
						Boats boat3c = new Boats(3, "c");
						Boats boat3d = new Boats(3, "d");
						Boats boat2a = new Boats(2, "a");
						Boats boat2b = new Boats(2, "b");

						Boats[] boatSizes = {boat5a, boat5b, boat4a, boat4b, boat3a, boat3b, boat3c, boat3d, boat2a, boat2b};

						for (int i =0; i < boatSizes.length; i++){
								boolean fits = false;

								while (fits == false){
										int x = (int)Math.floor(Math.random() * 12.0);
										int y = (int)Math.floor(Math.random() * 12.0);

										boolean horizontal = true;
										if (Math.random() < 0.5){
												horizontal = false;
										}

										boolean left = true;
										if (Math.random() < 0.5){
												left = false;
										}

										boolean inTheWay = false;

										if (horizontal && left){ //Horizontal and left
												if (((x+1) - boatSizes[i].getLength()) >= 0){ //Checks if boat can fit on board

													for (int k=0; k<boatSizes[i].getLength(); k++){

														if (board[y][x-k] instanceof Boats){ //check if different boat is in the way
															inTheWay = true;
															break;
														}
													}

													if (!inTheWay){
														fits = true;
														for (int j=0; j<boatSizes[i].getLength(); j++){
															board[y][x-j]=boatSizes[i];
														}
													}
												}
										}

										else if (horizontal && !left){  //Horizontal and right
											if (x + boatSizes[i].getLength() <= 12){

												for (int k=0; k<boatSizes[i].getLength(); k++){
													if (board[y][x+k] instanceof Boats){ //check if different boat is in the way
														inTheWay = true;
														break;
													}
												}

												if (!inTheWay){
													fits = true;
													for (int j=0; j<boatSizes[i].getLength(); j++){
															board[y][x+j]=boatSizes[i];
													}
												}
											}
										}

										else if (!horizontal && left){  //Vertical and up
											if ((y+1) - boatSizes[i].getLength() >= 0){

													for (int k=0; k<boatSizes[i].getLength(); k++){
														if (board[y-k][x] instanceof Boats){
															inTheWay = true;
															break;
														}
													}

													if (!inTheWay){
														fits = true;
														for (int j=0; j<boatSizes[i].getLength(); j++){
															board[y-j][x]=boatSizes[i];
														}
													}

											}
										}

										else if (!horizontal && !left){  //Vertical and down
											if (y + boatSizes[i].getLength() <= 12){

													for (int k=0; k<boatSizes[i].getLength(); k++){
														if (board[y+k][x] instanceof Boats){
															inTheWay = true;
															break;
														}
													}
													if (!inTheWay){
														fits = true;
														for (int j=0; j<boatSizes[i].getLength(); j++){
															board[y+j][x]=boatSizes[i];
														}
													}
											}
										}
								}
						}
				}
		}

		public int fire(int row, int col){  //Fires at coordinate (x,y). Used in BattleBoats.
				//Returns 1 for a hit, 0 for a miss, -1 for a penalty

			if (board[row][col] == null){
				board[row][col] = Boats.missedSpot;
				return 0;
			}

			else if (board[row][col].getHealth() == -1 || board[row][col].getHealth() == -2){
				return -1;
			}

			else if (board[row][col].getHealth() > 0){
				board[row][col].loseHealth();
				if (board[row][col].getHealth() == 0){
					System.out.println("You have sunk a boat!");
				}

				board[row][col] = Boats.hitBoat;
				return 1;
			}

			else{
				return -8;
			}
		}

		public int missileFire(int row, int col) {  //Fires at coordinate (x,y). Version used only in the missile.
				//Returns 1 for a hit, 0 for a miss, -2 for already been hit so change nothing because there is no penalty

			if (board[row][col] == null){
				board[row][col] = Boats.missedSpot;
				return 0;
			}

			else if (board[row][col].getHealth() == -1 || board[row][col].getHealth() == -2){
				return -2;
			}

			else{
				board[row][col].loseHealth();
				board[row][col] = Boats.hitBoat;
				return 1;
			}
		}


		public int [] missile(int row, int col){  //Fires missile at (x,y), will call fire on (x-1,y-1);(x,y-1);(x+1,y-1);(x-1,y);(x,y);(x+1,y);(x-1,y-1);(x,y-1);(x+1,y-1)
			int [] resultOfMissile = {-3,-3,-3,-3,-3,-3,-3,-3,-3}; // array of results of missile strike, -3 indicates that that area was not hit because it was out of bounds
			if ((0 <= row) && (row < board.length) && (0 <= col) && (col < board.length)){//Rendundant check but ensures we don't have to check again for all the other cases
				if ((board[row][col] != null) && (board[row][col].getHealth()==1)){//checks to see if the spot about to get hit will sink the boat.
					System.out.println("You have sunk a boat!");
				}
				resultOfMissile[0] = this.missileFire(row,col);
				//The missile result array is filled with -3 to start in case one of the other 8 blocks the missile is intended to hit is out of bounds
				if ((col+1 < board.length)){
					if ((board[row][col+1] != null) && (board[row][col+1].getHealth()==1)){//this also checks to see if the spot intended to get hit is null in order to prevent nullPointerExceptions from .getHealth()
					System.out.println("You have sunk a boat!");
					}
					resultOfMissile[1] = this.missileFire(row,col+1);
				}

				if ((0 <= col-1)){
					if ((board[row][col-1] != null) && (board[row][col-1].getHealth()==1)){
					System.out.println("You have sunk a boat!");
					}
					resultOfMissile[2] = this.missileFire(row,col-1);
				}

				if ((row+1 < board.length)){
					if ((board[row+1][col] != null) && (board[row+1][col].getHealth()==1)){
					System.out.println("You have sunk a boat!");
					}
					resultOfMissile[3] = this.missileFire(row+1,col);
				}

				if ((row+1 < board.length) && (col+1 < board.length)){
					if ((board[row+1][col+1] != null) && (board[row+1][col+1].getHealth()==1)){
					System.out.println("You have sunk a boat!");
					}
					resultOfMissile[4] = this.missileFire(row+1,col+1);
				}

				if ((row+1 < board.length) && (col-1 >= 0)){
					if ((board[row+1][col-1] != null) && (board[row+1][col-1].getHealth()==1)){
					System.out.println("You have sunk a boat!");
					}
					resultOfMissile[5] = this.missileFire(row+1,col-1);
				}

				if ((row-1 >= 0 ) && (col+1 < board.length)){
					if ((board[row-1][col+1] != null) && (board[row-1][col+1].getHealth()==1)){
					System.out.println("You have sunk a boat!");
					}
					resultOfMissile[6] = this.missileFire(row-1,col+1);
				}

				if (row-1 >= 0){
					if ((board[row-1][col] != null) && (board[row-1][col].getHealth()==1)){
					System.out.println("You have sunk a boat!");
					}
					resultOfMissile[7] = this.missileFire(row-1,col);
				}

				if ((row-1 >= 0 ) && (col-1 >= 0)){
					if ((board[row-1][col-1] != null) && (board[row-1][col-1].getHealth()==1)){
					System.out.println("You have sunk a boat!");
					}
					resultOfMissile[8] = this.missileFire(row-1,col-1);
				}
				return resultOfMissile;
			}

			else{
				System.out.println("Coordinate not in bounds");
				return resultOfMissile;
			}
		}

		public int drone(String direction, int index) {  //Scans a row or column. Updates the user with the amount of boats in the row
			int count = 0;

			if (direction.equals("row")){
				for (int i = 0; i < this.board[index].length; i++){
					if ((this.board[index][i] instanceof Boats) && (this.board[index][i].getHealth() != -2)){
						count ++;
					}
				}
			}

			else if (direction.equals("column")){
				for (int i = 0; i < this.board[0].length; i++){
					if (this.board[i][index] instanceof Boats && this.board[i][index].getHealth() != -2){
						count ++;
					}
				}
			}
			return count;
		}

		public static void main(String[] args){  //No longer used main test method.
			// BattleBoatsBoard thisboard = new BattleBoatsBoard("standard");
			// thisboard.placeBoats();
			// System.out.println(thisboard);


			// // BattleBoatsBoard newboard = new BattleBoatsBoard("expert");
			// // System.out.println(newboard);
			// // newboard.placeBoats();

			// // System.out.println(newboard);

			// thisboard.missile(3,4);

			// System.out.println(thisboard);

			// System.out.println(thisboard.drone("row", 3));
		}

}
