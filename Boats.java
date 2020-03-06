public class Boats{
    private int length;
    private int health;

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
}
