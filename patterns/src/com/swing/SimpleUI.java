package com.swing;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class SimpleUI extends JFrame{
	
	public SimpleUI(){
		setLayout(new FlowLayout());
		Button clickBut = new Button("Click");
		clickBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("click but clicked");
				
			}
		});
		Button exitBut = new Button("Exit");

		exitBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("exit but clicked");
				System.exit(0);
			}
		});
		add(clickBut);
		add(exitBut);
	}
 public static void main(String[] args) {
	SimpleUI ui = new SimpleUI();
	ui.setSize(300,300);
	ui.setVisible(true);
}
}
