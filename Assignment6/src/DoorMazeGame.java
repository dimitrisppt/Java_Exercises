// From java utilities import the Scanner
import java.util.Scanner;

/**
 * The DoorMazeGame program implements a game that there are six rooms and each one has
 * a blue door and a red door. Each door leads to either another room or to a monster. The player
 * has to choose the correct doors which are lead to the final room. The player has two lives and starts from the room1.
 */
public class DoorMazeGame {
	
	// The main method of the program. Where the execution of the program takes place.
	public static void main(String[] args){
		
		// Creation of the constructor monsterRoom of the class Room with parameters: "The Monster Room", true, false.
		Room monsterRoom = new Room("The Monster Room", true, false);
		// Creation of the constructor room6 of the class Room with parameters: "Chamber Six", false, true.
		Room room6 = new Room("Chamber Six", false, true);
		// Creation of the constructor room5 of the class Room with parameters: "Chamber Five", monsterRoom, room6, false, false.
		Room room5 = new Room("Chamber Five", monsterRoom, room6, false, false);
		// Creation of the constructor room4 of the class Room with parameters: "Chamber Four", monsterRoom, room5, false, false.
		Room room4 = new Room("Chamber Four", monsterRoom, room5, false, false);
		// Creation of the constructor room3 of the class Room with parameters: "Chamber Three", room4, monsterRoom, false, false.
		Room room3 = new Room("Chamber Three", room4, monsterRoom, false, false);
		// Creation of the constructor room2 of the class Room with parameters: "Chamber Two", monsterRoom, room3, false, false.
		Room room2 = new Room("Chamber Two", monsterRoom, room3, false, false);
		// Creation of the constructor room1 of the class Room with parameters: "Chamber One", room2, monsterRoom, false, false.
		Room room1 = new Room("Chamber One", room2, monsterRoom, false, false);
		// Creation of the constructor player of the class Player with parameters: "", 2, room1.
		Player player = new Player("", 2, room1);
		
		// Outputs the instructions of the game in the following six lines.
		System.out.println("Instructions:");
		System.out.println("     The player has to input their name. A player is created with the assigned name, has 2 lives and starts from room Chamber One.");
		System.out.println("     To win, the player has to reach the final room by choosing the correct door that leads to the next room and not the monster's room,");
		System.out.println("     between a blue door and a red door to progress to the next room.");
		System.out.println("     The player has to input 'blue' or 'red' depending their choice.");
		System.out.println("     If the player chooses a door that leads to a monster's room then loses a life.");
		System.out.println("     If the player loses 2 lives then the game ends. If the player manages to get to the final room then wins.");
		// Asks the user to input their name.
		System.out.print("Please enter a player's name: ");
		// Creation of the constructor inputName of the class Scanner that is used to let the user input their name.
		Scanner inputName = new Scanner(System.in);
		// The variable name stores the input from the user.
		String name = inputName.nextLine();
		// The player's name is updated accordingly to the previous input.
		player.setName(name);
		
		// The following statements are repeated until the condition after the while keyword is met.
		do {
			
			// Outputs the name of the player.
			System.out.println("Player Name: " + player.getName());
			// Outputs the player's left lives.
			System.out.println("Lives Left: " + player.getLives());
			// Outputs 'Details of the current room:'
			System.out.println("Details of the current room:");
			// Outputs the name of the current room.
			System.out.println("                          " + "Name: " + player.getCurrentRoom().getName());
			// Outputs a boolean value true or false whether the current room contains a monster or not.
			System.out.println("              " + "Contains Monster: " + player.getCurrentRoom().getContainsMonster());
			// Outputs a boolean value true or false whether the current room is the final.
			System.out.println("       " + "Is this the final room?: " + player.getCurrentRoom().getIsFinalRoom());
			
			// Asks the user to input 'blue' or 'red' to select a door.
			System.out.print("Please enter 'blue' or 'red' to move to your selected door: ");
			// Creation of the constructor inputRoom of the class Scanner that is used to let the user input their choice.
			Scanner inputRoom = new Scanner(System.in);
			// The variable room stores the input from the user.
			String room = inputRoom.nextLine();
			
			// Checks whether the input from the user is equal to 'blue'.
			if (room.equals("blue")) {
				
				// Makes the player to move to the room behind the blue door if it does not contain a monster inside.
				if (player.move(player.getBlueRoom()) == true) {
					
					// Sets the player's room to the room behind the blue door.
					player.setCurrentRoomBlue();
				} else {
					// Outputs message indicating that the player lost a life.
					System.out.println("Oh! You have entered the room behind the blue door but contains a monster! You have lost a life!");
				}
				
			// Checks if the input from the user is equal to 'red'
			} else if (room.equals("red")) {
				
				// Makes the player to move to the room behind the red door if it does not contain a monster inside.
				if (player.move(player.getRedRoom()) == true) {
					
					// Sets the player's room to the room behind the red door.
					player.setCurrentRoomRed();
					
				} else {
					// Outputs message indicating that the player lost a life.
					System.out.println("Oh! You have entered the room behind the red door but contains a monster! You have lost a life!");
				}
			
			// If the user input is something else then outputs an error message.
			} else {
				
				// Outputs an error message.
				System.out.println("Wrong input! Please enter 'blue' or 'red', to move to your selected room");
			} 
				
		// Repeat the previous statements until the player has zero lives or the player managed to get to the final room.
		} while(player.getLives() != 0 && player.getCurrentRoom().getIsFinalRoom() == false);
		
		// Checks if the player has zero lives.
		if (player.getLives() == 0) {
			
			// Outputs a message indicating that he lost.
			System.out.println("Oh dear! You lost! Try again :)");
		
		// If the player is alive then...
		} else {
			// Outputs the name of the player.
			System.out.println("Player Name: " + player.getName());
			// Outputs the player's left lives.
			System.out.println("Lives Left: " + player.getLives());
			// Outputs 'Details of the current room:'
			System.out.println("Details of the current room:");
			// Outputs the name of the current room.
			System.out.println("                          " + "Name: " + player.getCurrentRoom().getName());
			// Outputs a boolean value true or false whether the current room contains a monster or not.
			System.out.println("              " + "Contains Monster: " + player.getCurrentRoom().getContainsMonster());
			// Outputs a boolean value true or false whether the current room is the final.
			System.out.println("       " + "Is this the final room?: " + player.getCurrentRoom().getIsFinalRoom());
			// Outputs a message indicating that he won.
			System.out.println("Congratulations! You won!!!");
		}
		
		/* Uses the close method to indicate that the program finished asking the user
		 * for input by flagging that our Scanner can no longer be used for input.
		 */
		inputName.close();
		
	}

}
