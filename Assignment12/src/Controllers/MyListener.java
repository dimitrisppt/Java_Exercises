package Controllers;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class is used to add the functionality of the JSliders by implementing
 * the ChangeListener class, and overriding the stateChanged method.
 *
 * @author DimitrisMaiwand
 * 
 */
public class MyListener implements ChangeListener {

	private int x;
	private int speed;

	/**
	 * The constructor initialises the values of x to 5 and speed to 0 as the
	 * starting values of the sliders.
	 */
	public MyListener() {
		x = 5;
		speed = 0;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// Keeps the object that triggered the event as a slider
		JSlider slider = (JSlider) (e.getSource());
		// Checks from which of the two sliders the event was triggered by
		// checking if the slider's orientation is horizontal.
		if (slider.getOrientation() == 0) {
			x = slider.getValue();
		}
		// Else, the slider's orientation is vertical hence is the speed slider
		else {
			speed = slider.getValue();
		}
	}

	/**
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}

}
