/* BasicSingleton.java */

package singleton;

public class BasicSingleton implements DoStuff {

	private static BasicSingleton instance = new BasicSingleton();

	private BasicSingleton() {}

	public static BasicSingleton getInstance() {
		System.out.println("Returning basic singleton");
		return BasicSingleton.instance;
	}

	public void printStuff(String stuff) {
		System.out.println("printStuff: " + stuff);
	}

	public String[] createArray(String stuff) {
		return stuff.split("");
	}
}