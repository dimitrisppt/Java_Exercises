package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;

import controller.Controller;
import model.Model;

public class MainFrame extends JFrame implements Observer{
	
	private Model model ; 
	
	private JPanel left;
	private JPanel right;
	private JPanel center;
	Character fox = new Fox(100,0);
	Character goose = new Goose(100,150);
	Character beans = new Beans(100,300);
	Character farmer = new Farmer(100,450);
	Character boat = new Boat(200, 150);
	
	ArrayList<Character> characters = new ArrayList<Character>();

	private JButton jbFarmerLeft;

	private JButton jbGooseLeft;

	private JButton jbFoxLeft;

	private JButton jbBoatLeft;

	private JButton jbFarmerRight;

	private JButton jbBeansRight;

	private JButton jbBeansLeft;

	private JButton jbGooseRight;

	private JButton jbBoatRight;

	private JButton jbFoxRight;

	public MainFrame(Controller controller, Model model) throws IOException {
		super("Fox, Goose and Bag of Beans");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.model = model;

		initWidgets(controller);
		
		characters.add(boat);
		characters.add(fox);
		characters.add(goose);
		characters.add(beans);
		characters.add(farmer);
		

		drawCharacter(characters);

		model.runProgram(boat, fox, goose, beans, farmer);
	}
	
	
	public void initWidgets(Controller controller) throws IOException {
		
		JLabel jlBoat = new JLabel("Boat: ", SwingConstants.CENTER);
		JLabel jlFox = new JLabel("Fox: ", SwingConstants.CENTER);
		JLabel jlGoose = new JLabel("Goose: ", SwingConstants.CENTER);
		JLabel jlBeans = new JLabel("Beans: ", SwingConstants.CENTER);
		JLabel jlFarmer = new JLabel("Farmer: ", SwingConstants.CENTER);
		
		// creating the buttons 
		jbBoatLeft = new JButton("<");		
		jbBoatRight = new JButton(">");		
		jbFoxLeft = new JButton("<");				
		jbFoxRight = new JButton(">");			
		jbGooseLeft = new JButton("<");			
		jbGooseRight = new JButton(">");	
		jbBeansLeft = new JButton("<");		
		jbBeansRight = new JButton(">");	
		jbFarmerLeft = new JButton("<");	
		jbFarmerRight = new JButton(">");	
		
		// adding names to the buttons so they could be referenced in the action listener 
		jbBoatLeft.setName("Boat Left");
		jbBoatRight.setName("Boat Right");
		jbFoxLeft.setName("Fox Left");
		jbFoxRight.setName("Fox Right");
		jbGooseLeft.setName("Goose Left");
		jbGooseRight.setName("Goose Right");
		jbBeansLeft.setName("Beans Left");	
		jbBeansRight.setName("Beans Right");
		jbFarmerLeft.setName("Farmer Left");
		jbFarmerRight.setName("Farmer Right");	
		
		// registering the buttons with the controller 
		jbBoatLeft.addActionListener(controller);
		jbBoatRight.addActionListener(controller);
		jbFoxLeft.addActionListener(controller);
		jbFoxRight.addActionListener(controller);
		jbGooseLeft.addActionListener(controller);
		jbGooseRight.addActionListener(controller);
		jbBeansLeft.addActionListener(controller);
		jbBeansRight.addActionListener(controller);
		jbFarmerLeft.addActionListener(controller);
		jbFarmerRight.addActionListener(controller);
		
				
		// the main frame
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(600, 300));
		
		// creating the two main panels 
		JPanel jpDisplay = new JPanel(new BorderLayout());
		JPanel jpControls = new JPanel(new GridLayout(1,15));
		
		// the panels that hold the lands and the water
		left = new JPanel (new BorderLayout());
		left.setPreferredSize(new Dimension(180, getHeight()));
		right = new JPanel (new BorderLayout());
		right.setPreferredSize(new Dimension(180, getHeight()));
		center = new JPanel (new BorderLayout());
	
		
		
		
		// adding the panels to the display panel 
		jpDisplay.add(left, BorderLayout.WEST);
		jpDisplay.add(right, BorderLayout.EAST);
		jpDisplay.add(center, BorderLayout.CENTER);
		
		// adding all the buttons and labels
		jpControls.add(jlBoat);
		jpControls.add(jbBoatLeft);
		jpControls.add(jbBoatRight);
		jpControls.add(jlFox);
		jpControls.add(jbFoxLeft);
		jpControls.add(jbFoxRight);
		jpControls.add(jlGoose);
		jpControls.add(jbGooseLeft);
		jpControls.add(jbGooseRight);
		jpControls.add(jlBeans);
		jpControls.add(jbBeansLeft);
		jpControls.add(jbBeansRight);
		jpControls.add(jlFarmer);
		jpControls.add(jbFarmerLeft);
		jpControls.add(jbFarmerRight);
		
		// adding the two main panels to the main frame
		add(jpDisplay, BorderLayout.CENTER);
		add(jpControls, BorderLayout.SOUTH);
		

	}
	
	
	public void drawCharacter (ArrayList<Character> characters){
		 
	    GamePanel gamePanel = new GamePanel(characters, model);
        
        add (gamePanel);
        
        
	}
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("view notified");

		
		if (model.getIsBoatFull()  && model.getIsBoatRight()) {
			
			jbFarmerLeft.setEnabled(false);
			jbFoxLeft.setEnabled(false);
			jbGooseLeft.setEnabled(false);
			jbBeansLeft.setEnabled(false);
			
		} else if (model.getIsBoatFull() && model.getIsBoatRight() == false) {
			jbFarmerRight.setEnabled(false);
			jbFoxRight.setEnabled(false);
			jbGooseRight.setEnabled(false);
			jbBeansRight.setEnabled(false);
		}
		

		//drawCharacter(fox);
		
	}
	
	
}
