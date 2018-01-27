/**
 * The class Room is used to represent a room which contain a name, a blue door and a red door. 
 * Behind a door might be a monster. Also it can be the final room without any other doors.
 * The constructor Room it has five parameters, name of type String, blueDoorRoom, redDoorRoom of type Room,
 * containsMonster and isFinalRoom of type boolean.
 * It contains another constructor Room with three parameters, name of type String, containsMonster and isFinalRoom of type boolean.
 * It has getBlueDoorRoom and getRedDoorRoom methods which return the blueDoorRoom and redDoorRoom variables respectively.
 * It has getName method which return a String value.
 * It has getContainsMonster which return a boolean value.
 * It has getIsFinalRoom which return a boolean value.
 */
public class Room {
		
		// Creation of field name of type String.
		private String name;
		// Creation of field blueDoorRoom of type Room.
		private Room blueDoorRoom;
		// Creation of field redDoorRoom of type Room.
		private Room redDoorRoom;
		// Creation of field containsMonster of type boolean.
		private boolean containsMonster;
		// Creation of field isFinalRoom of type boolean.
		private boolean isFinalRoom;
		
		/**
		 * The constructor Room it has five parameters, name of type String, blueDoorRoom, redDoorRoom of type Room,
		 * containsMonster and isFinalRoom of type boolean.
		 */
		public Room(String name, Room blueDoorRoom, Room redDoorRoom, boolean containsMonster, boolean isFinalRoom){
			
			// Refers the variable name to the class.
			this.name = name;
			// Refers the variable blueDoorRoom to the class.
			this.blueDoorRoom = blueDoorRoom;
			// Refers the variable redDoorRoom to the class.
			this.redDoorRoom = redDoorRoom;
			// Refers the variable containsMonster to the class.
			this.containsMonster = containsMonster;
			// Refers the variable isFinalRoom to the class.
			this.isFinalRoom = isFinalRoom;
			
		}
		
		/**
		 * The constructor Room with three parameters, name of type String, containsMonster and isFinalRoom of type boolean.
		 */
		public Room(String name, boolean containsMonster, boolean isFinalRoom) {
			
			// Refers the variable name to the class.
			this.name = name;
			// Refers the containsMonster name to the class.
			this.containsMonster = containsMonster;
			// Refers the isFinalRoom name to the class.
			this.isFinalRoom = isFinalRoom;
		}
		
		/**
		 * The getBlueDoorRoom method returns a variable blueDoorRoom of type Room.
		 */
		public Room getBlueDoorRoom() {
			
			// Returns the blueDoorRoom variable.
			return blueDoorRoom;
		}
		
		/**
		 * The getRedDoorRoom method returns a variable getRedDoorRoom of type Room.
		 */
		public Room getRedDoorRoom() {
			
			// Returns the redDoorRoom variable.
			return redDoorRoom;
		}
		
		/**
		 * The getName method returns a variable name of type String.
		 */
		public String getName() {
			
			// Returns the name variable.
			return name;
		}
		
		/**
		 * The getContainsMonter method returns a variable of type boolean.
		 */
		public boolean getContainsMonster() {
			
			// Returns the containsMonster variable.
			return containsMonster;
		}
		
		/**
		 * The getIsFinalRoom method returns a variable of type boolean.
		 */
		public boolean getIsFinalRoom() {
			
			// Returns the isFinalRoom variable.
			return isFinalRoom;
		}
		
		
}
