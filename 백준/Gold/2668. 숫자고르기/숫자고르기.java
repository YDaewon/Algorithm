import java.io.*;
import java.util.*;


public class Main {
    static int n, ans;
    static int [] arr;
    static boolean [] check, visit;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int [n+1];
        visit = new boolean[n+1];
        check = new boolean[n+1];
        ans = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            int now = i;
            int nxt = arr[now];
            list = new ArrayList<>();
            visit[nxt] = true;
            list.add(nxt);
            IsCycle(nxt, i);
            visit[nxt] = false;
        }
        for (int i = 1; i <= n; i++) {
            if(check[i]) ans++;
        }
        System.out.println(ans);
        for (int i = 1; i <= n; i++) {
            if(check[i]) System.out.println(i);
        }
    }

    static void IsCycle(int start, int end){
        if(start == end){
            for(int i : list){
                //System.out.println(i + " is " + true);
                check[i] = true;
            }
            return;
        }
        int next = arr[start];
        if(!visit[next]){
            //System.out.println("cur: " + start + ", next: " + next);
            visit[next] = true;
            list.add(next);
            IsCycle(next, end);
            visit[next] = false;
        }
    }
}