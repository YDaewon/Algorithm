class Solution {
    public String addBinary(String a, String b) {
        
        int aidx = a.length() - 1;
        int bidx = b.length() - 1;

        int t = 0;
        StringBuilder res = new StringBuilder();

        while(t > 0 || aidx >= 0 || bidx >= 0){
            if(aidx >= 0) t += a.charAt(aidx--) - '0';
            if(bidx >= 0) t += b.charAt(bidx--) - '0';
            res.append(t % 2);
            t /= 2;
        }

        return res.reverse().toString();
    }

    // long str2num(String s){
    //     long num = 0;
    //     int len = s.length();
    //     for(int i = len-1; i >= 0; i--){
    //         char c = s.charAt(i);
    //         if(c == '1'){
    //             num += Math.pow(2, len - i - 1);
    //         }
    //     }
    //     return num;
    // }
}