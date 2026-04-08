import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int [] arr;
    static int [] dp;
    static int [] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());

        arr = new int [n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // for (int i = 0; i < n; i++) {
        //     dp[i] = 1;
        //     for (int j = 0; j < i; j++) {
        //         if(arr[j] > arr[i]){
        //             dp[i] = Math.max(dp[j] + 1, dp[i]);
        //         }
        //     }
        // }

        int cnt = 0;

        list = new int [n];
        list[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if(list[cnt] > arr[i]){
                list[++cnt] = arr[i];
            }
            else{
                int idx = binarysearch(0, cnt, arr[i]);
                list[idx] = arr[i];
            }


            // for (int j = 0; j < n; j++) {
            //     System.out.print(list[j] + " ");
            // }
            // System.out.println();
        }

        System.out.println(cnt + 1);

    }

    private static int binarysearch(int left, int right, int val) {
        
        while(left < right){
            int mid = (left + right) / 2;

            if(list[mid] > val){
                left = mid + 1;
            }
            else right = mid;
        }

        return left;
    }

}
