 import java.io.*;
import java.util.*;

public class Main {

    static String str;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        for (int i = 0; i <= 9; i++) calc(String.valueOf(i));

        System.out.println(ans);
    }

    static void calc(String now){
        if(str.equals(now)){
            ans++;
            return;
        }

        if(!str.contains(now)) return;

        for (int i = 0; i <= 9; i++) {
            String f = i + now;
            String b = now + i;
            calc(f);
            if(!f.equals(b)) calc(b);
        }
    }

}
