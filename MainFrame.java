package com.samarth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame {
	
	private JFrame frame;
	
	public MainFrame() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Robotics Inventory Management System");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,500);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		frame.add(panel, BorderLayout.CENTER);
		
		panel.setBackground(Color.WHITE);
		
		JLabel title = new JLabel("Robotics Inventory Management System");
		title.setFont(new Font("Sans-serif", Font.BOLD, 36));
		panel.add(title);
		
		JPanel continuePanel = new JPanel();
		continuePanel.setLayout(new FlowLayout(FlowLayout.CENTER,600, 100));
		continuePanel.setBackground(Color.WHITE);
		
		panel.add(continuePanel);
		
		JButton next = new JButton("Continue");
		next.setFont(new Font("Sans-serif", Font.PLAIN, 26));
		next.setPreferredSize(new Dimension(200,100));
		next.setToolTipText("Click to Continue");
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LoginFrame login = new LoginFrame();
				login.show();
				}
			});
		continuePanel.add(next);
		
		
		
	}

	public void show() {
		frame.setVisible(true);
	}
}
