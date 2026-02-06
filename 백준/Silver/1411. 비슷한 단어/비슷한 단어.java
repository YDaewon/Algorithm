import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int len;
    static char [][] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        str = new char [n][50];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine().toCharArray();
        }
        len = str[0].length;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(similar(str[i], str[j])) {
                    // System.out.println("plus: " + new String(str[i]) + " , " + new String(str[j]));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean similar(char [] a, char [] b){
        Map<Character, Character> amap = new HashMap<>();
        boolean [] alpha = new boolean[27];
        for (int i = 0; i < len; i++) {
            if (!amap.containsKey(a[i]) && !alpha[b[i] - 'a']) {
                amap.put(a[i], b[i]);
                alpha[b[i] - 'a'] = true;
            }
        }

        for (int i = 0; i < len; i++) {
            if(!amap.containsKey(a[i])) return false;
            if(amap.get(a[i]) != b[i]){
                // System.out.println("return false!");
                return false;
            }
        }
        return true;
    }

}
