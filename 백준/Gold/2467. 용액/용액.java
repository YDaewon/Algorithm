 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] ox;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ox = new int [n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ox[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;

        int [] ans = new int [2];
        int t = Integer.MAX_VALUE;

        while(left < right){
            int mid = (ox[left] + ox[right]);

            if(Math.abs(mid) < t){
                t = Math.abs(mid);
                ans[0] = ox[left];
                ans[1] = ox[right];
            }

            if(mid == 0) break;
            else if(mid < 0) left++;
            else right--;
        }

        System.out.println(ans[0] + " " + ans[1]);
        
    }

}
