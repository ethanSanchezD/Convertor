package view.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import controller.Controller;

import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CurrencyWindow extends JPanel implements ActionListener {
	private final JPanel contentCurrencyPanel = new JPanel();
	private Controller controller;
	private JTextField textFieldCuantityInput;
	private String[ ] currencyoptionStrings = {" ","MXN","USD","EUR","GBP","JPY","KRW"};
	private JPanel currencyAcronymPanel;
	private JLabel lblNewLabel;
	private JPanel currencyMenuPanel;
	private JLabel lblCuantity;
	private JLabel lblFrom;
	private JComboBox<String> comboBoxFrom;
	private JLabel lblTo;
	private JComboBox<String> comboBoxTo;
	private JButton btnConvert;
	private JLabel lblCuantityDescription;
	private JLabel lblCuantityResult;
	private JLabel lblConvertionDescription;
	
	/**
	 * Create the panel.
	 */
	public CurrencyWindow() {
		buildComponents();

	}

	private void buildComponents() {
		controller = new Controller();
		
		setLayout(null);
		contentCurrencyPanel.setBackground(new Color(255, 255, 255));
		add(contentCurrencyPanel);
		contentCurrencyPanel.setLayout(null);
		contentCurrencyPanel.setBounds(0,0,816,401);
		
		currencyAcronymPanel = new JPanel();
		currencyAcronymPanel.setBackground(new Color(255, 128, 0));
		currencyAcronymPanel.setForeground(new Color(255, 255, 255));
		currencyAcronymPanel.setBounds(0, 0, 223, 401);
		contentCurrencyPanel.add(currencyAcronymPanel);
		currencyAcronymPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Acronyms");
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 83, 131, 36);
		currencyAcronymPanel.add(lblNewLabel);
		
		currencyMenuPanel = new JPanel();
		currencyMenuPanel.setBounds(223, 0, 593, 401);
		contentCurrencyPanel.add(currencyMenuPanel);
		currencyMenuPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("   ");
		currencyMenuPanel.add(lblNewLabel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_2 = new JLabel("   ");
		currencyMenuPanel.add(lblNewLabel_2, BorderLayout.EAST);
		
		JPanel currencyContentPanel = new JPanel();
		currencyContentPanel.setBackground(new Color(152, 186, 224));
		currencyMenuPanel.add(currencyContentPanel, BorderLayout.CENTER);
		currencyContentPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Currency Convertor");
		lblNewLabel_5.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
		lblNewLabel_5.setBounds(182, 46, 236, 36);
		currencyContentPanel.add(lblNewLabel_5);
		
		textFieldCuantityInput = new JTextField();
		textFieldCuantityInput.setBounds(93, 141, 129, 20);
		currencyContentPanel.add(textFieldCuantityInput);
		textFieldCuantityInput.setColumns(10);
		
		lblCuantity = new JLabel("Cuantity:");
		lblCuantity.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblCuantity.setBounds(93, 110, 83, 20);
		currencyContentPanel.add(lblCuantity);
		
		lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblFrom.setBounds(93, 172, 83, 20);
		currencyContentPanel.add(lblFrom);
		
		comboBoxFrom = new JComboBox<>(currencyoptionStrings);
		comboBoxFrom.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		comboBoxFrom.setBounds(93, 203, 129, 22);
		currencyContentPanel.add(comboBoxFrom);
		
		lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblTo.setBounds(256, 172, 83, 20);
		currencyContentPanel.add(lblTo);
		
		comboBoxTo = new JComboBox<>(currencyoptionStrings);
		comboBoxTo.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		comboBoxTo.setBounds(256, 203, 129, 22);
		currencyContentPanel.add(comboBoxTo);
		
		btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnConvert.setBounds(414, 322, 89, 23);
		currencyContentPanel.add(btnConvert);
		btnConvert.addActionListener(this);
		
		lblCuantityDescription = new JLabel("New label");
		lblCuantityDescription.setBounds(93, 252, 292, 19);
		currencyContentPanel.add(lblCuantityDescription);
		
		lblCuantityResult = new JLabel("New label");
		lblCuantityResult.setBounds(93, 282, 292, 43);
		currencyContentPanel.add(lblCuantityResult);
		
		lblConvertionDescription = new JLabel("New label");
		lblConvertionDescription.setBounds(93, 336, 292, 14);
		currencyContentPanel.add(lblConvertionDescription	);
	}

	public void setController(Controller controller) {
		this.controller = controller;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConvert) {
			
			BigDecimal cuantityInput = new BigDecimal(textFieldCuantityInput.getText());
			String comboBoxFromString  = comboBoxFrom.getSelectedItem().toString();
			String comboBoxToString = comboBoxTo.getSelectedItem().toString();			
			
			
			String result = controller.convert(cuantityInput, comboBoxFromString, comboBoxToString).toString();
			
			lblCuantityResult.setText(result);
		}
		
	}
}
