package arrays;

import java.util.Arrays;

public class ShiftAllZerostoLeft {

	public static int[] shiftAllZerosRight(int[] a) {
		if (a.length == 1) {
			return a;
		}

		int[] newArray = new int[a.length];

		int count = a.length-1;
		for (int number : a) {
			if (number != 0) {
				newArray[count] = number;
				count--;

			}
		}
		return newArray;

	}

	public static void main(String[] args) {

		int[] inputArray = { 1, 0, 2, 0, 3, 0, 0, 0 };

		System.out.println(Arrays.toString(shiftAllZerosRight(inputArray)));

	}

}