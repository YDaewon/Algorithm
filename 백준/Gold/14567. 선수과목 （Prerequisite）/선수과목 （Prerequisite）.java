import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer> [] nodes = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) nodes[i] = new ArrayList<>();
		int [] cnt = new int [n+1];
		int [] ans = new int [n+1];
		for(int i = 0; i < m; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			nodes[f].add(s);
			cnt[s]++;
		}
		
		Queue<int []> q = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			if(cnt[i] == 0) {
				q.offer(new int [] {i, 1});
				ans[i] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			for(int i : nodes[cur[0]]) {
				if(ans[i] == 0) {
					cnt[i]--;
					if(cnt[i] == 0) {
						q.offer(new int [] {i, cur[1]+1});
						ans[i] = cur[1]+1;
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++) System.out.print(ans[i] + " ");
	}
}
