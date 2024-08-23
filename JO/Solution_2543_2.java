package JO;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution_2543_2 {
	static int n, hole_y, hole_x;
	static int [][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		hole_y = sc.nextInt();
		hole_x = sc.nextInt();
		arr = new int[n][n];
		sol(0,0,n, hole_y, hole_x);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	static void sol(int y, int x, int size, int hy, int hx) {
		if(size == 1) return;
		int tile = 1, half = size/2;
		int ey = y + half -1, ex = x + half-1;
		
		if(hy > ey) tile += 2;
		if(hx > ex) tile += 1;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				int ny = y + (half*i);
				int nx = x + (half*j);
				if(i * 2 + j + 1 == tile) {
					sol(ny,nx,half,hy,hx);
				}
				else {
					arr[ey+i][ex+j] = tile; 
					sol(ny,nx,half,ey+i,ex+j);
				}
			}
		}
	}
}
