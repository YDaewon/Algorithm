import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int n, ans;
	static int [][] arr;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			init();
			sol();
			System.out.println("#"+test+" "+ ans);
		}
	}
	
	static void init() {
		n = sc.nextInt();
		sc.nextLine();
		arr = new int[n][n];
		ans = 0;
		char [] t;
		for(int i = 0; i < n;i++) {
			t = sc.nextLine().toCharArray();
			for(int j = 0 ; j < n; j++) {
				arr[i][j] = t[j] - '0';
			}
		}
	}
	
	static void sol() {
		int p = n/2;
		int left = 0, right = 0;
		for(int i = 0; i < n;i++) {
			//System.out.print("[" + i + "]: ");
			for(int j = 0 ; j < n; j++) {
				if(j >= p-left && j <= p+right) {
					//System.out.print(j + " ");
					ans += arr[i][j];
				}
			}
			//System.out.println();
			if(i >= p) {
				left--; right--;
			}
			else {
				left++; right++;
			}
		}
	}
}