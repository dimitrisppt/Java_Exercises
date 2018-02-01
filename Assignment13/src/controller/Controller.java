package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;

public class Controller implements ActionListener{

	private Model model ;
	
	
	public Controller (Model model) {
		this.model = model ;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton pressedButton = (JButton) e.getSource();
		System.out.println(pressedButton.getName());
		
		model.setCharacterPostion(pressedButton.getName());
		
		
		

	}
	
}
