import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int [][] node;
	static boolean [] visit;
	static Scanner sc =new Scanner(System.in);
	static int n,m, in, out, ans;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			init();
			sol();
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void init() {
		n = sc.nextInt();
		m = sc.nextInt();
		node = new int[n+1][n+1];
		for(int i = 0; i < m ; i++) {
			node[sc.nextInt()][sc.nextInt()] = 1;
		}
		ans = 0;
		
	}
	
	static void sol() {
		for(int i = 1; i <= n; i++) {
			in = 0;
			out = 0;
			visit = new boolean[n+1];
			innode(i);
			Arrays.fill(visit, false);
			outnode(i);
			/* 이걸 재귀돌려야됨
			for(int j = 1; j <= n; j++) {
				if(node[j][i] == 1) in++;
				if(node[i][j] == 1) out++;
			}
			*/
			
			
			//System.out.println("in=" + in + ", out=" + out);
			if(in + out == n-1) {
				ans++;
			}
		}
	}
	
	static void innode(int now) {
		visit[now] = true;
		for(int j = 1; j <= n; j++) {
			if(!visit[j] && node[j][now] == 1) {
				in++;
				innode(j);
			}
		}
	}
	
	static void outnode(int now) {
		visit[now] = true;
		for(int j = 1; j <= n; j++) {
			if(!visit[j] && node[now][j] == 1) {
				out++;
				outnode(j);
			}
		}
	}
}
