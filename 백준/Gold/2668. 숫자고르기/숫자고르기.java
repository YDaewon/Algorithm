 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] arr;
    static boolean [] visit, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int [n+1];
        visit = new boolean[n+1];
        answer = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visit[arr[i]] = true;
            dfs(arr[i], i);
            visit[arr[i]] = false;
            
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(answer[i]) cnt++; 
        }

        System.out.println(cnt);
        for (int i = 1; i <= n; i++) {
            if(answer[i]) System.out.println(i); 
        }
    }

    static void dfs(int s, int e){
        if(s == e){
            for (int i = 0; i < n+1; i++) {
                if(visit[i]) answer[i] = true;
            }
            return;
        }
        if(!visit[arr[s]]){
            visit[arr[s]] = true;
            dfs(arr[s], e);
            visit[arr[s]] = false;
        }
    }
}
