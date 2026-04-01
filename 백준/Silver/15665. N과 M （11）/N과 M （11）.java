 import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Set<Integer> num = new TreeSet<>();
    static int [] pnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        pnt = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            num.add(temp);
        }   


        calc(0);

        System.out.println(sb);
    }

    static void calc(int d){
        if(d == m){
            for (int i : pnt) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i : num) {
            pnt[d] = i;
            calc(d+1);
        }
    }

}
