package controller;

import model.CurrencyConvertor;
import view.gui.CurrencyWindow;
import view.gui.PrincipalWindow;

public class Relations {
	
	public void build() {
		
		/**
		 * classes are instantiated
		 */
		PrincipalWindow principalWindow = new PrincipalWindow();
		CurrencyWindow currencyWindow = new CurrencyWindow();
		
		CurrencyConvertor currencyConvertor = new CurrencyConvertor();
		
		Controller controller = new Controller();
		
		/**
		 * Creating relations controller-views
		 */
		principalWindow.setController(controller);
		currencyWindow.setController(controller);
		currencyConvertor.setController(controller);
		
		/**
		 * Creating relations views-controller
		 */
		
		controller.setPrincipalWindow(principalWindow);
		controller.setCurrencyWindow(currencyWindow);
		controller.setCurrencyConvertor(currencyConvertor);
		
		/**
		 * showing principal window
		 */
		controller.showPrincipalWindow();
	}

}
