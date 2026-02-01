import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            if(str.equals("end")) break;
            boolean flag1 = false;
            boolean flag2 = true;
            boolean flag3 = true;
            int v_cnt = 0;
            int c_cnt = 0;
            char bef = '1';
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(bef == c && (c != 'e' && c != 'o')) {
                    flag3 = false;
                    break;
                }
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    flag1 = true;
                    if(v_cnt >= 2) {
                        flag2 = false;
                        break;
                    }
                    c_cnt = 0;
                    v_cnt++;
                }
                else{
                    if(c_cnt >= 2) {
                        flag2 = false;
                        break;
                    }
                    v_cnt = 0;
                    c_cnt++;
                }
                bef = c;
            }
            if(flag1 && flag2 && flag3) sb.append("<"+str+"> is acceptable.\n");
            else sb.append("<"+str+"> is not acceptable.\n");
        }
        System.out.println(sb);
    }

}
