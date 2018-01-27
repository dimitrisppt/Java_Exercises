/**
 * The GoldCoin class contains a constructor that increments the coinNumber
 * by one each time a new GoldCoin is created. This is done because all GoldCoins
 * must have a unique coin number.
 * Also it contains a method getCoinNumber that returns an integer which is the coinNumber.
 */
public class GoldCoin {
	
	// Creation of field coinNumber of type integer.
	private int coinNumber;
	/* Creation of field uniqueNumber of type integer. It's a static field 
	 * because that number for each coin is unique.
	 */
	private static int uniqueNumber;
	
	/**
	 * Creation of the constructor GoldCoin. It does not receive any parameter. Each time a GoldCoin 
	 * is created it is assigned with a new uniqueNumber.
	 */
	public GoldCoin() {
		
		// Assigns the coinNumber with a unique number which is incremented by one each time a gold coin is created.
		coinNumber = uniqueNumber++;
	}
	
	/**
	 * The getCoinNumber method returns an integer which is the unique number of the coin.
	 */
	public int getCoinNumber() {
		// Returns a coinNumber. 
		return coinNumber;
	}
	
	/**
	 * The method getName returns a String value, which is the name of the Product.
	 */
	public String toString() {
		// Returns the variable name which is a String value.
		return coinNumber+" ";
	}
	
}
