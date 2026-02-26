 import java.io.*;
import java.util.*;

public class Main {
    static int k, n, f;
    static List<Integer> [] graph;
    static int [] answer;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < f; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
            if(graph[i].size() >= k - 1) graph[0].add(i);
        }
        for(int i : graph[0]){
            answer[0] = i;
            go(i, 1);
            if(flag) break;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(answer[i] + "\n");
        }
        System.out.println((flag ? sb : -1));
    }


    static void go(int now, int d){
        if(flag) return;

        if(d == k){
            flag = true;
            return;
        }
        
        for(int i : graph[now]){
            if(now < i && check(i, d)){
                answer[d] = i;
                go(i, d + 1);
                if(flag) return;
            }
        }
    }
    static boolean check(int me, int d){
        for (int i = 0; i < d; i++) {
            if(!graph[answer[i]].contains(me)) return false;
        }
        return true;
    }
}
