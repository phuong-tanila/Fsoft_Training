package main;

import java.io.*;

public class WriteFile {

	public static void main(String args[]) throws IOException {
//
//		// attach the file to FileInputStream
//		FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "\\data.txt"); // lấy đường dẫn đến
//																									// file
//		System.out.println(System.getProperty("user.dir")); // in ra file code đang đứng ở đâu
//
//		// illustrating available method
//		System.out.println("Number of remaining bytes:" + fin.available()); // in ra số ký tự trong file
//
//		// illustrating skip method
//		/*
//		 * Original File content: This is my first line This is my second line
//		 */
////		fin.skip(5); //bỏ 5 ký tự
//		System.out.println("FileContents :");
//		// read characters from FileInputStream and write them
//		int ch;
//		while ((ch = fin.read()) != -1)
//			System.out.print((char) ch);
//
//		// close the file
//		fin.close();


	//GHI FILE
		// attach keyboard to DataInputStream
		DataInputStream dis = new DataInputStream(System.in);

		// attach file to FileOutputStream
		FileOutputStream fout = new FileOutputStream("file.txt");

		// attach FileOutputStream to BufferedOutputStream
		BufferedOutputStream bout = new BufferedOutputStream(fout, 1024);
		System.out.println("Enter text (@ at the end):");
		char ch;

		// read characters from dis into ch. Then write them into bout.
		// repeat this as long as the read character is not @
		while ((ch = (char) dis.read()) != '@') {
			bout.write(ch);
		}
		// close the file
		bout.close();
	}
}
