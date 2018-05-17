/* TestSingleton.java */

import singleton.*;

public class TestSingleton {

	public static void main(String[] args) {
		BasicSingleton s = BasicSingleton.getInstance();
		s.printStuff("Stuff Printed");

		System.out.println("-------------------------------------------");

		LazySingleton l = LazySingleton.getInstance();
		l.printStuff("Stuff Printed");

	}
}