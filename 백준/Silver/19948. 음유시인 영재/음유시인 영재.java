import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] str = br.readLine().toCharArray();
        int space = Integer.parseInt(br.readLine());
        int [] alpha = new int [26];
        StringTokenizer st = new StringTokenizer((br.readLine()));
        
        for (int i = 0; i < 26; i++) {
            alpha[i] = Integer.parseInt(st.nextToken());
        }
        String answer = "";
        answer += (str[0] >= 'A' && str[0] <= 'Z') ? str[0] : (char)(str[0] - 32);
        int i = 0;
        while(i < str.length){
            if((str[i] >= 'A' && str[i] <= 'Z') && alpha[str[i] - 'A'] > 0){
                alpha[str[i] - 'A']--;
                int j = i + 1;
                while(j < str.length && str[i] == str[j]) j++;
                i = j - 1;
            } else if((str[i] >= 'a' && str[i] <= 'z') && alpha[str[i] - 'a'] > 0){
                alpha[str[i] - 'a']--;
                int j = i + 1;
                while(j < str.length && str[i] == str[j]) j++;
                i = j - 1;
            } else if(str[i] == ' ' && space > 0){
                space--;
                while(i < str.length && str[i] == ' ') i++;
                answer += (str[i] >= 'A' && str[i] <= 'Z') ? str[i] : (char)(str[i] - 32);
            } else{
                break;
            }
           //System.out.print(str[i]);
            i++;
        }

        for (int j = 0; j < answer.length(); j++) {
            char c = answer.charAt(j);
            if(alpha[c - 'A'] <= 0) {
                i = -1;
                break;
            }
        }
        if(i == str.length) System.out.println(answer);
        else System.out.println(-1);

    }
}
