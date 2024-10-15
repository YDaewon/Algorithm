import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int n, m, x;
	static List<int []> [] node;
	static int [] distance; // x 기준
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   n = sc.nextInt(); // 도시 개수
	   m = sc.nextInt(); // 도로 개수
	   node = new ArrayList[n+1];
	   distance = new int[n+1];
	   Arrays.fill(distance, Integer.MAX_VALUE);
       distance[x] = 0;
	   for(int i = 1; i <= n; i++) node[i] = new ArrayList<>();
	   
	   for(int i = 1; i <= m; i++) {
		   int a = sc.nextInt();
		   int b = sc.nextInt();
		   int c = sc.nextInt();
		   node[a].add(new int[] {b, c});
	   }
	   x = sc.nextInt();
	   int end = sc.nextInt();
	   
	   dijkstra();
	   System.out.println(distance[end]);
   }
   
	private static void dijkstra() {
		PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2) -> {
			int a = o1[0];
			int b = o2[0];
			
			return a > b ? 1 : -1;
		});
		
		pq.add(new int[] {0, x});
		while(!pq.isEmpty()) {
			int [] p = pq.poll();
			if(distance[p[1]] < p[0]) continue;
			
			for(int [] n : node[p[1]]) {
				int cost = p[0] + n[1];
				if(cost < distance[n[0]]) {
					distance[n[0]] = cost;
					pq.add(new int[] {cost, n[0]});
				}
			}
			
		}
		
	}

}