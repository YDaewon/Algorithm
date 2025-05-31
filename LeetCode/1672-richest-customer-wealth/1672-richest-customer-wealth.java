import java.util.*;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for(int [] customer : accounts){
            int total = 0;
            for(int money : customer){
                total += money;
            }
            max = Math.max(total, max);
        }

        return max;
    }
}