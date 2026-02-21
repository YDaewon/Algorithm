 import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> [] pos = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) pos[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            pos[color].add(x);
        }

        for (int i = 0; i <= n; i++) Collections.sort(pos[i]);
        int sum = 0;

        for(List<Integer> color: pos){
            int len = color.size();
            for(int i = 0; i < len; i++){
                int temp = Integer.MAX_VALUE;
                if(i > 0) temp = Math.min(temp, Math.abs(color.get(i) - color.get(i-1)));
                if(i < len - 1) temp = Math.min(temp, Math.abs(color.get(i + 1) - color.get(i)));
                sum+= temp;
            }
        }

        System.out.println(sum);
    }
}
