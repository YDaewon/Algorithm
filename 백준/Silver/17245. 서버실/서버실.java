import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int left = 0;
        int right = 0;
        long com = 0;
        int [][] arr = new int [n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                right = Math.max(right, arr[i][j]);
                com += arr[i][j];
            }
        }
        while(left <= right){
            int mid = (left + right) / 2;

            // System.out.println("mid: " + mid + ", half: " + half);
            if(calc(n, mid, arr) < (com+1) / 2) left = mid + 1;
            else right = mid - 1;

        }

        System.out.println(left);
    }

    static long calc(int n , int mid, int [][] arr){
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += Math.min(arr[i][j], mid);
            }
        }
        return cnt;
    }

}
