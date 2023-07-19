package controller;

import java.math.BigDecimal;

import model.CurrencyConverter;
import model.MeasureConverter;
import model.TemperatureConverter;
import model.WeightConverter;
import view.gui.CurrencyWindow;
import view.gui.MeasureWindow;
import view.gui.PrincipalWindow;
import view.gui.TemperatureWindow;
import view.gui.WeightWindow;

public class Relations {
	
	public void build() {
		
		/**
		 * classes are instantiated
		 */
		PrincipalWindow principalWindow = new PrincipalWindow();
		CurrencyWindow currencyWindow = new CurrencyWindow();
		TemperatureWindow temperatureWindow = new TemperatureWindow();
		WeightWindow weightWindow =  new WeightWindow();
		MeasureWindow measureWindow = new MeasureWindow();
			
		CurrencyConverter currencyConverter = new CurrencyConverter();
		TemperatureConverter temperatureConverter = new TemperatureConverter();
		WeightConverter weightConverter = new WeightConverter();
		MeasureConverter measureConverter = new MeasureConverter();
		
		Controller controller = new Controller();
		
		
		
		
		
		/**
		 * Creating relations controller-views
		 */
		principalWindow.setController(controller);
		currencyWindow.setController(controller);
		temperatureWindow.setController(controller);
		weightWindow.setController(controller);
		measureWindow.setController(controller);
		
		currencyConverter.setController(controller);
		temperatureConverter.setController(controller);
		weightConverter.setController(controller);
		measureConverter.setController(controller);
		
		
		
		/**
		 * Creating relations views-controller
		 */
		
		controller.setPrincipalWindow(principalWindow);
		controller.setCurrencyWindow(currencyWindow);
		controller.setTemperatureWindow(temperatureWindow);
		controller.setWeightWindow(weightWindow);
		controller.setMeasureWindow(measureWindow);
		
		controller.setCurrencyConverter(currencyConverter);
		controller.setTemperatureConverter(temperatureConverter);
		controller.setWeightConverter(weightConverter);
		controller.setMeasureConverter(measureConverter);
		
		/**
		 * Creating relations principalwindow-converters windows
		 */
		controller.setCurrencyWindowToPrincipal(currencyWindow);
		controller.setTemperatureWindowToPrincipal(temperatureWindow);
		controller.setWeightWindowToPrincipal(weightWindow);
		controller.setMeasureWindowToPrincipal(measureWindow);
		
		/**
		 * showing principal window
		 */
		controller.showPrincipalWindow();
	}

}
