package view.gui;

import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Color;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.BorderLayout;
import controller.Controller;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Father class for all windows, it has all the components that all windows has in commune   
 */
public abstract class DefaultConverterWindow extends JPanel{
	

	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentConverterPanel = new JPanel();
	protected Controller controller;
	protected JTextField textFieldCuantityInput;
	protected String[] optionStrings = {" "};
	protected JPanel principalMenuPanel;
	protected JLabel lblCuantity;

	protected JPanel leftContentPanel;
	protected JLabel lblLeftContentTitle;
	protected JTextArea textAreaLeftContent;
	
	protected JLabel lblFrom;
	protected JComboBox<String> comboBoxFrom;
	protected JLabel lblTo;
	protected JComboBox<String> comboBoxTo;
	protected JButton btnConvert;
	protected JLabel lblCuantityDescription;
	protected JLabel lblCuantityResult;
	protected JPanel principalContentPanel;
	protected JLabel lblConverterTitle;
	
	
	/**
	 * Constructor that calls buildComponents()
	 */
	public DefaultConverterWindow() {
		buildComponents();

	}

	/**
	 * Method that creates all the components in the window 
	 */
	private void buildComponents() {
		
		setLayout(null);
	
		contentConverterPanel.setBackground(new Color(255, 255, 255));
		add(contentConverterPanel);
		contentConverterPanel.setLayout(null);
		contentConverterPanel.setBounds(0,0,816,401);
		
		leftContentPanel = new JPanel();
		leftContentPanel.setForeground(new Color(255, 255, 255));
		leftContentPanel.setBounds(0, 0, 223, 401);
		contentConverterPanel.add(leftContentPanel);
		leftContentPanel.setLayout(null);
		
		lblLeftContentTitle = new JLabel("Title");
		lblLeftContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeftContentTitle.setBounds(43, 46, 131, 36);
		leftContentPanel.add(lblLeftContentTitle);
		lblLeftContentTitle.setFont(PrincipalWindow.createFont(30));
		
		textAreaLeftContent = new JTextArea();
		textAreaLeftContent.setColumns(1);
		textAreaLeftContent.setForeground(new Color(255, 255, 255));
		textAreaLeftContent.setFont(PrincipalWindow.createFont(13));
		textAreaLeftContent.setBackground(new Color(35, 41, 70));
		textAreaLeftContent.setBounds(35, 90, 154, 239);
		leftContentPanel.add(textAreaLeftContent);
		
		
		principalMenuPanel = new JPanel();
		principalMenuPanel.setBounds(223, 0, 593, 401);
		contentConverterPanel.add(principalMenuPanel);
		principalMenuPanel.setLayout(new BorderLayout(0, 0));
		
		principalContentPanel = new JPanel();
		principalContentPanel.setBackground(new Color(0, 0, 0));
		principalMenuPanel.add(principalContentPanel, BorderLayout.CENTER);
		principalContentPanel.setLayout(null);
		
		lblConverterTitle = new JLabel("Title");
		lblConverterTitle.setForeground(new Color(255, 255, 254));
		lblConverterTitle.setFont(PrincipalWindow.createFont(30));
		lblConverterTitle.setBounds(182, 46, 236, 36);
		principalContentPanel.add(lblConverterTitle);
		
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
		principalContentPanel.add(textFieldCuantityInput);
		textFieldCuantityInput.setColumns(10);
		
		lblCuantity = new JLabel("Cuantity:");
		lblCuantity.setForeground(new Color(255, 255, 254));
		lblCuantity.setFont(PrincipalWindow.createFont(18));
		lblCuantity.setBounds(93, 110, 83, 20);
		principalContentPanel.add(lblCuantity);
		
		lblFrom = new JLabel("From:");
		lblFrom.setForeground(new Color(255, 255, 254));
		lblFrom.setFont(PrincipalWindow.createFont(18));
		lblFrom.setBounds(93, 172, 83, 20);
		principalContentPanel.add(lblFrom);
		
		comboBoxFrom = new JComboBox<>(optionStrings);
		comboBoxFrom.setFont(PrincipalWindow.createFont(12));
		comboBoxFrom.setBounds(93, 203, 129, 22);
		principalContentPanel.add(comboBoxFrom);
		
		lblTo = new JLabel("To:");
		lblTo.setForeground(new Color(255, 255, 254));
		lblTo.setFont(PrincipalWindow.createFont(18));
		lblTo.setBounds(256, 172, 83, 20);
		
		principalContentPanel.add(lblTo);
		
		comboBoxTo = new JComboBox<>(optionStrings);
		comboBoxTo.setFont(PrincipalWindow.createFont(12));
		comboBoxTo.setBounds(256, 203, 129, 22);
		principalContentPanel.add(comboBoxTo);
		
		btnConvert = new JButton("Convert");
		btnConvert.setForeground(new Color(35, 41, 70));
		btnConvert.setBackground(new Color(255, 255, 254));
		btnConvert.setFont(PrincipalWindow.createFont(14));
		btnConvert.setBounds(414, 322, 89, 23);
		principalContentPanel.add(btnConvert);
		
		lblCuantityDescription = new JLabel("  ");
		lblCuantityDescription.setForeground(new Color(192, 192, 192));
		lblCuantityDescription.setFont(PrincipalWindow.createFont(12));
		lblCuantityDescription.setBounds(93, 266, 292, 19);
		principalContentPanel.add(lblCuantityDescription);
		
		lblCuantityResult = new JLabel("  ");
		lblCuantityResult.setForeground(new Color(255, 255, 254));
		lblCuantityResult.setFont(PrincipalWindow.createFont(18));
		lblCuantityResult.setBounds(93, 282, 292, 43);
		principalContentPanel.add(lblCuantityResult);
	}

