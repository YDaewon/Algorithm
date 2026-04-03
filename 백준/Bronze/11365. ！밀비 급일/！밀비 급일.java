import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("END")) break;
            char [] temp = str.toCharArray();
            for (int i = temp.length - 1; i >= 0; i--) {
                sb.append(temp[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
