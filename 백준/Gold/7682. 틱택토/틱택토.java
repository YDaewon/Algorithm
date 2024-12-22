import java.io.*;
import java.util.*;


public class Main {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[3][3];
        while(true){
            String str = br.readLine();
            int o = 0;
            int x = 0;
            if(str.equals("end")) break;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = str.charAt(3*i + j);
                    if(board[i][j] == 'X') x++;
                    if(board[i][j] == 'O') o++;
                }
            }
            if(x + o == 9 && x - o == 1){
                if(isEnd('X') && isEnd('O')) System.out.println("invalid");
                else if(isEnd('O')) System.out.println("invalid");
                else System.out.println("valid");
            }
            else {
                if(isEnd('X') && isEnd('O')) System.out.println("invalid");
                else if(isEnd('O') && x - o == 0) System.out.println("valid");
                else if(isEnd('X') && x - o == 1) System.out.println("valid");
                else System.out.println("invalid");
            }
        }
    }

    static boolean isEnd(char player){
        int row = 0;
        int col = 0;
        int dia = 0;
        if(board[0][0] == player && board[0][0] == board[1][1] && board[2][2] == board[0][0]) dia++;
        if(board[0][2] == player && board[0][2] == board[1][1] && board[0][2] == board[2][0]) dia++;
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == player && board[i][0] == board[i][1] && board[i][0] == board[i][2]) col++;
            if(board[0][i] == player && board[0][i] == board[1][i] && board[0][i] == board[2][i]) row++;
        }
        if(dia + col + row != 0 && col == 1 && row == 0){
            return true;
        }
        else if(dia + col + row != 0 && col == 0 && row == 1){
            return true;
        }
        else if(dia != 0) return true;
        return false;
    }

}