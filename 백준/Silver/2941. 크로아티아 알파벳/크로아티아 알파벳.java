 import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<String, String> map = new HashMap<>();
        
        map.put("c=", "č");
        map.put("c-", "ć");
        map.put("dz=", "dž");
        map.put("d-", "đ");
        map.put("lj", "lj");
        map.put("nj", "nj");
        map.put("s=", "š");
        map.put("z=", "ž");

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(i + 2 <= str.length() &&( c =='c' || c == 'd' || c == 'l' || c == 'n' || c == 's' || c == 'z')){
                String t = str.substring(i, i+2);
                //System.out.println(t);
                if(map.containsKey(t)) i++;
                else if(i + 3 <= str.length()){
                    String t2 = str.substring(i, i+3);
                    if(t2.equals("dz=")) i+=2;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }

}
