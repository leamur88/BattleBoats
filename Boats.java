/* This is the class for Boat objects that will be stored in the board

Written by osmun046 and leibo023
*/

public class Boats{
	private final int length;  //Will not change, thus final
	private int health;
	private String name;

	public static Boats hitBoat = new Boats(-1,"hitBoat");  //Two placeholder Boats objects to be used in master board 
	public static Boats missedSpot = new Boats(-2,"missedSpot");  //This one if for a location the user has already fired upon 

	public Boats(int length, String name){  //Boats object constructor
		this.health = length;  //Sets starting health to length
		this.length = length;  //This length attribute will not be change
		this.name = name;
	}

	public int getLength(){  //Returns length (original health) of a Boats object
	    return this.length;
    }
    
    public int getHealth(){  //Returns health of a Boats object
	    return this.health;
    }

	public void loseHealth(){  //Decreases health by one
	    this.health --;
    }

	public String toString(){  //toString for Boats object. Used by the master board.
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
