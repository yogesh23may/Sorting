//checker board problem with recursion [minCostRecursive]
//checker board problem with recursion + memoization = Top Down DP [minCostMemoized]
//checker board problem using greedy approach [minCostGreedy]
package com;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Checker {

	private static int MAX = 100;
	private static int N;
	private static int[][] arr;
	private static int[][] memo;
	private static int i = 0;
	private static int j = 0;
	private static Scanner scanner ; 

	public static void main(String[] args) {

		System.out.println("\t\t\twelcome to the world of dynamic programming");
		System.out.println("\t\t\t===========================================\n");
		String locCh="";boolean firstTime = true ;boolean contChAsk = true;
		try{
			do{
				scanner = new Scanner(new InputStreamReader(System.in));
				if(firstTime){
					System.out.println("1)top down dynamic programming");
					System.out.println("2)greedy approach");
					System.out.println("3)normal recursion");
					System.out.println("4)exit");
				}

				do{
					System.out.println("\nkindly enter ur choice(1 to 4): ");
					System.out.println("-------------------------------");
					locCh = scanner.next();
					if(verify(locCh)){
						try{
							contChAsk = true;
							initiateProgram(Integer.parseInt(locCh));
						}catch(Exception e){
							System.out.println("\nkindly enter correct value");
							contChAsk = false;
						}
					}else{
						System.out.println("\nkindly enter correct value");
						contChAsk = false;
					}
				}while(!contChAsk);


				System.out.println("\ndo you want to continue(y/n): ");
				System.out.println("-----------------------------");
				locCh = scanner.next();
				firstTime = false;
			}while((locCh.charAt(0)=='y' || locCh.charAt(0)=='Y') && (locCh.length()==1));
			scanner.close();
		}
		catch(Exception e){
			System.out.println("exception occured in main ");
			e.printStackTrace();
		}
		System.out.println("\napplication closed !!!");
		System.exit(0);
	}

	private static boolean verify(String locCh) {
		int ascii =0;boolean ret = false ;
		for(int i=0;i<locCh.length();i++){
			ascii = locCh.charAt(i);
			if(ascii>=48 && ascii<=57){
				ret = true;
			}
		}
		return ret;
	}

	private static void initiateProgram(int ch) {

		if(ch>=1 && ch<=3){
			System.out.println("***********************************************************");
			filldata();
			display(arr,"arr");
			setArrayIndex();
		}
		switch(ch){
		case 1:
			System.out.println("\ntop down dynamic programming [finding min cost for arr["+i+","+ j+"]]");
			System.out.println("\nminCost("+i+","+ j+") = "+minCostMemoized(i,j));
			display(memo,"memo");
			break;
		case 2:
			System.out.println("\ngreedy pproach [finding min cost for arr["+i+","+ j+"]]");
			System.out.println("\nminCost("+i+","+ j+") = "+minCostGreedy(i, j));
			break;
		case 3:
			System.out.println("\nnormal recursion [finding min cost for arr["+i+","+ j+"]]");
			System.out.println("\nminCost("+i+","+ j+") = "+minCostRecursive(i, j));
			break;
		default:
			System.out.println("entered choice is wrong.");
			break;
		}
		if(ch>=1 && ch<=3){
			System.out.println("***********************************************************");
		}
	}

	private static void setArrayIndex() {
		String locCh = "";
		System.out.println("\nvalue range for (i,j) :"+0 +" to "+(arr.length-1));
		do{
			System.out.println("\nenter i(th) value for array correctly:");
			System.out.println("---------------------------------------");
			locCh = scanner.next();
			if(verify(locCh)){
				try{
					i=Integer.parseInt(locCh);
				}catch(Exception e){
					i=-1;
				}
			}else{
				i=-1;
			}
		}while(!(i<=arr.length-1 && i>=0));
		do{
			System.out.println("enter j(th) value for array correctly:");
			System.out.println("-------------------------------------");
			locCh = scanner.next();
			if(verify(locCh)){
				try{
					j=Integer.parseInt(locCh);
				}catch(Exception e){
					j = -1;
				}
			}else{
				j=-1;
			}
		}while(!(j<=arr.length-1 && j>=0));
	}

	private static int minCostGreedy(int i, int j) {
		int minCost = 0;int jIndex = 0;
		System.out.println("\niterations involved in greedy approach:");
		System.out.println("----------------------------------------");
		for(int k=i;k<N;k++){
			if(k>i){
				jIndex = minIndexDown(k,jIndex);
			}else{
				jIndex = j;
			}
			System.out.println("arr["+k+"]["+jIndex+"]"+"---->"+arr[k][jIndex]);
			minCost += arr[k][jIndex];
		}
		return minCost;
	}

	private static int minCostMemoized(int i, int j) {
		int ret = 0;
		if (j < 0 || j > N-1) {
			ret = MAX;
		}else { 
			if(memo[i][j] == 0){
				if (i == N-1){
					ret = arr[i][j];
				}else{
					ret = min(minCostMemoized(i+1,j-1), minCostMemoized(i+1,j),minCostMemoized(i+1,j+1))+ arr[i][j]; 
				}
				memo[i][j] = ret;
			}else{
				ret = memo[i][j];
			}
		}

		return ret;
	}

	private static int minCostRecursive(int i, int j) {
		int ret = 0;
		if (j < 0 || j > N-1) {
			ret = MAX;
		} else if (i == N-1){
			ret = arr[i][j];
		}else{
			ret = min(minCostRecursive(i+1,j-1), minCostRecursive(i+1,j),minCostRecursive(i+1,j+1))+ arr[i][j];
		}
		return ret;
	}

	private static int min(int minCost1, int minCost2, int minCost3) {
		int smallest=0;
		if(minCost1<=minCost2 && minCost1<minCost3){
			smallest = minCost1;
		}
		else if(minCost2<=minCost3){
			smallest=minCost2;
		}
		else {
			smallest = minCost3;
		}
		return smallest;
	}

	private static int minIndexDown(int i,int j) {
		int minCost1 =0 ;int minCost2 = 0;int minCost3 = 0;
		if (j-1 < 0 ) {
			minCost1 = MAX;
		}else{
			minCost1 = arr[i][j-1];
		}

		if (j < 0 || j > N-1) {
			minCost2 = MAX;
		}else{
			minCost2 = arr[i][j];
		}

		if (j+1 > N-1) {
			minCost3 = MAX;
		}else{
			minCost3 = arr[i][j+1];
		}

		int smallestIndex=0;
		if(minCost1<=minCost2 && minCost1<minCost3){
			smallestIndex = j-1;
		}
		else if(minCost2<=minCost3){
			smallestIndex = j;
		}
		else {
			smallestIndex = j+1;
		}
		return smallestIndex;
	}

	private static void display(int[][] dispArr,String type) {
		if(type.equalsIgnoreCase("arr")){
			System.out.println("checker board:");
			System.out.println("-------------");
		}else{
			System.out.println("\nmemoized array:");
			System.out.println("----------------");
		}
		int balFac = dispArr.length;
		for (int i = 0; i < dispArr.length; i++) {
			if(balFac<10){
				System.out.print(i + "  |");
			}else{
				if(i<10)
					System.out.print(i + "  |");
				else
					System.out.print(i + " |");
			}
			for (int j = 0; j < dispArr.length; j++) {
				System.out.print(dispArr[i][j]);
				if (j < dispArr.length - 1) {
					if(dispArr[i][j]<=9){
						System.out.print(" . ");
					}else{
						System.out.print(". ");
					}
				}
			}
			System.out.println();
		}
	}

	private static void filldata() {
		String locCh="";
		System.out.println("value range for 2D array :["+2 +" to "+100+"]");
		do{
			System.out.println("\nenter 2D array dimension correctly:");
			System.out.println("-----------------------------------");	
			try{
				locCh = scanner.next();
				if(verify(locCh)){
					try{
						N=Integer.parseInt(locCh);
					}catch(Exception e){
						N=-1;
					}
				}else{
					N=-1;
				}
			}catch(Exception e){
				System.out.println("exception occured in fillData");
			}
		}while(!(N>=2 && N<=100));
		arr = new int[N][N];
		memo = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] =new Double(Math.floor(Math.random()*10)).intValue();
			}
		}
	}

}
