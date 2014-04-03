package com.training;

import static java.math.BigDecimal.ONE;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UI extends JFrame {

	
	public UI(){
		BigDecimal bg = ONE;
		
		JButton but = new JButton("click me!!! north");
		add(but,BorderLayout.NORTH);
		JButton but1 = new JButton("click me!!! south");
		add(but1,BorderLayout.SOUTH);
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button is clicked");
				
			}
		});
		but1.addActionListener(new ClickButton());
		
	}
	
	public static void main(String[] args) {
		UI u = new UI();
		u.setSize(200,200);
		u.setVisible(true);
	}
}
