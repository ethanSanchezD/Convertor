package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

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
		BigDecimal fourhundredAndfiftyNineDotSixtyseven = new BigDecimal(459.67).setScale(2,RoundingMode.HALF_UP);
		
		
		double fiveD = 5;
		double nineD = 9;
		double fiveNinthsD = fiveD/nineD;
		double nineFithsD = nineD/fiveD;
		
		BigDecimal fiveNinths = new BigDecimal(fiveNinthsD);
		
		BigDecimal nineFiths = new BigDecimal(nineFithsD);
		
		BigDecimal twohundredAndSeventyThreeDotFifteenBigDecimal = new BigDecimal(273.15);
		
		
		
		//Celsius to Fahrenheit
		if(comboBoxFromString.equals(controller.getTemperatureWindow().getOptionStrings()[1]) && 
				comboBoxToString.equals(controller.getTemperatureWindow().getOptionStrings()[2])) {
			
			result = cuantityInput.divide(five,3, RoundingMode.HALF_UP).multiply(nine).add(thirtyTwo);
		
		//Fahrenheit to Celsius
		}else if(comboBoxFromString.equals(controller.getTemperatureWindow().getOptionStrings()[2]) && 
				comboBoxToString.equals(controller.getTemperatureWindow().getOptionStrings()[1])) {
			result = cuantityInput.subtract(thirtyTwo).multiply(five).divide(nine,3, RoundingMode.HALF_UP);
			
		//Fahrenheit to Kelvin
		}else if(comboBoxFromString.equals(controller.getTemperatureWindow().getOptionStrings()[2]) && 
				comboBoxToString.equals(controller.getTemperatureWindow().getOptionStrings()[3])){
			result = cuantityInput.add(fourhundredAndfiftyNineDotSixtyseven).multiply(fiveNinths);
		
		
		//Kelvin to Fahrenheit
		}else if(comboBoxFromString.equals(controller.getTemperatureWindow().getOptionStrings()[3]) && 
				comboBoxToString.equals(controller.getTemperatureWindow().getOptionStrings()[2])){
			result = cuantityInput.multiply(nineFiths).subtract(fourhundredAndfiftyNineDotSixtyseven);
		
			
		//Celsius to Kelvin
		}else if(comboBoxFromString.equals(controller.getTemperatureWindow().getOptionStrings()[1]) && 
				comboBoxToString.equals(controller.getTemperatureWindow().getOptionStrings()[3])) {
			result = cuantityInput.add(twohundredAndSeventyThreeDotFifteenBigDecimal);
			
		//Kelvin to Celsius
		}else if(comboBoxFromString.equals(controller.getTemperatureWindow().getOptionStrings()[3]) && 
				comboBoxToString.equals(controller.getTemperatureWindow().getOptionStrings()[1])) {
			result = cuantityInput.subtract(twohundredAndSeventyThreeDotFifteenBigDecimal);
		}else {
			result = cuantityInput;
		}
		
		return result.setScale(3, RoundingMode.HALF_UP);
	}

}
