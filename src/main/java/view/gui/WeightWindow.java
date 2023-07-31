package view.gui;

import java.math.BigDecimal;


import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for weight window, it is shown when the user click the 'Weight' menu, in the principal window
 */
public class WeightWindow extends DefaultConverterWindow implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that builds all the window components
	 */
	public WeightWindow() {
		super();
		
		lblLeftContentTitle.setText("Formula");
		
		optionStrings = new String[] {" ","kg (Kilograms)","g (Grams)", "lb (Pounds)"};
		
		DefaultComboBoxModel<String> newModelFrom = new DefaultComboBoxModel<>(optionStrings);
		comboBoxFrom.setModel(newModelFrom);
		
		
		DefaultComboBoxModel<String> newModelTo = new DefaultComboBoxModel<>(optionStrings);
		comboBoxTo.setModel(newModelTo);

		
		lblLeftContentTitle.setForeground(new Color(56, 28, 104));
		
		textAreaLeftContent.setFont(PrincipalWindow.createFont(14));
		textAreaLeftContent.setBackground(new Color(56, 28, 104));
		textAreaLeftContent.setBounds(35, 137, 156, 83);
		
		leftContentPanel.setBackground(new Color(155, 141, 192));
		
		principalContentPanel.setBackground(new Color(56, 28, 104));
		
		lblConverterTitle.setLocation(193, 45);
		lblConverterTitle.setText("Weight Converter");
		
		btnConvert.setForeground(new Color(56, 28, 104));
		btnConvert.addActionListener(this);
		
	}

	/**
	 * convert method, where the controller calls the weight conversion method 
	 */
	@Override
	protected String convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		return controller.weightConversion(cuantityInput, comboBoxFromString, comboBoxToString).toString();
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
				
				//Kilograms to Grams
				if(comboBoxFromString.equals(getOptionStrings()[1]) && 
						comboBoxToString.equals(getOptionStrings()[2])) {
					textAreaLeftContent.setText(writeFormulas("Kg to g"));
				
					//Kilograms to Pounds
				}else if(comboBoxFromString.equals(getOptionStrings()[1]) && 
						comboBoxToString.equals(getOptionStrings()[3])) {
					textAreaLeftContent.setText(writeFormulas("Kg to lb"));
				
					//Grams to Kilograms
				}else if(comboBoxFromString.equals(getOptionStrings()[2]) && 
						comboBoxToString.equals(getOptionStrings()[1])){
					textAreaLeftContent.setText(writeFormulas("g to Kg"));
				
					//Grams to Pounds
				}else if(comboBoxFromString.equals(getOptionStrings()[2]) && 
						comboBoxToString.equals(getOptionStrings()[3])){
					textAreaLeftContent.setText(writeFormulas("g to lb"));
				
					
					//Pounds to Kilograms
				}else if(comboBoxFromString.equals(getOptionStrings()[3]) && 
						comboBoxToString.equals(getOptionStrings()[1])) {
					textAreaLeftContent.setText(writeFormulas("lb to Kg"));
					
					//Pounds to Grams
				}else if(comboBoxFromString.equals(getOptionStrings()[3]) && 
						comboBoxToString.equals(getOptionStrings()[2])) {
					textAreaLeftContent.setText(writeFormulas("lb to g"));
					
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
	 * It uses a switch that returns a specific formula 
	 * @param option The specific formula we want (example: 'm to km') 
	 * @return The specific formula 
	 */
	private String writeFormulas(String option) {
		String result = "\n \n";
		switch (option) {
		//Kilograms to Grams
		case "Kg to g":
			result =result + "      g = Kg * 1000";
			
			break;
			
		//Kilograms to Pounds
		case "Kg to lb":
			result = result+ "      lb = Kg / 0.45359237";
			break;
			
		//Grams to Kilograms
		case "g to Kg":
			result = result + "      Kg = g / 1000";
			break;
		//Grams to Pounds
		case "g to lb":
			result = result + "      lb = g / 453.59237";
			break;
		//Pounds to Kilograms
		case "lb to Kg":
			result = result + "      Kg = lb * 0.45359237";
			break;
			
		//Pounds to Grams
		case "lb to g":
			result = result + "      g = lb * 453.59237";
			break;
	
		default:
			result = result + "      No formula to show";
			break;
		}
		
		return result;
	}

}
