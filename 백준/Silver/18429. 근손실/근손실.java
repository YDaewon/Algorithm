 import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int cnt = 0;
    static int [] kit;
    static boolean [] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        kit = new int [n];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            kit[i] = Integer.parseInt(st.nextToken()) - k;
        }

        per(0, 500);

        System.out.println(cnt);
    }
    
    static void per(int d, int now){
        if(now < 500) return;

        if(d == n){
            cnt++;
            return;
        }

        for(int i = 0 ; i < n ; i++){
            if(!visit[i]){
                visit[i] = true;
                per(d+1, now + kit[i]);
                visit[i] = false;
            }
        }
    }


}
