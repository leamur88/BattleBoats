public class Boats{
    private int length;
    private int health;
    private String name;

    static Boats hitBoat = new Boats(-1,"hitBoat");
    static Boats missSpot = new Boats(-2,"missSpot");

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
            result += "["+this.name+"]";
        }

        else if (this.health < 0) {
            result = "X";
        }
    return result;
    }
}
