import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String [] snums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            snums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(snums, (s1, s2) -> (s2 + s1).compareTo(s1+s2));
        if(snums[0].equals("0")) return "0";
        for(String str : snums){
            answer += str;
        }
        return answer;
    }
}