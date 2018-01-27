/**
 * The class TreasureChest consist of an array of GoldCoins that can hold up to 15 elements.
 * It contains a constructor that fill each slot of the goldCoin array with a new GoldCoin.
 * Also contains two methods: takeOneGoldCoin and getCoinsCounter,
 * The takeOneGoldCoin method returns a GoldCoin from the goldCoin array, if the coinsCounter is 
 * greater than 0, and assigns that slot with null.
 * The getCoinsCounter returns an integer.
 */
public class TreasureChest {
	
	// Creation of field numberOfGoldCoins which is a fixed number for all chests.
	private static final int numberOfGoldCoins = 15;
	// Creation of field coinsCounter of type integer.
	private int coinsCounter;
	// Creation of a GoldCoin array that can hold up to 15 elements.
	private GoldCoin[] goldCoin = new GoldCoin[15];
	
	/**
	 * The constructor TreasureChest is used to fill each slot of the goldCoin array
	 * with a new GoldCoin, every time it's called.
	 */
	public TreasureChest() {
		
		// Assigns the coinsCounter with the fixed value of numberOfGoldCoins variable.
		coinsCounter = numberOfGoldCoins;
		
		// The for loop is used to fill each slot of the goldCoin array with a new GoldCoin.
		for (int i=0; i<15; i++){
			
			// Fills the current slot that corresponds to the index of the goldCoin array with a new GoldCoin.
			this.goldCoin[i] = new GoldCoin();
		}
		
	}
	
	/**
	 * The method takeOneGoldCoin returns a GoldCoin from the goldCoin array, if the coinsCounter is 
	 * greater than 0, and assigns that slot with null.
	 * Else returns null.
	 */
	public GoldCoin takeOneGoldCoin(){
		
		// If the coinsCounter is greater than 0 then
		if (coinsCounter > 0){
			
			// Stores the GoldCoin that exist in the current slot of the goldCoin array to the coin variable.
			GoldCoin coin = goldCoin[coinsCounter-1];
			// The current slot of the goldCoin array is assigned to null.
			goldCoin[coinsCounter-1] = null;
			// The coinsCounter is decremented by one.
			coinsCounter--;
			// Returns the coin.
			return coin;
		}
		// Returns null.
		return null;
	}

	/**
	 * The method getCoinsCounter returns an integer which is the coinsCounter variable.
	 */
	public int getCoinsCounter(){
		
		// Returns the coinsCounter variable.
		return coinsCounter;
	}
}
