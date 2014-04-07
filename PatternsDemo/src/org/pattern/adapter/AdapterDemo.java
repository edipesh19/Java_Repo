package org.pattern.adapter;

class Volt{
	int volt;
	public Volt(int volt){
		this.volt = volt;
	}
	
	public int getVolt() {
		return volt;
	}
	public void setVolt(int volt) {
		this.volt = volt;
	}
	
	public String toString() {
		return "" + volt;
	}
}

class Socket{
	Volt volt;
	public Volt getVolt() {
		return new Volt(120);
	}
}

interface SocketAdapterInt{
	public Volt get120();
	public Volt get12v();
	public Volt get3V();
}

// 1.  This is a class adapter implementation where it inherit the Socket class.
/*class SocketAdapter extends Socket implements SocketAdapterInt{

	public Volt get120() {
		return getVolt();
	}

	public Volt get12v() {
		return convert(getVolt(),10);
	}
	public Volt get3V() {
		return convert(getVolt(),40);
	}
	
	private Volt convert(Volt volt, int i) {
		return new Volt(volt.getVolt()/i);
	}
}*/

// 2. This is Object Adapter implementation where Adapter class contains the object of socket class.
class SocketAdapter implements SocketAdapterInt{
	private Socket socket = new Socket();

	public Volt get120() {
		return socket.getVolt();
	}

	public Volt get12v() {
		return convert(socket.getVolt(),10);
	}

	public Volt get3V() {
		return convert(socket.getVolt(),40);
	}
	
	private Volt convert(Volt volt, int i) {
		return new Volt(volt.getVolt()/i);
	}
}

public class AdapterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SocketAdapterInt c = new SocketAdapter();
		System.out.println(c.get120());
		System.out.println(c.get12v());
		System.out.println(c.get3V());
	}
}
