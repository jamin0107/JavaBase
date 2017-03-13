package com.jamin.java.algorithm.sort;

public class SortTest {

	private static final int num = 40000;

	public static void main(String[] args) {
		hannoi(4, "A", "B", "C");
		// testSort();
	}

	private static void testSort() {
		// System.out.println("��������Ե���������������5��--10��֮�䣡");
		// Scanner sn = new Scanner(System.in);
		// int num = sn.nextInt();
		int[] dataArray = new int[num];
		for (int i = 0; i < num; i++) {
			int t = (int) (Math.random() * 100000);// ������Χ��0--10000�������
			dataArray[i] = t;
		}

		SortTest sort = new SortTest();
		// System.out.println("��ѡ�������㷨��" + "\n" + "1��ð�����򣨸Ľ��棩" + "\n"
		// + "2����ѡ������" + "\n" + "3��ֱ�Ӳ�������" + "\n" + "4����������");
		// Calendar cal = Calendar.getInstance();
		// int c = sn.nextInt();
		// switch (c) {
		// case 1:
		long beginTime = System.currentTimeMillis();
		sort.bubbleSort(dataArray);
		long endTime = System.currentTimeMillis();
		System.out.println(num + "������ " + " ð����������ʱ��:" + (endTime - beginTime)
				+ "���롣");
		// break;
		// case 2:
		long beginTime2 = System.currentTimeMillis();
		sort.selectSort(dataArray);
		long endTime2 = System.currentTimeMillis();

		System.out.println(num + "������ " + " ��ѡ������ʱ��:"
				+ (endTime2 - beginTime2) + "���롣");
		// break;
		// case 3:
		long beginTime3 = System.currentTimeMillis();
		sort.insertSort(dataArray);
		long endTime3 = System.currentTimeMillis();
		System.out.println(num + "������ " + " ֱ�Ӳ�����������ʱ��:"
				+ (endTime3 - beginTime3) + "���롣");
		// break;
		// case 4:
		long beginTime4 = System.currentTimeMillis();
		QuickSort.quickSort(0, dataArray.length - 1, dataArray);
		long endTime4 = System.currentTimeMillis();
		System.out.println(num + "������ " + " ������������ʱ��:"
				+ (endTime4 - beginTime4) + "���롣");
		// break;
		// }

		// ��ӡ���ݱȽϽ϶�ʱ����̨������ȫ����Ч����
		// System.out.println("������Ľ����");
		// sort.printResult(dataArray);
	}

	// ��ӡ������
	public void printResult(int dataArray[]) {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.println("dataArray[" + i + "] = " + dataArray[i]);
		}

	}

	public void bubbleSort(int[] array) {
		// ð�����򣬴�С�����ܹ��Ƚ�n-1��
		for (int i = 0; i < array.length - 1; i++) {
			int flag = 0;// �Ľ���ð�������㷨�����ñ�ǣ������һ��û�н������ݽ������������������
			for (int j = array.length - 1; j > i; j--) {
				// �Ӻ���ǰ�Ƚϣ�С�����ϸ�
				if (array[j] < array[j - 1]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					flag = 1;// ��¼�Ƿ������ݽ���
				}
			}
			if (flag == 0)
				break;
		}
	}

	public void selectSort(int[] array) {
		// ѡ�����򣬴�С�����ܹ��Ƚ�n-1��
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;// ����ѡ��ÿ�˵�һ��Ԫ��Ϊ�Ƚ϶���min��¼��Сֵ�±�
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			// �ҵ��˱�����Сֵ�±꣬����ֵ�뱾�˵�һ��ֵ����
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}

	public void insertSort(int[] array) {
		/*
		 * ֱ�Ӳ������� ���ܹ��Ƚ�n-1�� ˼�룺��n���������Ԫ�ؿ���һ��������һ������� ��ʼʱ���������1��Ԫ�أ����������n-1��Ԫ�أ�
		 * ���������ÿ�δ��������ȡ����һ��Ԫ�أ�������������е�Ԫ�رȽϣ� �ҵ��ʵ���λ�ò��룬ʹ֮��Ϊ�µ������
		 */
		for (int i = 1; i < array.length; i++) {// ����Ϊ��һ����������ģ��������еڶ���Ԫ�ؿ�ʼ���������Ԫ�رȽ�
			int insertVal = array[i];// ��ȡ���Ƚϵ�Ԫ��
			int index = i - 1;// ��i�ˣ���������Ѿ�����i��Ԫ��
			while (index >= 0 && insertVal < array[index]) {// ���������Ԫ��������ǰ�������Ԫ�رȽϣ�ֱ���ҵ��ʵ�λ��
				array[index + 1] = array[index];// ���������Ԫ�ؿճ�λ��
				index--;
			}
			array[index + 1] = insertVal;// ִ�в������
		}
	}




	public static void hannoi(int num, String from, String with, String to) {
		if (num == 1) {
			// �ݹ����!
			System.out.println("����:" + 1 + from + ">>>>" + to);
		} else {
			hannoi(num - 1, from, to, with);
			System.out.println("����:" + num + from + ">>>>" + to);
			hannoi(num - 1, with, from, to);
		}
	}
}
