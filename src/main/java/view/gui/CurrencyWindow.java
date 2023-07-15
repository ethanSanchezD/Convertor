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

public class CurrencyWindow extends DefaultConverterWindow implements ActionListener{;
	
	String[] currencyOptionsKeys = {"", "Mexican Peso","US Dollar", "Euro","British Pound", "Japanese Yen", "South Korean Won"};
	private HashMap<String,String> hashMapOptions;
	private JPanel currencyAcronymPanel;
	private JLabel lblAcronymTitle;
	
	/**
	 * Create the panel.
	 */
	public CurrencyWindow() {
		super();
		principalContentPanel.setForeground(new Color(255, 255, 254));
		optionStrings = new String[] {" ","MXN","USD","EUR","GBP","JPY","KRW"};
		fillHashMap();
		
		contentConverterPanel.setBackground(new Color(255, 255, 255));
		contentConverterPanel.setBounds(0,0,816,401);
		
		currencyAcronymPanel = new JPanel();
		currencyAcronymPanel.setBackground(new Color(122, 134, 188));
		currencyAcronymPanel.setForeground(new Color(255, 255, 255));
		currencyAcronymPanel.setBounds(0, 0, 223, 401);
		contentConverterPanel.add(currencyAcronymPanel);
		currencyAcronymPanel.setLayout(null);
		
		lblAcronymTitle = new JLabel("Acronyms");
		lblAcronymTitle.setForeground(new Color(35, 41, 70));
		lblAcronymTitle.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
		lblAcronymTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcronymTitle.setBounds(43, 46, 131, 36);
		currencyAcronymPanel.add(lblAcronymTitle);
		
		JTextArea textAreaAcronym = new JTextArea();
		textAreaAcronym.setColumns(1);
		textAreaAcronym.setForeground(new Color(255, 255, 255));
		textAreaAcronym.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		textAreaAcronym.setBackground(new Color(35, 41, 70));
		textAreaAcronym.setBounds(35, 90, 154, 239);
		currencyAcronymPanel.add(textAreaAcronym);
		textAreaAcronym.setText(printHashMapOptions());
		
		principalMenuPanel.setBounds(223, 0, 593, 401);
		
		principalContentPanel.setBackground(new Color(35, 41, 70));
		
		lblConverterTitle.setText("Currency Convertor");
		lblConverterTitle.setForeground(new Color(255, 255, 254));
		
		
		textFieldCuantityInput.setBounds(93, 141, 129, 20);
		
		lblCuantity.setForeground(new Color(255, 255, 254));
		lblCuantity.setBounds(93, 110, 83, 20);
		
		lblFrom.setForeground(new Color(255, 255, 254));
		lblFrom.setBounds(93, 172, 83, 20);
		
		DefaultComboBoxModel<String> newModelFrom = new DefaultComboBoxModel<>(optionStrings);
		comboBoxFrom.setModel(newModelFrom);
		comboBoxFrom.setBounds(93, 203, 129, 22);
		
		lblTo.setBounds(256, 172, 83, 20);
		
		DefaultComboBoxModel<String> newModelTo = new DefaultComboBoxModel<>(optionStrings);
		comboBoxTo.setModel(newModelTo);
		comboBoxTo.setBounds(256, 203, 129, 22);
	
		btnConvert.setForeground(new Color(35, 41, 70));
		btnConvert.setBackground(new Color(255, 255, 254));
		btnConvert.setBounds(414, 322, 89, 23);
		btnConvert.addActionListener(this);
		
		lblCuantityDescription.setForeground(new Color(192, 192, 192));
		lblCuantityDescription.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblCuantityDescription.setBounds(93, 266, 292, 19);
		
		lblCuantityResult.setForeground(new Color(255, 255, 254));
		lblCuantityResult.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblCuantityResult.setBounds(93, 282, 292, 43);
	

	}
	


	private String printHashMapOptions() {
		String stringResultString ="";
		for(int i =1; i < optionStrings.length; i++) {
			stringResultString = stringResultString + "\n" + "   " + optionStrings[i] + " - " + currencyOptionsKeys[i] + "\n";
		}
		return stringResultString;
	}

	private void fillHashMap() {
		hashMapOptions = new HashMap<String, String>();
		for(int i =0; i <  optionStrings.length ;i++) {
			hashMapOptions.put(optionStrings[i],currencyOptionsKeys[i]);
		}
		
	}


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

	@Override
	protected String convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		return controller.currencyConvertion(cuantityInput, comboBoxFromString, comboBoxToString).toString();
	}



	public Controller getController() {
		return this.controller;
	}


	
}
