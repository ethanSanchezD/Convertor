package view.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import controller.Controller;

import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class for temperature window, it is shown when the user click the 'Temperature' menu, in the principal window
 */
public class TemperatureWindow extends DefaultConverterWindow implements ActionListener{ 

	
	/**
	 * Constructor that builds all the window components
	 */
	public TemperatureWindow() {
		
		super();
		
		
		optionStrings = new String[] {" ","°C (Celsius)","°F (Fharenheit)", "K (Kelvins)"};

		lblLeftContentTitle.setText("Formula");
		
		textAreaLeftContent.setText("  ");
		textAreaLeftContent.setFont(PrincipalWindow.createFont(14));
		textAreaLeftContent.setBounds(35, 137, 156, 83);
		textAreaLeftContent.setBackground(new Color(9, 64, 103));
		
		
		lblLeftContentTitle.setForeground(new Color(9, 64, 103));
		leftContentPanel.setBackground(new Color(109, 156, 190));
		lblConverterTitle.setBounds(159, 46, 280, 36);
		contentConverterPanel.setBackground(new Color(255, 255, 255));
		

		principalContentPanel.setBackground(new Color(9, 64, 103));
		
		lblConverterTitle.setText("Temperature Converter");
		lblConverterTitle.setForeground(new Color(255, 255, 254));
		
		
		
		
		lblCuantity.setForeground(new Color(255, 255, 254));
		
		lblFrom.setForeground(new Color(255, 255, 254));
	
		DefaultComboBoxModel<String> newModelFrom = new DefaultComboBoxModel<>(optionStrings);
		comboBoxFrom.setModel(newModelFrom);
		
		
		DefaultComboBoxModel<String> newModelTo = new DefaultComboBoxModel<>(optionStrings);
		comboBoxTo.setModel(newModelTo);
	
		
		btnConvert.setForeground(new Color(9, 64, 103));
		btnConvert.addActionListener(this);
		
	
		
		
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
					
					//Celsius to Fahrenheit
					if(comboBoxFromString.equals(getOptionStrings()[1]) && 
							comboBoxToString.equals(getOptionStrings()[2])) {
						textAreaLeftContent.setText(writeFormulas("C to F"));
					
					//Fahrenheit to Celsius
					}else if(comboBoxFromString.equals(getOptionStrings()[2]) && 
							comboBoxToString.equals(getOptionStrings()[1])) {
						textAreaLeftContent.setText(writeFormulas("F to C"));
					
					//Fahrenheit to Kelvin
					}else if(comboBoxFromString.equals(getOptionStrings()[2]) && 
							comboBoxToString.equals(getOptionStrings()[3])){
						textAreaLeftContent.setText(writeFormulas("F to K"));
					
					//Kelvin to Fahrenheit
					}else if(comboBoxFromString.equals(getOptionStrings()[3]) && 
							comboBoxToString.equals(getOptionStrings()[2])){
						textAreaLeftContent.setText(writeFormulas("K to F"));
					
						
					//Celsius to Kelvin
					}else if(comboBoxFromString.equals(getOptionStrings()[1]) && 
							comboBoxToString.equals(getOptionStrings()[3])) {
						textAreaLeftContent.setText(writeFormulas("C to K"));
						
					//Kelvin to Celsius
					}else if(comboBoxFromString.equals(getOptionStrings()[3]) && 
							comboBoxToString.equals(getOptionStrings()[1])) {
						textAreaLeftContent.setText(writeFormulas("K to C"));
						
					}else {
						textAreaLeftContent.setText(writeFormulas(""));
					}
					
					lblCuantityDescription.setText(cuantityInput.toString() + " " + comboBoxFromString+ " =");
					lblCuantityResult.setText(result + " " + comboBoxToString);	
				}
				
								
				
			
			
		}
		
	}
	
	/**
	 * convert method, where the controller calls the temperature conversion method 
	 */
	@Override
	protected String convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		return controller.temperatureyConversion(cuantityInput, comboBoxFromString, comboBoxToString).toString();
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
		//Celsius to Fahrenheit
		case "C to F":
			result =result + "      °F = ((°C/5) * 9) + 32";
			
			break;
			
		//Fahrenheit to Celsius
		case "F to C":
			result = result+ "      °C = ((°F - 32) * 5) / 9";
			break;
			
		//Fahrenheit to Kelvin
		case "F to K":
			result = result + "      K = (°F + 459.67) * 5/9";
			break;
		//Kelvin to Fahrenheit
		case "K to F":
			result = result + "      °F = (K * 9/5) - 459.67";
			break;
		//Celsius to Kelvin
		case "C to K":
			result = result + "      K = °C + 273.15";
			break;
			
		//Kelvin to Celsius
		case "K to C":
			result = result + "      °C = K - 273.15";
			break;
	
		default:
			result = result + "      No formula to show";
			break;
		}
		
		return result;
	}
}
