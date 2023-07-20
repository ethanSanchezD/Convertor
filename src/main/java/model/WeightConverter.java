package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.naming.spi.DirStateFactory.Result;

import controller.Controller;

/**
 * Class for weigth conversion logic
 */
public class WeightConverter {
	
	private Controller controller;
	
	
	/**
	 * Method that makes all the logic for weight conversion
	 * @param quantityInput The quantity that user wants to convert
	 * @param comboBoxFromString 'From' currency user option,  
	 * @param comboBoxToString 'To' currency user option
	 * @return The conversion result
	 */
	public BigDecimal convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		BigDecimal result = new BigDecimal(0);
		
		BigDecimal oneThousand = new BigDecimal(1000);
		BigDecimal zeroPointSomething = new BigDecimal(0.45359237).setScale(8, RoundingMode.HALF_UP);
		BigDecimal fourHundredAndFiftyPointSomething = new BigDecimal(453.59237).setScale(5, RoundingMode.HALF_UP);
		
		//Kilograms to Grams
		if(comboBoxFromString.equals(controller.getWeightWindow().getOptionStrings()[1]) && 
				comboBoxToString.equals(controller.getWeightWindow().getOptionStrings()[2])) {
			result = cuantityInput.multiply(oneThousand);
		
			//Kilograms to Pounds
		}else if(comboBoxFromString.equals(controller.getWeightWindow().getOptionStrings()[1]) && 
				comboBoxToString.equals(controller.getWeightWindow().getOptionStrings()[3])) {
			result = cuantityInput.divide(zeroPointSomething,3, RoundingMode.HALF_UP);
		
			//Grams to Kilograms
		}else if(comboBoxFromString.equals(controller.getWeightWindow().getOptionStrings()[2]) && 
				comboBoxToString.equals(controller.getWeightWindow().getOptionStrings()[1])){
			result = cuantityInput.divide(oneThousand,3, RoundingMode.HALF_UP);
		
			//Grams to Pounds
		}else if(comboBoxFromString.equals(controller.getWeightWindow().getOptionStrings()[2]) && 
				comboBoxToString.equals(controller.getWeightWindow().getOptionStrings()[3])){

			result = cuantityInput.divide(fourHundredAndFiftyPointSomething,3, RoundingMode.HALF_UP).setScale(5, RoundingMode.HALF_UP);
		
			
			//Pounds to Kilograms
		}else if(comboBoxFromString.equals(controller.getWeightWindow().getOptionStrings()[3]) && 
				comboBoxToString.equals(controller.getWeightWindow().getOptionStrings()[1])) {
			result = cuantityInput.multiply(zeroPointSomething);
			
			//Pounds to Grams
		}else if(comboBoxFromString.equals(controller.getWeightWindow().getOptionStrings()[3]) && 
				comboBoxToString.equals(controller.getWeightWindow().getOptionStrings()[2])) {
			result = cuantityInput.multiply(fourHundredAndFiftyPointSomething);
			
		}else {
			result = cuantityInput; 
		}
		
		
		return result.setScale(3, RoundingMode.HALF_UP);
	}
	
	/**
	 * Setter for controller field
	 * @param controller The new controller 
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

}
