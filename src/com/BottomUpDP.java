/*
 * fib(n-1) + fib(n-2)----->fib(n)
 */
package com;

public class BottomUpDP {
	private static int N =50;
	private static long[] arr = new long[N+1];
	public static void main(String[] args) {
		arr[1]=1;arr[2]=1;
		fibonacci(N);
		display(arr);
		calculateSum();
	}
	
	private static void calculateSum() {
		long sum = 0;
		for(int i=1;i<=N;i++){
			sum += arr[i];
		}
		System.out.println("sum = "+sum);
	}

	private static void display(long[] arr2) {
		for(int i=1;i<=N;i++){
			System.out.println("fib["+i+"]--->"+arr[i]);
		}
	}

	private static long fibonacci(long n) {
		long f=0;long s=0;long t =0;
		for(int k=3;k<=N;k++){
			f = arr[k-1]; 
			s = arr[k-2]; 
			t = f + s;
			arr[k] = t;
		}
		return t;
	}

}
