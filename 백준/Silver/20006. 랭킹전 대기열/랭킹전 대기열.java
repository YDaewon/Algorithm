import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<player>> play = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name =  st.nextToken();
            boolean flag = true;
            for(List<player> user : play){
                if(Math.abs(user.get(0).level - level) <= 10 && user.size() < m){
                    user.add(new player(level, name));
                    flag = false;
                    break;
                }
            }
            if(flag){
                List<player> user = new ArrayList<>();
                user.add(new player(level, name));
                play.add(user);
            }
        }

        for(List<player> user : play){
            Collections.sort(user);
            System.out.println( user.size() < m ? "Waiting!" : "Started!" );
            for(player pr : user){
                System.out.println(pr.level + " " + pr.name);
            }
        }
    }

    static class player implements Comparable<player>{
        int level;
        String name;
        player(int level, String name){
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(player o) {
            return this.name.compareTo(o.name);
        }
    }
}