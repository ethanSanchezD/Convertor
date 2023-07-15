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
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CurrencyWindow extends JPanel implements ActionListener{
	private final JPanel contentCurrencyPanel = new JPanel();
	private Controller controller;
	private JTextField textFieldCuantityInput;
	private String[] currencyOptionStrings = {" ","MXN","USD","EUR","GBP","JPY","KRW"};
	private String[] currencyOptionsKeys = {"", "Mexican Peso","US Dollar", "Euro","British Pound", "Japanese Yen", "South Korean Won"};
	private HashMap<String,String> hashMapOptions;
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
	
	/**
	 * Create the panel.
	 */
	public CurrencyWindow() {
		buildComponents();

	}

	private void buildComponents() {
		fillHashMap();
		controller = new Controller();
		
		setLayout(null);
	
		contentCurrencyPanel.setBackground(new Color(255, 255, 255));
		add(contentCurrencyPanel);
		contentCurrencyPanel.setLayout(null);
		contentCurrencyPanel.setBounds(0,0,816,401);
		
		currencyAcronymPanel = new JPanel();
		currencyAcronymPanel.setBackground(new Color(122, 134, 188));
		currencyAcronymPanel.setForeground(new Color(255, 255, 255));
		currencyAcronymPanel.setBounds(0, 0, 223, 401);
		contentCurrencyPanel.add(currencyAcronymPanel);
		currencyAcronymPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Acronyms");
		lblNewLabel.setForeground(new Color(35, 41, 70));
		lblNewLabel.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(43, 46, 131, 36);
		currencyAcronymPanel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(1);
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		textArea.setBackground(new Color(35, 41, 70));
		textArea.setBounds(35, 90, 154, 239);
		currencyAcronymPanel.add(textArea);
		textArea.setText(printHashMapOptions());
		
		currencyMenuPanel = new JPanel();
		currencyMenuPanel.setBounds(223, 0, 593, 401);
		contentCurrencyPanel.add(currencyMenuPanel);
		currencyMenuPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel currencyContentPanel = new JPanel();
		currencyContentPanel.setBackground(new Color(35, 41, 70));
		currencyMenuPanel.add(currencyContentPanel, BorderLayout.CENTER);
		currencyContentPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Currency Convertor");
		lblNewLabel_5.setForeground(new Color(255, 255, 254));
		lblNewLabel_5.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
		lblNewLabel_5.setBounds(182, 46, 236, 36);
		currencyContentPanel.add(lblNewLabel_5);
		
		textFieldCuantityInput = new JTextField();
		textFieldCuantityInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				char keyChar = e.getKeyChar();
				if(Character.isLetter(keyChar)) {
					JOptionPane.showMessageDialog(null,"Please enter a number","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textFieldCuantityInput.setBounds(93, 141, 129, 20);
		currencyContentPanel.add(textFieldCuantityInput);
		textFieldCuantityInput.setColumns(10);
		
		lblCuantity = new JLabel("Cuantity:");
		lblCuantity.setForeground(new Color(255, 255, 254));
		lblCuantity.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblCuantity.setBounds(93, 110, 83, 20);
		currencyContentPanel.add(lblCuantity);
		
		lblFrom = new JLabel("From:");
		lblFrom.setForeground(new Color(255, 255, 254));
		lblFrom.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblFrom.setBounds(93, 172, 83, 20);
		currencyContentPanel.add(lblFrom);
		
		comboBoxFrom = new JComboBox<>(currencyOptionStrings);
		comboBoxFrom.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		comboBoxFrom.setBounds(93, 203, 129, 22);
		currencyContentPanel.add(comboBoxFrom);
		
		lblTo = new JLabel("To:");
		lblTo.setForeground(new Color(255, 255, 254));
		lblTo.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblTo.setBounds(256, 172, 83, 20);
		currencyContentPanel.add(lblTo);
		
		comboBoxTo = new JComboBox<>(currencyOptionStrings);
		comboBoxTo.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		comboBoxTo.setBounds(256, 203, 129, 22);
		currencyContentPanel.add(comboBoxTo);
		
		btnConvert = new JButton("Convert");
		btnConvert.setForeground(new Color(35, 41, 70));
		btnConvert.setBackground(new Color(255, 255, 254));
		btnConvert.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnConvert.setBounds(414, 322, 89, 23);
		currencyContentPanel.add(btnConvert);
		btnConvert.addActionListener(this);
		
		lblCuantityDescription = new JLabel("  ");
		lblCuantityDescription.setForeground(new Color(192, 192, 192));
		lblCuantityDescription.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblCuantityDescription.setBounds(93, 266, 292, 19);
		currencyContentPanel.add(lblCuantityDescription);
		
		lblCuantityResult = new JLabel("  ");
		lblCuantityResult.setForeground(new Color(255, 255, 254));
		lblCuantityResult.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblCuantityResult.setBounds(93, 282, 292, 43);
		currencyContentPanel.add(lblCuantityResult);
	}

	private String printHashMapOptions() {
		String stringResultString ="";
		for(int i =1; i < currencyOptionStrings.length; i++) {
			stringResultString = stringResultString + "\n" + "   " + currencyOptionStrings[i] + " - " + currencyOptionsKeys[i] + "\n";
		}
		return stringResultString;
	}

	private void fillHashMap() {
		hashMapOptions = new HashMap<String, String>();
		for(int i =0; i <  currencyOptionStrings.length ;i++) {
			hashMapOptions.put(currencyOptionStrings[i],currencyOptionsKeys[i]);
		}
		
	}

	public void setController(Controller controller) {
		this.controller = controller;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConvert) {
			
			if(textFieldCuantityInput.getText().length()<= 0) {
				JOptionPane.showMessageDialog(null,"Type a number input","Error",JOptionPane.ERROR_MESSAGE);
				
				
			}else if(comboBoxFrom.getSelectedItem().equals(currencyOptionStrings[0]) || comboBoxTo.getSelectedItem().equals(currencyOptionStrings[0])) {
				JOptionPane.showMessageDialog(null,"Select a 'From' and 'To' option","Error",JOptionPane.ERROR_MESSAGE);
			}else {
				
				BigDecimal cuantityInput = new BigDecimal(textFieldCuantityInput.getText());
				String comboBoxFromString  = comboBoxFrom.getSelectedItem().toString();
				String comboBoxToString = comboBoxTo.getSelectedItem().toString();					
				String result = controller.convert(cuantityInput, comboBoxFromString, comboBoxToString).toString();
				
				lblCuantityDescription.setText(cuantityInput.toString() + " " + hashMapOptions.get(comboBoxFromString) + " =");
				lblCuantityResult.setText(result + " " + hashMapOptions.get(comboBoxToString));		
				
			}
			
			
		}
		
	}
}
