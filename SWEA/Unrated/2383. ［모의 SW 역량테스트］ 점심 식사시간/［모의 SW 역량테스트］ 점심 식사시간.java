import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Stair {
		int r, c, k;
		
		Stair(int r, int c, int k){
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}
	
	static class Person {
		int r, c;
		int arrive;
		int stair;
		int waitstair;
		
		Person(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		private void get_arrive() {
			this.arrive = Math.abs(r - stairs[stair].r) + Math.abs(c - stairs[stair].c);
		}
	}
	
	static Queue<Person> [] qarr;
	static ArrayList<Person> persons;
	static boolean [] visited;
	static Stair [] stairs;
	static int N, T, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			persons = new ArrayList<>();
			qarr = new LinkedList[2];
			qarr[0] = new LinkedList<>();
			qarr[1] = new LinkedList<>();
			stairs = new Stair[2];
			ans = Integer.MAX_VALUE;
			
			int idx = 0;
			
			for(int r = 1 ; r <= N ; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 1 ; c <= N ; c++) {
					int num = Integer.parseInt(st.nextToken()); 
					
					if(num == 0) {
						continue;
					}
					else if(num == 1) {
						persons.add(new Person(r, c));
					}
					else {
						stairs[idx++] = new Stair(r, c, num);
					}
				}
			}
			
			
			subset(0);
			
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void subset(int d) {
		
		if(d == persons.size()) {
			visited = new boolean[persons.size()];

			int cur = calc();
			
			ans = Math.min(ans, cur);
			return;
		}

		persons.get(d).stair = 0;
		persons.get(d).get_arrive();
		subset(d + 1);

		persons.get(d).stair = 1;
		persons.get(d).get_arrive();
		subset(d + 1);
	}

	private static int calc() {
		int cnt = 0;
		int time = 1;
		
		while(true) {
			for(Queue<Person> q : qarr) {
                int size = q.size();
				for(int i = 0; i < size; i++) {
					Person p = q.poll();
					if(p.waitstair + stairs[p.stair].k <= time) continue;
					q.offer(p);
				}
			}
			
			if(cnt == persons.size() && qarr[0].isEmpty() && qarr[1].isEmpty()) return time;


			for(int i = 0; i < persons.size(); i++) {
				if(visited[i]) continue;
				Person p = persons.get(i);
				Queue<Person> q = qarr[p.stair];
				if(p.arrive + 1 <= time && q.size() < 3) {
					p.waitstair = time;
					visited[i] = true;
					q.offer(p);
					cnt++;
				}
			}
			time++;
		}
	}
}