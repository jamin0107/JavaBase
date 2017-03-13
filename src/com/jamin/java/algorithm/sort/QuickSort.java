package com.jamin.java.algorithm.sort;

public class QuickSort {

	
	public static void quickSort(int low, int high, int[] array) {
		// 快速排序(最快，但是占用内存大，典型的空间换时间)O(nlogn (以2为底的))
		if (low < high) {
			int k = partition(low, high, array);
			quickSort(low, k - 1, array);
			quickSort(k + 1, high, array);
		}

	}
	
	
	// partition函数，为快速排序做准备，把数据分割成以枢轴为中心的两部分
	private static int partition(int low, int high, int[] array) {
		int pivot = array[low];
		while (low < high) {
			while (low < high && array[high] >= pivot)
				--high; // high位置值与pivot比，高位下标--
			array[low] = array[high];// 当以上条件不满足时，将high位置的值暂存于data[low]中。此时data[high]为空位
			while (low < high && array[low] <= pivot)
				++low; // low位置值与pivot比，低位下标++
			array[high] = array[low]; // 当上条件不满足时，将low位置的值暂存于data[high]中。此时data[low]为空位
		}
		// while结束时，data[low]一定是空位
		array[low] = pivot;
		return low;
	}

	
}
