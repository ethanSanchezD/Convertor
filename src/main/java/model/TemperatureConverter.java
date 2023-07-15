package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import controller.Controller;

public class TemperatureConverter {
	
	private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
		
	}

	public BigDecimal convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		BigDecimal result = new BigDecimal(0);
		BigDecimal five = new BigDecimal(5);
		BigDecimal nine = new BigDecimal(9);
		BigDecimal thirtyTwo = new BigDecimal(32);
		
		
		if(comboBoxFromString.equals(controller.getTemperatureWindow().getOptionStrings()[1]) && 
				comboBoxToString.equals(controller.getTemperatureWindow().getOptionStrings()[2])) {
			
			result = cuantityInput.divide(five,3, RoundingMode.HALF_UP).multiply(nine).add(thirtyTwo);
			
		}else if(comboBoxFromString.equals(controller.getTemperatureWindow().getOptionStrings()[2]) && 
				comboBoxToString.equals(controller.getTemperatureWindow().getOptionStrings()[1])) {
			result = cuantityInput.subtract(thirtyTwo).multiply(five).divide(nine,3, RoundingMode.HALF_UP);
		}else {
			result = cuantityInput;
		}
		
		return result;
	}

}
