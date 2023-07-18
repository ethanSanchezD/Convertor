package view.gui;

import java.math.BigDecimal;
import javax.swing.SwingConstants;

public class MeasureWindow extends DefaultConverterWindow{
	
	
	public MeasureWindow() {
		super();
		lblConverterTitle.setText("Measure Converter");
		lblConverterTitle.setHorizontalAlignment(SwingConstants.CENTER);
	}

	@Override
	protected String convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		// TODO Auto-generated method stub
		return null;
	}

}
