package com.jamin.java.acm;

import java.util.Scanner;

/**
 * Calculate A + B.
 * @author Jamin
 *
 */
public class Main1000 {

	public static void main(String arg[]) {
		Scanner scin = new Scanner(System.in);
		while (scin.hasNextInt()) {
			int a = scin.nextInt();
			int b = scin.nextInt();
			System.out.println(a + b);
		}
	}
}
