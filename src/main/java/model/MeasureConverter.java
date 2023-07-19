package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import controller.Controller;

public class MeasureConverter {
	
	private Controller controller;
	
	
	public void setController(Controller controller) {
		this.controller = controller;
		
	}
	
	public BigDecimal convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		BigDecimal result = new BigDecimal(0);
		
		BigDecimal onethousand = new BigDecimal(1000);
		BigDecimal onethousandAndSixhundredAndNine = new BigDecimal(1609);
		BigDecimal threePointTwohundredAndEightyONe = new BigDecimal(3.281).setScale(3,RoundingMode.HALF_UP);
		BigDecimal onePointSixhundredAndNine = new BigDecimal(1.609).setScale(3,RoundingMode.HALF_UP);
		BigDecimal threethousandAndTwohundredAndEightyOne = new BigDecimal(3281);
		BigDecimal fiveThousanAndTwohundredAndEighty = new BigDecimal(5280);
		
		//Meter to Kilometer
		if(comboBoxFromString.equals(controller.getMeasureWindow().getOptionStrings()[1]) && 
				comboBoxToString.equals(controller.getMeasureWindow().getOptionStrings()[2])) {
			result = cuantityInput.divide(onethousand,3,RoundingMode.HALF_UP);
		
			//Meter to Mile
		}else if(comboBoxFromString.equals(controller.getMeasureWindow().getOptionStrings()[1]) && 
				comboBoxToString.equals(controller.getMeasureWindow().getOptionStrings()[3])) {
			result = cuantityInput.divide(onethousandAndSixhundredAndNine,3,RoundingMode.HALF_UP);
		
		//Meter to Foot
		}else if(comboBoxFromString.equals(controller.getMeasureWindow().getOptionStrings()[1]) && 
				comboBoxToString.equals(controller.getMeasureWindow().getOptionStrings()[4])){
			result = cuantityInput.multiply(threePointTwohundredAndEightyONe);
		
		//Kilometer to Meter
		}else if(comboBoxFromString.equals(controller.getMeasureWindow().getOptionStrings()[2]) && 
				comboBoxToString.equals(controller.getMeasureWindow().getOptionStrings()[1])){
			result = cuantityInput.multiply(onethousand);
		
			
		//Kilometer to Mile
		}else if(comboBoxFromString.equals(controller.getMeasureWindow().getOptionStrings()[2]) && 
				comboBoxToString.equals(controller.getMeasureWindow().getOptionStrings()[3])) {
			result = cuantityInput.divide(onePointSixhundredAndNine, 3, RoundingMode.HALF_UP);
			
		//kilometer to Foot
		}else if(comboBoxFromString.equals(controller.getMeasureWindow().getOptionStrings()[2]) && 
				comboBoxToString.equals(controller.getMeasureWindow().getOptionStrings()[4])) {
			result = cuantityInput.multiply(threethousandAndTwohundredAndEightyOne);
			
		//Foot to Meter 
		}else if(comboBoxFromString.equals(controller.getMeasureWindow().getOptionStrings()[4]) && 
				comboBoxToString.equals(controller.getMeasureWindow().getOptionStrings()[1])) {
			result = cuantityInput.divide(threePointTwohundredAndEightyONe, 3, RoundingMode.HALF_UP);
		
		//Foot to Kilometer
		}else if(comboBoxFromString.equals(controller.getMeasureWindow().getOptionStrings()[4]) && 
				comboBoxToString.equals(controller.getMeasureWindow().getOptionStrings()[2])) {
			result = cuantityInput.divide(threethousandAndTwohundredAndEightyOne, 3, RoundingMode.HALF_UP);
			
		//Foot to Mile	
		}else if(comboBoxFromString.equals(controller.getMeasureWindow().getOptionStrings()[4]) && 
				comboBoxToString.equals(controller.getMeasureWindow().getOptionStrings()[3])) {
			result = cuantityInput.divide(fiveThousanAndTwohundredAndEighty,3, RoundingMode.HALF_UP );
		}else {
			result = cuantityInput;
		}
		
		return result.setScale(3,RoundingMode.HALF_UP);
		
	}
}
