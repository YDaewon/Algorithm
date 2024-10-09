import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n,m;
	static Scanner sc = new Scanner(System.in);
    static List<Integer>[] node;
    static int [] visit;
    static List<Integer> ans;
    public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		node =  new ArrayList[n + 1];
		ans = new ArrayList<>();
		visit = new int[n+1];
		for(int i = 1; i <= n; i++) {
			node[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			node[f].add(s);
			visit[s]++;
		}
		
		topological();
		for(int i : ans) System.out.print(i + " ");
	}
    
    static void topological() {
    	Queue<Integer> q = new LinkedList<>();
    	for(int i = 1; i <= n; i++) {
    		if(visit[i] == 0) q.add(i);
    	}
    	while(!q.isEmpty()) {
    		int t = q.poll();
    		ans.add(t);
    		for(int i : node[t]) {
    			visit[i]--;
    			if(visit[i] == 0) q.add(i);
    		}
    	}
    }
}
