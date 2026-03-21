 import java.io.*;
import java.util.*;

public class Main {
    static int n, t, p;

    static boolean [][] seats;

    static List<Reservation> reservations = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        seats = new boolean [n+1][time2minute("1200") + 1];

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();

            Reservation r = new Reservation(i, time2minute(start) - time2minute("0900"), time2minute(end) - time2minute("0900"));
            reservations.add(r);
        }

        Collections.sort(reservations, (a, b) -> {
            if (a.start == b.start) {
                return (a.end - a.start) - (b.end - b.start);
            }
            return a.start - b.start;
        });

        for(Reservation r : reservations){
            // System.out.println(r.start + " : " + r.end);
            selectseat(r);
        }

        int ans = 0;
        for(int i = 0; i < time2minute("1200"); i++){
            if(!seats[p][i]) ans++;
        }

        System.out.println(ans);
    }

    static void selectseat(Reservation r){
        int num = 0;
        int max = -1;
        for(int i = 1; i <= n; i++){
            if(seats[i][r.start]) continue;

            int temp = Integer.MAX_VALUE;
            for(int j = 1; j <= n; j++){
                if(seats[j][r.start]){
                    temp = Math.min(temp, Math.abs(i - j));
                }
            }

            if(temp == Integer.MAX_VALUE){
                num = 1;
                break;
            }

            if(max < temp){
                num = i;
                max = temp;
            }
        }
        for(int i = r.start; i < r.end; i++){
            seats[num][i] = true;
        }
    }
    
    static int time2minute(String str){
        int time = Integer.parseInt(str.substring(0, 2));
        int minute = Integer.parseInt(str.substring(2, 4));

        return time * 60 + minute;
    } 


    static class Reservation{
        int num;
        int start;
        int end;

        Reservation(int num, int start, int end){
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }
}
