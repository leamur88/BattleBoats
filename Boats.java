public class Boats{
    private int length;
    private int health;

    static Boats hitBoat = new Boats(-1);

    public Boats(int length) {
        this.health = length;
        this.length = length;
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
