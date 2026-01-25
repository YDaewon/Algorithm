import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String [] strs = new String[n];
        Map<Character, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
            if(!map.containsKey(strs[i].charAt(0))) map.put(strs[i].charAt(0), new ArrayList<>());
            map.get(strs[i].charAt(0)).add(strs[i]);
        }

        String S = "";
        String T = "";
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String start = strs[i];
            int len1 = start.length();
            for(String str : map.get(start.charAt(0))){
                if(str.equals(start)) continue;
                int len2 = str.length();
                int len = Math.min(len1, len2);
                for (int j = 0; j < len; j++) {
                    if(start.charAt(j) != str.charAt(j)) break;
                    if(cnt < j+1){
                        S = start;
                        T = str;
                        cnt = j+1;
                        //System.out.println("갱신: " + S + ", " + T + ", cnt: " + cnt);
                    }
                }
            }
        }
        System.out.println(S);
        System.out.println(T);
    }
}