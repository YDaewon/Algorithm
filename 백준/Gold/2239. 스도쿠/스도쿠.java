import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static boolean [][] row, col, square;
	static int [][] board;
	public static void main(String[] args) {
		board = new int [10][10]; 
		row = new boolean [10][10]; 
		col = new boolean [10][10]; 
		square = new boolean [10][10]; 
		for(int i = 1 ; i <= 9; i++) {
			String t = sc.nextLine();
			for(int j = 1 ; j <= 9; j++) {
				board[i][j] = t.charAt(j-1) - '0';
				if(board[i][j] != 0) {
					int sq_num = (j-1)/3 + (3*((i-1)/3))+1;
					check_board(i, j, board[i][j], sq_num, true);
				}
			}
		}
		/*
		for(int i = 1 ; i <= 9; i++) {
			for(int j = 1 ; j <= 9; j++) {
				System.out.print(((j-1)/3 + (3*((i-1)/3))+1) + " ");
			}
			System.out.println();
		}*/
		
		sol(1,1);
	}
	private static void sol(int y, int x) {
		//System.out.println(y + ", " + x);
		if(x == 10) {
			y++;
			x = 1;
		}
		if(y == 10 && x == 1) {
			for(int i = 1 ; i <= 9; i++) {
				for(int j = 1 ; j <= 9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(board[y][x] == 0) {
			int sq_num = (x-1)/3 + (3*((y-1)/3))+1;
			for(int i = 1; i <= 9; i++) {
				if(!row[y][i] && !col[x][i] && !square[sq_num][i]) {
					check_board(y, x, i, sq_num, true);
					board[y][x] = i;
					sol(y, x+1);
					board[y][x] = 0;
					check_board(y, x, i, sq_num, false);
				}
			}
		}
		else {
			sol(y, x+1);
		}
	}
	
	static void check_board(int y, int x, int n, int sq, boolean check) {
		row[y][n] = check;
		col[x][n] = check;
		square[sq][n] = check;
	}
}
