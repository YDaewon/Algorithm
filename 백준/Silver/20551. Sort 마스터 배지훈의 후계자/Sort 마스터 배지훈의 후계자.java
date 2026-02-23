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

       arr = new int[n];
       for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(br.readLine());
       }

       Arrays.sort(arr);

       for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(br.readLine());

            int left = 0;
            int right = n-1;
            int ans = -1;
            while(left <= right){
                int mid = (left+right)/2;

                if(arr[mid] < t)  left =mid+1;
                else{
                    if(arr[mid] == t) ans = mid;
                    right = mid - 1;
                } 
            }
            System.out.println(ans);
       }

    }


}
