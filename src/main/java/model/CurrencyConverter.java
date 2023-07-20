package model;

import java.io.IOException;
import java.math.BigDecimal;

import org.json.JSONObject;

import controller.Controller;
import okhttp3.Response;

/**
 * Class for currency conversion logic
 */
public class CurrencyConverter {
	
	private Controller controller;

	/**
	 * Method that makes all the logic for currency conversion (it uses an API for the conversion)
	 * @param quantityInput The quantity that user wants to convert
	 * @param comboBoxFromString 'From' currency user option,  
	 * @param comboBoxToString 'To' currency user option
	 * @return the conversion result
	 */
	public BigDecimal convert(BigDecimal quantityInput, String comboBoxFromString, String comboBoxToString) {
		String urlString = "https://api.exchangerate.host/latest?base=" + comboBoxFromString.toUpperCase();
		
		String stringResponse = null;
		try {
			Response response = new RequestHttp().makeHttpRequest(urlString);
			stringResponse = response.body().string();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		JSONObject jsonObject = new JSONObject(stringResponse);
		JSONObject ratesObject = jsonObject.getJSONObject("rates");
		BigDecimal rate = ratesObject.getBigDecimal(comboBoxToString.toUpperCase());
		
		BigDecimal result = rate.multiply(quantityInput);
		
		return result;
		
		
		
		
	}

	/**
	 * Setter for controller field
	 * @param controller The new controller 
	 */
	public void setController(Controller controller) {
		this.controller = controller;
		
	}
	
	
	

}
