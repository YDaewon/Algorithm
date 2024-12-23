import java.io.*;
import java.util.*;


public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, 1);
        }

        for (int i = 0; i < m; i++) {
            String [] input = br.readLine().split(",");
            for(String str : input){
                if(map.containsKey(str)){
                    map.remove(str);
                    n--;
                }
            }
            System.out.println(n);
        }

    }
}