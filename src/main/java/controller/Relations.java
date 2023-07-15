package controller;

import java.math.BigDecimal;

import model.CurrencyConverter;
import model.TemperatureConverter;
import view.gui.CurrencyWindow;
import view.gui.PrincipalWindow;
import view.gui.TemperatureWindow;

public class Relations {
	
	public void build() {
		
		/**
		 * classes are instantiated
		 */
		PrincipalWindow principalWindow = new PrincipalWindow();
		CurrencyWindow currencyWindow = new CurrencyWindow();
		TemperatureWindow temperatureWindow = new TemperatureWindow();
			
		CurrencyConverter currencyConverter = new CurrencyConverter();
		TemperatureConverter temperatureConverter = new TemperatureConverter();
		Controller controller = new Controller();
		
		
		
		
		
		/**
		 * Creating relations controller-views
		 */
		principalWindow.setController(controller);
		currencyWindow.setController(controller);
		
		temperatureWindow.setController(controller);
		
		currencyConverter.setController(controller);
		temperatureConverter.setController(controller);
		
		
		/**
		 * Creating relations views-controller
		 */
		
		controller.setPrincipalWindow(principalWindow);
		controller.setCurrencyWindow(currencyWindow);
		controller.setTemperatureWindow(temperatureWindow);
		
		controller.setCurrencyConverter(currencyConverter);
		controller.setTemperatureConverter(temperatureConverter);
		
		/**
		 * Creating relations principalwindow-converters windows
		 */
		controller.setCurrencyWindowToPrincipal(currencyWindow);
		controller.setTemperatureWindowToPrincipal(temperatureWindow);
		
		/**
		 * showing principal window
		 */
		controller.showPrincipalWindow();
	}

}
