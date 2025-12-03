class Solution {
    public boolean canWinNim(int n) {
        int cnt = 0;
        while(n % 4 != 0){
            cnt++;
            n--;
        }
        //System.out.println(cnt);

        if(cnt == 0)return false;
        else return true;
    }
}