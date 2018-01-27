// Imports ArrayList from java's utilities.
import java.util.ArrayList;

/**
 * The class Customer consists of the fields name of type String, shoppingBasket of type ArrayList<Product>, ownedProducts of type ArrayList<Product>, purse of type ArrayList<GoldCoin>.
 * It has a constructor that receives two parameters, name of type String, and numberOfGoldCoins of type integer.
 * It has a method addToShoppingBasket that receives a parameter Product and adds it to the the shoppingBasket ArrayList.
 * It has a method removeFromShoppingBasket that receives a parameter Product and returns a boolean value true if the product removed from the shoppingBasket ArrayList, or false if the product cannot be allocated.
 * It has a method searchShoppingBasket that receives a parameter Product and searches in the shoppingBasket ArrayList if this Product exist. If it's exists then returns that Product, else returns null.
 * It has a method addOwnedProduct that receives a parameter Product and adds it to the ownedProducts ArrayList.
 * It has a method addCoin that receives a parameter GoldCoin and adds it to the purse ArrayList.
 * It has a method getCustomerName that returns a String variable, which is the name of the Customer.
 * It has a method purchaseProducts that receives a parameter Shop and returns a boolean value.
 * It has a method toString that converts the name of the class, the field names and the field values to string.
 * It has a method getCustomerGoldCoins that returns an integer value, which is the number of gold coins the customer has.
 * It has a method getShoppingBasket that returns an ArrayList of Product.
 * It has a method getOwnedProducts that returns an ArrayList of Product.
 */
public class Customer {
	
	// Creation of field name of type String.
	private String name;
	// Creation of field shoppingBasket which is an ArrayList of Product.
	private ArrayList<Product> shoppingBasket;
	// Creation of field ownedProducts which is an ArrayList of Product.
	private ArrayList<Product> ownedProducts;
	// Creation of field purse which is an ArrayList of GoldCoin.
	private ArrayList<GoldCoin> purse; 
	
	/**
	 * The constructor Customer receives two parameters, name of type String and numberOfGoldCoins of type integer.
	 * The shoppingBasket, ownedProducts and purse ArrayList are created.
	 * Also the purse ArrayList is filled up with GoldCoins.
	 */
	public Customer(String name, int numberOfGoldCoins) {
		
		// Refers the name variable to the class.
		this.name = name;
		// Creation of a new ArrayList of Product and assign it to the shoppingBasket variable.
		shoppingBasket =  new ArrayList<Product>();
		// Creation of a new ArrayList of Product and assign it to the ownedProducts variable.
		ownedProducts = new ArrayList<Product>();
		// Creation of a new ArrayList of GoldCoin and assign it to the purse variable.
		purse = new ArrayList<GoldCoin>();
		// Loop until is not less than the received value of numberOfGoldCoins.
		for (int i=0; i<numberOfGoldCoins; i++){
			// Declaration of the variable goldCoin of type GoldCoin. Assign to it a new GoldCoin.
			GoldCoin goldCoin = new GoldCoin();
			// Calls the method addCoin which adds the goldCoin to the purse ArrayList.
			addCoin(goldCoin);
		}	
	}
	
	/**
	 * The method addToShoppingBasket receives a variable product of type Product and adds it to the shoppingBasket.
	 */
	public void addToShoppingBasket(Product product) {
		
		// Adds the received Product to the shoppingBasket ArrayList.
		shoppingBasket.add(product);
	}
		
	/**
	 * The method removeFromShoppingBasket receives a variable product of type Product and returns true whether the product removed from the shoppingBasket ArrayList.
	 * Returns false if the product cannot be allocated.
	 */
	public boolean removeFromShoppingBasket(Product product) {
		
		// Calls the remove method by suppling the product as a parameter. If the product is successfully removed from the shopping basket...
		if (shoppingBasket.remove(product) == true) {
			// Returns true.
			return true;
		// If cannot be allocated to be removed...
		} else {
			// Returns false.
			return false;
		}
	}
	
