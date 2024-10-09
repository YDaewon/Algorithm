import java.util.Scanner;

public class Main{
	static int [][] score = new int[6][3];
	static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			int sum = 0;
			flag = false;
			for(int j = 0; j < 6; j++) {
				sum += score[j][0] = sc.nextInt(); // win
				sum += score[j][1] = sc.nextInt(); // draw
				sum += score[j][2] = sc.nextInt(); // lose
			}
			if(sum==30) sol(0,0, 1);
			System.out.print((flag ? 1: 0) + " ");
		}
	}
	
	static void sol(int depth, int team, int i) {
		if(flag) return;
		for (int j = 0; j < 3; j++) {
			if(score[team][j] < 0 | score[team+i-1][j] < 0) return;
		}
		if(depth == 15) {
			flag = true;
			return;
		}
		if(depth == 5) {
			team++;
			i=1;
		}
		else if(depth == 9) {
			team++;
			i=1;
		}
		else if(depth == 12) {
			team++;
			i=1;
		}
		else if(depth == 14) {
			team++;
			i=1;
		}

		score[team][0]--; score[team+i][2]--;
		sol(depth+1, team, i+1);
		score[team][0]++; score[team+i][2]++;
		score[team][1]--; score[team+i][1]--;
		sol(depth+1, team, i+1);
		score[team][1]++; score[team+i][1]++;
		score[team][2]--; score[team+i][0]--;
		sol(depth+1, team, i+1);
		score[team][2]++; score[team+i][0]++;
	}
}
