package com;
import javax.swing.plaf.SliderUI;

public class MultiThread {
	
	public static void main(String[] args) {
		Thread1 thread1 =new Thread1();
		Thread t1 = new Thread(thread1);

		Thread2 thread2 =new Thread2();
		Thread t2 = new Thread(thread2);

		Thread3 thread3 =new Thread3();
		Thread t3 = new Thread(thread3);

		t1.start();
		t2.start();
		t3.start();
	}
}

class CommonDataFunction{
	private static int k =30;
	public static void commonFunc(){
		System.out.println("k = "+k);
		k--;
		System.out.println("-------------");
	}
}

class Thread1 implements Runnable{

	@Override
	public void run() {
		int j=0;
		CommonDataFunction obj =null;
		for(int i=0;i<10;i++){
			System.out.println("t1 :"+(++j));
			obj= new CommonDataFunction();
			obj.commonFunc();
		}
	}

}

class Thread2 implements Runnable{

	@Override
	public void run() {
		int j=0;
		CommonDataFunction obj =null;
		for(int i=0;i<10;i++){
			System.out.println("t2 :"+(++j));
			obj = new CommonDataFunction();
			obj.commonFunc();
		}
	}

}

class Thread3 implements Runnable{

	@Override
	public void run() {
		int j=0;
		CommonDataFunction obj =null;
		for(int i=0;i<10;i++){
			System.out.println("t3 :"+(++j));
			obj = new CommonDataFunction();
			obj.commonFunc();
		}
	}
}