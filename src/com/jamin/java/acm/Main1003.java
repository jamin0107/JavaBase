package com.jamin.java.acm;

import java.util.Scanner;

/**
 * http://acm.hdu.edu.cn/showproblem.php?pid=1003 Max Sum Given a sequence
 * a[1],a[2],a[3]......a[n], your job is to calculate the max sum of a
 * sub-sequence. For example, given (6,-1,5,4,-7), the max sum in this sequence
 * is 6 + (-1) + 5 + 4 = 14.
 * 
 * Input The first line of the input contains an integer T(1<=T<=20) which means
 * the number of test cases. Then T lines follow, each line starts with a number
 * N(1<=N<=100000), then N integers followed(all the integers are between -1000
 * and 1000).
 * 
 * Output For each test case, you should output two lines. The first line is
 * "Case #:", # means the number of the test case. The second line contains
 * three integers, the Max Sum in the sequence, the start position of the
 * sub-sequence, the end position of the sub-sequence. If there are more than
 * one result, output the first one. Output a blank line between two cases.
 * 
 * Sample Input 2 5 6 -1 5 4 -7 7 0 6 -1 1 -6 7 -5
 * 
 * Sample Output Case 1: 14 1 4
 * 
 * Case 2: 7 1 6
 * 动态规划(dynamic programming)
 * @author Jamin
 * 670MS	13840K	1126B	
 */
public class Main1003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();// 总共需要计算几组序列
		StringBuilder stringBuilder = new StringBuilder();
		// 序列循环N次
		for (int i = 1; i <= n; i++) {
			stringBuilder.setLength(0);
			// array Size
			int arraySize = scanner.nextInt();

			int start = 0, end = 0;
			int tempStart = 0;// temp var
			int sum = 0;
			int maxSum = -1001;// maxSum minValue is -1000
			for (int j = 0; j < arraySize; j++) {
				int arrayNumber = scanner.nextInt();
				sum += arrayNumber;
				if (sum > maxSum) {
					maxSum = sum;
					end = j;
					start = tempStart;
				}
				if (sum < 0) {
					tempStart = j + 1;
					sum = 0;
				}
			}
			// Case 1:
			stringBuilder.append("Case ");
			stringBuilder.append(i);
			stringBuilder.append(":");
			System.out.println(stringBuilder);
			stringBuilder.setLength(0);

			//output result
			stringBuilder.append(maxSum);
			stringBuilder.append(" ");
			stringBuilder.append(start + 1);
			stringBuilder.append(" ");
			stringBuilder.append(end + 1);
			System.out.println(stringBuilder);

			// if not last line add block line after result
			if (i < n) {
				System.out.println();
			}
		}
	}

}
