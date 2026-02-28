 import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
       
        arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int now = n-1;
        int cnt = 0;
        while(k > 0){
            if(k / arr[now] == 0){
                now--;
                continue;
            }
            
            int t = k / arr[now];
            k -= arr[now--] * t;
            cnt += t;
        }
        System.out.println(cnt);
    }
}
