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
		return weightConverter.convert(cuantityInput, comboBoxFromString, comboBoxToString);
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
	
	public void setCurrencyConverter(CurrencyConverter currencyConvertor) {
		this.currencyConverter = currencyConvertor;
		
	}

	public void setCurrencyWindowToPrincipal(CurrencyWindow currencyWindow) {
		principalWindow.setCurrencyWindow(currencyWindow);
		
	}
	
	public void setTemperatureWindowToPrincipal(TemperatureWindow temperatureWindow) {
		principalWindow.setTemperatureWindow(temperatureWindow);
	}
	
	
	public void setWeightWindowToPrincipal(WeightWindow weightWindow) {
		principalWindow.setWeightWindow(weightWindow);
		
	}

	
	public void setMeasureWindowToPrincipal(MeasureWindow measureWindow) {
		principalWindow.setMeasureWindow(measureWindow);
		
	}


	
	public void setTemperatureWindow(TemperatureWindow temperatureWindow) {
		this.temperatureWindow = temperatureWindow;
		
	}







	public void setWeightWindow(WeightWindow weightWindow) {
		this.weightWindow = weightWindow;
		
	}



	public void setWeightConverter(WeightConverter weightConverter) {
		this.weightConverter = weightConverter;		
	}



	public void setMeasureWindow(MeasureWindow measureWindow) {
		this.measureWindow = measureWindow;
	}



	public void setMeasureConverter(MeasureConverter measureConverter) {
		this.measureConverter = measureConverter;
	}

	
	public void setTemperatureConverter(TemperatureConverter temperatureConverter) {
		this.temperatureConverter = temperatureConverter;
		
	}



	public TemperatureWindow getTemperatureWindow() {
		return temperatureWindow;
	}

	
	public CurrencyWindow getCurrencyWindow() {
		return currencyWindow;
	}



	public WeightWindow getWeightWindow() {
		return weightWindow;
	}



	public MeasureWindow getMeasureWindow() {
		return measureWindow;
	}


	
}
