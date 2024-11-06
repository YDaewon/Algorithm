import java.util.Scanner;

public class Main {
	static int [] arr, selected;
	static int n = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			if(n == 0) return;
			arr = new int [n];
			selected = new int [6];
			for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
			combination(0, 0);
			System.out.println();
		}
	}
	private static void combination(int d, int cur) {
		if(d == 6) {
			for(int i : selected) System.out.print(i + " ");
			System.out.println();
			return;
		}
		for(int i = cur; i < n; i++) {
			selected[d] = arr[i];
			combination(d+1, i+1);
			selected[d] = 0;
		}
	}
}
