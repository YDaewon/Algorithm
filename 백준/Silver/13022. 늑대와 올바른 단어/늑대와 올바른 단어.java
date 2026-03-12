 import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] str = br.readLine().toCharArray();
        
        int i = 0;
        while(i < str.length) {
            if(str[i] != 'w'){
                System.out.println(0);
                return;
            }

            int t = 0; // n
            while(i + t < str.length && 'w' == str[i + t]){ // w
                t++;
            }

            char [] wolf = {'w', 'o', 'l', 'f'};
            for(char c : wolf){
                for (int j = 0; j < t; j++) {
                    int cur = i + j;
                    if(cur >= str.length || str[cur] != c) {
                        System.out.println(0);
                        return;
                    }
                }
                i += t;
            }
        }
        System.out.println(1);
    }   

}
