 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t;
        while((t = br.readLine()) != null && !t.isEmpty()){
            n = Integer.parseInt(t);
            sb = new StringBuilder();
            calc(true, (int)Math.pow(3, n));
            System.out.println(sb);
        }
    }

    static void calc(boolean flag, int num){
        if(!flag) {
            for (int i = 0; i < num; i++) {
                sb.append(" ");
            }
            return;
        }

        if(num == 1){
            if(flag) sb.append("-");
            else sb.append(" ");
            return;
        }
        int d = num / 3;
        calc(true, d);
        calc(false, d);
        calc(true, d);
    }

}
