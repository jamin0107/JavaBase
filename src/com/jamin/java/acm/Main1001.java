package com.jamin.java.acm;

import java.util.Scanner;


/**
 * In this problem,your task is to calculate SUM(n) = 1 + 2 + 3 + ... + n.
 * @author Jamin
 *
 */
public class Main1001 {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			if(n % 2 == 0){
				int sum = n/2 * (n + 1);
				System.out.println(sum);
				System.out.println();
			}else{
				int sum = (n + 1) /2 *n;
				System.out.println(sum);
				System.out.println();
			}
		}
	}
}
