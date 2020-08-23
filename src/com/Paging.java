package com;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Paging {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		System.out.println("enter # of processor bits:");
		int procBit  = scanner.nextInt();
		System.out.println("enter page size(bytes):");
		int pageSize  = scanner.nextInt();
		int offsetBit = getOrderOfTwo(pageSize);
		int pageNoBit = 0;
		if(procBit>pageNoBit){
			pageNoBit = procBit - offsetBit;
		}
		System.out.println("processor bit = "+procBit + " bit");
		System.out.println("page size = "+pageSize+" bytes"+"("+bytesToXB(getOrderOfTwo(pageSize))+")");
		System.out.println("pageNo bit = "+pageNoBit+" bit");
		System.out.println("offset bit = "+offsetBit+" bit");
		System.out.println("logical address space = "+bytesToXB(32));
		System.out.println("max # of pages in page table = 2"+"^"+pageNoBit);
		System.out.println("max size of page table = "+bytesToXB(pageNoBit+getOrderOfTwo(procBit/8)));
		scanner.close();
		
	}

	private static String bytesToXB(int i) {
		int f = i;String ret = "";int k = 0;
		if(i>=0 && i<10){
			k = (int) Math.pow(2,i);
			ret = k+" bytes";
		}else{
			i = i/10;
			f = f - i*10;
			k = (int) Math.pow(2,f);
			if(i==1){
				ret = k+" KB";
			}else if(i==2){
				ret = k+" MB";
			}else if(i==3){
				ret = k+" GB";
			}else if(i==4){
				ret = k+" TB";
			}
			else if(i==5){
				ret = k+" PB";
			}
			else if(i==6){
				ret = k+" EB";
			}
			else if(i==7){
				ret = k+" ZB";
			}
			else if(i==8){
				ret = k+" YB";
			}
		}
		return ret;
	}

	private static int getOrderOfTwo(int pageSize) {
		int order = 0;
		while(!(pageSize==1)){
			pageSize = pageSize/2;
			order++;
		}
		return order;
	}
}
