package model;

import java.io.IOException;
import java.math.BigDecimal;

import org.json.JSONObject;

import controller.Controller;
import okhttp3.Response;

public class CurrencyConverter {
	
	private Controller controller;

	public BigDecimal convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
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
		
		BigDecimal result = rate.multiply(cuantityInput);
		
		return result;
		
		
		
		
	}

	public void setController(Controller controller) {
		this.controller = controller;
		
	}
	
	
	

}
