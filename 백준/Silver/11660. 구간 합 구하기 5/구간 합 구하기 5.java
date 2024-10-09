import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
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
		while(m-- != 0) {
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();
			System.out.println(sum[ex][ey] - sum[sx-1][ey] - sum[ex][sy-1] + sum[sx-1][sy-1]);
		}
	}
}
