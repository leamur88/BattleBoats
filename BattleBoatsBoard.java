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
                  boardResult += "0";
                }
                else{
                 boardResult += board[i][j];
                }

            }
        }
        return boardResult;
    }


    public void placeBoats() {  //Randomly places boats on board
        if (this.gamemode.equals("standard")){
            Boats boat5 = new Boats(5);
            Boats boat4 = new Boats(4);
            Boats boat31 = new Boats(3);
            Boats boat32 = new Boats(3);
            Boats boat2 = new Boats(2);


            Boats[] boatSizes = {boat5, boat4, boat31, boat32, boat2};


            for (int i =0; i < boatSizes.length; i++) {
                boolean fits = false;
                int iterations = 0;

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

                    if (horizontal && left){ //Horizontal and left
                        if (((x+1) - boatSizes[i].getLength()) >= 0){//Checks if boat can fit on board

                          for (int k=0; k<boatSizes[i].getLength(); k++){
                            if (board[y][x-k] instanceof Boats){ //check if different boat is in the way
                              break;
                            }
                          }
                            fits = true;
                            for (int j=0; j<boatSizes[i].getLength(); j++){
                              board[y][x-j]=boatSizes[i];
                            }
                        }
                    }

                    else if (horizontal && !left){  //Horizontal and right
                      if (x + boatSizes[i].getLength() <= 8){

                        for (int k=0; k<boatSizes[i].getLength(); k++){
                          if (board[y][x+k] instanceof Boats){ //check if different boat is in the way
                            break;
                          }
                        }

                          fits = true;
                          for (int j=0; j<boatSizes[i].getLength(); j++){
                            board[y][x+j]=boatSizes[i];
                          }
                      }
                    }

                    else if (!horizontal && left){  //Vertical and up
                      if ((y+1) - boatSizes[i].getLength() >= 0){

                          for (int k=0; k<boatSizes[i].getLength(); k++){
                            if (board[y-k][x] instanceof Boats){
                              break;
                            }
                          }

                          fits = true;
                          for (int j=0; j<boatSizes[i].getLength(); j++){
                            board[y-j][x]=boatSizes[i];
                          }
                      }
                    }

                    else if (!horizontal && !left){  //Vertical and down
                      if (y + boatSizes[i].getLength() <= 8){

                          for (int k=0; k<boatSizes[i].getLength(); k++){
                            if (board[y+k][x] instanceof Boats){
                              break;
                            }
                          }

                          fits = true;
                          for (int j=0; j<boatSizes[i].getLength(); j++){
                            board[y+j][x]=boatSizes[i];
                          }
                      }
                    }
                    iterations ++;

                }
                System.out.println(iterations);

            }
        }
    }

    public void fire(int x, int y) {  //Fires at coordinate (x,y)
        //Must update userBoard location hit with miss or
    }

    public void display() {  //Displays current board state. Void because it will use println()

    }

    public void print() {  //Displays fully revealed board state.

    }

    public void missile(int x, int y) {  //Fires missile at (x,y), will call fire on (x-1,y-1);(x,y-1);(x+1,y-1);(x-1,y);(x,y);(x+1,y);(x-1,y-1);(x,y-1);(x+1,y-1)

    }

    public void drone(int direction, int index) {  //Scans a row or column. Updates the s

    }

    public static void main(String[] args){
      BattleBoatsBoard thisboard = new BattleBoatsBoard("standard");
      thisboard.placeBoats();
      System.out.println(thisboard);
    }
}
