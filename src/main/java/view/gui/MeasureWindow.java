package view.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

/**
 * Class for measure window, it is shown when the user click the 'Measure' menu, in the principal window
 */
public class MeasureWindow extends DefaultConverterWindow implements ActionListener{
	
	
	public MeasureWindow() {
		super();
		
		lblLeftContentTitle.setText("Formula");
		
		optionStrings = new String[] {" ","m (meter)","km (kilometer)", "mi (mile)","ft (foot)"};
		
		DefaultComboBoxModel<String> newModelFrom = new DefaultComboBoxModel<>(optionStrings);
		comboBoxFrom.setModel(newModelFrom);
		
		
		DefaultComboBoxModel<String> newModelTo = new DefaultComboBoxModel<>(optionStrings);
		comboBoxTo.setModel(newModelTo);

		
		lblLeftContentTitle.setForeground(new Color(5, 88, 88));
		
		textAreaLeftContent.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		textAreaLeftContent.setBackground(new Color(5, 88, 88));
		textAreaLeftContent.setBounds(35, 137, 156, 83);
		
		leftContentPanel.setBackground(new Color(122, 182, 164));
		
		principalContentPanel.setBackground(new Color(5, 88, 88));
		
		lblConverterTitle.setLocation(193, 45);
		lblConverterTitle.setText("Measure Converter");
		
		btnConvert.setForeground(new Color(5, 88, 88));
		btnConvert.addActionListener(this);
	}

	/**
	 * convert method, where the controller calls the measure conversion method 
	 */
	@Override
	protected String convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		return controller.measureConversion(cuantityInput, comboBoxFromString, comboBoxToString).toString();
	}

	/**
	 * The action performed when btnConvert button is clicked  
	 * It changes textAreaLeftContent, lblCuantityDescription and lblCuantityResult depending of
	 * 'From' and 'To' user options
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConvert) {

			if(super.noErrorMessages()) {
				BigDecimal cuantityInput = new BigDecimal(textFieldCuantityInput.getText());
				String comboBoxFromString  = comboBoxFrom.getSelectedItem().toString();
				String comboBoxToString = comboBoxTo.getSelectedItem().toString();	
				String result = convert(cuantityInput, comboBoxFromString, comboBoxToString);
				
				//Meter to Kilometer
				if(comboBoxFromString.equals(getOptionStrings()[1]) && 
						comboBoxToString.equals(getOptionStrings()[2])) {
					textAreaLeftContent.setText(writeFormulas("m to km"));
				
					//Meter to Mile
				}else if(comboBoxFromString.equals(getOptionStrings()[1]) && 
						comboBoxToString.equals(getOptionStrings()[3])) {
					textAreaLeftContent.setText(writeFormulas("m to mi"));
				
				//Meter to Foot
				}else if(comboBoxFromString.equals(getOptionStrings()[1]) && 
						comboBoxToString.equals(getOptionStrings()[4])){
					textAreaLeftContent.setText(writeFormulas("m to ft"));
				
				//Kilometer to Meter
				}else if(comboBoxFromString.equals(getOptionStrings()[2]) && 
						comboBoxToString.equals(getOptionStrings()[1])){
					textAreaLeftContent.setText(writeFormulas("km to m"));
				
					
				//Kilometer to Mile
				}else if(comboBoxFromString.equals(getOptionStrings()[2]) && 
						comboBoxToString.equals(getOptionStrings()[3])) {
					textAreaLeftContent.setText(writeFormulas("km to mi"));
					
				//kilometer to Foot
				}else if(comboBoxFromString.equals(getOptionStrings()[2]) && 
						comboBoxToString.equals(getOptionStrings()[4])) {
					textAreaLeftContent.setText(writeFormulas("km to ft"));
					
				//Foot to Meter 
				}else if(comboBoxFromString.equals(getOptionStrings()[4]) && 
						comboBoxToString.equals(getOptionStrings()[1])) {
					textAreaLeftContent.setText(writeFormulas("ft to m"));
				
				//Foot to Kilometer
				}else if(comboBoxFromString.equals(getOptionStrings()[4]) && 
						comboBoxToString.equals(getOptionStrings()[2])) {
					textAreaLeftContent.setText(writeFormulas("ft to km"));
					
				//Foot to Mile	
				}else if(comboBoxFromString.equals(getOptionStrings()[4]) && 
						comboBoxToString.equals(getOptionStrings()[3])) {
					textAreaLeftContent.setText(writeFormulas("ft to mi"));
				}else {
					textAreaLeftContent.setText(writeFormulas(""));
				}
				
				lblCuantityDescription.setText(cuantityInput.toString() + " " + comboBoxFromString+ " =");
				lblCuantityResult.setText(result + " " + comboBoxToString);	
			}
		}
		
	}

	/**
	 * Write the formulas in the textAreaLeftContent depending of 'From' and 'To' user options
	 * It uses a switch that returns the specific formula 
	 * @param option The specific formula we want (example: 'm to km') 
	 * @return The specific formula 
	 */
	private String writeFormulas(String option) {
		String result = "\n \n";
		switch (option) {
		//Meter to Kilometer
		case "m to km":
			result = result + "      Km = m / 1000";
			
			break;
			
			//Meter to Mile
		case "m to mi":
			result = result+ "      Mi = m / 1609";
			break;
			
			//Meter to Foot
		case "m to ft":
			result = result + "      Ft = m * 3.281";
			break;
			//Kilometer to Meter
		case "km to m":
			result = result + "      M = km * 1000";
			break;
			//Kilometer to Mile
		case "km to mi":
			result = result + "      Mi = km / 1.609";
			break;
			
			//kilometer to Foot
		case "km to ft":
			result = result + "      Ft = km * 3281";
			break;
	
			
			//Foot to Meter 
		case "ft to m":
			result = result + "      M = ft / 3.281";
			break;
		
			//Foot to Kilometer 
		case "ft to km":
			result = result + "      Km = ft / 3281";
			break;
			//Foot to Mile 
		case "ft to mi":
			result = result + "      Mi = ft / 5280";
			break;
			
		default:
			result = result + "      No formula to show";
			break;
		}
		
		return result;
	}

}
