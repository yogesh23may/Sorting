package com;

public class HeapSort {
	private static int N;
	public static void main(String[] args){
		int a[] = {12,5,45,78,64,19,48};
		display(a);
		heapSort(a);
		display(a);
	}

	//heapSort
	private static void heapSort(int[] arr){
		heapify(arr);        
		for (int i = N; i > 0; i--){
			swap(arr,0, i);
			N = N-1;
			maxheap(arr, 0);
		}
	}
	
	//Function to build a heap
	private static void heapify(int[] arr){
		N = arr.length-1;
		for (int i = N/2; i >= 0; i--)
			maxheap(arr, i);		
	}

	//create max heap
	private static void maxheap(int[] arr, int i) {
		int left = 2*i ;
		int right = 2*i + 1;
		int max = i;
		System.out.println(left+","+right+","+max);
		System.out.println("--------------");

		if (left <= N && arr[left] > arr[i])
			max = left;

		if (right <= N && arr[right] > arr[max])        
			max = right;

		if (max != i){
			swap(arr, i, max);
			maxheap(arr, max);
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
