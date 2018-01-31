package Model;

import Controllers.MyListener;
import ReusedClasses.Coordinates;
import View.FlightSimulator;

/**
 * The class Aeroplane contains the supposed behaviour of the aeroplane on the
 * runway, it contains update methods that change the current state of it and
 * overrides the toString method in order to obtain the string representation of
 * it that can be displayed as output message.
 * 
 * @author DimitrisMaiwand
 *
 */
public class Aeroplane {

	// Define private fields.
	private Coordinates coordinates;
	private int speed;
	private int elevation;
	private int timeCounter;
	private int maxSpeedCounter;

	/**
	 * Constructor method for the Aeroplane taking Coordinates and int
	 * parameters, Also all the fields are initialised.
	 */
	public Aeroplane(Coordinates coordinates, int speed) {

		// Setting the necessary fields to equal the parameter values
		this.coordinates = coordinates;
		this.speed = speed;

		// Starting off with zero
		elevation = 0;
		timeCounter = 0;
		maxSpeedCounter = 0;
	}

	/**
	 * @return coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * Method to update the speed of the Aeroplane, so it will be changed later
	 * on
	 *
	 * @param speed
	 */
	public void updateSpeed(int speed) {
		this.speed = speed;

	}

	/**
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * This method will update the position of the X coordinate
	 * 
	 * @param x
	 */
	public void updatePositionX(int x) {
		this.coordinates.setX(x);
	}

	/**
	 * This method will update the position of the Y coordinate
	 *
	 * @param speed
	 */
	public void updatePositionY(int speed) {
		// reference setY method and in parameter take value of Y and add
		// current speed
		this.coordinates.setY(coordinates.getY() + speed);
	}

	/**
	 * This method will ensure the plane gains elevation using an if statement,
	 * so it only elevates when speed is over 10.
	 */
	public void gainElevation() {

		if (speed == 10) {
			// Tracks seconds within speed of 10
			maxSpeedCounter += 1;
			if (maxSpeedCounter > 4) {
				// then elevate after 5 seconds
				elevation += 1;
			}
			// Otherwise if elevation is not already 0 then decrease elevation
		} else if (elevation != 0) {
			elevation -= 1;
		}
	}

	/**
	 * This method will show if take off has been successful so in the case of
	 * elevation more than 5 and plane x coordinate stays at 5 then take off
	 * success.
	 *
	 * @return
	 */
	public boolean takeOff() {

		// Checks if the aeroplane is in the middle of the runway and has
		// elevation of above 5 units
		if (elevation > 5 && coordinates.getX() == 5) {
			return true;
		}
		return false;
	}

	/**
	 * This method will update the time counter by one, for tracking the number
	 * of seconds our program runs
	 *
	 * @return
	 */
	public int updateTimeCounter() {

		return timeCounter++;
	}

	/**
	 * This method overrides the toString method in order to return the string
	 * representation of the aeroplane in the form of seconds, x coordinate, y
	 * coordinate, speed and elevation.
	 */
	public String toString() {

		return "Seconds: " + timeCounter + "\n" + "X: " + coordinates.getX() + " Y: " + coordinates.getY() + " Speed: "
				+ speed + " Elevation: " + elevation + "\n";

	}
	
	public void runSimulation(FlightSimulator simulator, Aeroplane aeroplane, Coordinates Coordinates, MyListener myListener, Runway runway) {
		
	
		// While the aeroplane is still on the ground and the y coordinate is
		// less than the length of the runway, loop.
		while (aeroplane.takeOff() != true && aeroplane.getCoordinates().getY() <= runway.getLength()) {

			// Shows the string representation of the aeroplane to the
			// JTextArea.
			simulator.setJtaMessage(aeroplane.toString());

			try {
				// Pauses the program for 1000ms, (1000ms = 1sec).
				Thread.sleep(1000);
				// Update the aeroplane time counter.
				aeroplane.updateTimeCounter();
			} catch (InterruptedException e) {
			}

			// Updates the x position of the aeroplane based on the value of the
			// JSlider.
			aeroplane.updatePositionX(myListener.getX());
			// Updates the speed of the aeroplane based on the value of the
			// JSlider.
			aeroplane.updateSpeed(myListener.getSpeed());
			// Updates the y position of the aeroplane based on the speed and
			// the previous y coordinate.
			aeroplane.updatePositionY(myListener.getSpeed());
			// Determine if the aeroplane should gain elevation based on the
			// speed.
			aeroplane.gainElevation();

		}

		// Checks whether the aeroplane is in the air.
		if (aeroplane.takeOff() == true) {
			simulator.setJtaMessage("Plane in air!");
		} else {
			simulator.setJtaMessage("Take off failed.");
		}

	}

}
