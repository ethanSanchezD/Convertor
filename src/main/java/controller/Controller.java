package controller;

import java.math.BigDecimal;

import model.CurrencyConvertor;
import view.gui.CurrencyWindow;
import view.gui.PrincipalWindow;

public class Controller {
	
	private PrincipalWindow principalWindow;
	private CurrencyWindow currencyWindow;
	private CurrencyConvertor currencyConvertor = new CurrencyConvertor();
	

	public void setPrincipalWindow(PrincipalWindow principalWindow) {
		this.principalWindow = principalWindow;
	}

	public void showPrincipalWindow() {
		principalWindow.setVisible(true);
	}

	public void setCurrencyWindow(CurrencyWindow currencyWindow) {
		this.currencyWindow = currencyWindow;
		
	}

	public BigDecimal convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		BigDecimal result = currencyConvertor.convert(cuantityInput,comboBoxFromString,comboBoxToString);
		
		return result;
		
		
	}

	public void setCurrencyConvertor(CurrencyConvertor currencyConvertor) {
		this.currencyConvertor = currencyConvertor;
		
	}

}
