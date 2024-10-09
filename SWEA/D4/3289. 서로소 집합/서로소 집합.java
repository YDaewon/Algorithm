import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static int [] p;
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			n = sc.nextInt();
			m = sc.nextInt();
			p = new int[n+1];
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= n; i++) {
				p[i] = i;
			}
			sb.append("#"+test+" ");
			for(int i = 0; i < m; i++) {
				int q = sc.nextInt();
				int f = sc.nextInt();
				int s = sc.nextInt();
				if(q == 0) {
					union(f, s);
				}
				else {
					sb.append(find(f) == find(s) ? 1 : 0);
				}
			}
			System.out.println(sb);
		}
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		p[b] = a;
		return;
	}
	
	static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
}
