import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Meat [] meat = new Meat[n];
		int weight = 0, cost = 0, b = 0, ans = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			meat[i] = new Meat(c, w);
		}
		Arrays.sort(meat);
//		for(Meat me : meat) {
//			System.out.println(me.cost + ", " + me.weight);
//		}
		boolean flag = true;
		for(int i = 0; i < n; i++) {
			weight += meat[i].weight;
			if(b == meat[i].cost) // 가격이 같으니 더한다
				cost += meat[i].cost;
			else {
				cost = meat[i].cost; // 다르면 b보다 현재 cost가 더 높음
				b = cost;
			}
			if(weight >= m) { // 무게는 이미 넘고, 더 싼방법이 있으면 갱신
				ans = Math.min(ans, cost);
				flag = false;
			}
		}
		System.out.println(flag ? -1 : ans);
	}
	
}

class Meat implements Comparable<Meat>{
	int weight, cost;
	Meat(int cost, int weight){
		this.cost = cost;
		this.weight = weight;
	}
	@Override
	public int compareTo(Meat o) {
		if(this.cost == o.cost) return o.weight - this.weight;
		return this.cost - o.cost;
	}
	
}

class comp implements Comparator<Meat>{
	@Override
	public int compare(Meat a, Meat b) {
		if(a.cost > b.cost) {
			return 1;
		}
		else if(a.cost < b.cost) {
			return 0;
		}
		else {
			if(a.weight <= b.weight) return 1;
			else return 0;
		}
	}
}