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
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Component;

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
	private JLabel lblHomeOption;
	private JLabel lblNewLabel;
	private JLabel lblLogo;
	private CurrencyWindow currencyWindow;
	private TemperatureWindow temperatureWindow;

	
	public PrincipalWindow() {
		buildComponents();
		
	}


	private void buildComponents() {
		
		controller = new Controller();
		currencyWindow = new CurrencyWindow();
		temperatureWindow = new TemperatureWindow();
		
		setTitle("Principal Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(35, 41, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		principalPanel = new JPanel();
		contentPane.add(principalPanel, BorderLayout.CENTER);
		principalPanel.setLayout(new BorderLayout(0, 0));
		
		northPanel = new JPanel();
		northPanel.setBackground(new Color(184, 193, 236));
		principalPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		
		
		
		
		optionsPanel = new JPanel();
		optionsPanel.setBackground(new Color(184, 193, 236));
		northPanel.add(optionsPanel, BorderLayout.EAST);
		optionsPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("    ");
		lblNewLabel_1.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		optionsPanel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("    ");
		lblNewLabel_2.setBackground(new Color(35, 41, 70));
		lblNewLabel_2.setForeground(new Color(35, 41, 70));
		optionsPanel.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("   ");
		optionsPanel.add(lblNewLabel_3, BorderLayout.EAST);
		
		convertorsPanel = new JPanel();
		convertorsPanel.setForeground(new Color(35, 41, 70));
		optionsPanel.add(convertorsPanel, BorderLayout.CENTER);
		convertorsPanel.setLayout(new GridLayout(0, 5, 12, 0));
		convertorsPanel.setOpaque(false);
		
		lblHomeOption = new JLabel("Home");
		lblHomeOption.setForeground(new Color(35, 41, 70));
		lblHomeOption.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblHomeOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertorsPanel.add(lblHomeOption);
		lblHomeOption.addMouseListener(this);
		
		lblCurrencyOption = new JLabel("Currency");
		lblCurrencyOption.setForeground(new Color(35, 41, 70));
		lblCurrencyOption.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblCurrencyOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertorsPanel.add(lblCurrencyOption);
		lblCurrencyOption.addMouseListener(this);
		
		lblTemperatureOption = new JLabel("Temperature");
		lblTemperatureOption.setForeground(new Color(35, 41, 70));
		lblTemperatureOption.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblTemperatureOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertorsPanel.add(lblTemperatureOption);
		lblTemperatureOption.addMouseListener(this);
		
		lblWeigthOption = new JLabel("Weight");
		lblWeigthOption.setForeground(new Color(35, 41, 70));
		lblWeigthOption.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblWeigthOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertorsPanel.add(lblWeigthOption);
		lblWeigthOption.addMouseListener(this);
		
		lblMeasureOption = new JLabel("Measure");
		lblMeasureOption.setForeground(new Color(35, 41, 70));
		lblMeasureOption.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblMeasureOption.setHorizontalAlignment(SwingConstants.CENTER);
		convertorsPanel.add(lblMeasureOption);
		
		JPanel panelLogo = new JPanel();
		northPanel.add(panelLogo, BorderLayout.CENTER);
		panelLogo.setLayout(null);
		panelLogo.setOpaque(false);
		
		lblLogo = new JLabel("   ");
		lblLogo.setBackground(new Color(35, 41, 70));
		lblLogo.setBounds(31, 8, 19, 27);
		panelLogo.add(lblLogo);
		lblLogo.setOpaque(false);
		lblLogo.setIcon(new ImagePanel().paintComponent(lblLogo,"/icons/Vector.png"));
		
		
		southPanel = new JPanel();
		southPanel.setBackground(new Color(184, 193, 236));
		principalPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("     ");
		southPanel.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("   ");
		southPanel.add(lblNewLabel_5, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_6 = new JLabel("Made by Ethan Sanchez");
		lblNewLabel_6.setForeground(new Color(35, 41, 70));
		lblNewLabel_6.setFont(new Font("Roboto Condensed", Font.BOLD, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		southPanel.add(lblNewLabel_6, BorderLayout.CENTER);
		
		centerPanel = new JPanel();
		centerPanel.setForeground(new Color(0, 0, 0));
		principalPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		
		contenCenterPanel = new JPanel();
		contenCenterPanel.setBackground(new Color(35, 41, 70));
		contenCenterPanel.setBounds(0, 0, 816, 401);
		centerPanel.add(contenCenterPanel);
		contenCenterPanel.setLayout(null);
		
		lblImage_1 = new JLabel("   ");
		lblImage_1.setBounds(277, 10, 285, 343);
		lblImage_1.setHorizontalAlignment(SwingConstants.CENTER);
		contenCenterPanel.add(lblImage_1);
		//setImageLabel(lblImage_1,"/icons/sukuna-chibi.png");
		lblImage_1.setIcon(new ImagePanel().paintComponent(lblImage_1,"/icons/sukuna-chibi.png"));
		
		lblNewLabel_8 = new JLabel("No option convertor selected");
		lblNewLabel_8.setForeground(new Color(255, 255, 254));
		lblNewLabel_8.setBounds(250, 346, 301, 26);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Roboto Condensed", Font.BOLD, 22));
		contenCenterPanel.add(lblNewLabel_8);
		
	}


	public void setController(Controller controller) {
		this.controller = controller;
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == lblCurrencyOption) {
			
			changeCenterPanel(currencyWindow);
			
		}else if(e.getSource() == lblHomeOption) {
			changeCenterPanel(contenCenterPanel);
			
		}else if(e.getSource() == lblTemperatureOption) {
			
			changeCenterPanel(temperatureWindow);
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
		
		
		centerPanel.removeAll();
		centerPanel.add(panel, BorderLayout.CENTER);
		centerPanel.revalidate();
		centerPanel.repaint();
	}
}