	/**
	 * The method searchShoppingBasket receives a product of type String and searches inside the shoppingBasket. If supplied product exists in the ArrayList then returns the product variable
	 * which is of type Product, else returns null.
	 */
	public Product searchShoppingBasket(String product) {
		// Loops until i is less than shoppingBasket ArrayList size
		for (int i=0; i<shoppingBasket.size(); i++) {
			// Checks if the supplied product exists in the shoppingBasket ArrayList.
			if (shoppingBasket.get(i).getName().equals(product)) {
				// Returns the product of type Product.
				return shoppingBasket.get(i);
			}
		}
		// Returns null.
		return null;
	}
	
	/**
	 * The method addOwnedProduct receives a parameter product of type Product.
	 * Then adds the supplied Product to the ownedProducts ArrayList.
	 */
	public void addOwnedProduct(Product product) {
		// Adds the supplied product to the ownedProducts ArrayList.
		ownedProducts.add(product);
	}
	
	/**
	 * The method addCoin receives a goldCoin variable of type GoldCoin
	 * Then adds the supplied GoldCoin to the purse ArrayList.
	 */
	public void addCoin(GoldCoin goldCoin) {
		// Adds the supplied goldCoin to the purse ArrayList.
		purse.add(goldCoin);
	}
	
	/**
	 * The getCustomerName returns a String value which is the name of the Customer.
	 */
	public String getCustomerName() {
		// Returns a variable name of type String which is the name of the Customer.
		return name;
	}
	
	/**
	 * The method purchaseProducts receives a supplied shop variable of type Shop.
	 * This method calculates the total cost of all the products that are inside the shoppingBasket of the customer at that time.
	 * If the total cost is greater than the amount of goldCoins the customer has in his wallet returns false,
	 * else, removes the amount of coins the products cost and adds them to the shop coin box. Also adds the product to the ownedProducst ArrayList and
	 * removes it from the shoppingBasket.
	 */
	public boolean purchaseProducts(Shop shop) {
		// Initialises totalCost to zero.
		int totalCost = 0;
		
		// Loop until i is not less than the size of the shoppingBasket ArrayList.
		for(int i=0; i<shoppingBasket.size(); i++){
			
			// Increases the totalCost variable by the price of the product.
			totalCost += shoppingBasket.get(i).getPrice();
		}
		
		// If the totalCost is greater than the number of gold coins the Customer has then...
		if (totalCost > getCustomerGoldCoins()) {
			// Returns false.
			return false;
			
		// Else...
		} else {
			
			// Loops until i is not less than the totalCost. Increases i by one.
			for (int i=0; i<totalCost; i++) {
				
				// Removes one goldCoin from the purse ArrayList.
				purse.remove(getCustomerGoldCoins() - 1);
				// Adds a goldCoin to the shop coinBox.
				shop.addGoldCoin();
			}	
				
			// Loops until i is not greater or equal to 0. Decreases i by one.
			for (int i=shoppingBasket.size()-1; i>=0; i--) {
				// Adds the product to the ownedProducts ArrayList. 
				ownedProducts.add(shoppingBasket.get(0));
				// Removes the product from the shoppingBasket.
				shoppingBasket.remove(0);
			}
			
		// Updates the total spend amount of the customer by supplying to the method updateTotalSpend two parameters: this(refers to the class Customer) and totalCost.
		shop.updateTotalSpend(name, totalCost);		
		//Returns true.
		return true;
		}
	}
	
	/**
	 * The toString method converts the name of the class, the field names and the field values to string.
	 * Returns a String value.
	 */
	public String toString() {
		// Returns a String value.
		return "Customer" + "[name=" + this.name + "," + " purse=" + this.purse.size() + "]";
	}
	
	/**
	 * The method getCustomerGoldCoins returns an integer value which is the size of the purse.
	 */
	public int getCustomerGoldCoins() {
		// Returns the size of the purse.
		return purse.size();
	}
	
	/**
	 * The method getShoppingBasket returns the elements in the shoppingBasket ArrayList.
	 */
	public ArrayList<Product> getShoppingBasket() {
		// Returns the elements of the shoppingBasket.
		return shoppingBasket;
	}
	
	/**
	 * The method getOwnedProducts returns the elements in the ownedProducts ArrayList.
	 */
	public ArrayList<Product> getOwnedProducts() {
		// Returns the elements of the ownedProducts ArrayList.
		return ownedProducts;
	}

	
}