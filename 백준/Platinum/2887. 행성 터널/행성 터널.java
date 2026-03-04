 import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] p;
    static Planet [] planets;
    static List<int []> costs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        planets = new Planet[n];
        p = new int [n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }

        Arrays.sort(planets, (a, b) -> a.x - b.x);
        for (int i = 1; i < n; i++) {
            costs.add(new int [] {planets[i-1].num, planets[i].num, planets[i-1].get_dist(planets[i])});
        }
        Arrays.sort(planets, (a, b) -> a.y - b.y);
        for (int i = 1; i < n; i++) {
            costs.add(new int [] {planets[i-1].num, planets[i].num, planets[i-1].get_dist(planets[i])});
        }
        Arrays.sort(planets, (a, b) -> a.z - b.z);
        for (int i = 1; i < n; i++) {
            costs.add(new int [] {planets[i-1].num, planets[i].num, planets[i-1].get_dist(planets[i])});
        }

        Collections.sort(costs, (a,b) -> a[2] - b[2]);
        int ans = 0;

        for(int [] cur : costs){
            if(union(cur[0], cur[1])) continue;
            ans += cur[2];
        }
        System.out.println(ans);
    }

    static int find(int a){
        if(a == p[a]) return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return true;
        
        if(a < b) p[b] = a;
        else p[a] = b;
        return false;
    }

    static class Planet{
        int num;
        int x;
        int y;
        int z;
        Planet(int num, int x, int y, int z){
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        int get_dist(Planet p){
            return Math.min(Math.abs(this.x - p.x), Math.min(Math.abs(this.y - p.y), Math.abs(this.z - p.z)));
        }
    }

}
