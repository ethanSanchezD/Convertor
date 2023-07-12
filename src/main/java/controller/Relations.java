package controller;

import view.gui.PrincipalWindow;

public class Relations {
	
	public void build() {
		
		/**
		 * classes are instantiated
		 */
		PrincipalWindow principalWindow = new PrincipalWindow();
		
		
		Controller controller = new Controller();
		
		/**
		 * Creating relations controller-views
		 */
		principalWindow.setController(controller);
		
		/**
		 * Creating relations views-controller
		 */
		
		controller.setPrincipalWindow(principalWindow);
		
		/**
		 * showing principal window
		 */
		controller.showPrincipalWindow();
	}

}
