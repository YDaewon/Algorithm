 import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        for (int i = 0; i < str.length; i++) {
            int t = str[i];
            if(t >= 'A' && t <= 'Z'){
                t = t - 'A' + 13;
                t %= 26;
                str[i] = (char)(t + 'A');
            }
            else if(t >= 'a' && t <= 'z'){
                t = t - 'a' + 13;
                t %= 26;
                str[i] = (char)(t + 'a');
            }
        }

        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
    }
}
