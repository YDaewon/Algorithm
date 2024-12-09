import java.util.*;

public class Main {
    static List<Integer> [] build;
    static int n;
    static int [] time, result, indegree;
    static Queue<Integer> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        build = new ArrayList[n+1];
        indegree = new int [n+1];
        result = new int [n+1];
        q = new LinkedList<>();
        for(int i = 1; i <= n; i++) build[i] = new ArrayList<>();
        time = new int [n+1];
        for(int i = 1; i <= n; i++){
            time[i] = sc.nextInt();
            int t = sc.nextInt();
            while (t != -1){
                build[t].add(i);
                indegree[i]++;
                t = sc.nextInt();
            }
        }
        //for(int i : indegree) System.out.println(i);
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0) {
                result[i] = time[i];
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
           // System.out.println("now idx: " + cur);
            for (int i = 0; i < build[cur].size(); i++) {
                int next = build[cur].get(i);
                result[next] = Math.max(result[next], result[cur] + time[next]);
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            }
        }


        for(int i =1;i <= n;i++) System.out.println(result[i]);
    }
}
