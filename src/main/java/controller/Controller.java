package controller;

import java.math.BigDecimal;

import model.CurrencyConverter;
import model.TemperatureConverter;
import view.gui.CurrencyWindow;
import view.gui.PrincipalWindow;
import view.gui.TemperatureWindow;

public class Controller {
	
	private PrincipalWindow principalWindow;
	private CurrencyWindow currencyWindow;
	private CurrencyConverter currencyConverter;
	private TemperatureWindow temperatureWindow;
	private TemperatureConverter temperatureConverter;
	

	
	public void showPrincipalWindow() {
		principalWindow.setVisible(true);
	}

	

	public BigDecimal currencyConvertion(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		
		
		return currencyConverter.convert(cuantityInput,comboBoxFromString,comboBoxToString);
		
		
	}
	
	public BigDecimal temperatureyConvertion(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		return temperatureConverter.convert(cuantityInput,comboBoxFromString,comboBoxToString);
	}
	

	public BigDecimal weightConvertion(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		return null;
	}
	
	public BigDecimal MeasureConvertion(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		return null;
	}

	
	public void setPrincipalWindow(PrincipalWindow principalWindow) {
		this.principalWindow = principalWindow;
	}

	
	public void setCurrencyWindow(CurrencyWindow currencyWindow) {
		this.currencyWindow = currencyWindow;
		
	}
	
//	public void setWeightWindow(WeigthWindow weigthWindow) {
//		this.weigthWindow = weigthWindow;
//		
//	}
//	
//	public void setMeasureWindow(MesureWindow measureWindow) {
//		this.measureWindow = measureWindow;
//		
//	}

	public void setCurrencyConverter(CurrencyConverter currencyConvertor) {
		this.currencyConverter = currencyConvertor;
		
	}

	public void setCurrencyWindowToPrincipal(CurrencyWindow currencyWindow) {
		principalWindow.setCurrencyWindow(currencyWindow);
		
	}

	public void setTemperatureWindowToPrincipal(TemperatureWindow temperatureWindow) {
		principalWindow.setTemperatureWindow(temperatureWindow);
	}

	
	public void setTemperatureWindow(TemperatureWindow temperatureWindow) {
		this.temperatureWindow = temperatureWindow;
		
	}



	public void setTemperatureConverter(TemperatureConverter temperatureConverter) {
		this.temperatureConverter = temperatureConverter;
		
	}



	public TemperatureWindow getTemperatureWindow() {
		return temperatureWindow;
	}

}
