import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int d = sc.nextInt();
        List<Boolean> sec = new ArrayList<Boolean>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < l; j++) { 
                sec.add(true);
            }
            
            if(i != n-1) { 
                for(int j = 0; j < 5; j++) {
                    sec.add(false);
                }
            }
        }
        
        int result = 0;
        while(result < sec.size()) { 
            if(sec.get(result) == false) {
                break;
            }
            result += d;    
        }
        System.out.println(result);
        
        
    }
 
}