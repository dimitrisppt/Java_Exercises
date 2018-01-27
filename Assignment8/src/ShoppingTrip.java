// Imports ArrayList from java's utilities.
import java.util.ArrayList;
// Imports Scanner from java's utilities.
import java.util.Scanner;

/**
 * The class ShoppingTrip consists of the main method, where the execution of the program takes place. 
 * Creates three products, each product has two parameters a name and a price,
 * outputs their details to the terminal and stores them into an ArrayList of Product with name products.
 * Creates a shop which has three parameters, a name, number of GoldCoins inside the coinBox and the previously created products ArrayList.
 * Outputs the details of the product to the terminal.
 * Creates a customer with two parameters, a name and a number of goldCoins. Then outputs their details to the terminal.
 * Then asks the customer for input, to add product to their shopping basket, remove product or purchase products.
 * The customer has to type exit to terminate.
 */
public class ShoppingTrip {

		/**
		 * The main method of the program.
		 */
		public static void main(String[] args) {
			
			// Creation of object product1 of the class Product with parameters "Diamond", 40.
			Product product1 = new Product("Diamond", 40);
			// Creation of object product2 of the class Product with parameters "Crown Jewels", 100.
			Product product2 = new Product("Crown Jewels", 100);
			// Creation of object product3 of the class Product with parameters "Silver Locket", 60.
			Product product3 = new Product ("Silver Locket", 60);
			
			// Outputs the details of the product1 by converting it to string using the toString method. 
			System.out.println(product1.toString());
			// Outputs the details of the product2 by converting it to string using the toString method. 
			System.out.println(product2.toString());
			// Outputs the details of the product3 by converting it to string using the toString method. 
			System.out.println(product3.toString());
			// Outputs a blank line.
			System.out.println("");
			
			// Creation of an ArrayList of Product with name products.
			ArrayList<Product> products = new ArrayList<Product>();
			
			// Adds the proctus1 to the ArrayList products.
			products.add(product1);
			// Adds the proctus2 to the ArrayList products.
			products.add(product2);
			// Adds the proctus3 to the ArrayList products.
			products.add(product3);
			
			// Creation of object shop of the class Shop with parameters "Hidden Hideaway", 125, product.
			Shop shop = new Shop("Hidden Hideaway", 125, products);
			// Outputs the details of the shop by converting it to string using the toString method following by the number of goldCoins the shop has.
			System.out.println(shop.toString() + shop.getNumberOfGoldCoins() + "]");
			// Outputs a blank link.
			System.out.println("");
			
			// Creation of object customer of the class Customer with parameters "BlackBeard", 100.
			Customer customer = new Customer("BlackBeard", 100);
			// Outputs the details of the customer by converting it to string using the toString method. 
			System.out.println(customer.toString());
			// Outputs a blank line.
			System.out.println("");
			
			// Outputs a welcome message.
			System.out.println("Welcome to the shop!");
			
			// Creation of object in of the class Scanner.
			Scanner in = new Scanner(System.in);
			// Declares userInput to String and assigns it to "".
			String userInput = "";
			
			// If the userInput is not 'exit', loop.
			while (!userInput.equals("exit")){
				
				// Outputs the details of the shop following by the number of goldCoins inside the coinBox.
				System.out.println(shop.toString() + shop.getNumberOfGoldCoins() + "]");
				// Outputs what's the customer's shopping basket contains.
				System.out.println("Shopping Basket: " + customer.getShoppingBasket());
				// Outputs the current number of goldCoins the customer has.
				System.out.println("You have " + customer.getCustomerGoldCoins() + " coins.");
				// Outputs a blank line.
				System.out.println("");
				
				// Outputs the options the user can enter.
				System.out.println("Please enter one of the following options: 'add product', 'remove product', 'purchase' or 'exit' to end.");
				// Asks user for input.
				userInput = in.nextLine();
				
				// Checks whether the input from the user is equal to 'add product'.
				if (userInput.equals("add product")) {
					
					// Outputs a message to add a name of product.
					System.out.print("Enter the name of product you want to add: ");
					// Asks user for input.
					userInput = in.nextLine();
				
					// Checks if the result of the search of the product is null.
					if (shop.searchProduct(userInput) == null){
						
						// Outputs a warning message, that there is no such an item with that name.
						System.out.println("There is no such an item with the name: " + userInput);
						
					// If the result is not null...
					} else {
						
						// Declares inputProduct variable of type Product and initialise it to the result of the search.
						Product inputProduct = shop.searchProduct(userInput);
						// Adds the product to the customer's shopping basket.
						customer.addToShoppingBasket(inputProduct);
						// Removes the product from the shop's product list.
						shop.removeProduct(inputProduct);
						// Outputs a message to inform the customer.
						System.out.println("Adding " + inputProduct + " to your shopping basket...");
					}
				
				// Checks whether the input from the user is equal to 'remove product'.
				} else if (userInput.equals("remove product")) {
					
					// Outputs a message to remove a name of product.
					System.out.print("Enter the name of product you want to remove: ");
					// Asks user for input.
					userInput = in.nextLine();
					
					// Checks if the result of the search is not null
					if (customer.searchShoppingBasket(userInput) != null) {
						
						// Declares inputProduct variable of type Product and initialise it to the result of the search.
						Product inputProduct = customer.searchShoppingBasket(userInput);
						// Removes the product to the customer's shopping basket.
						customer.removeFromShoppingBasket(inputProduct);
						// Adds the product from the shop's product list.
						shop.addProduct(inputProduct);
						// Outputs a message to inform the customer.
						System.out.println("Removing " + inputProduct + " from your shopping basket...");
						// Outputs blank line.
						System.out.println("");
						
					// Else...
					} else {
						// Outputs a warning message, that there is no such an item with that name.
						System.out.println("There is no product in your shopping basket with the name: " + userInput);
					}
					
				// Checks whether the input from the user is equal to 'purchase'.
				} else if (userInput.equals("purchase")) {
						
						// Checks if the customer has enough money to purchase items.
						if (customer.purchaseProducts(shop) == false) {		
							// Outputs a warning message.
							System.out.println("You do not have enough gold coins. Please remove some items.");
							
						// Else...
						} else {
							
							// Outputs an informing message.
							System.out.println("Purchasing...");
							// The customer purchases all the products that was in his shopping basket.
							customer.purchaseProducts(shop);
							// Outputs the owned products of the customer.
							System.out.println("Owned Products: " + customer.getOwnedProducts());
							// Outputs a blank line.
							System.out.println("");
						}
				} 
			}
		
		// Closes the Scanner.	
		in.close();
		}
}
