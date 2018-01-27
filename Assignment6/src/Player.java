/**
 * The class Player is used to represent a player with name, number of lives and a current room which is in.
 * It contains a constructor Player with three parameters, name of type String, lives of type integer and currentRoom of type Room.
 * It has a move method that receives a supplied Room the nextRoom and if it does not contain a monster then it returns a boolean value
 * true, else it returns false.
 * It has a getLives method which returns an integer value.
 * It has a setName method that receives a supplied String value and updates the name of the Player.
 * It has a getName method that returns a String value.
 * It has a setCurrentRoomBlue and setCurrentRoomRed method which update the currentRoom with a Room behind the blue or red door respectively.
 * It has a getCurrentRoom method that returns the currentRoom of the Player.
 * It has a getBlueRoom and getRedRoom methods that return the Room behind the blue door and red door respectively..
 */
public class Player {
	
	// Creation of the field name of type String.
	private String name;
	// Creation of the field lives of the integer.
	private int lives;
	// Creation of the field currentRoom of type Room.
	private Room currentRoom;
	
	/**
	 * The constructor Player receives three parameters, name of type String, lives of type integer and currentRoom of type Room.
	 */
	public Player(String name, int lives, Room currentRoom){
		
		// Refers variable name to the class.
		this.name = name;
		// Refers variable lives to the class.
		this.lives = lives;
		// Refers variable currentRoom to the class.
		this.currentRoom = currentRoom;
	}
	
	/**
	 * The method move receives a variable nextRoom of type Room and returns a boolean value true or false,
	 * depending if there is a monster behind the selected door.
	 */
	public Boolean move(Room nextRoom) {
		
		// Declaration of variable result of type boolean.
		boolean result;
		
		// Checks whether there is a monster behind the selected door.
		if (nextRoom.getContainsMonster() == true) {
			
			// If yes the lives are decremented by one.
			lives -= 1;
			// Initialisation of the variable result to false.
			result = false;
		
		// If there is not a monster behind the selected door then...
		} else {
			
			// Initialisation of the variable result to true.
			result = true;
		}
		
		// Returns the result.
		return result;
	}
	
	/**
	 * The method getLives returns a variable lives of type integer. 
	 */
	public int getLives() {
		
		// Returns the variable lives.
		return lives;
	}
	
	/**
	 * The method setName receives a parameter name of type String and updates the name of the player. 
	 */
	public void setName(String name) {
		
		// Refers variable name to the class.
		this.name = name;
	}
	
	/**
	 * The method getName returns a String variable.
	 */
	public String getName(){
		
		// Returns the variable name of type String.
		return name;
	}
	
	/**
	 * The method setCurrentRoomBlue updates the currentRoom of the Player to the room behind the blue door.
	 */
	public void setCurrentRoomBlue(){
		
		// Updates the currentRoom to the Room behind the blue door.
		this.currentRoom = currentRoom.getBlueDoorRoom();
	}
	
	/**
	 * The method setCurrentRoomRed updates the currentRoom of the Player to the room behind the red door.
	 */
	public void setCurrentRoomRed(){
		
		// Updates the currentRoom to the Room behind the red door.
		this.currentRoom = currentRoom.getRedDoorRoom();
	}
	
	/**
	 * The getCurrentRoom returns a currentRoom variable of type Room which is the currentRoom of the Player at that moment.
	 */
	public Room getCurrentRoom() {
		
		// Returns a currentRoom variable of type Room.
		return currentRoom;
	}
	
	/**
	 * The getBlueRoom returns the Room behind the blue door.
	 */
	public Room getBlueRoom(){
		
		// Returns the room behind the blue door.
		return currentRoom.getBlueDoorRoom();
	}
	
	/**
	 * The getBlueRoom returns the Room behind the red door.
	 */
	public Room getRedRoom() {
		
		// Returns the room behind the red door.
		return currentRoom.getRedDoorRoom();
	}
	
		
}
