package assessment;

import view.MainFrame;
import view.Character;
import view.Farmer;
import view.Fox;
import view.Goose;

import java.io.IOException;

import controller.Controller;
import model.Model;
import view.Beans;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Model model = new Model (); 
		
		Controller controller = new Controller(model);
		
		MainFrame mainFrame = new MainFrame(controller, model);
		
		mainFrame.setVisible(true);
		
		model.addObserver(mainFrame);

		
	}

}
