/* This class will contain the main method. Main should create and initalize a BattleBoatsBoard object
and use scanner to take in input until the game ends. May also contain any useful helper methods.

Written by osmun046 and leibo023
*/

public class BattleBoatsMain {

    public static void main(String[] args) {
      BattleBoatsBoard thisboard = new BattleBoatsBoard("expert");
      thisboard.placeBoats();
      System.out.println(thisboard);
    }
}
