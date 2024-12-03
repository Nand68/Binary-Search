class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix[0].length-1;
        while ( high >= 0 && low < matrix.length){
            if (matrix[low][high] == target ){
                return true;
            }
            else if ( matrix[low][high] < target){
                low++;
            }
            else{
                high--;
            }
        }
        return false;
    }
}