	/**
	 * Method that returns true if no error was shown, false in other case
	 * @return True if no error was shown, false otherwise 
	 */
	public Boolean noErrorMessages() {
		/**
		 * if there is an space blank in the TextField 
		 */
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(textFieldCuantityInput.getText());
		
		/**
		 * if there is an space blank, the length of the String input is minor than 0, 
		 * or if the String input has a punctuation character it shows an error message 
		 * 
		 */
		if(textFieldCuantityInput.getText().length()<= 0 || matcher.find() || textFieldCuantityInput.getText().matches("[\\p{P}\\p{S}]")) {
			JOptionPane.showMessageDialog(null,"Type a valid input (no spaces, no punctuation simbols)","Error",JOptionPane.ERROR_MESSAGE);
			return false;
			
		/**
		 * If no 'from' or 'to' option is selected, ir shows an error
		 */
		}else if(comboBoxFrom.getSelectedItem().equals(optionStrings[0]) || comboBoxTo.getSelectedItem().equals(optionStrings[0])) {
			JOptionPane.showMessageDialog(null,"Select a 'From' and 'To' option","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}

	
	/**
	 * Abstract method that child classes have to implement
	 * @param quantityInput The user input 
	 * @param comboBoxFromString 'From' user input option
	 * @param comboBoxToString 'To' user input option
	 * @return The conversion result as a String
	 */
	protected abstract String convert(BigDecimal quantityInput, String comboBoxFromString, String comboBoxToString);

	/**
	 * Getter for controller field
	 * @return The controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * Setter for controller field
	 * @param controller The new controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Getter for textFieldCuantityInput field
	 * @return The textFieldCuantityInput
	 */
	public JTextField getTextFieldCuantityInput() {
		return textFieldCuantityInput;
	}

	/**
	 * Setter for textFieldCuantityInput field
	 * @param textFieldCuantityInput The new textFieldCuantityInput
	 */
	public void setTextFieldCuantityInput(JTextField textFieldCuantityInput) {
		this.textFieldCuantityInput = textFieldCuantityInput;
	}
	
	/**
	 * Getter for optionStrings field, that has 'from'/ 'to' options
	 * @return The optionStrings 
	 */
	public String[] getOptionStrings() {
		return optionStrings;
	}
	
	/**
	 * Setter for optionStrings field
	 * @param optionStrings The new optionStrings 
	 */
	public void setOptionStrings(String[] optionStrings) {
		this.optionStrings = optionStrings;
	}

	/**
	 * Getter for principalMenuPanel field
	 * @return The principalMenuPanel
	 */
	public JPanel getPrincipalMenuPanel() {
		return principalMenuPanel;
	}
	
	/**
	 * Setter for principalMenuPanel field
	 * @param principalMenuPanel The new principalMenuPanel
	 */
	public void setPrincipalMenuPanel(JPanel principalMenuPanel) {
		this.principalMenuPanel = principalMenuPanel;
	}

	/**
	 * Getter for lblCuantity field
	 * @return The lblCuantity
	 */
	public JLabel getLblCuantity() {
		return lblCuantity;
	}

	/**
	 * Setter for lblCuantity field
	 * @param lblCuantity The new lblCuantity
	 */
	public void setLblCuantity(JLabel lblCuantity) {
		this.lblCuantity = lblCuantity;
	}

	/**
	 * Getter for leftContentPanel field
	 * @return The leftContentPanel
	 */
	public JPanel getLeftContentPanel() {
		return leftContentPanel;
	}

	/**
	 * Setter for leftContentPanel field
	 * @param leftContentPanel The new leftContentPanel
	 */
	public void setLeftContentPanel(JPanel leftContentPanel) {
		this.leftContentPanel = leftContentPanel;
	}

	/**
	 * Getter for lblLeftContentTitle field
	 * @return The lblLeftContentTitle
	 */
	public JLabel getLblLeftContentTitle() {
		return lblLeftContentTitle;
	}

	/**
	 * Setter for lblLeftContentTitle field
	 * @param lblLeftContentTitle The new lblLeftContentTitle
	 */
	public void setLblLeftContentTitle(JLabel lblLeftContentTitle) {
		this.lblLeftContentTitle = lblLeftContentTitle;
	}

	/**
	 * Getter for textAreaLeftContent field
	 * @return The textAreaLeftContent
	 */
	public JTextArea getTextAreaLeftContent() {
		return textAreaLeftContent;
	}

	/**
	 * Setter for textAreaLeftContent field
	 * @param textAreaLeftContent The new textAreaLeftContent
	 */
	public void setTextAreaLeftContent(JTextArea textAreaLeftContent) {
		this.textAreaLeftContent = textAreaLeftContent;
	}

	/**
	 * Getter for lblFrom field 
	 * @return The lblFrom
	 */
	public JLabel getLblFrom() {
		return lblFrom;
	}

	/**
	 * Setter for lblFrom
	 * @param lblFrom The new lblFrom 
	 */
	public void setLblFrom(JLabel lblFrom) {
		this.lblFrom = lblFrom;
	}

	/**
	 * Getter for comboBoxFrom field
	 * @return The comboBoxFrom
	 */
	public JComboBox<String> getComboBoxFrom() {
		return comboBoxFrom;
	}

	/**
	 * Setter for comboBoxFrom field
	 * @param comboBoxFrom The new comboBoxFrom
	 */
	public void setComboBoxFrom(JComboBox<String> comboBoxFrom) {
		this.comboBoxFrom = comboBoxFrom;
	}

	/**
	 * Getter for lblTo field
	 * @return The lblTo
	 */
	public JLabel getLblTo() {
		return lblTo;
	}

	/**
	 * Setter for lblTo field
	 * @param lblTo The new lblTo
	 */
	public void setLblTo(JLabel lblTo) {
		this.lblTo = lblTo;
	}

	/**
	 * Getter for comboBoxTo field
	 * @return The comboBoxTo
	 */
	public JComboBox<String> getComboBoxTo() {
		return comboBoxTo;
	}

	/**
	 * Setter for comboBoxTo field
	 * @param comboBoxTo The new comboBoxTo
	 */
	public void setComboBoxTo(JComboBox<String> comboBoxTo) {
		this.comboBoxTo = comboBoxTo;
	}

	/**
	 * Getter for btnConvert field
	 * @return The btnConvert
	 */
	public JButton getBtnConvert() {
		return btnConvert;
	}

	/**
	 * Setter for btnConvert field
	 * @param btnConvert
	 */
	public void setBtnConvert(JButton btnConvert) {
		this.btnConvert = btnConvert;
	}

	/**
	 * Getter for lblCuantityDescription field
	 * @return The lblCuantityDescription
	 */
	public JLabel getLblCuantityDescription() {
		return lblCuantityDescription;
	}

	/**
	 * Setter for lblCuantityDescription field 
	 * @param lblCuantityDescription The new lblCuantityDescription
	 */
	public void setLblCuantityDescription(JLabel lblCuantityDescription) {
		this.lblCuantityDescription = lblCuantityDescription;
	}

	/**
	 * Getter for lblCuantityResult field
	 * @return The lblCuantityResult
	 */
	public JLabel getLblCuantityResult() {
		return lblCuantityResult;
	}

	/**
	 * Setter for lblCuantityResult field
	 * @param lblCuantityResult The new lblCuantityResult
	 */
	public void setLblCuantityResult(JLabel lblCuantityResult) {
		this.lblCuantityResult = lblCuantityResult;
	}

	/**
	 * Getter for principalContentPanel field
	 * @return The principalContentPanel
	 */
	public JPanel getPrincipalContentPanel() {
		return principalContentPanel;
	}

	/**
	 * Setter for principalContentPanel field
	 * @param principalContentPanel The new principalContentPanel
	 */
	public void setPrincipalContentPanel(JPanel principalContentPanel) {
		this.principalContentPanel = principalContentPanel;
	}

	/**
	 * Getter for lblConverterTitle field  
	 * @return The lblConverterTitle
	 */
	public JLabel getLblConverterTitle() {
		return lblConverterTitle;
	}

	/**
	 * Setter for lblConverterTitle field
	 * @param lblConverterTitle The new lblConverterTitle
	 */
	public void setLblConverterTitle(JLabel lblConverterTitle) {
		this.lblConverterTitle = lblConverterTitle;
	}

	/**
	 * Getter for contentConverterPanel field
	 * @return The contentConverterPanel
	 */
	public JPanel getContentConverterPanel() {
		return contentConverterPanel;
	}
	
	
	
	
	

}
