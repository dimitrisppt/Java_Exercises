/**
 * The class Pirate consists of a constructor that receives two parameters, name of type String and map which is an array of the Island.
 * It has a search method that searches if a supplied String variable exist in any position of the array map and returns an Island.
 * It has a method getTreasure that receives a parameter name of type Island and returns a boolean value.
 * It has a method getTotalCoins that returns an integer variable coinCounter which is the number of coins the Pirate has.
 * It has a method speak that receives a String variable, phrase and apply to it a random suffix that exist in the pirateSuffix array.
 */
public class Pirate {
	
	// Creation of the field name of type integer.
	private String name;
	// Creation of field purse which is an array of type GoldCoin.
	private GoldCoin[] purse;
	// Creation of field coinCounter of type integer.
	private int coinCounter;
	// Creation of field map which is an array of type Island.
	private Island[] map;
	// Creation of field pirateSuffix which is an array of type String and contains a number of suffixes.
	private String[] pirateSuffix = {", arrr!", ", shiver me timbers!", ", avast!", ", ahoy, matey!", ", yo, ho ho!"};
	
	/**
	 * Creation of constructor Pirate that receives two parameters: name of type String and map which is an array of type Island.
	 */
	public Pirate(String name, Island[] map){
		
		// Refers the name variable to the class.
		this.name = name; 
		// Creates a new array of type GoldCoin that can hold 1000 elements(because we don't know exactly the number of GoldCoins that the pirate's purse can hold). Then refers the purse to the class.
		this.purse = new GoldCoin[1000];
		// Refers the map to the class.
		this.map = map;
		// Initialises coinCounter variable to 0.
		coinCounter = 0;
	}
	
	/**
	 * The method search receives a name variable of type String and returns an Island.
	 * This process is done by checking whether the supplied name is equal to an element in the map array.
	 */
	public Island search(String name) {
		
		// This loop is repeated 3 times because the map has only 3 elements to be checked.
		for (int i=0; i<3; i++){
			
			// Checks whether the supplied name is equal to an element in the map array.
			if (name.equals(map[i].getIslandName())) {
				
				// Returns the element of the map array with the current index.
				return map[i];
			}
		}
		// Returns null.
		return null;
	}
	
	/**
	 * The method getTreasure receives a name variable of type Island and returns a boolean value.
	 */
	public boolean getTreasure(Island name) {
		
		// The for loop, loops until the i is not less than the number of locations the supplied Island has.
		for (int i=0; i < name.getNumBuryLocations(); i++) {
			
			// Checks if the dig method that is called suppling the index(i) as a parameter is not equal to null.
			if (name.dig(i) != null){
				
				// Stores a temporary copy of the TreasureChest that is returned by the dig method inside treasureChestTemp variable.
				TreasureChest treasureChestTemp = name.dig(i); 
				// Sets the treasureLocation of the supplied Island to -1 because the pirate dug in and took the treasureChest.
				name.setTreasureLocation();
				
				// If the TreasureChest treasureChestTemp coinsCounter is greater than 0 then repeat the following process. 
				while (treasureChestTemp.getCoinsCounter() > 0){
					
					// Sets the purse array in the index coinCounter to the GoldCoin that is returned by the takeOneGoldCoin method
					purse[coinCounter] = treasureChestTemp.takeOneGoldCoin();
					// Increments the coinCounter by one.
					coinCounter++;
				}
				// Returns true.
				return true;
			}
		}
		// Returns false.
		return false;
	}
	
	/**
	 * The method getTotalCoins returns an integer variable coinCounter.
	 */
	public int getTotalCoins() {
		// Returns an integer variable coinCounter which is the number of coins the Pirate currently has.
		return coinCounter;
	}
	
	/**
	 * The method speak receives a parameter of type String.
	 * Is used to print phrases that have a random pirate suffix at the end.
	 */
	public void speak(String phrase) {
		
		// Generates a random number up to 5.
		int i = (int)(Math.random() * 5);
		// Concatenates the phrase with the random pirateSuffix.
		phrase = phrase + pirateSuffix[i];
		// Outputs the new phrase.
		System.out.println(phrase);
		
	}
	
}
