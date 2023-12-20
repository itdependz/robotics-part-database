package com.samarth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

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
		panel.add(title);
		
		
	}
	
	private static void add(JPanel panel, String center) {
		// TODO Auto-generated method stub
		
	}

	public void show() {
		frame.setVisible(true);
	}
}
