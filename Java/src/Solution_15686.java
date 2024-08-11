//(x2-x1) + (y2 - y1) = 치킨 거리
// 치킨집은 많을수록 당연히 총 거리가 낮아짐
// M개 만큼 됐을 떄 거리 비교
// nCm 조합


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_15686 {
    static int n,m, answer = 99999999;
    static int [] com;
    static List<Pair15686> home, store;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        store = new ArrayList<>();
        com = new int[14];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    home.add(new Pair15686(i,j));
                }
                else if(temp == 2){
                    store.add(new Pair15686(i,j));
                }
            }
        }
        combination(0,0);
        System.out.println(answer);
    }
    static void combination(int d, int now){
        if(d == m){
            answer = Math.min(answer, siggas());
        }
        else {
            for(int i = now; i < store.size(); i++){
                if(com[i] == 0){
                    com[i] = 1;
                    combination(d+1, i);
                    com[i] = 0;
                }
            }
        }
    }
    static int siggas(){
        int sum = 0;
        for(int i = 0; i < home.size();i++){
            int value = 999999;
            for(int j = 0; j < store.size();j++){
                if(com[j] == 1){
                    value = Math.min(value, (Math.abs(home.get(i).y - store.get(j).y) + Math.abs(home.get(i).x - store.get(j).x)));
                }
            }
            sum += value;
        }
        return sum;
    }
}

class Pair15686{
    public int y, x;
    Pair15686(int y, int x){
        this.y = y;
        this.x = x;
    }
}