import java.util.*;

public class Solution_15666 {
    static int n;
    static int m;
    static int [] arr;
    static List<Integer> ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        sol(0,0);
    }

    static void sol(int depth, int now){
        if(depth == m){
            for (int i = m-1; i >= 0; i--) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
            return;
        }
        int temp = 0;
        for (int i = now; i < n; i++) {
            if(arr[i] != temp) {
                temp = arr[i];
                ans.add(0, arr[i]);
                sol(depth + 1, i);
                ans.remove(0);
            }
        }
    }
}
