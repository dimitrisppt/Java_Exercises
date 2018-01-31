package Model;

/**
 * This class represents the Runway of the aeroplane. Its dimensions are passed
 * as parameters when we create objects of this class. It has getLength and
 * getWidth methods that return the length and the width of the runway
 * respectively.
 * 
 * @author DimitrisMaiwand
 *
 */
public class Runway {

	private int width;
	private int length;

	/**
	 * @param width
	 * @param length
	 */
	public Runway(int width, int length) {

		this.width = width;
		this.length = length;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

}
