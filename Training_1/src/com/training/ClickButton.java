package com.training;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickButton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("second button is called.");
	}

}
