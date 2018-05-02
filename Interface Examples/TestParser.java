/* TestParser.java */

import parser.*;

public class TestParser {

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
			System.out.println(e.getMessage());
		}
	}

}