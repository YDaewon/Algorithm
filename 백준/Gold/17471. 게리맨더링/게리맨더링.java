import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static List<Integer> [] graph = new ArrayList[11];
	static int [] people = new int[11];
	static int [] team = new int[11];
	static int [] visit = new int[11];
	static int n, ans;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		init();
		for(int i = 1; i <= n/2; i++) combination(0, 1, i);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void init() {
		n = sc.nextInt();
		for(int i = 0; i <= n; i ++) {
			graph[i] = new ArrayList<>();
			if(i==0) continue;
			people[i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i ++) {
			int s = sc.nextInt();
			for(int j = 0; j < s; j++) {
				int e = sc.nextInt();
				graph[i].add(e);
				graph[e].add(i);
			}
		}
		ans = Integer.MAX_VALUE;
	}
	
	static void combination(int d, int now, int end) { 
		if(d == end) {
			if(check(1) && check(0)) {
				int a = 0, b = 0;
				for(int i = 1; i <= n; i++) {
					if(team[i]==1) {
						a+=people[i];
						//System.out.print(i + " ");
					}
					else b += people[i];
				}
				//System.out.println();
				//System.out.println("a: " + a + ", " + "b: " + b);
				ans = Math.min(ans,  Math.abs(a-b));
			}
			return;
		}
		for(int i = now; i <= n; i++) {
			team[i] = 1;
			combination(d+1, i+1, end);
			team[i] = 0;
		}
	}
	
	static boolean check(int t) {   // dfs
		int cnt = 0;
		int start = 0;
		for(int i = 1; i<= n; i++) {
			if(team[i] == t) {
				cnt++;
				start = i;
			}
			visit[i] = 0;
		}
		
		Stack<Integer> s = new Stack<>();
		s.push(start);
		visit[start] = 1;
		while(!s.isEmpty()) {
			int cur = s.pop();
			cnt--;
			for(int i : graph[cur]) {
				if(visit[i] == 0 && team[i] == t) {
					visit[i] = 1;
					s.push(i);
				}
			}
		}
		//System.out.println(cnt);
		return cnt == 0;
	}
	
	
}
