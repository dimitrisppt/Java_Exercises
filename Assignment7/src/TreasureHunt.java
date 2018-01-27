// Imports the Scanner class from java's utilities.
import java.util.Scanner;

/**
 * The class TreasureHunt is contains the main method of the program. This is where the execution of the program takes place.
 * Firstly three Islands are created, which are added to a map. Then a pirate is created, with appropriate name, and a map.
 * The pirate asks from the user to suggest him an island name. The user inputs an Island and the pirate searches if that Island exist 
 * in his map. If it does not exist then the pirate says: "The suggested island could not be found" and asks an Island name again from the user.
 * If the user inputs a correct Island name then the pirate searches in a number of island's locations until he finds the treasure. When he finds
 * the treasure informs the user that the "The chest was found at: " followed by the name of the island. Also says the current amount of coins that 
 * he has in his possession. Then asks the user again for an Island name until the user inputs "stop". 
 */
public class TreasureHunt {
	
	/**
	 * Main method of the program. Where the execution of the program takes place.
	 */
	public static void main(String[] args){
		
		// Creation of the object nassau of the class Island with parameters: "Nassau", 15.
		Island nassau = new Island("Nassau", 15);
		// Creation of the object havana of the class Island with parameters: "Havana", 15.
		Island havana = new Island("Havana", 15);
		// Creation of the object stKitts of the class Island with parameters: "St Kitts", 15.
		Island stKitts = new Island("St Kitts", 15);
		
		// Creation of the map which is an Island array and holds the three previously created objects nassau, havana and stKitts.
		Island[] map = {nassau, havana, stKitts};
		
		// Creation of the object pirate of the class Pirate with parameters: "Captain Robot", map.
		Pirate pirate = new Pirate("Captain Robot", map);
		
		// Calls the speak method that exist inside the Pirate class, that add a pirate suffix at the end of the provided phrase.
		pirate.speak("Suggest me an island name");
		// Creation of the object inputIslandName of the class Scanner.
		Scanner inputIslandName = new Scanner(System.in);
		// The user inputs an island name that is stored inside the islandName variable.
		String islandName = inputIslandName.nextLine();
		
		// If the provided islandName is not equal to "stop" then repeat the following process.
		while(!islandName.equals("stop")) {
			
			// Calls the speak method that exist inside the Pirate class, that add a pirate suffix at the end of the provided phrase.
			pirate.speak("Searching for" + " " + islandName);
			
			// If the returned value from the search is equal to null then...
			if (pirate.search(islandName) == null) {
				// Calls the speak method that exist inside the Pirate class, that add a pirate suffix at the end of the provided phrase.
				pirate.speak("The suggested island could not be found");
				
			// Else...
			} else {
				
				// If the pirate finds a TreasureChest in the supplied Island then...
				if (pirate.getTreasure(pirate.search(islandName)) == true) {
					
					/* Calls the speak method that exist inside the Pirate class, that add a pirate suffix at the end of the provided phrase.
					 * Outputs the name of the Island that the treasure chest was found.
					 */
					pirate.speak("The chest was found at: " + islandName);
					/* Calls the speak method that exist inside the Pirate class, that add a pirate suffix at the end of the provided phrase. 
					 * Outputs the total coins the pirate currently has.
					 */
					pirate.speak("Now I have" + " " + pirate.getTotalCoins() + " " + "coins");
				
				// If the pirate cannot find any treasure chest in the provided Island then...
				} else {
					
					// Calls the speak method that exist inside the Pirate class, that add a pirate suffix at the end of the provided phrase. 
					pirate.speak("The suggested island did not contain any treasure");
					
				}
			}
			
			// Calls the speak method that exist inside the Pirate class, that add a pirate suffix at the end of the provided phrase. Asks the user to input an island name.
			pirate.speak("Suggest me an island name");
			// The user inputs an island name that is stored inside the islandName variable.
			islandName = inputIslandName.nextLine();
			
		}
		// Closes the Scanner.
		inputIslandName.close();
	}	

}
