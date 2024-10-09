import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m, r;
	static int [][] arr;
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < r; i++) {
			sol();			
		}
		for(int k = 0; k < n; k++) {
			for(int j = 0; j < m; j++) {
				System.out.print(arr[k][j] + " ");		
			}	
			System.out.println();
		}
	}
	
	static void sol() {
		int repeat = Math.min(n,m) / 2;
		for(int i = 0; i < repeat;i++) {
			int t = arr[i][i];
			for(int j = i; j < m-i-1;j++) { // to left
				arr[i][j] = arr[i][j+1];
			}
			for(int j = i; j < n-i-1;j++) { // to left
				arr[j][m-i-1] = arr[j+1][m-i-1];
			}
			for(int j = m-i-1; j > i;j--) {
				arr[n-1-i][j] = arr[n-1-i][j-1];
			}
			for(int j = n-i-1; j > i;j--) {
				arr[j][i] = arr[j-1][i];
			}
			arr[i+1][i] = t;
		}
	}
}
