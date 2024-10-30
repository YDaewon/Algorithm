import java.util.Scanner;

public class Main {

	static int N;
	static int[] cnt = new int[3];
	static int[][] map;

	static int check(int y, int x, int len) {
		int n = map[y][x];
		for (int i = y; i < y + len; i++) {
			for (int j = x; j < x + len; j++) {
				if (map[i][j] != n)
					return -99;
			}
		}
		return n;
	}

	static void func(int y, int x, int len) {
		int n = check(y, x, len);
		if (n != -99) {
			cnt[n + 1]++;
			return;
		}
		len /= 3;
		for (int i = 0; i < 3; i++) {
			func(y + len * i, x, len);
			func(y + len * i, x + len, len);
			func(y + len * i, x + len * 2, len);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		func(0, 0, N);
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
	}
}