package com.samarth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeFrame {
	
	private JFrame frame;
	
	public HomeFrame() {
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
		frame.add(panel);
		
		panel.setBackground(Color.WHITE);
		
		JLabel title = new JLabel("Home");
		title.setFont(new Font("Sans-serif", Font.BOLD, 36));
		title.setAlignmentX(0);
		title.setAlignmentY(0);
		
		panel.add(title);
		
		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
		optionPanel.setBackground(Color.GREEN);
		optionPanel.setAlignmentY(-50);
		frame.add(optionPanel);
		
		//back button
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
		optionPanel.add(back);
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
}
