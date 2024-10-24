import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 기둥 개수
        int [] list = new int [1001];
        int maxX=0, maxH=0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int h = sc.nextInt();
            list[x] = h;
            if(maxH < h){
                maxX = x;
                maxH = h;
            }
        }

        Stack<Point> s = new Stack<>();
        int ans = list[maxX];
        for(int i = 0; i <= maxX; i++){
            if(list[i] == 0) continue;
            if(s.isEmpty()){
                s.push(new Point(i, list[i]));
                continue;
            }
            if(list[i] >= s.peek().h){
                ans += s.peek().h * (i - s.peek().x);
                //System.out.println(s.peek().x + " ~ " + i);
                s.push(new Point(i, list[i]));
            }
        }
        s = new Stack<>();
        for(int i = 1000; i >= maxX; i--){
            if(list[i] == 0) continue;
            if(s.isEmpty()){
                s.push(new Point(i, list[i]));
                continue;
            }
            if(list[i] >= s.peek().h){
                ans += s.peek().h * (s.peek().x - i);
                //System.out.println(i + " ~ " +s.peek().x);
                s.push(new Point(i, list[i]));
            }
        }
        System.out.println(ans);

    }
    static class Point{
        int h, x;
        Point(){
            h = 0;
            x = 0;
        }

        Point(int x, int h){
            this.x = x;
            this.h = h;
        }
    }

}

