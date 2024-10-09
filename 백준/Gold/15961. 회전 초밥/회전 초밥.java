import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt(); // 접시의 수
		int d = sc.nextInt(); // 초밥 종류
		int k = sc.nextInt(); // 접시 수
		int c = sc.nextInt(); // 쿠폰 번호
		Deque<Integer> dq = new ArrayDeque<>();
		int [] arr = new int [n];
		int [] check = new int[d+1];

		for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

		int ans = ++check[c];
		for(int i = 0; i < k; i++){
			if(check[arr[i]] == 0) ans++;
			check[arr[i]]++;
		}

		int cnt = ans;
		for(int i = 1; i <= n; i++) {
			int pop = arr[i-1];
			check[pop]--;
			if(check[pop] == 0) {
				cnt--;
			}

			int push = arr[(i+k-1) % n];
			if(check[push] == 0) cnt++;
			check[push]++;

			ans = Math.max(cnt, ans);
		}
		System.out.println(ans);
	}
}
