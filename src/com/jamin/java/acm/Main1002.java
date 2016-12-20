package com.jamin.java.acm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * I have a very simple problem for you. Given two integers A and B, your job is to calculate the Sum of A + B.
 * @author Jamin
 *
 */
public class Main1002 {
	

	//374MS	11520K	1062B
	//312MS	11452K	1083B
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		BigInteger a , b;
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 1 ; i<= num; i++){
			stringBuilder.setLength(0);
			a = scanner.nextBigInteger();
			b = scanner.nextBigInteger();
			stringBuilder.append("Case ");
			stringBuilder.append(i);
			stringBuilder.append(":");
			System.out.println(stringBuilder);
			stringBuilder.setLength(0);
			if(i < num){
				stringBuilder.append(a);
				stringBuilder.append(" + ");
				stringBuilder.append(b);
				stringBuilder.append(" = ");
				stringBuilder.append(a.add(b));
				System.out.println(stringBuilder);
				System.out.println();
			}else{
				stringBuilder.append(a);
				stringBuilder.append(" + ");
				stringBuilder.append(b);
				stringBuilder.append(" = ");
				stringBuilder.append(a.add(b));
				System.out.println(stringBuilder);
			}
			
			
		}
	}
	
	
	//327MS	11660K
	//358MS	11664K	564B
//	public static void main(String[] args) {
//		
//		Scanner scanner = new Scanner(System.in);
//		int num = scanner.nextInt();
//		BigInteger a , b;
//		for(int i = 1 ; i<= num; i++){
//			a = scanner.nextBigInteger();
//			b = scanner.nextBigInteger();
//			System.out.println("Case " + i +":");
//			if(i < num){
//				System.out.println(a + " + " + b + " = " + a.add(b));
//				System.out.println();
//			}else{
//				System.out.println(a + " + " + b + " = " + a.add(b));
//			}
//			
//			
//		}
//	}
	
	
}
