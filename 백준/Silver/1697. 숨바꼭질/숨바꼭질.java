import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int [] visit = new int[100001];
    static int s, e, ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        e = sc.nextInt();
        visit[s]= 1;
        System.out.println(dfs(s));
    }
    
    public static int dfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        q.add(new int[] {n, cnt});
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int num = t[0];
            int cost = t[1];
            if(num == e) return cost;
            if(num+1 >= 0 && num+1 <100001) {
            	if(visit[num+1] == 0) {
            		visit[num+1] = 1;
            		q.add(new int[] {num+1,cost+1});
            	}
            }
            if(num-1 >= 0 && num-1 <100001) {
            	if(visit[num-1] == 0) {
            		visit[num-1] = 1;
            		q.add(new int[] {num-1,cost+1});
            	}
            }
            if(num*2 >= 0 && num*2 <100001) {
            	if(visit[num*2] == 0) {
            		visit[num*2] = 1;
            		q.add(new int[] {num*2,cost+1});
            	}
            }
        }
        return -1;
    }

}
