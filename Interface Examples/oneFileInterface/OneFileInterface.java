import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface Parser {

	public String parse();

}

class JsonParser implements Parser {

	public JsonParser() {

	}

	public String parse() {
		return "JSON Parser";
	}
}

class XmlParser implements Parser {

	public XmlParser() {

	}

	public String parse() {
		return "XML Parser";
	}
}

public class OneFileInterface {
	

	public static void main(String[] args) {
		String[] fileInfo = args[0].split("\\.");
		Parser file;
		try {
			if (fileInfo[1].equals("xml")) {
				file = new XmlParser();
			} else if (fileInfo[1].equals("json")) {
				file = new JsonParser();
			} else {
				throw new Exception("Error: Invalid File Type.");
			}
			System.out.println(file.parse());

		} catch (Exception e) {
			System.out.println("Line #23");
			System.out.println(e.getMessage());
		}
	}

}

