import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String str = br.readLine();
            char [] carr = str.toCharArray();
            if(str.equals("end")) break;
            boolean flag1 = false;
            boolean flag2 = true;
            boolean flag3 = true;
            
            int v = 0;
            int c = 0;

            for (int i = 0; i < carr.length; i++) {
                if(carr[i] == 'a' || carr[i] =='e' || carr[i] == 'i' || carr[i] == 'o' || carr[i] =='u'){
                    flag1 = true;
                    c++;
                    v = 0;
                }else{
                    c = 0;
                    v++;
                }
                if(v >= 3 || c >= 3) flag2 = false;

                if(i > 0){
                    if(carr[i-1] == carr[i] && carr[i] != 'e' && carr[i] != 'o') flag3 = false;
                }
            }


            if(flag1 && flag2 && flag3) System.out.println("<" + str + "> is acceptable.");
            else System.out.println("<" + str + "> is not acceptable.");
        }
    }

}
