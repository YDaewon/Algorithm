import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int N;
	static int[][] map;

	static int func(int y, int x, int len) {
		if (len == 1) {
			return map[y][x];
		}
		len /= 2;
        int[] arr = new int[4];
		arr[0] = func(y, x, len);
		arr[1] = func(y, x + len, len);
		arr[2] = func(y + len, x, len);
		arr[3] = func(y + len, x + len, len);
		
		Arrays.sort(arr);
		return arr[2];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(func(0, 0, N));
	}
}