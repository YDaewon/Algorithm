import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int n, start, max, ans;
	static Set<Integer> g[];
	static int [] visit;
	public static void main(String[] args) {
		for(int t = 1; t<= 10; t++) {
			init();
			sol(start);
			System.out.println("#"+t+" "+ ans);
		}
	}
	
	
	static void init() {
		n = sc.nextInt();
		start = sc.nextInt();
		g = new HashSet[101];
		ans = 0;
		max = 0;
		visit = new int [101];
		for(int i = 1; i<= 100; i++) g[i] = new HashSet<>();
		for(int i = 0; i < n/2; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			g[f].add(s);
		}
	}
	
	static void sol(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start, 0});
		visit[start] = 1;
		while(!q.isEmpty()) {
			int [] t = q.poll();
			int x = t[0];
			int cost = t[1];
			if(max < cost) {
				ans = 0;
				max = cost;
				if(ans < x) {
					ans = x;
				}
			}
			else if(max == cost) {
				if(ans < x) {
					ans = x;
				}
			}
			for(int i : g[x]) {
				if(visit[i] == 0) {
					visit[i] = 1;
					q.add(new int[] {i, cost+1});
				}
			}
		}
	}
}
