import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int [] dy = {0,1,0,-1};
		int [] dx = {1,0,-1,0};
		for(int test = 1; test <= T; test++) {
			int n = sc.nextInt();
			int [][] arr = new int[n][n];
			int x = 0, y = 0, d = 0;
			for(int i = 1; i <= n * n; i++) {
				arr[y][x] = i;
				int ny = y + dy[d];
				int nx = x + dx[d];
				if((ny >= n || ny < 0 || nx >= n || nx < 0) || arr[ny][nx] != 0 ) d++;
				d %= 4;
				y += dy[d];
				x += dx[d];
			}
			System.out.println("#" + test);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
