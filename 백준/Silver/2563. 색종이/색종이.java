import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int [][] arr;
	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int [101][101];
		int ans = 0;
		for(int i = 0; i < n ; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			for(int j = y; j < y+10;j++) {
				for(int k = x; k < x+10;k++) {
					if(arr[j][k] == 0) {
						arr[j][k] = 1;
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
