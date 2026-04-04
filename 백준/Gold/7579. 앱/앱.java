import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [] arr;
    static int [] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr= new int[n];
        cost = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int temp = 0;
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            temp += cost[i];
        }

        int [] dp = new int [temp+1]; // n의 비용을 냈을 때 얻을 수 있는 메모리 공간의 최대

        for (int i = 0; i < n; i++) {
            for (int j = temp; j >= 0; j--) {
                if(j >= cost[i]) dp[j] = Math.max(dp[j], dp[j - cost[i]] + arr[i]);
            }
        }
        
        for (int i = 0; i < dp.length; i++) {
            if(dp[i] >= m){
                System.out.println(i);
                return;
            }
        }
    }
}
