import java.util.Scanner;

public class Main {
	static int n, m;
	static int [] arr, pnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[9];
		pnt = new int[9];
		sol(0);
	}
	
	static void sol(int d) {
		if(d == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(pnt[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(arr[i] == 0) {
				pnt[d] = i;
				arr[i] = 1;
				sol(d+1);
				arr[i] = 0;
			}
		}
	}
}
