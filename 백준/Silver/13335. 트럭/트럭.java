import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 트럭 개수
        int w = sc.nextInt(); // 다리 길이
        int l = sc.nextInt(); // 다리 하중
        int [] truck = new int [n];
        for (int i = 0; i < n; i++) {
            truck[i] = sc.nextInt();
        }

        int ans = 0;
        int idx = 0;
        int truck_w = 0;
        int cnt = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        while(!bridge.isEmpty()){
            ans++;
            truck_w -= bridge.poll();
            if(idx == n) continue;

            if(truck_w + truck[idx] <= l){
                bridge.add(truck[idx]);
                truck_w += truck[idx++];
            }
            else{
                bridge.add(0);
            }
        }
        System.out.println(ans);
    }
}
