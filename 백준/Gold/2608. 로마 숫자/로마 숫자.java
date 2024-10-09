import java.util.*;

public class Main {
        static char [] n1, n2;
    static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);


        n1 = sc.next().toCharArray();
        n2 = sc.next().toCharArray();
        Integer answer = decode(n1) + decode(n2);
        System.out.println(answer);
        System.out.println(encode(answer));
    }

    static int Convert(char c){
       return map.get(c);
    }

    static String Convert(int n){
        for (Character c : map.keySet()) {
            //System.out.println(map.get(c));
            if (map.get(c) == n) {
                return c.toString();
            }
        }
        return "";
    }

    static int decode(char [] str){
        int result = 0;
        for (int i = 0; i < str.length;i++) {
            result +=  map.get(str[i]);
            if (i > 0 && map.get(str[i-1]) < map.get(str[i])) {
                result -= map.get(str[i-1]) * 2;
            }
        }
        return result;
    }

    static String encode(Integer n){
        String ans = "";
        while(n != 0){
            char [] str = n.toString().toCharArray();
            int ten_val = (int)Math.pow(10, str.length -1);
            int num = (int)str[0] - '0';
            if(num <= 3){
                for(int j = 0; j < num; j++)
                    ans += Convert(ten_val);
                n -= num * ten_val;
            }
            else if(num == 4 || num == 9){
                int temp = num * ten_val;
                ans += Convert(ten_val);
                ans += Convert(temp + ten_val);
                n -= temp;
            }
            else{
                ans += Convert(5 * ten_val);
                n -= 5 * ten_val;
            }
        }

        return ans;
    }
}