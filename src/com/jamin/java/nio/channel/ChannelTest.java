package com.jamin.java.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class ChannelTest {

	
	
	public static void main(String[] args) {
		try {
			RandomAccessFile aFile = new RandomAccessFile("C://Users/Jamin/github/JavaBase/trunk/niodata.txt", "rw");
			FileChannel inChannel =   aFile.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(96);
			int bytesRead = inChannel.read(byteBuffer);
			while (bytesRead != -1) {
				System.out.println("Read " + bytesRead);
				byteBuffer.flip();
				System.out.println(new String(byteBuffer.array()));
//				while (byteBuffer.hasRemaining()) {
//					System.out.println(Byte.toString(byteBuffer.get()));
//					System.out.println(new String(new byte[]{byteBuffer.get()}));
//				}
				byteBuffer.clear();
				bytesRead = inChannel.read(byteBuffer);
			}
			
			aFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
