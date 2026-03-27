 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = 1;

        int temp = Integer.MAX_VALUE;

        while(l < n && r < n){
            int mid = Math.abs(arr[l] - arr[r]);

            if(mid < m){
                r++;
            }
            else{
                temp = Math.min(temp, mid);
                l++;
            }
        }

        System.out.println(temp);

    }


}
