public class Boats{
    private int length;
    private int health;
    private String name;

    static Boats hitBoat = new Boats(-1);
    static Boats missSpot = new Boats(-2);

    public Boats(int length, String name) {
        this.health = length;
        this.length = length;
        this.name = name;
    }

    public int getLength(){
      return this.length;
    }

    public void loseHealth(){
      this.health --;
    }

    public String toString(){
        String result = "";
        
        if (this.health > 0) {
            result = String.valueOf(this.length);
        }

        else if (this.health < 0) {
            result = "X";
        }
    return result;
    }
}
