class Solution {
    public int lengthOfLastWord(String s) {
        String [] temp = s.split(" ");
        for(int i = temp.length - 1; i >= 0; i--){
            if(!temp[i].equals("")) return temp[i].length();
        }
        return 0;
    }
}