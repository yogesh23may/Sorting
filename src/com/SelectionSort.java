package com;

public class SelectionSort {

	public static void main(String[] args) {
		int a[] = {12,5,45,78,64,19,48,23,8};
		display(a);
		selectionSort(a);
		display(a);
	}

	//selection sort
	private static void selectionSort(int[] a) {
		int i,j,iMin,arrSize;
		arrSize = a.length;
		
		for(i=0;i<arrSize-1;i++){ //setting i(th) element as min
			iMin = i;
			for(j=i+1;j<arrSize;j++){//getting index of minimum element from second element to last
				if(a[j]<a[iMin]){
					iMin = j;
				}
			}
			if(iMin != i){//if min element found ,then swap it with position i
				swap(a,i, iMin);
			}
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
