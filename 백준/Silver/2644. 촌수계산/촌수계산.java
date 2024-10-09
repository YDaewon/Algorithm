import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m, ans;
	static List<Integer> g[];
	static int [] visit;
	public static void main(String[] args) {
		n = sc.nextInt();
		int ans1 = sc.nextInt();
		int ans2 = sc.nextInt();
		g = new ArrayList[n+1];
		visit = new int[n+1];
		m = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			g[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			g[f].add(s);
			g[s].add(f);
		}
		sol(ans1, ans2);
		System.out.println(ans);
	}
	
	static void sol(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{a, 0});
		visit[a] = 1;
		while(!q.isEmpty()) {
			int [] t = q.poll();
			if(t[0] == b) {
				ans = t[1];
				return;
			}
			for(int i : g[t[0]]) {
				if(visit[i] == 0) {
					visit[i] = 1;
					q.add(new int[]{i, t[1]+1});
				}
			}
		}
		ans = -1;
		return;
	}
}
