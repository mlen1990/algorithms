/* LazySingleton.java */

package singleton;

public class LazySingleton implements DoStuff {

	private static LazySingleton instance;

	private LazySingleton() {}

	public static LazySingleton getInstance() {
		if (instance == null) {
			System.out.println("Initilizing lazy singleton");
			instance = new LazySingleton();
		}
		System.out.println("Returning lazy singleton");
		return instance;
	}

	public void printStuff(String stuff) {
		System.out.println("printStuff: " + stuff);
	}

	public String[] createArray(String stuff) {
		return stuff.split("");
	}
}