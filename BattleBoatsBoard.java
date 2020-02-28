/* This class contains all functions and methods used by BattleBoatsGame class

Written by osmun046 and leibo023
 */

public class BattleBoatsBoard {
    char[][] board;
    int totalShots = 0;
    int turns = 0;
    int shipsRemaining;

    public BattleBoatsBoard(int size) { //Constructor. Makes a square board of int size

        board = new char[size][size];
    }

    public void placeBoats() {  //Randomly places boats on board

    }

    public void fire(int x, int y) {  //Fires at coordinate (x,y)

    }

    public void display() {  //Displays current board state. Void because it will use println()

    }

    public void print() {  //Displays fully revealed board state.

    }

    public void missile(int x, int y) {  //Fires missile at (x,y), will call fire on (x-1,y-1);(x,y-1);(x+1,y-1);(x-1,y);(x,y);(x+1,y);(x-1,y-1);(x,y-1);(x+1,y-1)

    }

    public void drone(int direction, int index) {  //Scans a row or column. Updates the s

    }
}
