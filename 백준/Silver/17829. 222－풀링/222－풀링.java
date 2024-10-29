import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][] map;

	static int getValue(int[] arr) {
		Arrays.sort(arr);
		return arr[2];
	}

	static int func(int y, int x, int len) {
		if (len == 2) {
			return getValue(new int[] { map[y][x], map[y + 1][x], map[y][x + 1], map[y + 1][x + 1] });
		}
		len /= 2;
		int n1 = func(y, x, len);
		int n2 = func(y, x + len, len);
		int n3 = func(y + len, x, len);
		int n4 = func(y + len, x + len, len);
		
		return getValue(new int[] { n1, n2, n3, n4 });
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][];
		
		for (int i=0; i<N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		System.out.println(func(0, 0, N));

	}
}