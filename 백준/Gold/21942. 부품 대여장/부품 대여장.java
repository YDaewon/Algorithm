 import java.io.*;
import java.util.*;

public class Main {
    static int n, f;
    static long ddd;
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        String DDD = st.nextToken();
        ddd = (Long.parseLong(DDD.substring(0, 3)) * 24 * 60)
        + (Long.parseLong(DDD.substring(4, 6)) * 60)
        + (Long.parseLong(DDD.substring(7, 9)));
        
        f = Integer.parseInt(st.nextToken());
        Map<String, Long> cost = new TreeMap<>();
        Map<String, Long> logs= new HashMap<>();
        for (int i = 0; i < n; i++) {
            // GROUP BY name, product
            String [] cmd = br.readLine().split(" ");
            
            String key = cmd[3] + "-" + cmd[2];

            long value = change_minute(cmd[0], cmd[1]);
            
            if(logs.containsKey(key)){
                long calc = value - logs.get(key);
                if(calc > ddd) {
                    cost.put(cmd[3], cost.getOrDefault(cmd[3], (long)0) + (calc - ddd) * f);
                }
                logs.remove(key);
            }
            else{
                logs.put(key, value);
            }     
        }

        StringBuilder sb = new StringBuilder();
        if(cost.size() == 0){
            sb.append(-1);
        }
        else{
            for(Map.Entry<String, Long> t : cost.entrySet()){
                sb.append(t.getKey() + " " + t.getValue() + "\n");
            }
        }

        System.out.println(sb);
    }
    
    

    static int[] monthes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    static long change_minute(String date, String time){
        String [] d = date.split("-");

        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);

        int month2day = day;
        for(int i = 1; i < month; i++) month2day += monthes[i];

        String [] t = time.split(":");
        
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);

        return month2day * 24 * 60 + (hour * 60) + minute;  
    }
}
