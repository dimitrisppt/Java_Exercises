package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Model;

public class GamePanel extends JPanel implements Observer{
	 
	private ArrayList<Character> characters;
	private Model model;
	private BufferedImage imageGrass;
	private BufferedImage imageWater;
	 
	 public GamePanel(ArrayList<Character> characters, Model model) {
		 this.characters = characters;
		 this.model = model;
		 model.addObserver(this);
	 }
	 
	 protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		try {
			imageGrass = ImageIO.read(new File("src/Images/grass.png"));
			imageWater = ImageIO.read(new File("src/Images/water.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         g.drawImage(imageGrass, (int)(69*getWidth()/1000),(int)(69*getHeight()/1000) , this);
         g.drawImage(imageWater, (int)(100*getWidth()/1000), (int)(100*getHeight()/1000), this);
         g.drawImage(imageGrass, (int)(200*getWidth()/1000),(int)(200*getHeight()/1000), this);
		 for (Character x : characters){
	         g.drawImage(x.image, (int)(x.xPos*getWidth()/1000), (int)(x.yPos*getHeight()/1000), this);
		 }
		 
     
	 }

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
		
	}
}
