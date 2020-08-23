package com;

public class QuickSort {

	private static int i = 1;

	public static void main(String[] args) {
		int a[] = {3,7,8,9,6,1,2,5,4};
		int p=0;int r=a.length-1;
		System.out.println("initial");display(a);
		quickSort(a,p,r);
		System.out.println("final");display(a);
	}

	//quicksort
	private static void quickSort(int[] a,int p, int r) {
		if(p<r){
			int q=partition(a,p,r);
			System.out.println("intermediate");display(a);
			System.out.println("storeIndex:"+q+" :value at storeIndex:"+a[q]);
			quickSort(a,p,q-1);
			quickSort(a,q+1,r);
			
		}
	}

	//partition : inplace approach
	private static int partition(int[] a, int p, int r) {
		int pivotIndex = (p+r)/2;
		int pivotValue = a[pivotIndex];
		int storeIndex = p;
		swap(a,pivotIndex,r);
		for(int i=p;i<r;i++){
			if(a[i]<=pivotValue){
				swap(a,i,storeIndex);
				storeIndex = storeIndex+1;
			}
		}
		swap(a,storeIndex,r);
		return storeIndex;
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

