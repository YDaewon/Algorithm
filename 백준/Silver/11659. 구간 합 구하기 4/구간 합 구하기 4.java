import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] arr = new int[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		while(m-- != 0) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println(arr[e] - arr[s-1]);
		}
	}
}
