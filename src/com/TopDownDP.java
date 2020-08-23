//recursion + memoization = Top Down DP
package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TopDownDP {

	private static Map<Long,Long> map = new HashMap<Long,Long>();
	private static long N = 5;

	public static void main(String[] args) {
		map.put(1L,1L);map.put(2L,1L);
		fibonacci(N);
		display();
		System.out.println("sum = "+calculateSum());
		
	}

	private static long fibonacci(long n) {
		long ret = 0;
		if(n<=2){
			ret = 1;
		}else{
			if(map.get(n) == null){
				ret = fibonacci(n-1) + fibonacci(n-2);
				map.put(n,ret);
			}else{
				ret = map.get(n);
			}
		}
		return ret;
	}

	private static void display() {
		Set<Long> keySet = map.keySet();
		for(long i=1;i<=keySet.size();i++){
			System.out.println("fib("+i+")->"+map.get(i));
		}
	}
	
	private static long calculateSum() {
		long sum = 0;
		Set<Long> keySet = map.keySet();
		for(long i=1;i<=keySet.size();i++){
			sum+=map.get(i);
		}
		return sum;
	}


}
