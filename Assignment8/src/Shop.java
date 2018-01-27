// Imports ArrayList from java's utilities.
import java.util.ArrayList;
// Imports TreeMap from java's utilities.
import java.util.TreeMap;

/**
 * The class Shop consists of fields: name of type String, products which is an ArrayList of Product, coinBox which is an ArrayList of GoldCoin and
 * a customerTotalSpend which is a TreeMap of String and Integer.
 * The constructor Shop receives three parameters, name of type String, number of type integer, product of type ArrayList of Product.
 * It has a method addProduct that receives a parameter product of type Product and adds it to the products ArrayList.
 * It has a method removeProduct that receives a parameter product of type Product and removes it from the products ArrayList.
 * It has a method searchProduct that receives a parameter productName of type String and returns a Product, if the supplied productName exists in the products ArrayList, else returns null.
 * It has a method add GoldCoin which adds a goldCoin to the coinBox ArrayList.
 * It has a method toString that converts the name of the class, the field names and the field values to string.
 * It has a method getNumberOfGoldCoins which returns the coinBox ArrayList size.
 */
public class Shop {
	
	// Creation of field name of type String.
	private String name;
	// Creation of field products which is an ArrayList of Product.
	private ArrayList<Product> products;
	// Creation of field coinBox which is an ArrayList of GoldCoin.
	private ArrayList<GoldCoin> coinBox;
	// Creation of field customerTotalSpend which is a TreeMap of String and Integer.
	private TreeMap<String, Integer> customerTotalSpend;
	
	/**
	 * The constructor Shop receives three parameters, name of type String, number of type integer, product of type ArrayList of Product.
	 * The coinBox, ArrayList and customerTotalSpend TreeMap are created.
	 * Also the coinBox ArrayList is filled up with GoldCoins.
	 */
	public Shop(String name, int number, ArrayList<Product> products) {
		
		// Refers the name variable to the class.
		this.name = name;
		// Refers the products variable to the class.
		this.products = products;
		// A new ArrayList of GoldCoin is created and assigned to coinBox.
		coinBox = new ArrayList<GoldCoin>();
		// A new TreeMap of String and Integer is created and assigned to customerTotalSpend.
		customerTotalSpend = new TreeMap<String, Integer>();
		// Loop until i is not less than the supplied number variable.
		for (int i=0; i<number; i++){
			// Adds a GoldCoin to the coinBox ArrayList using the addGoldCoin method.
			addGoldCoin();
		}
	}
	
	/**
	 * The method addProduct receives a product variable of type Product and adds it to the products ArrayList.
	 */
	public void addProduct(Product product) {
		
		// Adds the supplied product variable to the products ArrayList.
		products.add(product);
	}	
		
	/**
	 * The method removeProduct receives a product variable of type Product. Searches if there is a product with the same name as the supplied product
	 * in the products ArrayList and then removes it from the products ArrayList. Then returns true. If it cannot finds the product returns false.
	 */
	public boolean removeProduct(Product product) {
		
		// If there is a product with the same name as the supplied product in the products ArrayList and then removes it from the products ArrayList.
		if (searchProduct(product.getName()) == product) {
			// Removes the product from the products ArrayList.
			products.remove(product);
			// Returns true
			return true;
		}
		// Returns false.
		return false;
	}
	
	/**
	 * The method searchProduct receives a parameter productName of type String and returns a Product if there is a product with the same name as the supplied product
	 * in the products ArrayList. Then returns that product. Else, returns null.
	 */
	public Product searchProduct(String productName) {
		
		// Loop until i is not less than the products ArrayList size.
		for (int i=0; i<products.size(); i++) {
			// Checks whether the name of Product at the index(i) is the same as the supplied productName.
			if (products.get(i).getName().equals(productName)) {
				// Returns the Product at the index(i). 
				return products.get(i);
			}	
		}
		// Returns null.
		return null;
	}
	
	/**
	 * The method addGoldCoin adds a new GoldCoin to the coinBox ArrayList.
	 */
	public void addGoldCoin(){
		// Adds a new GoldCoin to the coinBox ArrayList.
		coinBox.add(new GoldCoin());
	}
	
	/**
	 * The method updateTotalSpend receives two parameters, customer of type String and goldCoins of type integer.
	 * This method updates the total spend associated with that customer's name by adding on the supplied amount of coins.
	 */
	public void updateTotalSpend(String customer, int goldCoins) {
		
		// Checks whether there is a customer with that name
		if (customerTotalSpend.containsKey(customer)){	
			// Declares the amount variable to integer and initialise it to the amount of goldCoins the customer spent.
			int amount = customerTotalSpend.get(customer); 
			// Adds the customer's name and the amount to the customerTotalSpend TreeMap.
			customerTotalSpend.put(customer, new Integer(amount));
		// Else...
		} else {
			// Update the total spend associated with that customer's name.
			customerTotalSpend.put(customer, new Integer(goldCoins));
		}
	}
	
	/**
	 * The toString method converts the name of the class, the field names and the field values to string.
	 * Returns a String value.
	 */
	public String toString() {
		
		// Returns the name of the class, the field names and the field values, as a String values.
		return "Shop" + "[name=" + this.name + "," + " products=" + this.products + ", coinBox=";
	}
	
	/**
	 * The method getNumberOfGoldCoins returns an integer value which is the coinBox size.
	 */
	public int getNumberOfGoldCoins() {
		// Returns the coinBox size.
		return coinBox.size();
	}
}
