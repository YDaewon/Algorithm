import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int [][] arr;
	static int [] ans; // 0: white,   1: blue
	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int [n][n];
		ans = new int [2];
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < n ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sol(0,0,n);
		//System.out.println("white: " + ans[0] + ", blue: " + ans[1]);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
	
	static void sol(int sy, int sx, int size) {
		int color = arr[sy][sx];
		if(check(sy,sx,size,color)) {
			ans[color] ++;
			return;
		}
		int half = size/2;
		sol(sy,sx,half);
		sol(sy,sx + half,half);
		sol(sy + half,sx,half);
		sol(sy + half,sx + half,half);
	}
	
	
	static boolean check(int sy, int sx, int size, int color) {
		for(int i = sy; i < sy+size ; i++) {
			for(int j = sx; j < sx+size; j++) {
				if(arr[i][j] != color) return false;
			}
		}
		return true;
	}
}
