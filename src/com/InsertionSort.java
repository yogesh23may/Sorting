package com;

public class InsertionSort {

	public static void main(String[] args) {
		int a[] = {12,5,45,78,64,19,48,23,8};
		display(a);
		insertionSort(a);
		display(a);
	}
	
	//insertion sort
	//at any index i,keep on matching with previous values and find its correct position within [0-i]
	private static void insertionSort(int[] a) {
		int arrSize = a.length;
		for(int i=0;i<arrSize;i++){
			int j=i;
			while(j>0 && a[j-1]>a[j]){
				swap(a,j-1,j);
				j=j-1;
			}
		}
	}

	//swap data
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
}
