package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Character extends JFrame{
	int xPos ;
	int yPos ;
	BufferedImage img;
	private String s = ""; 
	BufferedImage image;
	
	public Character (String s, int xPos, int yPos) throws IOException {
		System.out.println("super called");
		this.s = s;
		this.xPos = xPos; 
		this.yPos = yPos;
		this.image = ImageIO.read(new File(s));
	}
	
	
	public void setXPos (int xPos){
		this.xPos = xPos; 
	}
	
	public int getXPos (){
		return xPos;
	}
	
	public void setYPos (int yPos){
		this.yPos = yPos; 
	}
	
	public int getYPos (){
		return yPos;
	}
	

	
	
	
}
