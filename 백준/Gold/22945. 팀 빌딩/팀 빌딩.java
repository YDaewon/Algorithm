import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] d = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        int l = 0, r = n-1;

        while(l < r){
            answer = Math.max(Math.min(d[l], d[r]) * (r-l-1), answer);
            if(d[l] < d[r]) l++;
            else r--;
        }
        System.out.println(answer);


    }


}
