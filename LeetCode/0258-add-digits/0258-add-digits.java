class Solution {
    public int addDigits(int num) {
        int res = 0;
        while(true){
            res  += num % 10;
            num /= 10;
            if(num == 0){
                if(res > 9) {
                    num = res;
                    res = 0;
                }
                else{
                    break;
                }
            }
        }
        return res;
    }
}