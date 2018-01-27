/**
 * The Product class contains the fields name of type String and price of type integer.
 * Also it has a constructor that receives two parameters, name of type String and price of type integer.
 * It has a method toString that converts the name of the class, the field names and the field values to string.
 * It has a method getName that returns a String variable, the name of the product.
 * It has a method getPrice that returns an integer variable, the price of the product.  
 */
public class Product {
	
	// Creation of field name of type String.
	private String name;
	// Creation of field price of type integer.
	private int price;
	
	/**
	 * The constructor Product receives two parameters, name of type String and price of type integer.
	 */
	public Product(String name, int price){
		
		// Refers the name variable to the class.
		this.name = name;
		// Refers the price variable to the class.
		this.price = price;
	}
	
	/**
	 * The toString method converts the name of the class, the field names and the field values to string.
	 * Returns a String value.
	 */
	public String toString() {
		
		// Returns the name of the class, the field names and the field values, as a String values.
		return "Product" + "[name=" + this.name + "," + " price=" + this.price + "]";
	}
	
	/**
	 * The method getName returns a String value, which is the name of the Product.
	 */
	public String getName() {
		// Returns the variable name which is a String value.
		return name;
	}
	
	/**
	 * The method getPrice returns an integer value, which is the price of the product.
	 */
	public int getPrice() {
		// Returns the variable price which is an integer value.
		return price;
	}
}
