package com;

public class BubbleSort {
	static int k=1;
	
	public static void main(String[] args) {
		int a[] = {12,5,45,78,64,19,48,23,8};
		System.out.println("initial:");
		display(a);
		bubbleSort(a);
		System.out.println("final:");
		display(a);

	}
	//bubble sort : settling the heavier element at the bottom
	private static void bubbleSort(int[] a) {
		int n = a.length;
		for(int i=n-1;i>0;i--){      //n
			for(int j=1;j<=i;j++){   //i
				if(a[j-1]>a[j]){     //1
					swap(a,j-1,j);
				}
			}
			System.out.println("iterarion : "+k);k++;
			display(a);
		}
	}

	//swap
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
