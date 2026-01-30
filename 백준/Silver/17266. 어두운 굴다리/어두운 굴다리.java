import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int [] arr = new int [m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = arr[0];
        int right = n;

        while(left <= right){
            int mid = (left + right) / 2;

            if(calc(mid, arr, n)){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    static boolean calc(int mid, int [] arr, int n){
        int cur = 0;
        for(int i : arr){
            if(cur < i - mid || cur > i + mid) return false;
            cur = i + mid;
        }
        if(cur < n) return false;
        return true;
    }
}
