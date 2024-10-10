import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] board;
	static boolean [][] visit;
	static int ans;
	static int[] dy = { -1,1,0,0 };
	static int[] dx = { 0,0,-1,1 };
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n][m];
		board = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visit[i][j] = true;
				dfs(1,board[i][j],i,j);
				T(i,j);
				visit[i][j] = false;
			}
		}
		
		System.out.println(ans);
	}
	private static void dfs(int cnt ,int sum ,int y, int x) {
		if(cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || nx<0 || ny >=n || nx >=m) continue;
			if(!visit[ny][nx]) {
				visit[ny][nx] = true;
				dfs(cnt +1, sum+board[ny][nx] ,ny,nx);
				visit[ny][nx] = false;
			}
		}
	}
	
	private static void T(int y, int x) {
		for(int i = 0 ; i < 4; i++) {
			int sum = board[y][x];
			int cnt = 0;
			for(int j = 0; j < 4; j++) {
				if(i == j) continue;
				int ny = y + dy[j];
				int nx = x + dx[j];
				if(ny<0 || nx<0 || ny >=n || nx >=m) continue;
				cnt++;
				sum += board[ny][nx];
			}
			if(cnt == 3) {
				ans = Math.max(sum,  ans);
			}
		}
	}
}
