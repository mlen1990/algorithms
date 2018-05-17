/* TestSingleton.java */

import java.util.Arrays;
import singleton.*;

public class TestSingleton {

	public static void main(String[] args) {
		BasicSingleton s = BasicSingleton.getInstance();
		s.printStuff("Stuff Printed");
		System.out.println(Arrays.toString(s.createArray("BasicSingleton")));

		System.out.println("-------------------------------------------");

		LazySingleton l = LazySingleton.getInstance();
		l.printStuff("Stuff Printed");
		System.out.println(Arrays.toString(l.createArray("LazySingleton")));

		System.out.println("-------------------------------------------");

		ConcurrentSingleton c = ConcurrentSingleton.getInstance();
		c.printStuff("Stuff Printed");
		System.out.println(Arrays.toString(c.createArray("ConcurrentSingleton")));

	}
}