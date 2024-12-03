class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int[] demo = {-1,-1};
        int high = mat[0].length-1;
        while ( low <= high){
            int mid = (low + high)/2;
            int y = findMax(mat,mid);
            int total = mat[y][mid];
            int left = mid - 1 >= 0 ? mat[y][mid-1] : -1;
            int right = mid + 1 < m ? mat[y][mid+1] : -1;
            if ( left < total && total > right){
                demo[0] = y;
                demo[1] = mid;
                return demo;
            }
            else if ( left > total){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
           
        }
         return demo;
    }
    public int findMax(int[][] mat,int mid){
        int max = Integer.MIN_VALUE;
        int indX = -1;
        for ( int i = 0; i < mat.length; i++){
            if ( mat[i][mid] > max){
                indX = i;
                max = mat[i][mid];
            }
        }
        return indX;
    }
}
