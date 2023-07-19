package view.gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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

public abstract class DefaultConverterWindow extends JPanel{
	/**
	 * 
	 */
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
	 * Create the panel.
	 */
	public DefaultConverterWindow() {
		buildComponents();

	}

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
		lblLeftContentTitle.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
		
		textAreaLeftContent = new JTextArea();
		textAreaLeftContent.setColumns(1);
		textAreaLeftContent.setForeground(new Color(255, 255, 255));
		textAreaLeftContent.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
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
		lblConverterTitle.setFont(new Font("Roboto Condensed", Font.BOLD, 30));
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
		lblCuantity.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblCuantity.setBounds(93, 110, 83, 20);
		principalContentPanel.add(lblCuantity);
		
		lblFrom = new JLabel("From:");
		lblFrom.setForeground(new Color(255, 255, 254));
		lblFrom.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblFrom.setBounds(93, 172, 83, 20);
		principalContentPanel.add(lblFrom);
		
		comboBoxFrom = new JComboBox<>(optionStrings);
		comboBoxFrom.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		comboBoxFrom.setBounds(93, 203, 129, 22);
		principalContentPanel.add(comboBoxFrom);
		
		lblTo = new JLabel("To:");
		lblTo.setForeground(new Color(255, 255, 254));
		lblTo.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblTo.setBounds(256, 172, 83, 20);
		
		principalContentPanel.add(lblTo);
		
		comboBoxTo = new JComboBox<>(optionStrings);
		comboBoxTo.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		comboBoxTo.setBounds(256, 203, 129, 22);
		principalContentPanel.add(comboBoxTo);
		
		btnConvert = new JButton("Convert");
		btnConvert.setForeground(new Color(35, 41, 70));
		btnConvert.setBackground(new Color(255, 255, 254));
		btnConvert.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnConvert.setBounds(414, 322, 89, 23);
		principalContentPanel.add(btnConvert);
		
		lblCuantityDescription = new JLabel("  ");
		lblCuantityDescription.setForeground(new Color(192, 192, 192));
		lblCuantityDescription.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblCuantityDescription.setBounds(93, 266, 292, 19);
		principalContentPanel.add(lblCuantityDescription);
		
		lblCuantityResult = new JLabel("  ");
		lblCuantityResult.setForeground(new Color(255, 255, 254));
		lblCuantityResult.setFont(new Font("Roboto Condensed", Font.BOLD, 18));
		lblCuantityResult.setBounds(93, 282, 292, 43);
		principalContentPanel.add(lblCuantityResult);
	}

	public Boolean noErrorMessages() {
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(textFieldCuantityInput.getText());
		
		
		if(textFieldCuantityInput.getText().length()<= 0 || matcher.find() || textFieldCuantityInput.getText().matches("[\\p{P}\\p{S}]")) {
			JOptionPane.showMessageDialog(null,"Type a valid input (no spaces, no punctuation simbols)","Error",JOptionPane.ERROR_MESSAGE);
			return false;
			
			
		}else if(comboBoxFrom.getSelectedItem().equals(optionStrings[0]) || comboBoxTo.getSelectedItem().equals(optionStrings[0])) {
			JOptionPane.showMessageDialog(null,"Select a 'From' and 'To' option","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}

	

	protected abstract String convert(BigDecimal cuantityInput, String comboBoxFromString, String comboBoxToString);

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public JTextField getTextFieldCuantityInput() {
		return textFieldCuantityInput;
	}

	public void setTextFieldCuantityInput(JTextField textFieldCuantityInput) {
		this.textFieldCuantityInput = textFieldCuantityInput;
	}

	public String[] getOptionStrings() {
		return optionStrings;
	}

	public void setOptionStrings(String[] optionStrings) {
		this.optionStrings = optionStrings;
	}

	public JPanel getPrincipalMenuPanel() {
		return principalMenuPanel;
	}

	public void setPrincipalMenuPanel(JPanel principalMenuPanel) {
		this.principalMenuPanel = principalMenuPanel;
	}

	public JLabel getLblCuantity() {
		return lblCuantity;
	}

	public void setLblCuantity(JLabel lblCuantity) {
		this.lblCuantity = lblCuantity;
	}

	public JPanel getLeftContentPanel() {
		return leftContentPanel;
	}

	public void setLeftContentPanel(JPanel leftContentPanel) {
		this.leftContentPanel = leftContentPanel;
	}

	public JLabel getLblLeftContentTitle() {
		return lblLeftContentTitle;
	}

	public void setLblLeftContentTitle(JLabel lblLeftContentTitle) {
		this.lblLeftContentTitle = lblLeftContentTitle;
	}

	public JTextArea getTextAreaLeftContent() {
		return textAreaLeftContent;
	}

	public void setTextAreaLeftContent(JTextArea textAreaLeftContent) {
		this.textAreaLeftContent = textAreaLeftContent;
	}

	public JLabel getLblFrom() {
		return lblFrom;
	}

	public void setLblFrom(JLabel lblFrom) {
		this.lblFrom = lblFrom;
	}

	public JComboBox<String> getComboBoxFrom() {
		return comboBoxFrom;
	}

	public void setComboBoxFrom(JComboBox<String> comboBoxFrom) {
		this.comboBoxFrom = comboBoxFrom;
	}

	public JLabel getLblTo() {
		return lblTo;
	}

	public void setLblTo(JLabel lblTo) {
		this.lblTo = lblTo;
	}

	public JComboBox<String> getComboBoxTo() {
		return comboBoxTo;
	}

	public void setComboBoxTo(JComboBox<String> comboBoxTo) {
		this.comboBoxTo = comboBoxTo;
	}

	public JButton getBtnConvert() {
		return btnConvert;
	}

	public void setBtnConvert(JButton btnConvert) {
		this.btnConvert = btnConvert;
	}

	public JLabel getLblCuantityDescription() {
		return lblCuantityDescription;
	}

	public void setLblCuantityDescription(JLabel lblCuantityDescription) {
		this.lblCuantityDescription = lblCuantityDescription;
	}

	public JLabel getLblCuantityResult() {
		return lblCuantityResult;
	}

	public void setLblCuantityResult(JLabel lblCuantityResult) {
		this.lblCuantityResult = lblCuantityResult;
	}

	public JPanel getPrincipalContentPanel() {
		return principalContentPanel;
	}

	public void setPrincipalContentPanel(JPanel principalContentPanel) {
		this.principalContentPanel = principalContentPanel;
	}

	public JLabel getLblConverterTitle() {
		return lblConverterTitle;
	}

	public void setLblConverterTitle(JLabel lblConverterTitle) {
		this.lblConverterTitle = lblConverterTitle;
	}

	public JPanel getContentConverterPanel() {
		return contentConverterPanel;
	}
	
	
	
	
	

}
