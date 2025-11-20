import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] triangle = new int[3];
            for (int i = 0; i < 3; i++) triangle[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(triangle);
            if(triangle[2] == 0) break;
            int result = 0;

            if(triangle[0] == triangle[1]) result++;
            if(triangle[1] == triangle[2]) result++;
            if(triangle[2] >= triangle[0] + triangle[1]) result = -1;

            if(result == 2) System.out.println("Equilateral");
            else if(result == 1) System.out.println("Isosceles");
            else if(result == 0) System.out.println("Scalene");
            else System.out.println("Invalid");
        }
    }
}
