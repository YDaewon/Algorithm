import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int n, m, party, ans;
	static List<int []> [] node;
	static int party_distance[][];
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   n = sc.nextInt();
	   m = sc.nextInt();
	   party = sc.nextInt();
	   node = new ArrayList[n+1];
	   party_distance = new int[n+1][n+1];
	   for(int i = 1; i <= n; i++) {
		   Arrays.fill(party_distance[i], Integer.MAX_VALUE);
		   party_distance[i][i] = 0;
	   }

	   for(int i = 1; i <= n; i++) node[i] = new ArrayList<>();
	   
	   for(int i = 1; i <= m; i++) {
		   int a = sc.nextInt();
		   int b = sc.nextInt();
		   int c = sc.nextInt();
		   node[a].add(new int[] {b, c});
	   }
	   
	   for(int i = 1; i<= n; i++) {
		   dijkstra(i);
	   }
	   for(int i = 1; i<= n; i++) {
		   ans = Math.max(ans, party_distance[i][party] + party_distance[party][i]);
	   }
	   
	   System.out.println(ans);
   }
   
	private static void dijkstra(int x) {
		PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2) -> {
			int a = o1[0];
			int b = o2[0];
			
			return a > b ? 1 : -1;
		});
		
		pq.add(new int[] {0, x});
		while(!pq.isEmpty()) {
			int [] p = pq.poll();
			if(party_distance[x][p[1]] < p[0]) continue;
			
			for(int [] n : node[p[1]]) {
				int cost = p[0] + n[1];
				if(cost < party_distance[x][n[0]]) {
					party_distance[x][n[0]] = cost;
					pq.add(new int[] {cost, n[0]});
				}
			}
			
		}
		
	}

}