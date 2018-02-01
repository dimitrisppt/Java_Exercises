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
	
	private boolean isLeftSideOfRiver;
	private boolean isRightSideOfRiver;
	
	private boolean isOnBoatInfrontLeft;
	private boolean isOnBoatInfrontRight;
	
	private boolean isOnBoatBackLeft;
	private boolean isOnBoatBackRight;
	
	
	public boolean isLeftSideOfRiver() {
		return isLeftSideOfRiver;
	}


	public void setLeftSideOfRiver(boolean isLeftSideOfRiver) {
		this.isLeftSideOfRiver = isLeftSideOfRiver;
	}


	public boolean isRightSideOfRiver() {
		return isRightSideOfRiver;
	}


	public void setRightSideOfRiver(boolean isRightSideOfRiver) {
		this.isRightSideOfRiver = isRightSideOfRiver;
	}


	public boolean isOnBoatInfrontLeft() {
		return isOnBoatInfrontLeft;
	}


	public void setOnBoatInfrontLeft(boolean isOnBoatInfrontLeft) {
		this.isOnBoatInfrontLeft = isOnBoatInfrontLeft;
	}


	public boolean isOnBoatInfrontRight() {
		return isOnBoatInfrontRight;
	}


	public void setOnBoatInfrontRight(boolean isOnBoatInfrontRight) {
		this.isOnBoatInfrontRight = isOnBoatInfrontRight;
	}


	public boolean isOnBoatBackLeft() {
		return isOnBoatBackLeft;
	}


	public void setOnBoatBackLeft(boolean isOnBoatBackLeft) {
		this.isOnBoatBackLeft = isOnBoatBackLeft;
	}


	public boolean isOnBoatBackRight() {
		return isOnBoatBackRight;
	}


	public void setOnBoatBackRight(boolean isOnBoatBackRight) {
		this.isOnBoatBackRight = isOnBoatBackRight;
	}


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
