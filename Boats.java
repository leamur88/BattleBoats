/* This is the class for Boat objects that will be stored in the board

Written by osmun046 and leibo023
*/

public class Boats{
	private int length;
	private int health;
	private String name;

	public static Boats hitBoat = new Boats(-1,"hitBoat");
	public static Boats missedSpot = new Boats(-1,"missedSpot");

	public Boats(int length, String name) {
		this.health = length;
		this.length = length;
		this.name = name;
	}

	public int getLength(){
	    return this.length;
    }
    
    public int getHealth(){
	    return this.health;
    }

	public void loseHealth(){
	    this.health --;
    }

	public String toString(){
		String result = "";
		
		if (this.health > 0){
			result += "["+this.length+this.name+"] ";
		}

		else if (this.health == -1){
			result = "[XX] ";
		}

		else if (this.health == -2){
			result = "[OO] ";
		}

	return result;
	}
}
