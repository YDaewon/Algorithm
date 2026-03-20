 import java.io.*;
import java.util.*;

public class Main {
    static int n, l;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());   
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {   
            if(arr[i] <= l) l++;
            else break;
        }
        
        System.out.println(l);
    } 


}
