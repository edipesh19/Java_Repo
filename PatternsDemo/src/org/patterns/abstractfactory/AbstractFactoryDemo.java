package org.patterns.abstractfactory;

interface GuiFactory{
	Button getButton();
	TextBox getTextBox();
	
}

interface Button{
	void draw();
	void click();
	
}

interface TextBox{
	void draw();
	void write();
}

class WinButton implements Button{

	public void draw() {
		System.out.println("Drawing Win Button");
	}

	public void click() {
		System.out.println("Clicked on Win Button");
	}
	
}

class WinTextBox implements TextBox{

	public void draw() {
		System.out.println("Drawing Win TestBox");
	}

	public void write() {
		System.out.println("Writting on Win TextBox");
	}
}

class MacButton implements Button{

	public void draw() {
		System.out.println("Drawing Mac Button");
	}

	public void click() {
		System.out.println("Clicked on Win Button");
	}
	
}

class MacTextBox implements TextBox{

	public void draw() {
		System.out.println("Drawing Mac TestBox");
	}

	public void write() {
		System.out.println("Writting on Mac TextBox");
	}
	
}

class MacFactory implements GuiFactory{
	public Button getButton() {
		return new MacButton();
	}

	public TextBox getTextBox() {
		return new MacTextBox();
	}
}

class WinFactory implements GuiFactory{
	
	public Button getButton(){
		return new WinButton();
	}
	
	public TextBox getTextBox(){
		return new WinTextBox();
	}
}
public class AbstractFactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GuiFactory factory = new WinFactory();
		factory.getButton().draw();

	}

}
