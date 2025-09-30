class Solution {
    List<List<Integer>> dp = new ArrayList<>();
    public List<Integer> getRow(int rowIndex) {
        for(int i = 0; i <= rowIndex; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) row.add(1);
                else{
                    int left = dp.get(i-1).get(j-1);
                    int right = dp.get(i-1).get(j);
                    row.add(left+right);
                }
            }
            dp.add(row);
        }

        return dp.get(rowIndex);
    }
}