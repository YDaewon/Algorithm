package SWEA;

import java.util.Scanner;

public class Solution_1952 {
	static int ans;
	static int [] plan, cost;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T;t++) {
			cost = new int [4];
			for(int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}
			plan = new int [12];
			for(int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			ans = Integer.MAX_VALUE;
			find(0,0);
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void find(int d, int sum) {
		if(d >= 12) {
			ans = Math.min(sum,  ans);
			return;
		}
		if(ans <= sum) return; // 12���� �Ǳ����� �̹� ����� �ѱ�� ����
		if(plan[d] != 0) { // �̹��޿� �����ϴ� ���� ������ 4�� �̿���� cost�� ����
			find(d+1, sum + (plan[d] * cost[0]));
			find(d+1, sum + cost[1]);
			find(d+3, sum + cost[2]);
			if(d == 0) find(12, sum + cost[3]);
		}
        else {
			find(d+1, sum); // �ش���� �����ϴ� ���� ������ �����޷� �̵�
		}
	}

}
