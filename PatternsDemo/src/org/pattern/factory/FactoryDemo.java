package org.pattern.factory;

interface Shape{
	void draw();
}

class Circle implements Shape{

	public void draw() {
		System.out.println("Drawing Circle");
	}
}

class Rectangle implements Shape{

	public void draw() {
		System.out.println("Drawing Rectangle");
	}
}

class Triangle implements Shape{

	public void draw() {
		System.out.println("Drawing Triangle");
	}
}

class ShapeFactory{
	
	public Shape getShape(String shapetype){
		if (shapetype.equals("circle")){
			return new Circle();
		}
		else if (shapetype.equals("rectangle")){
			return new Rectangle();
		}
		else if (shapetype.equals("triangle")){
			return new Triangle();
		}
		else {
			return null;
		}
	}
}
public class FactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		
		Shape shape1 = factory.getShape("circle");
		if (shape1 != null){
			shape1.draw();
		}
		Shape shape2 = factory.getShape("rectangle");
		if (shape2 != null){
			shape2.draw();
		}
		Shape shape3 = factory.getShape("triangle");
		if (shape3 != null){
			shape3.draw();
		}
		Shape shape4 = factory.getShape("badshape");
		if (shape4 != null){
			shape4.draw();
		}

	}

}
