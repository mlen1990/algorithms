/* ConcurrentSingleton.java */

package singleton;

public class ConcurrentSingleton implements DoStuff {

	private volatile static ConcurrentSingleton instance;

	private ConcurrentSingleton() {}

	public static ConcurrentSingleton getInstance() {
		if (instance == null) {
			synchronized(ConcurrentSingleton.class) {
				if (instance == null) {
					instance = new ConcurrentSingleton();
				}
			}
		}
		return instance;
	}

	public void printStuff(String stuff) {
		System.out.println("printStuff: " + stuff);
	}

	public String[] createArray(String stuff) {
		return stuff.split("");
	}
}