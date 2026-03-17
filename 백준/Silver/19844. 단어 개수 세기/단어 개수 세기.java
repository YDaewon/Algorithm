 import java.io.*;
import java.util.*;

public class Main {
    static char [] str;
    static String [] word = {"c", "j", "n", "m", "t", "s", "l", "l", "d", "qu", "s"};
    static char [] check = {'a', 'e', 'i', 'o', 'u', 'h'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();

        int cnt = 1;
        String t = "";
        for (int i = 0; i < str.length; i++) {
            if(str[i] == '\''){
                boolean flag = false;
                for (char c : check) {
                    if(str[i+1] == c){
                        flag = true;
                    }
                }
                if(flag){
                    for(String s : word){
                        if(s.equals(t)){
                            cnt++;
                            break;
                        }
                    }
                }
            }
            else if(str[i] == '-' || str[i] == ' '){
                cnt++;
                t = "";
            }
            else{
                t += str[i];
            }

            //System.out.println(t + " cnt:" + cnt);
        }

        
        System.out.println(cnt);
    } 


}
