import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {	
			int n = sc.nextInt();
			int m = sc.nextInt();
			int [][] arr = new int[n+1][n+1];
			int [][] sum = new int[n+1][n+1];
			for(int i = 0; i < n * n; i++) {
				int x = (i % n) + 1;
				int y = (i / n) + 1;
				arr[y][x] = sc.nextInt();
				sum[y][x] = arr[y][x] + sum[y-1][x] + sum[y][x-1] - sum[y-1][x-1];
				
			}
			int ans = 0;
			for(int i = 1; i <= n-m+1; i++) {
				for(int j = 1; j <= n-m+1; j++) {
					ans = Math.max(ans, sum[i+m-1][j+m-1] - sum[i-1][j+m-1] - sum[i+m-1][j-1] + sum[i-1][j-1]);
				}
			}
			System.out.println("#" + test+ " " +ans);
		}
	}
}
