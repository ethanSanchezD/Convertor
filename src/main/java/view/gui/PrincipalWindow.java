package view.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class PrincipalWindow extends JFrame implements MouseListener{

	private JPanel contentPane;
	private Controller controller;
	private JPanel principalPanel;
	private JPanel northPanel;
	private JPanel optionsPanel;
	private JPanel convertorsPanel;
	private JLabel lblCurrencyOption;
	private JLabel lblTemperatureOption;
	private JLabel lblWeigthOption;
	private JLabel lblMeasureOption ;
	private JPanel southPanel;
	private JPanel centerPanel;
	private JPanel contenCenterPanel;
	private JLabel lblImage_1;
	private JLabel lblNewLabel_8;

	
	public PrincipalWindow() {
		buildComponents();
		
	}


	private void buildComponents() {
		controller = new Controller();
		setTitle("Principal Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(22, 22, 26));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		principalPanel = new JPanel();
		contentPane.add(principalPanel, BorderLayout.CENTER);
		principalPanel.setLayout(new BorderLayout(0, 0));
		
		northPanel = new JPanel();
		principalPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Image");
		northPanel.add(lblNewLabel, BorderLayout.CENTER);
		
		optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(22, 22, 26));
		northPanel.add(optionsPanel, BorderLayout.EAST);
		optionsPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("    ");
		optionsPanel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("    ");
		optionsPanel.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("   ");
		optionsPanel.add(lblNewLabel_3, BorderLayout.EAST);
		
		convertorsPanel = new JPanel();
		optionsPanel.add(convertorsPanel, BorderLayout.CENTER);
		convertorsPanel.setLayout(new GridLayout(0, 4, 12, 0));
		//convertorsPanel.setOpaque(false);
		
		lblCurrencyOption = new JLabel("Currency");
		lblCurrencyOption.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCurrencyOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertorsPanel.add(lblCurrencyOption);
		lblCurrencyOption.addMouseListener(this);
		
		lblTemperatureOption = new JLabel("Temperature");
		lblTemperatureOption.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTemperatureOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertorsPanel.add(lblTemperatureOption);
		
		lblWeigthOption = new JLabel("Weight");
		lblWeigthOption.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblWeigthOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertorsPanel.add(lblWeigthOption);
		
		lblMeasureOption = new JLabel("Measure");
		lblMeasureOption.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMeasureOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertorsPanel.add(lblMeasureOption);
		
		southPanel = new JPanel();
		principalPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("     ");
		southPanel.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("   ");
		southPanel.add(lblNewLabel_5, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_6 = new JLabel("Copyrigth");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		southPanel.add(lblNewLabel_6, BorderLayout.CENTER);
		
		centerPanel = new JPanel();
		centerPanel.setForeground(new Color(0, 0, 0));
		principalPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		
		contenCenterPanel = new JPanel();
		contenCenterPanel.setBackground(new Color(0, 255, 0));
		contenCenterPanel.setBounds(0, 0, 816, 401);
		centerPanel.add(contenCenterPanel);
		contenCenterPanel.setLayout(null);
		
		lblImage_1 = new JLabel("   ");
		lblImage_1.setBounds(277, 10, 285, 343);
		lblImage_1.setHorizontalAlignment(SwingConstants.CENTER);
		contenCenterPanel.add(lblImage_1);
		lblImage_1.setIcon(new ImagePanel().paintComponent(lblImage_1));
		
		lblNewLabel_8 = new JLabel("No option convertor selected");
		lblNewLabel_8.setBounds(250, 364, 301, 26);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		contenCenterPanel.add(lblNewLabel_8);
		
	}


	public void setController(Controller controller) {
		this.controller = controller;
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == lblCurrencyOption) {
			CurrencyWindow currencyWindow = new CurrencyWindow();
			changeCenterPanel(currencyWindow);
			
	
			
			
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void changeCenterPanel(JPanel panel) {
		panel.setSize(816,401);
		panel.setLocation(0,0);
		
		
		contenCenterPanel.removeAll();
		contenCenterPanel.add(panel, BorderLayout.CENTER);
		contenCenterPanel.revalidate();
		contenCenterPanel.repaint();
	}
}
