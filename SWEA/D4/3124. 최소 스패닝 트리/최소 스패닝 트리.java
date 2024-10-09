import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    static int v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
            
        for(int t = 1; t <= T; t++) {
        	v = sc.nextInt();
        	int e = sc.nextInt();
        	
        	PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        	List<int []> [] edges = new ArrayList[v+1];

        	for (int i = 1; i <= v; i++) {
        		edges[i] = new ArrayList<>();
        	}
        	boolean [] visit = new boolean[v+1];
        	for (int i = 0; i < e; i++) {
        		int start = sc.nextInt();
        		int end = sc.nextInt();
        		int cost = sc.nextInt();
        		edges[start].add(new int [] {end, cost});
        		edges[end].add(new int [] {start, cost});
        	}
        	pq.add(new int[] {1,0});
        	
        	long ans = 0;
        	int cnt = 0;
        	while(!pq.isEmpty()) {
        		int [] ed = pq.poll();
        		if(visit[ed[0]]) continue;
        		visit[ed[0]] = true;
        		//if(cnt++ == v-1) break;
        		ans += ed[1];
        		for(int [] i : edges[ed[0]]) {
        			if(!visit[i[0]]) pq.add(i);
        		}
        		
        	}
        	
        	System.out.println("#" + t + " " + ans);
        }
    }
   
}