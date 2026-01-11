import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char [] str = br.readLine().toCharArray();
        int len = str.length;
        int zero = 0;
        int one = 0;

        for (int i = 0; i < len; i++) {
            if(str[i] == '0') zero++;
            else one++;
        }
        zero /= 2;
        one /= 2;
        for (int i = len - 1; i >= 0; i--) {
            if(str[i] == '0' && zero > 0){
                str[i] = 'x';
                zero--;
            }
            if(str[(len-1) - i] == '1' && one > 0){
                str[(len-1) - i] = 'x';
                one--;
            }

            if(zero == 0 && one == 0) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if(str[i] != 'x') sb.append(str[i]);
        }

        System.out.println(sb);
    }

}