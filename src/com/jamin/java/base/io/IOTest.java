package com.jamin.java.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest {

	
	public static void main(String[] args) {
		
		File file = new File("d:/nihao.txt");
		File fileOut = new File("d:/nihao1.txt");
		String text = "";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(fileOut);
			byte[] buffer = new byte[15];
			int length = 0;
			while ((length = fis.read(buffer)) != -1) {
				String bufferStr = new String(buffer, 0, length);
				text += bufferStr;
				fos.write(buffer, 0, length);
			}
			System.out.println(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos != null){
				try {
					fos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

}
