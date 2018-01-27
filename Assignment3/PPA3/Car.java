/**
 * The class Car contains three methods declarations and one constructor declaration.
 * The Car constructor is invoked to create objects from the class blueprint.
 * The getCar method is used to return the id of the car.
 * The completeLap is used to calculate and return the amount of total seconds each car needs to complete 
 * a single lap in the track.
 * The getCompleteLap is used to return the total time the car runs on the track.
 */
public class Car {

	// Creation of field id of type integer.
	private int id;
	// Creation of field fuel of type integer.
	private int fuel;
	// Creation of field lowFuelBoost of type integer.
	private int lowFuelBoost;
	// Creation of field highFuelSlowdown of type integer.
	private int highFuelSlowdown;
	// Creation of field fuelConsumptionPerLap of type integer.
	private int fuelConsumptionPerLap;
	// Creation of field pitStopTime of type integer.
	private int pitStopTime;
	// Creation of field rainSlowdown of type integer.
	private int rainSlowdown;
	// Creation of field totalTime of type integer.
	private int totalTime;
	// Declaration of variable track to type RaceTrack.
	RaceTrack track;


	/* 
	 * Declaration of the constructor Car with the needed number and types of the arguments.
	 */
	public Car(RaceTrack track, int id, int fuel, int lowFuelBoost, int highFuelSlowdown, int fuelConsumptionPerLap,int pitStopTime,int rainSlowdown, int totalTime) {
		
		// Refers to the instance track of the class.
		this.track = track;
		// Refers to the instance id of the class.
		this.id = id;
		// Refers to the instance fuel of the class.
		this.fuel = fuel;
		// Refers to the instance lowFuelBoost of the class.
		this.lowFuelBoost = lowFuelBoost;
		// Refers to the instance highFuelSlowdown of the class.
		this.highFuelSlowdown = highFuelSlowdown;
		// Refers to the instance fuelConsumptionPerLap of the class.
		this.fuelConsumptionPerLap = fuelConsumptionPerLap;
		// Refers to the instance pitStopTime of the class.
		this.pitStopTime = pitStopTime;
		// Refers to the instance rainSlowDown of the class.
		this.rainSlowdown = rainSlowdown;
		// Refers to the instance totalTime of the class.
		this.totalTime = totalTime;
	}
	

	/**
	 * Creation of method getCar to return the id of the car.
	 */
	public int getCar() {
		// Returns the id of the car.
		return id;
	}
	

	/**
	 * Creation of method completeLap that is used to calculate and return the amount of total seconds each car needs to complete 
 	 * a single lap in the track.
	 */
	public void completeLap() {

		// Summation of the totalTime and the averageLapTime of the track 
		totalTime = totalTime + track.getAverageLapTime();
		
		// Checks if the fuel is above 50 units to add the highFuelSlowdown time with the totalTime
		if (fuel > 50) {

			// Summation of the totalTime with the highFuelSlowdown because the car is heavy so it goes slower.
			totalTime = totalTime + highFuelSlowdown;

		// If it's not above 50 units then the statement below is executed.
		} else {
			
			// Subtraction of the lowFuelBoost value from the totalTime because the car is lighter it goes faster.
			totalTime = totalTime - lowFuelBoost;
		}
		
		// Checks if it's raining on the track.
		if (track.getIsRaining() == true) {
			
			// Addition of the rainSlowdown value to the totalTime because it's raining therefore the car goes slower.
			totalTime = totalTime + rainSlowdown;
		}
		
		
		// Subtraction of the fuelConsumptionPerLap from the fuel because the car ran a lap on the track.
		fuel = fuel - fuelConsumptionPerLap;
		
		// Checks if the fuel is lower than the amount needed for the car to run a single lap on the track.
		if (fuel < fuelConsumptionPerLap) {
			
			// If it's lower then the car cannot run the whole track so it goes for pit stop. Addition of pitStopTime to totalTime.
			totalTime = totalTime + pitStopTime;
			// Refills the fuel to maximum capacity of 100 units.
			fuel = 100;
		}
	
	}
	
	/**
	 * Creation of method getCompleteLap to return the total time in seconds the car runs on the track.
	 */
	public int getcompleteLap(){
		
		// Returns the total time the car runs on the track.
		return totalTime;
	}

}
