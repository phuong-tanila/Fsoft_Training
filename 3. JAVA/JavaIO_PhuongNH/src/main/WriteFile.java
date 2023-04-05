package main;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
	public static void main(String[] args) throws IOException {
		DataInputStream dis = new DataInputStream(System.in);

		// attach file to FileOutputStream
		FileOutputStream fos = new FileOutputStream("writefile.txt");

		// attach FileOutputStream to BufferedOutputStream
		BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
		System.out.println("Enter text (# at the end):");
		char ch;

		while ((ch = (char) dis.read()) != '#') {
			bos.write(ch);
		}
		
		bos.close();
	}
}
