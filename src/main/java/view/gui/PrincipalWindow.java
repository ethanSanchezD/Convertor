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
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class PrincipalWindow extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	
	public PrincipalWindow() {
		buildComponents();
		
	}


	private void buildComponents() {
		setTitle("Principal Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel principalPanel = new JPanel();
		contentPane.add(principalPanel, BorderLayout.CENTER);
		principalPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		principalPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Image");
		northPanel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel optionsPanel = new JPanel();
		northPanel.add(optionsPanel, BorderLayout.EAST);
		optionsPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("    ");
		optionsPanel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("    ");
		optionsPanel.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("   ");
		optionsPanel.add(lblNewLabel_3, BorderLayout.EAST);
		
		JPanel convertorsPanel = new JPanel();
		optionsPanel.add(convertorsPanel, BorderLayout.CENTER);
		convertorsPanel.setLayout(new GridLayout(0, 4, 12, 0));
		
		JButton btnCurrency = new JButton("Currency");
		convertorsPanel.add(btnCurrency);
		btnCurrency.setBorderPainted(false);
		btnCurrency.setBorder(null);
		btnCurrency.setBackground(null);
		btnCurrency.setContentAreaFilled(false);
		
		
		JButton btnTemperature = new JButton("Temperature");
		convertorsPanel.add(btnTemperature);
		
		JButton btnWeight = new JButton("Weight");
		convertorsPanel.add(btnWeight);
		
		JButton btnMeasure = new JButton("Measure");
		convertorsPanel.add(btnMeasure);
		
		JPanel southPanel = new JPanel();
		principalPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("     ");
		southPanel.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("   ");
		southPanel.add(lblNewLabel_5, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_6 = new JLabel("Copyrigth");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		southPanel.add(lblNewLabel_6, BorderLayout.CENTER);
		
		JPanel centerPanel = new JPanel();
		principalPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImage = new JLabel("   ");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblImage, BorderLayout.CENTER);
		lblImage.setSize(250, 300);
		lblImage.setIcon(new ImagePanel().paintComponent(lblImage));
		
		JLabel lblNewLabel_7 = new JLabel("No option convertor selected");
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblNewLabel_7, BorderLayout.SOUTH);
		
	}


	public void setController(Controller controller) {
		this.controller = controller;
		
	}

}
