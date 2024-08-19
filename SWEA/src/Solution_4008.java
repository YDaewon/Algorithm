package test;

import java.util.Scanner;

public class Solution_4008 {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int [] num;
	static int [] select;
	static int [] opr;
	static int max, min;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			init();
			sol();
			System.out.println("#" + test + " " + (max-min));
		}
	}
	
	static void init() {
		n = sc.nextInt();
		max = Integer.MIN_VALUE;
		min =Integer.MAX_VALUE;
		num = new int[n];
		select = new int[n-1];
		opr = new int[4];
		char [] str = new char[n-1];
		for(int i = 0; i < 4; i++) {
			opr[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
	}
	
	static void sol() {
		dfs(0);
	}
	
	 static void dfs(int idx) { 
	        //����
	    if(idx == n-1) {  // N ������ ����, ������ N-1
	        int tot = calc();
	        max = Math.max(max, tot);
	        min = Math.min(min, tot);
	        return;
	    }
	         
	        //����
	    for(int i = 0 ; i < 4; i++) {
	        if(opr[i] > 0) {
	            opr[i]--;
	            select[idx] = i;
	            dfs(idx+1);
	            opr[i]++;
	        }
	    }
	 }
	 private static int calc() { //��Ģ����
	        int sum = num[0];
	        for(int i = 1; i < n; i++) {
	            switch(select[i-1]) {
	            case 0: 
	            	sum += num[i];
	                break;
	            case 1: 
	            	sum -= num[i];
	                break;
	            case 2:
	            	sum *= num[i];
	                break;
	            case 3: 
	            	sum /= num[i];
	                break;
	            }
	        }
	        return sum;
	    }
}
