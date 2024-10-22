import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j< n ;j++) {
				arr[i][j] = sc.nextInt();
			}
			arr[i][i] = 1;
		}
		int [] plan = new int [m];
		for(int i = 0; i< m; i++) plan[i] = sc.nextInt()-1;
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j< n ;j++) {
					if(arr[i][j] == 0) arr[i][j] = arr[i][k] & arr[k][j];
				}
			}
		}
		boolean flag = true;
		int start = plan[0];
		for(int i = 1; i < m; i++) {
			int end = plan[i];
			if(arr[start][end] == 0) {
				flag = false;
				break;
			}
			start = plan[i];
		}
		System.out.println(flag ? "YES" : "NO");
	}
}
