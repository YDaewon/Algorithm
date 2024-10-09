import java.util.Scanner;

public class Main {
	static int [][] graph;
	static int n, ans;
	static boolean [] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		graph = new int [n][n];
		ans = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n ; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < n; i++) {
			visit = new boolean[n];
			visit[i] = true;
			sol(0, i, i, 0);
		}
		System.out.println(ans);
	}
	
	static void sol(int d, int start, int now, int sum) {
		//System.out.println(sum);
		if(d == n-1) {
			if(graph[now][start] != 0) {
				sum += graph[now][start];
				ans = Math.min(ans, sum);
				return;
			}
		}
		for(int i = 0; i < n; i++) {
			if(!visit[i] && graph[now][i] != 0) {
				visit[i] = true;
				sol(d+1, start, i, sum+graph[now][i]);
				visit[i] = false;
			}
		}
	}
}
