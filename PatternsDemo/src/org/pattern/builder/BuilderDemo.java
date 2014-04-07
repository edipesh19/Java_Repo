package org.pattern.builder;


class Computer{
	private String ram;
	
	private boolean isGraphicsCardEnable;
	private boolean isWifiEnable;
	private boolean isBluetoothEnable;
	
	public String getRam() {
		return ram;
	}
	
	public boolean isBluetoothEnable() {
		return isBluetoothEnable;
	}
	public boolean isGraphicsCardEnable() {
		return isGraphicsCardEnable;
	}
	
	public boolean isWifiEnable() {
		return isWifiEnable;
	}
	
	private Computer(ComputerBuilder builder){
		this.ram = builder.ram;
		this.isBluetoothEnable = builder.isBluetoothEnable;
		this.isWifiEnable = builder.isWifiEnable;
		this.isGraphicsCardEnable = builder.isGraphicsCardEnable;
	}
	
	public String toString() {
		return ram+ " " + "isGraphicsCardEnable=" +isGraphicsCardEnable+ " " + "isWifiEnable="+isWifiEnable
				+"isBluetoothEnable="+isBluetoothEnable;
	}
	
	public static class ComputerBuilder{
		private String ram;
		
		private boolean isGraphicsCardEnable;
		private boolean isWifiEnable;
		private boolean isBluetoothEnable;
		
		public ComputerBuilder(String ram){
			this.ram = ram;
		}
		
		public ComputerBuilder setGraphicsCardEnable(boolean isGraphicsCardEnable) {
			this.isGraphicsCardEnable = isGraphicsCardEnable;
			return this;
		}
		
		public ComputerBuilder setWifiEnable(boolean isWifiEnable) {
			this.isWifiEnable = isWifiEnable;
			return this;
		}
		
		public ComputerBuilder setBluetoothEnable(boolean isBluetoothEnable) {
			this.isBluetoothEnable = isBluetoothEnable;
			return this;
		}
		
		public Computer build(){
			return new Computer(this);
		}
		
	}
}
public class BuilderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder("8 GB").setBluetoothEnable(true)
				.setGraphicsCardEnable(false).setWifiEnable(true).build();
		
		System.out.println(computer);
		

	}

}
