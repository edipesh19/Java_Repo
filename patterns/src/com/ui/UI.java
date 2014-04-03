package com.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UI extends JFrame{
	
	public UI(){
		JButton but = new JButton("Click ME");
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Event one is called ....");
				
			}
		});
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Event two is called ....");
				
			}
		});
		add(but,BorderLayout.NORTH);
	}
public static void main(String[] args) {
	UI u = new UI();
	u.setSize(300,300);
	u.setVisible(true);
}
}
