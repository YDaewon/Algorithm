 import java.io.*;
import java.util.*;

public class Main {
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int [] arr = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;

        for(int l1 = 0; l1 < n - 3; l1++){
            for(int r1 = l1 + 3; r1 < n; r1++){
                int l2 = l1 + 1;
                int r2 = r1 - 1;

                while(l2 < r2){
                    int h1 = arr[l1] + arr[r1];
                    int h2 = arr[l2] + arr[r2];

                    ans = Math.min(ans, Math.abs(h1 - h2));

                    if(h1 > h2){
                        l2++;
                    }else{
                        r2--;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
