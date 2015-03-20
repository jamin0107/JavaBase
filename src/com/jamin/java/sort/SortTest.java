package com.jamin.java.sort;

public class SortTest {

	private static final int num = 40000;

	public static void main(String[] args) {
		hannoi(4, "A", "B", "C");
		// testSort();
	}

	private static void testSort() {
		// System.out.println("请输入测试的数据数量，建议5万--10万之间！");
		// Scanner sn = new Scanner(System.in);
		// int num = sn.nextInt();
		int[] dataArray = new int[num];
		for (int i = 0; i < num; i++) {
			int t = (int) (Math.random() * 100000);// 产生范围在0--10000的随机数
			dataArray[i] = t;
		}

		SortTest sort = new SortTest();
		// System.out.println("请选择排序算法：" + "\n" + "1、冒泡排序（改进版）" + "\n"
		// + "2、简单选择排序" + "\n" + "3、直接插入排序" + "\n" + "4、快速排序");
		// Calendar cal = Calendar.getInstance();
		// int c = sn.nextInt();
		// switch (c) {
		// case 1:
		long beginTime = System.currentTimeMillis();
		sort.bubbleSort(dataArray);
		long endTime = System.currentTimeMillis();
		System.out.println(num + "个数据 " + " 冒泡排序消耗时间:" + (endTime - beginTime)
				+ "毫秒。");
		// break;
		// case 2:
		long beginTime2 = System.currentTimeMillis();
		sort.selectSort(dataArray);
		long endTime2 = System.currentTimeMillis();

		System.out.println(num + "个数据 " + " 简单选择消耗时间:"
				+ (endTime2 - beginTime2) + "毫秒。");
		// break;
		// case 3:
		long beginTime3 = System.currentTimeMillis();
		sort.insertSort(dataArray);
		long endTime3 = System.currentTimeMillis();
		System.out.println(num + "个数据 " + " 直接插入排序消耗时间:"
				+ (endTime3 - beginTime3) + "毫秒。");
		// break;
		// case 4:
		long beginTime4 = System.currentTimeMillis();
		sort.quickSort(0, dataArray.length - 1, dataArray);
		long endTime4 = System.currentTimeMillis();
		System.out.println(num + "个数据 " + " 快速排序消耗时间:"
				+ (endTime4 - beginTime4) + "毫秒。");
		// break;
		// }

		// 打印数据比较较多时控制台不能完全看到效果！
		// System.out.println("排完序的结果：");
		// sort.printResult(dataArray);
	}

	// 打印排序结果
	public void printResult(int dataArray[]) {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.println("dataArray[" + i + "] = " + dataArray[i]);
		}

	}

	public void bubbleSort(int[] array) {
		// 冒泡排序，从小到大，总共比较n-1趟
		for (int i = 0; i < array.length - 1; i++) {
			int flag = 0;// 改进的冒泡排序算法，设置标记，如果这一趟没有进行数据交换，则排序立即完毕
			for (int j = array.length - 1; j > i; j--) {
				// 从后向前比较，小的数上浮
				if (array[j] < array[j - 1]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					flag = 1;// 记录是否发生数据交换
				}
			}
			if (flag == 0)
				break;
		}
	}

	public void selectSort(int[] array) {
		// 选择排序，从小到大，总共比较n-1趟
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;// 不妨选择每趟第一个元素为比较对象，min记录最小值下标
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			// 找到了本趟最小值下标，将其值与本趟第一个值交换
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}

	public void insertSort(int[] array) {
		/*
		 * 直接插入排序 ，总共比较n-1趟 思想：把n个待排序的元素看成一个有序表和一个无序表， 开始时有序表中有1个元素，无序表中有n-1个元素，
		 * 排序过程中每次从无序表中取出第一个元素，依次与有序表中的元素比较， 找到适当的位置插入，使之成为新的有序表。
		 */
		for (int i = 1; i < array.length; i++) {// 先认为第一个数是有序的，从数组中第二个元素开始与有序表中元素比较
			int insertVal = array[i];// 获取待比较的元素
			int index = i - 1;// 第i趟，有序表中已经有了i个元素
			while (index >= 0 && insertVal < array[index]) {// 将待插入的元素依次与前面的有序元素比较，直到找到适当位置
				array[index + 1] = array[index];// 给待插入的元素空出位置
				index--;
			}
			array[index + 1] = insertVal;// 执行插入操作
		}
	}

	// partition函数，为快速排序做准备，把数据分割成以枢轴为中心的两部分
	public int partition(int low, int high, int[] array) {
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

	public void quickSort(int low, int high, int[] array) {
		// 快速排序(最快，但是占用内存大，典型的空间换时间)O(nlogn (以2为底的))
		if (low < high) {
			int k = partition(low, high, array);
			quickSort(low, k - 1, array);
			quickSort(k + 1, high, array);
		}

	}

	public static void hannoi(int num, String from, String with, String to) {
		if (num == 1) {
			// 递归出口!
			System.out.println("盘子:" + 1 + from + ">>>>" + to);
		} else {
			hannoi(num - 1, from, to, with);
			System.out.println("盘子:" + num + from + ">>>>" + to);
			hannoi(num - 1, with, from, to);
		}
	}
}
