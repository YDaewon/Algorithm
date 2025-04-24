import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        for(int h = 3; h <= brown - 2; h++){
            int w = (brown - 2*h) / 2 + 2;
            
            int need_yellow = h * w - brown;
            if(yellow == need_yellow){
                answer[0] = Math.max(h,w);
                answer[1] = Math.min(h,w);
            }
        }
        return answer;
    }
}

// 갈색: 테두리 1줄(3, 5, 7, 9, ... 총길이 / 2까지 대충?)
// 노란색: 나머지