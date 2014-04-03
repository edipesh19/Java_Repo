package com.decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class DecoratorDemo {

	public static void main(String[] args) {

		Animal animal = new LivingAnimal();
		animal.describe();

		animal = new LegDecorator(animal);
		animal.describe();

		animal = new WingDecorator(animal);
		animal.describe();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(
							new File("c:\test.xml"))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*animal = new GrowlDecorator(animal);
		animal = new GrowlDecorator(animal);
		animal.describe();*/
	}

}