// Imports Collection class from java's utilities.
import java.util.Collections;
// Imports Scanner class from java's utilities.
import java.util.Scanner;

/**
 * The class Game has the main method of the program.
 * It creates objects of the classes Battleship, Cruiser, Frigate, Minesweeper. then adds the objects into the ships ArrayList.
 * Calculates the number that battleships, cruisers, frigates, minesweepers exist on the board. Outputs the frequency of them and the board.
 * The user has to enter the number of row and column to hit a ship's part on the board. If a part is hit then outputs "Hit!", else outputs "Miss!".
 * The user enters quit to terminate.
 */
public class Game {

	/**
	 * The main method of the program. Where the execution of it takes place.
	 */
	public static void main(String[] args) {
		// Initialises rowNumber and columnNumber to -1.
		int rowNumber = -1, columnNumber = -1;
		// Creates object board of the class Board.
		Board board = new Board();
		// Creates object battleship of the class Battleship with parameters 0,5
		Battleship battleship = new Battleship(0,5);
		// Creates object cruiserOne of the class Cruiser with parameters 1,4
		Cruiser cruiser = new Cruiser(1,4);
		// Creates object frigate of the class Frigate with parameters 3,3
		Frigate frigate = new Frigate(3,3);
		// Creates object minesweeper of the class Minesweeper with parameters 4,2
		Minesweeper minesweeper = new Minesweeper(4,2);
		
		// Creation of object in of the class Scanner.
		Scanner in = new Scanner(System.in);
		// Declares userInput to String and assigns it to "".
		String userInput = "";
		
		// While userInput is not equal to 'quit'
		while (!userInput.equals("quit")) {
			// Calculates the number of battleship on the board.
			int freqOfBattleship = Collections.frequency(board.getShips(), battleship);
			// Calculates the number of cruisers on the board.
			int freqOfCruiser = Collections.frequency(board.getShips(), cruiser);
			// Calculates the number of frigates on the board.
			int freqOfFrigate = Collections.frequency(board.getShips(), frigate);
			// Calculates the number of minesweeper on the board.
			int freqOfMinesweeper = Collections.frequency(board.getShips(), minesweeper);
			
			// Outputs the number of battleships on the board.
			System.out.println("Battleships: " + freqOfBattleship);
			// Outputs the number of cruisers on the board.
			System.out.println("Cruisers: " + freqOfCruiser);
			// Outputs the number of frigates on the board.
			System.out.println("Frigates: " + freqOfFrigate);
			// Outputs the number of minesweppers on the board.
			System.out.println("Minesweepers: " + freqOfMinesweeper);
			
			// Outputs the board.
			System.out.println(board);

			// Asks the user for input.
			System.out.print("Input a row and a column: ");
			// Stores the input from the user in the userInput variable.
			userInput = in.nextLine();
			
			// If the userInput is not equal to 'quit' then...
			if (!userInput.equals("quit")){
				
				// Splits the userInput where it has ' '.
				for (String input: userInput.split(" ")) {
					// Checks if the rowNumber is equal to -1.
					if(rowNumber == -1){
						// Converts the input into integer and stores it in rowNumber.
						rowNumber = Integer.parseInt(input);
					// Else...
					} else { 
						// Converts the input into integer and stores it in columnNumber.
						columnNumber = Integer.parseInt(input);
					}
				}
				
				/* Checks whether the hit method returns true by suppling as parameters the input from the user,
				 * rowNumber and columnNumber variables.
				 */
				if (board.hit(rowNumber, columnNumber)) {
					// Outputs a 'Hit!' message.
					System.out.println("Hit!");
				// Else...
				} else {
					// Outputs a 'Miss!' message.
					System.out.println("Miss!");
				}
				// Sets the rowNumber again to -1.
				rowNumber = -1;
			}
		}
	// Closes the object in.
	in.close();
	}

}

