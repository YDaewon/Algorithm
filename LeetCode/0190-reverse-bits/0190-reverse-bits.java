class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int t = (n & (1 << i)) == 0 ? 0 : 1;
            System.out.print(t);
            if(t != 0) res |= (1 << 31 - i);
        }
        return res;
    }
}