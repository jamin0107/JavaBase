package com.jamin.java.sort;

public class QuickSort {

	
	public static void quickSort(int low, int high, int[] array) {
		// ��������(��죬����ռ���ڴ�󣬵��͵Ŀռ任ʱ��)O(nlogn (��2Ϊ�׵�))
		if (low < high) {
			int k = partition(low, high, array);
			quickSort(low, k - 1, array);
			quickSort(k + 1, high, array);
		}

	}
	
	
	// partition������Ϊ����������׼���������ݷָ��������Ϊ���ĵ�������
	private static int partition(int low, int high, int[] array) {
		int pivot = array[low];
		while (low < high) {
			while (low < high && array[high] >= pivot)
				--high; // highλ��ֵ��pivot�ȣ���λ�±�--
			array[low] = array[high];// ����������������ʱ����highλ�õ�ֵ�ݴ���data[low]�С���ʱdata[high]Ϊ��λ
			while (low < high && array[low] <= pivot)
				++low; // lowλ��ֵ��pivot�ȣ���λ�±�++
			array[high] = array[low]; // ��������������ʱ����lowλ�õ�ֵ�ݴ���data[high]�С���ʱdata[low]Ϊ��λ
		}
		// while����ʱ��data[low]һ���ǿ�λ
		array[low] = pivot;
		return low;
	}

	
}
