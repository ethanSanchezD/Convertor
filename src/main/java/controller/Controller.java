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

/**
 * Controller class, it connects with the view classes and converter classes
 */
public class Controller {
	
	private PrincipalWindow principalWindow;
	private CurrencyWindow currencyWindow;
	private CurrencyConverter currencyConverter;
	private TemperatureWindow temperatureWindow;
	private TemperatureConverter temperatureConverter;
	private WeightWindow weightWindow;
	private WeightConverter weightConverter;
	private MeasureWindow measureWindow;
	private MeasureConverter measureConverter;
	

	
	
	
	
	/**
	 * It calls the principalwindow method to set it visible 
	 */
	public void showPrincipalWindow() {
		principalWindow.setVisible(true);
	}

	
	/**
	 * Conversion method for currency converter, it calls currencyConverter convert method
	 * @param quantityInput The input that the user enter in the Text field
	 * @param comboBoxFromString The user 'from' option input
	 * @param comboBoxToString The user 'for' option input 
	 * @return The result of the conversion 
	 */
	public BigDecimal currencyConversion(BigDecimal quantityInput, String comboBoxFromString, String comboBoxToString) {
		
		
		return currencyConverter.convert(quantityInput,comboBoxFromString,comboBoxToString);
		
		
	}
	
	/**
	 * Conversion method for temperature converter, it calls temperatureConverter convert method
	 * @param quantityInput The input that the user enter in the Text field
	 * @param comboBoxFromString The user 'from' option input
	 * @param comboBoxToString The user 'for' option input 
	 * @return The result of the conversion 
	 */
	public BigDecimal temperatureyConversion(BigDecimal quantityInput, String comboBoxFromString, String comboBoxToString) {
		return temperatureConverter.convert(quantityInput,comboBoxFromString,comboBoxToString);
	}
	
	/**
	 * Conversion method for weight converter, it calls weightConverter convert method
	 * @param quantityInput The input that the user enter in the Text field
	 * @param comboBoxFromString The user 'from' option input
	 * @param comboBoxToString The user 'for' option input 
	 * @return The result of the conversion 
	 */
	public BigDecimal weightConversion(BigDecimal quantityInput, String comboBoxFromString, String comboBoxToString) {
		return weightConverter.convert(quantityInput, comboBoxFromString, comboBoxToString);
	}
	
	/**
	 * Conversion method for measure converter, it calls measureConverter convert method
	 * @param quantityInput The input that the user enter in the Text field
	 * @param comboBoxFromString The user 'from' option input
	 * @param comboBoxToString The user 'for' option input 
	 * @return The result of the conversion 
	 */
	public BigDecimal measureConversion(BigDecimal quantityInput, String comboBoxFromString, String comboBoxToString) {
		return measureConverter.convert(quantityInput, comboBoxFromString, comboBoxToString);
	}

	/**
	 * Setter method for principalWindow field, it is where the other windows are going to show
	 * @param principalWindow The new principal window
	 */
	public void setPrincipalWindow(PrincipalWindow principalWindow) {
		this.principalWindow = principalWindow;
	}

	
	
	

	/**
	 * Setter to connect a currencyWindow to principalWindow 
	 * @param currencyWindow The currency window to connect 
	 */
	public void setCurrencyWindowToPrincipal(CurrencyWindow currencyWindow) {
		principalWindow.setCurrencyWindow(currencyWindow);
		
	}
	
	/**
	 * Setter to connect a temperatureWindow to principalWindow 
	 * @param temperatureWindow The temperature window to connect 
	 */
	public void setTemperatureWindowToPrincipal(TemperatureWindow temperatureWindow) {
		principalWindow.setTemperatureWindow(temperatureWindow);
	}
	
	/**
	 * Setter to connect a weightWindow to principalWindow  
	 * @param currencyWindow The weight window to connect 
	 */
	public void setWeightWindowToPrincipal(WeightWindow weightWindow) {
		principalWindow.setWeightWindow(weightWindow);
		
	}

	/**
	 * Setter to connect a measureWindow to principalWindow 
	 * @param measureWindow The measure window to connect 
	 */
	public void setMeasureWindowToPrincipal(MeasureWindow measureWindow) {
		principalWindow.setMeasureWindow(measureWindow);
		
	}


	/**
	 * Setter method for currencyWindow field
	 * @param currencyWindow The new currencyWindow
	 */
	public void setCurrencyWindow(CurrencyWindow currencyWindow) {
		this.currencyWindow = currencyWindow;
		
	}



	/**
	 * Setter method for temperatureWindow field
	 * @param temperatureWindow The new temperatureWindow 
	 */
	public void setTemperatureWindow(TemperatureWindow temperatureWindow) {
		this.temperatureWindow = temperatureWindow;
		
	}


	/**
	 * Setter method for weightWindow field
	 * @param weightWindow The new weightWindow 
	 */
	public void setWeightWindow(WeightWindow weightWindow) {
		this.weightWindow = weightWindow;
		
	}
	
	/**
	 * Setter method for measureWindow field
	 * @param measureWindow The new measureWindow
	 */
	public void setMeasureWindow(MeasureWindow measureWindow) {
		this.measureWindow = measureWindow;
	}

	/**
	 * Setter method for currencyConverter field
	 * @param currencyConvertor The new currencyConvertor
	 */
	public void setCurrencyConverter(CurrencyConverter currencyConvertor) {
		this.currencyConverter = currencyConvertor;
		
	}
	
	/**
	 * Setter method for temperatureConverter field
	 * @param temperatureConverter The new temperatureConverter
	 */
	public void setTemperatureConverter(TemperatureConverter temperatureConverter) {
		this.temperatureConverter = temperatureConverter;
		
	}

	/**
	 * Setter method for weighConverter field
	 * @param weightConverter The new weight converter
	 */
	public void setWeightConverter(WeightConverter weightConverter) {
		this.weightConverter = weightConverter;		
	}

	/**
	 * Setter method for measureConverter field
	 * @param measureConverter The new measureConverter
	 */
	public void setMeasureConverter(MeasureConverter measureConverter) {
		this.measureConverter = measureConverter;
	}

	
	
	


	
	/**
	 * Getter method for temperatureWindow field
	 * @return The temperatureWindow
	 */
	public TemperatureWindow getTemperatureWindow() {
		return temperatureWindow;
	}

	
	/**
	 * Getter method for currencyWindow field
	 * @return The currencyWindow
	 */
	public CurrencyWindow getCurrencyWindow() {
		return currencyWindow;
	}


	/**
	 * Getter method for weightWindow field
	 * @return The weghtWindow 
	 */
	public WeightWindow getWeightWindow() {
		return weightWindow;
	}


	/**
	 * Getter method for measureWindow field
	 * @return The measureWindow 
	 */
	public MeasureWindow getMeasureWindow() {
		return measureWindow;
	}


	
}
