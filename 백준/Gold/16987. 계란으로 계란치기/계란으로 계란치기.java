import java.util.Scanner;

public class Main {
	static Egg [] egg;
	static int n, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		egg = new Egg [n];
		ans = 0;
		for(int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int w = sc.nextInt();
			egg[i] = new Egg(s,w);
		}
		sol(0,0);
		System.out.println(ans);
	}
	private static void sol(int now, int cnt) {
		if(now == n) {
			ans = Math.max(ans, cnt);
			return;
		}
		if(egg[now].s <= 0 || cnt >= n-1) {
			sol(now+1, cnt);
			return;
		}
		
		int t = cnt;
		for(int i = 0; i < n; i++) {
			if(i == now) continue;
			if(egg[i].s <= 0) continue;
			Break(i, now);
			if(egg[i].s <= 0) cnt++;
			if(egg[now].s <= 0) cnt++;
			sol(now+1, cnt);
			rollback(i, now);
			cnt = t;
		}
	}
	
	static void Break(int a, int b) {
		egg[a].s -= egg[b].w;
		egg[b].s -= egg[a].w;
	}
	static void rollback(int a, int b) {
		egg[a].s += egg[b].w;
		egg[b].s += egg[a].w;
	}
	
	
	static class Egg{
		int s, w;
		Egg(int s, int w){
			this.s = s;
			this.w = w;
		}
	}
}
