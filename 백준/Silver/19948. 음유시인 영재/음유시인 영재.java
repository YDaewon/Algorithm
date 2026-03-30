 import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] str = br.readLine().toCharArray();

        int space = Integer.parseInt(br.readLine());

        int [] alpha = new int[26];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 26; i++) {
            alpha[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        String title = "";
        if(str[0] >= 'a') title += (char)(str[0] - 'a' + 'A');
        else title += str[0];

        while(idx < str.length) {
            char now = str[idx];
            if(now >= 'a' && now <= 'z' && alpha[now - 'a'] > 0){
                alpha[now - 'a']--;
                while(idx < str.length && now == str[idx]) idx++;
            }
            else if(now == ' ' && space > 0){
                space--;
                while(idx < str.length && now == str[idx]) idx++;
                
                if(str[idx] >= 'a') title += (char)(str[idx] - 'a' + 'A');
                else title += str[idx];
            }
            else if(now >= 'A' && now <= 'Z' && alpha[now - 'A'] > 0){
                alpha[now - 'A']--;
                while(idx < str.length && now == str[idx]) idx++;
            }
            else{
                break;
            }
        }

        for (int j = 0; j < title.length(); j++) {
            char c = title.charAt(j);
            if(alpha[c - 'A'] <= 0) {
                idx = -1;
                break;
            }
        }

        System.out.println(idx == str.length ? title : - 1);
    }


}
