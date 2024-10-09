import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] friends;
	static int[] friendCnt;
	static int a,b,c;
	static int minV = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		friends = new int[n+1][n+1];
		friendCnt = new int[n+1];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a][b] = 1;
			friends[b][a] = 1;
			friendCnt[a]++;
			friendCnt[b]++;
			
		}
		
		for (int i =1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if(i == j || friends[i][j]!=1) continue;
				for (int k=1; k<=n; k++) {
					if(j == k || i ==k || friends[j][k]!=1 || friends[i][k] !=1) continue;
					a = friendCnt[i] - 2;
					b = friendCnt[j] - 2;
					c = friendCnt[k] - 2;
					minV = Math.min(minV, a+b+c);
				}
			}
		}
		if(minV != Integer.MAX_VALUE) System.out.println(minV);
		else System.out.println(-1);
	}
	
}
