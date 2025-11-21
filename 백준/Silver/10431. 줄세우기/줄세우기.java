import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());

        while(P-- > 0){
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int [] arr = new int[20];
            for (int i = 0; i < 20; i++) arr[i] = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int i = 0; i < 20; i++){
                for(int j = 0; j < i; j++){
                    if(arr[i] < arr[j]){
                        int temp = arr[i];
                        for(int k = i; k > j; k--){
                            arr[k] = arr[k-1];
                            cnt++;
                        }
                        arr[j] = temp;
                        break;
                    }
                }
//                System.out.print("for step " + i + ": ");
//                for(int t : arr) System.out.print(t + " ");
//                System.out.println();
            }
            System.out.println(T + " " + cnt);
        }
    }

}
