package Baekjoon;

import java.util.Scanner;

public class Solution_1074 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int r = sc.nextInt();
	    int c = sc.nextInt();
	    System.out.println(sol(n,r,c));
	}
	
	static int sol(int n, int r, int c){
	    int pr= 0;
	    int pc = 0;
	    int size = (int) Math.pow(2, n-1);
	    
	    if (r >= size)
	        pr = 2; // 
	    if (c >= size)
	        pc = 1;
	    
	    if (n == 1)
	        return pr + pc;
	    else
	        return (pr+pc)*(int)Math.pow(size, 2) + sol(n-1, r % size, c % size);
	    	/*(pr+pc)*(int)Math.pow(size, 2) = pr�� pc�� 4������ ���� �� ���° �и鿡 �ִ��� �ľ�
	    	 *           |
	    	 *           |
	    	 *     1     |     2
	    	 *           |
	    	 * ---------------------
	    	 *           |
	    	 *     3     |     4
	    	 *           |
	    	 *           |
	    	 *           
	    	 *           
	    	 * sol(n-1, r % size, c % size) = 4���ҵ� �и鿡�� ���� Ž��
	        */
	        
	     
	}
}
