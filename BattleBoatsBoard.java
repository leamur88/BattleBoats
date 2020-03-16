/* This class contains all functions and methods used by BattleBoatsGame class

Written by osmun046 and leibo023
*/

public class BattleBoatsBoard {
		Boats[][] board;
		int totalShots = 0;
		int turns = 0;
		int shipsRemaining;
		String gamemode;

		public BattleBoatsBoard(String gamemode) { //Constructor. Makes a square board of int size
				this.gamemode = gamemode;
				if (gamemode.equals("standard")){
						board = new Boats[8][8];
						

				}

				else if (gamemode.equals("expert")){
						board = new Boats[12][12];
				}

				else {
						System.out.println("Choose either standard or expert.");
				}
		}

		public String toString(){
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

		public Boats getBoat(int row, int col){
			return this.board[row][col];
		}



		public void placeBoats() {  //Randomly places boats on board
				if (this.gamemode.equals("standard")){
						Boats boat5a = new Boats(5, "a");
						Boats boat4a = new Boats(4, "a");
						Boats boat3a = new Boats(3, "a");
						Boats boat3b = new Boats(3, "b");
						Boats boat2a = new Boats(2, "a");


						Boats[] boatSizes = {boat5a, boat4a, boat3a, boat3b, boat2a};


						for (int i =0; i < boatSizes.length; i++) {
								boolean fits = false;

								while (fits == false){
										int x = (int)Math.floor(Math.random() * 8.0);
										int y = (int)Math.floor(Math.random() * 8.0);

										boolean horizontal = true;
										if (Math.random() < 0.5) {
												horizontal = false;
										}

										boolean left = true;
										if (Math.random() < 0.5) {
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

						for (int i =0; i < boatSizes.length; i++) {
								boolean fits = false;

								while (fits == false){
										int x = (int)Math.floor(Math.random() * 12.0);
										int y = (int)Math.floor(Math.random() * 12.0);

										boolean horizontal = true;
										if (Math.random() < 0.5) {
												horizontal = false;
										}

										boolean left = true;
										if (Math.random() < 0.5) {
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


		public int fire(int row, int col) {  //Fires at coordinate (x,y)
				//Returns 1 for a hit, 0 for a miss, -1 for a penalty
				//Must update userBoard location hit with miss or hit
			

			if (board[row][col] == null){
				System.out.println("Miss");
				return 0;
				
			}

			else if (board[row][col].getHealth() == -1){
				System.out.println("Penalty");
				return -1;
				
			}
			
			else{
				System.out.println(board[row][col]);
				board[row][col].loseHealth();
				board[row][col] = Boats.hitBoat;
				System.out.println("HIT");
				return 1;
				
				
			}
		}


		public void missile(int row, int col) {  //Fires missile at (x,y), will call fire on (x-1,y-1);(x,y-1);(x+1,y-1);(x-1,y);(x,y);(x+1,y);(x-1,y-1);(x,y-1);(x+1,y-1)
			this.fire(row-1,col-1);
			this.fire(row-1,col);
			this.fire(row,col-1);
			this.fire(row,col);
			this.fire(row+1,col);
			this.fire(row,col+1);
			this.fire(row+1,col+1);
			this.fire(row+1,col-1);
			this.fire(row-1,col+1);


		}

<<<<<<< HEAD
		public void drone(int direction, int index) {  //Scans a row or column. Updates the user on how many boat objects are in the col/row
=======
		public int drone(String direction, int index) {  //Scans a row or column. Updates the s
			int count = 0;
			
			if (direction.equals("row")){
				for (int i = 0; i < this.board[index].length; i++){
					if (this.board[index][i] != null){
						count ++;
					}
				}
			}
>>>>>>> 0579639956a1f3496f6f0d38ffab6e6084c0980e

			else if (direction.equals("column")){
				for (int i = 0; i < this.board[0].length; i++){
					if (this.board[i][index] != null){
						count ++;
					}
				}
			}
			return count;
		}

		public static void main(String[] args){
			BattleBoatsBoard thisboard = new BattleBoatsBoard("standard");
			thisboard.placeBoats();
			System.out.println(thisboard);
			
			// BattleBoatsBoard newboard = new BattleBoatsBoard("expert");
			// System.out.println(newboard);
			// newboard.placeBoats();

			// System.out.println(newboard);
<<<<<<< HEAD

			thisboard.missile(4,4);
			
			
			


			
=======
			
			//newboard.fire(1,1);

			System.out.println(thisboard.drone("column", 1));

>>>>>>> 0579639956a1f3496f6f0d38ffab6e6084c0980e
		}
}
