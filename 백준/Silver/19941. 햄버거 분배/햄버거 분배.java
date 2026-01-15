import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        char [] str = br.readLine().toCharArray();
        
        int count = 0;
        for(int i=0;i<n;i++){
            if(str[i]!='P') continue;
            for(int x = i-k; x <= i+k; x++){
                if(x < 0 || x >= n) continue;
                if(str[x] == 'H'){
                    count++;
                    str[x] = 'X';
                    str[i] = 'X';
                    break;
                }
            }
        }
        
        System.out.println(count);
    }

}