import java.io.*;
import java.util.*;

public class Main {
    static char [][][] cube;

    static void init_cube(){
        cube = new char [6][3][3];
        char [] color = {'w', 'y' , 'r', 'o', 'g', 'b'};

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cube[i][j][k] = color[i];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            init_cube();
            for (int i = 0; i < n; i++) {
                rotate(st.nextToken());
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(cube[0][j][2-i]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void cmd(int f, int u, int l, int d, int r, int direct){ // p: 위치, d: 시계: 0, 반시계: 1
        char[][] tmp = new char[3][3];
        char[] tmp2 = new char[3];
        
        if (direct == 0) {
            for (int i=0; i<3; ++i)
                for (int j=0; j<3; ++j) {
                    tmp[i][j] = cube[f][2-j][i];
                }
            for (int i=0; i<3; ++i)
                tmp2[i] = cube[u][i][0];
            for (int i=0; i<3; ++i)
                cube[u][i][0] = cube[l][0][2-i];
            for (int i=0; i<3; ++i)
                cube[l][0][2-i] = cube[d][2][i];
            for (int i=0; i<3; ++i)
                cube[d][2][i] = cube[r][2-i][2];
            for (int i=0; i<3; ++i)
                cube[r][2-i][2] = tmp2[i];
        }
        else {
            for (int i=0; i<3; ++i)
                for (int j=0; j<3; ++j) {
                    tmp[i][j] = cube[f][j][2-i];
                }
            for (int i=0; i<3; ++i)
                tmp2[i] = cube[u][i][0];
            for (int i=0; i<3; ++i)
                cube[u][i][0] = cube[r][2-i][2];
            for (int i=0; i<3; ++i)
                cube[r][2-i][2] = cube[d][2][i];
            for (int i=0; i<3; ++i)
                cube[d][2][i] = cube[l][0][2-i];
            for (int i=0; i<3; ++i)
                cube[l][0][2-i] = tmp2[i];
        }
        cube[f] = tmp;
    }

    static void rotate(String str) {
        char [] c = str.toCharArray();
        int d = c[1] == '+' ? 0 : 1;
        int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
        
        switch (str.charAt(0)) {
        case 'U': cmd(U, L, F, R, B, d); break;
        case 'D': cmd(D, B, R, F, L, d); break;
        case 'F': cmd(F, U, L, D, R, d); break;
        case 'B': cmd(B, R, D, L, U, d); break;
        case 'L': cmd(L, F, U, B, D, d); break;
        case 'R': cmd(R, D, B, U, F, d); break;
        }
    }
}
