/**
 * The class Harvest consist of the main method of the program.
 * Inside the main method the creation of the object farm of the class Farm is done and then
 * a harvester and a combine harvester with parameters (1,1) and (2,2,3) are added respectively.
 * Then 5 Crops: corn, wheat, oats  and barley are added with value 20 in a field inside farm.
 * The profit of the farm is calculated after the harvesting of the farm.
 */
public class Harvest {
	
	/**
	 * The main method of the program.
	 */
	public static void main(String[] args){
		
		// Creation of the object farm of the class Farm.
		Farm farm = new Farm();
		// Adds a harvester to the farm by suppling 1,1 as parameters of the method.
		farm.addHarvester(1, 1);
		// Adds a combine harvester to the farm by suppling 2,2,3 as parameters of the method.
		farm.addCombineHarvester(2, 2, 3);
		
		// Loops until i is not less than 5.
		for (int i=0; i<5; i++){
			// Adds a corn with value 20 to the farm.
			farm.addField("corn", 20);
			// Adds a wheat with value 20 to the farm.
			farm.addField("wheat", 20);
			// Adds a oats with value 20 to the farm.
			farm.addField("oats", 20);
			// Adds a barley with value 20 to the farm.
			farm.addField("barley", 20);
		}
		
		// Calls the harvest method of the class Farm.
		farm.harvest();
		// Outputs the profit of the farm.
		System.out.println("Farm's profit: " + farm.getProfit());
	}

}
