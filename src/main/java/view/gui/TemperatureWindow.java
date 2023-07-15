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

public class TemperatureWindow extends DefaultConverterWindow implements ActionListener{ 

	
	/**
	 * Create the panel.
	 */
	public TemperatureWindow() {
		
		super();
		optionStrings = new String[] {" ","°C","°F"};
		contentConverterPanel.setBackground(new Color(255, 255, 255));
		contentConverterPanel.setBounds(0,0,816,401);
		
		principalMenuPanel.setBounds(0, 0, 816, 401);

		principalContentPanel.setBackground(new Color(9, 64, 103));
		
		lblConverterTitle.setText("Temperature Convertor");
		lblConverterTitle.setForeground(new Color(255, 255, 254));
		lblConverterTitle.setBounds(278, 49, 292, 36);
		
		
		
		textFieldCuantityInput.setBounds(189, 144, 129, 20);
		
		lblCuantity.setForeground(new Color(255, 255, 254));
		lblCuantity.setBounds(189, 113, 83, 20);
		
		lblFrom.setForeground(new Color(255, 255, 254));
		lblFrom.setBounds(189, 175, 83, 20);
		
		DefaultComboBoxModel<String> newModelFrom = new DefaultComboBoxModel<>(optionStrings);
		comboBoxFrom.setModel(newModelFrom);
		comboBoxFrom.setBounds(189, 206, 129, 22);
		
		lblTo.setBounds(352, 175, 83, 20);
		
		DefaultComboBoxModel<String> newModelTo = new DefaultComboBoxModel<>(optionStrings);
		comboBoxTo.setModel(newModelTo);
		comboBoxTo.setBounds(352, 206, 129, 22);
		
		btnConvert.setForeground(new Color(9, 64, 103));
		btnConvert.setBounds(510, 325, 89, 23);
		btnConvert.addActionListener(this);
		
		lblCuantityDescription.setBounds(189, 257, 292, 19);
		
		lblCuantityResult.setBounds(189, 273, 292, 43);
	}
		
		
	
	
		
		

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConvert) {
			
				if(super.noErrorMessages()) {
					BigDecimal cuantityInput = new BigDecimal(textFieldCuantityInput.getText());
					String comboBoxFromString  = comboBoxFrom.getSelectedItem().toString();
					String comboBoxToString = comboBoxTo.getSelectedItem().toString();	
					String result = convert(cuantityInput, comboBoxFromString, comboBoxToString);
					lblCuantityDescription.setText(cuantityInput.toString() + " " + comboBoxFromString+ " =");
					lblCuantityResult.setText(result + " " + comboBoxToString);	
				}
				
								
				
			
			
		}
		
	}

	@Override
	protected String convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString) {
		return controller.temperatureyConvertion(cuantityInput, comboBoxFromString, comboBoxToString).toString();
	}
}
