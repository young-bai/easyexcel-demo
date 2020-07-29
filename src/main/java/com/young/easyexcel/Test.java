package com.young.easyexcel;

/**
 * @author lmhd-emp
 * @date 2020/7/28 14:00
 */
public class Test {

	public static void main(String[] args) {
		//		// 创建不同类型数组： Integer, Double 和 Character
		//		Integer[] intArray = { 1, 2, 3, 4, 5 };
		//		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		//		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		//		System.out.println("整型数组元素为:");
		//		printArray(intArray);
		//		System.out.println("\n双精度型数组元素为:");
		//		printArray(doubleArray);
		//		System.out.println("\n字符型数组元素为:");
		//		printArray(charArray);
		//		printArray(intArr);
		//		System.out.println("==============================================");
		//		intArr[0] = 2;
		//		printArray(intArr);
		Integer[] intArr = { 1, 2, 3, 4, 5, 6, 7 };
		Integer[] arr = { intArr[0] };
		arr[0] = 0;
		intArr = arr;
		System.out.println("===================================================");
		System.out.printf("当前数组长度 : %s \n", intArr.length);
		printArray(intArr);
	}

	private static <E> void printArray(E[] arr) {
		for (E e : arr) {
			System.out.printf("当前元素 : %s\n", e);
		}
	}
}
