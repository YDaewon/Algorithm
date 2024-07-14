import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_12919 {
    static boolean ans = false;
    public static void mk_str(String s, String e){
        if(s.equals(e)) {
            ans = true;
            return;
        }
        else if (s.length() <= e.length() || ans){
            return;
        }
        else{

            if(s.charAt(s.length()-1) == 'A') {
                String nxt = s.substring(0, s.length()-1);
                //System.out.println(nxt);
                mk_str(nxt, e);
            }
            if(s.charAt(0) == 'B'){
                StringBuilder str = new StringBuilder(s);
                String nxt = str.deleteCharAt(0).reverse().toString();
                mk_str(nxt, e);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        mk_str(t, s);
        System.out.println(ans ? "1" : "0");
    }
}
