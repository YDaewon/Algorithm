import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    static int v;
    static int[] parents;
    static int [][] island;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
        	v = sc.nextInt();
        	island = new int[v+1][2];
        	for (int i = 1; i <= v; i++) {
        		island[i][1] = sc.nextInt();
        	}
        	for (int i = 1; i <= v; i++) {
        		island[i][0] = sc.nextInt();
        	}
        	double E = sc.nextDouble();
        	
        	
        	List<Edge>[] edges = new ArrayList[v+1];
        	for(int i = 1; i<= v; i++) {
        		edges[i] = new ArrayList<>();
        	}
        	for(int i = 1; i<= v; i++) {
        		for(int j = 1; j<= v; j++) {
            		if(i == j) continue;
            		edges[i].add(new Edge(j, get_distance(i,j)));
            		edges[j].add(new Edge(i, get_distance(i,j)));
            	}
        	}
        	PriorityQueue<Edge> pq = new PriorityQueue<>();
        	
        	pq.add(new Edge(1, 0));
        	double cnt = 0, cost = 0;
        	boolean [] visited = new boolean[v+1];
        	while(!pq.isEmpty()) {
        		Edge ed = pq.poll();
        		if(visited[ed.nxt]) continue;
        		visited[ed.nxt] = true;
        		cost+= ed.weight;
        		for(Edge i : edges[ed.nxt]) {
        			if(!visited[i.nxt]) pq.add(i);
        		}
        	}
        	System.out.println("#" + t + " " + Math.round(cost * E));
        }
    }
    
    static double get_distance(int a, int b) {
    	return Math.pow(island[a][0] - island[b][0], 2) + Math.pow(island[a][1] - island[b][1], 2);
    }
    
    static class Edge implements Comparable<Edge>{
        int nxt;
        double weight;

        public Edge(int nxt, double weight) {
            super();
            this.nxt = nxt;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return Double.compare(this.weight, o.weight);
        }
    }
}