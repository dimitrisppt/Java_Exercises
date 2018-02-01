package model;

import java.util.ArrayList;
import java.util.Observable;

import view.Beans;
import view.Character;
import view.Farmer;
import view.Fox;
import view.Goose;

public class Model extends Observable{
	
	// private fields: 
		// 1. x position of boat 
		// 2. x position of farmer 
		// 3. x position of goose
		// 4. x position of fox
		// 5. x position of beans
	
	private Character fox;
	private Character goose;
	private Character farmer;
	private Character beans;
	private Character boat;
	private boolean isBoatFull;
	private boolean isBoatRight;
	
	
	
	
	ArrayList<Character> characters = new ArrayList<Character>();
	
	private int xPosFox ;
	private int xPosFarmer ;
	
	
	
	
	public void setCharacterPostion (String characterDirection) {
		
		// change position of the character 
		if (characterDirection.equals("Fox Left")){
			fox.setXPos( fox.getXPos() - 100 );
			fox.setYPos(250);
		} else if (characterDirection.equals("Fox Right")){
			System.out.println("model wokring");
			fox.setXPos( fox.getXPos() + 100 );
			fox.setYPos(250);
		} else if (characterDirection.equals("Goose Left")){
			goose.setXPos( goose.getXPos() - 100 );
		} else if (characterDirection.equals("Goose Right")){
			goose.setXPos( goose.getXPos() + 100 );
			goose.setYPos(250);
		} else if (characterDirection.equals("Beans Left")){
			beans.setXPos( beans.getXPos() - 100 );
			beans.setYPos(250);
		} else if (characterDirection.equals("Beans Right")){
			beans.setXPos( beans.getXPos() + 100 );
			beans.setYPos(250);
		} else if (characterDirection.equals("Farmer Left")){
			farmer.setXPos( farmer.getXPos() - 100 );
			farmer.setYPos(250);
		} else if (characterDirection.equals("Farmer Right")){
			farmer.setXPos( farmer.getXPos() + 100 );
			farmer.setYPos(250);
		} else if (characterDirection.equals("Boat Left")){
			boat.setXPos( boat.getXPos() - 100 );
			boat.setYPos(250);
			if (isBoatFull) {
				
			}
		} else if (characterDirection.equals("Boat Right")){
			boat.setXPos(boat.getXPos() + 100 );
			boat.setYPos(250);
		}
		
		setChanged() ;
		notifyObservers();
	}
	
	public int getFoxPostion () {
		return fox.getXPos(); 
	}
	public int getFarmerPostion () {
		return farmer.getXPos(); 
	}
	public int getGoosePostion () {
		return goose.getXPos(); 
	}
	public int getBeansPostion () {
		return beans.getXPos(); 
	}
	public int getBoatPostion () {
		return boat.getXPos(); 
	}
	
	public void runProgram(Character boat,Character fox,Character goose,Character beans,Character farmer) {
		this.fox = fox; 
		this.goose = goose; 
		this.beans = beans; 
		this.farmer = farmer;
		this.boat = boat;
	}
	
	public boolean getIsBoatFull() {
		return isBoatFull;
	}
	
	public boolean getIsBoatRight() {
		return isBoatRight;
	}
	
	
	
	
}
