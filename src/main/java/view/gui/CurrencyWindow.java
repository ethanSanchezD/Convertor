package view.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
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
 * Class for currency window, it is shown when the user click the 'Currency' menu, in the principal window
 */
public class CurrencyWindow extends DefaultConverterWindow implements ActionListener{;
	
	String[] currencyOptionsKeys = {"", "Mexican Peso","US Dollar", "Euro","British Pound", "Japanese Yen", "South Korean Won"};
	private HashMap<String,String> hashMapOptions;
	
	
	/**
	 * Constructor that builds all the components in the window 
	 */
	public CurrencyWindow() {
		super();
		principalContentPanel.setForeground(new Color(255, 255, 254));
		optionStrings = new String[] {" ","MXN","USD","EUR","GBP","JPY","KRW"};
		fillHashMap();
		
		contentConverterPanel.setBackground(new Color(255, 255, 255));
		
		
		
		leftContentPanel.setBackground(new Color(122, 134, 188));
		
		
		lblLeftContentTitle.setText("Acronyms");
		lblLeftContentTitle.setForeground(new Color(35, 41, 70));
		
		
		JTextArea textAreaCurrencyWindowArea = new JTextArea();
		textAreaCurrencyWindowArea.setColumns(1);
		textAreaCurrencyWindowArea.setForeground(new Color(255, 255, 255));
		textAreaCurrencyWindowArea.setFont(PrincipalWindow.createFont(13));
		textAreaCurrencyWindowArea.setBackground(new Color(35, 41, 70));
		textAreaCurrencyWindowArea.setBounds(35, 90, 154, 239);
		leftContentPanel.remove(textAreaLeftContent);
		leftContentPanel.add(textAreaCurrencyWindowArea);
		
		textAreaCurrencyWindowArea.setText(printHashMapOptions());
		
		
		
		principalContentPanel.setBackground(new Color(35, 41, 70));
		
		lblConverterTitle.setText("Currency Convertor");
		lblConverterTitle.setForeground(new Color(255, 255, 254));
		
		
		textFieldCuantityInput.setBounds(93, 141, 129, 20);
		
		lblCuantity.setForeground(new Color(255, 255, 254));
		
		
		lblFrom.setForeground(new Color(255, 255, 254));
		
		
		DefaultComboBoxModel<String> newModelFrom = new DefaultComboBoxModel<>(optionStrings);
		comboBoxFrom.setModel(newModelFrom);
		comboBoxFrom.setBounds(93, 203, 129, 22);
		
		
		
		DefaultComboBoxModel<String> newModelTo = new DefaultComboBoxModel<>(optionStrings);
		comboBoxTo.setModel(newModelTo);
		comboBoxTo.setBounds(256, 203, 129, 22);
	
		btnConvert.setForeground(new Color(35, 41, 70));
		btnConvert.setBackground(new Color(255, 255, 254));
		
		btnConvert.addActionListener(this);
		
		lblCuantityDescription.setForeground(new Color(192, 192, 192));
		lblCuantityDescription.setFont(PrincipalWindow.createFont(12));
		
		
		lblCuantityResult.setForeground(new Color(255, 255, 254));
		lblCuantityResult.setFont(PrincipalWindow.createFont(18));
		
	

	}
	


	/**
	 * It returns a string with all the currency acronyms meaning  
	 * @return The formated string
	 */
	private String printHashMapOptions() {
		String stringResultString ="";
		for(int i =1; i < optionStrings.length; i++) {
			stringResultString = stringResultString + "\n" + "   " + optionStrings[i] + " - " + currencyOptionsKeys[i] + "\n";
		}
		return stringResultString;
	}

	/**
	 * It puts in the hashmap field all the currency options as a key/value Strings
	 * Example: for 'MXN' key, 'Mexican Peso' value  
	 */
	private void fillHashMap() {
		hashMapOptions = new HashMap<String, String>();
		for(int i =0; i <  optionStrings.length ;i++) {
			hashMapOptions.put(optionStrings[i],currencyOptionsKeys[i]);
		}
		
	}

	/**
	 * The action performed when btnConvert button is clicked  
	 * It changes textAreaLeftContent, lblCuantityDescription and lblCuantityResult depending of
	 * 'From' and 'To' user options
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConvert) {
			
				if( super.noErrorMessages()) {
					BigDecimal cuantityInput = new BigDecimal(textFieldCuantityInput.getText());
					String comboBoxFromString  = comboBoxFrom.getSelectedItem().toString();
					String comboBoxToString = comboBoxTo.getSelectedItem().toString();					
					String result = convert(cuantityInput, comboBoxFromString, comboBoxToString).toString();
					lblCuantityDescription.setText(cuantityInput.toString() + " " + hashMapOptions.get(comboBoxFromString) + " =");
					lblCuantityResult.setText(result + " " + hashMapOptions.get(comboBoxToString));	
					
				}
				
				
				
					
				
		}
			
			
		
		
	}
	
	/**
	 * convert method, where the controller calls the currency conversion method 
	 */
	@Override
	protected String convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		return controller.currencyConversion(cuantityInput, comboBoxFromString, comboBoxToString).toString();
	}


	/**
	 * Getter for controller field
	 * @return The controller 
	 */
	public Controller getController() {
		return this.controller;
	}


	
}
