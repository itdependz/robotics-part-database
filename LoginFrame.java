package com.samarth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginFrame {
	private JFrame frame;
	
	public LoginFrame() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Robotics Inventory Management System");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,500);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		frame.add(panel);
		
		panel.setBackground(Color.WHITE);
		
		JLabel title = new JLabel("Login");
		title.setFont(new Font("Sans-serif", Font.BOLD, 36));
		panel.add(title);
		
		JPanel loginLabelPanel = new JPanel();
		loginLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER,200, 10));
		panel.add(loginLabelPanel);
		
		JLabel teamNumberLabel = new JLabel("Team Number");
		teamNumberLabel.setFont(new Font("Sans-serif", Font.PLAIN, 12));
		loginLabelPanel.setBackground(Color.WHITE);
		loginLabelPanel.add(teamNumberLabel);
		
		JPanel textBoxPanel = new JPanel();
		textBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));
		//loginLabelPanel.add(textBoxPanel);
		
		
		JTextField teamNumber = new JTextField(5);
		//teamNumber.setBackground(Color.GRAY);
		teamNumber.setToolTipText("Enter your Team Number ex.9999");
		loginLabelPanel.add(teamNumber);
		
		JPanel submitPanel = new JPanel();
		submitPanel.setLayout(new GridLayout(1,2));
		loginLabelPanel.add(submitPanel);
		
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Sans-serif", Font.PLAIN, 12));
		submit.setPreferredSize(new Dimension(100,100));
		submit.setToolTipText("Submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(teamNumber.getText());
				}
			});
		submitPanel.add(submit);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Sans-serif", Font.PLAIN, 12));
		back.setPreferredSize(new Dimension(100,100));
		back.setToolTipText("Go Back");
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainFrame main = new MainFrame();
				main.show();
				}
			});
		submitPanel.add(back);
		
		
		
		
		
		
	}
	
	public void show() {
		frame.setVisible(true);
	}
}
