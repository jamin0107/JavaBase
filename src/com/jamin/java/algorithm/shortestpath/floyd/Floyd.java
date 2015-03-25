package com.jamin.java.algorithm.shortestpath.floyd;

import java.util.ArrayList;

public class Floyd {
	public static int M = Integer.MAX_VALUE;

	public static int MAXSUM(int a, int b) {
		return (a != M && b != M) ? (a + b) : M;
	}

	public static ArrayList<Integer[][]> flody(Integer[][] dist) {
		Integer[][] path = new Integer[6][6];// �洢���Ǵ�i->j���������һ���ڵ�
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				path[i][j] = i;
			}
		}
		for (int k = 0; k < 6; k++) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (dist[i][j] > MAXSUM(dist[i][k], dist[k][j])) {
						path[i][j] = path[k][j];// �洢���Ǵ�i->j���������һ���ڵ�
						dist[i][j] = MAXSUM(dist[i][k], dist[k][j]);
					}
				}
			}
		}
		ArrayList<Integer[][]> list = new ArrayList<Integer[][]>();
		list.add(dist);
		list.add(path);
		return list;
	}

	public static Integer[] reverse(Integer[] chain, int count) {
		int temp;
		for (int i = 0, j = count - 1; i < j; i++, j--) {
			temp = chain[i];
			chain[i] = chain[j];
			chain[j] = temp;
		}
		return chain;
	}

	public static void display_path(ArrayList<Integer[][]> list) {
		Integer[][] dist = list.get(0);
		Integer[][] path = list.get(1);
		Integer[] chain = new Integer[6];
		System.out.println("orign->dist" + " dist " + " path");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (i != j) {// ֻ�Ǳ�����vi->vi�����
					// ���Դ��Ŀ�ĵ�
					System.out.print("\n   " + (i) + "->" + (j) + "     ");
					// ������·���ĳ���
					if (dist[i][j] == M) {
						System.out.print(" NA ");
					} else {
						System.out.print(dist[i][j] + "      ");
						int count = 0;
						int k = j;
						do {
							k = chain[count++] = path[i][k];
						} while (i != k);
						chain = reverse(chain, count);
						// ���·��
						System.out.print(chain[0] + "");
						for (k = 1; k < count; k++) {
							System.out.print("->" + (chain[k]));
						}
						System.out.print("->" + j);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer[][] dist = {
				{ 0, 1, 4, M, M, M },
				{ 1, 0, 2, 7, 5, M },
				{ 4, 2, 0, M, 1, M }, 
				{ M, 7, M, 0, 3, 2 },
				{ M, 5, 1, 3, 0, 6 }, 
				{ M, M, M, 2, 6, 0 } };// ����һ��Ȩֵ����

		ArrayList<Integer[][]> list = flody(dist);
		display_path(list);
	}
}