package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import Controllers.MyListener;
import Model.Aeroplane;
import Model.Runway;
import ReusedClasses.Coordinates;

/**
 * The main class of the program, constructs the GUI of the program.
 * 
 * @author DimitrisMaiwand
 */
public class FlightSimulator extends JFrame{

	private static JSlider sliderX;
	private static JSlider sliderSpeed;
	private JTextArea jtaMessage;
	private JScrollPane jspMessage;

	/**
	 * Main method of the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		

		FlightSimulator simulator = new FlightSimulator();
		
		Coordinates coordinates = new Coordinates(5, 0);
		Aeroplane aeroplane = new Aeroplane(coordinates, 0);
		MyListener myListener = new MyListener();
		sliderX.addChangeListener(myListener);
		sliderSpeed.addChangeListener(myListener);
		Runway runway = new Runway(10, 100);
		
	
		aeroplane.runSimulation(simulator, aeroplane, coordinates, myListener, runway);
	}
	
	public FlightSimulator() {
		// Creation of the JFrame with name Flight Simulator.
				super("Flight Simulator");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Sets the size of the frame to 500x500 pixels.
				setSize(500, 500);

				// Creation of a JTextArea to represent the printing statements with the
				// details of the aeroplane.
				jtaMessage = new JTextArea();

				// Creation of a JSlider with bounds 0-10 and a starting value of 5, to
				// represent the x-coordinates of the aeroplane.
				sliderX = new JSlider(0, 10, 5);
				// Sets the size of the JSlider to 500 pixels width and 60 pixels
				// height.
				sliderX.setPreferredSize(new Dimension(500, 60));
				// Divides the JSlider into 10 equal sized spaces.
				sliderX.setMajorTickSpacing(1);
				// Turns on the ticks of the JSlider.
				sliderX.setPaintTicks(true);
				// Prints the value of each tick.
				sliderX.setPaintLabels(true);

				// Creation of a vertical JSlider with bounds 0-10 and a starting value
				// of 0, to represent the speed of the aeroplane.
				sliderSpeed = new JSlider(JSlider.VERTICAL, 0, 10, 0);
				// Sets the size of the JSlider to 60 pixels width and 300 pixels
				// height.
				sliderSpeed.setPreferredSize(new Dimension(60, 300));
				// Divides the JSlider into 10 equal sized spaces.
				sliderSpeed.setMajorTickSpacing(1);
				// Turns on the ticks of the JSlider.
				sliderSpeed.setPaintTicks(true);
				// Prints the value of each tick.
				sliderSpeed.setPaintLabels(true);

				// Creation of a JScrollPane to include a scrolling bar if the printing
				// statements at the JTextArea are too long.
				jspMessage = new JScrollPane(jtaMessage);
				// Adds the JScrollPane to the frame.
				add(jspMessage);

				// Creates a reset button.
				JButton jbReset = new JButton("Reset");

				// Divides the frame in two, the top to represent the runway and the
				// bottom to represent the controls.
				setLayout(new GridLayout(2, 1));
				// Creates a JPanel for the top, using BorderLayout.
				JPanel jpTop = new JPanel(new BorderLayout());
				// Creates a JPanel for the bottom, using BorderLayout.
				JPanel jpBottom = new JPanel(new BorderLayout());

				// Adds the panels to the frame.
				add(jpTop);
				add(jpBottom);

				// Adds the JScrollPane to the top panel.
				jpTop.add(jspMessage);

				// Adds the JSlider that controls the x-coordinates of the aeroplane, at
				// the North of the Panel.
				jpBottom.add(sliderX, BorderLayout.NORTH);
				// Adds the JSlider that controls the speed of the aeroplane, at the
				// CENTER of the Panel.
				jpBottom.add(sliderSpeed, BorderLayout.CENTER);
				// Adds the reset button at the South of the Panel.
				jpBottom.add(jbReset, BorderLayout.SOUTH);

				// Automatically adjusts the dimensions of the frame if we change the
				// size of the frame manually.
				pack();
				// Makes the frame visible.
				setVisible(true);
	}


	public void setJtaMessage(String message) {
		jtaMessage.append(message);
	}

}
