import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static boolean ans;
	static List<Integer> g[];
	static int [] visit;
	public static void main(String[] args) {
		n = sc.nextInt();
		g = new ArrayList[n];
		visit = new int[n];
		m = sc.nextInt();
		for(int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			g[f].add(s);
			g[s].add(f);
		}
		for(int i = 0; i < n; i++) {
			sol(1, i);
			if(ans) break;
		}
		System.out.println(ans ? 1: 0);
	}
	
	static void sol(int d, int start) {
		if(d >= 5) {
			ans = true;
			return;
		}
		visit[start] = 1;
		for(int i : g[start]) {
			if(visit[i] == 0) {
				sol(d+1, i);
			}
		}
		visit[start] = 0;
	}
}
