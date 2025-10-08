class Solution {

    public String convertToTitle(int columnNumber) {
        StringBuilder a = new StringBuilder();

        while(columnNumber > 0){
            if(columnNumber % 26 == 0){
                a.append((char) ('Z'));
                columnNumber = columnNumber / 26 - 1;
            }
            else {
                a.append((char) ('A'+ columnNumber % 26 - 1));
                columnNumber /= 26;
            }
        }
        return a.reverse().toString();
    }
}