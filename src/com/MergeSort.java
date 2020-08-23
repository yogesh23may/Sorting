package com;

import java.util.Arrays;

public class MergeSort {
	private static int[] numbers;
	private static int[] helper;
	private static int number;

	public static void main(String[] args) {
		int a[] = {9,8,7,6,18,28,45,56,98,104};
		display(a);
		sort(a);
		display(a);
	}

	public static void sort(int[] values) {
		numbers = values;
		number = values.length;
		helper = new int[number];
		mergeSort(0, number - 1);
	}

	private static void mergeSort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergeSort(low, middle);
			// Sort the right side of the array
			mergeSort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private static void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}
	}

	//display
	private static void display(int[] a) {
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
			if(i<a.length-1){
				System.out.print("->");
			}
		}
		System.out.println();
	}
	
	//swap data
		private static void swap(int i, int j) {
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
}

