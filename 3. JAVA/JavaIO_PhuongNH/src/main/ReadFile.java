package main;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\readfile.txt");

		System.out.println("Number of remaining bytes:" + fis.available());

		System.out.println("FileContents :");
		int ch;
		while ((ch = fis.read()) != -1)
			System.out.print((char) ch);
		
		fis.close();
	}
}
