import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int n, m, k, x;
	static List<Integer> [] node;
	static int [] distance; // x 기준
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   n = sc.nextInt(); // 도시 개수
	   m = sc.nextInt(); // 도로 개수
	   k = sc.nextInt(); // 거리가 얘랑 같아야 함
	   x = sc.nextInt(); // 출발 도시 번호
	   node = new ArrayList[n+1];
	   distance = new int[n+1];
	   Arrays.fill(distance, Integer.MAX_VALUE);
       distance[x] = 0;
	   for(int i = 1; i <= n; i++) node[i] = new ArrayList<>();
	   
	   for(int i = 1; i <= m; i++) {
		   int a = sc.nextInt();
		   int b = sc.nextInt();
		   node[a].add(b);
	   }
	   dijkstra();
	   boolean flag = true;
	   for(int i = 1; i <= n; i++) {
		   if(distance[i] == k) {
			   System.out.println(i);
			   flag = false;
		   }
	   }
	   if(flag) System.out.println(-1);
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
			
			for(int n : node[p[1]]) {
				int cost = p[0] + 1;
				if(cost < distance[n]) {
					distance[n] = cost;
					pq.add(new int[] {cost, n});
				}
			}
			
		}
		
	}

}