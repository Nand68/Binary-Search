class Solution {
    int median(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        
        // Find the range of possible values in the matrix
        for (int i = 0; i < rows; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][cols - 1]);
        }
        
        int required = (rows * cols) / 2; // Position of the median in a sorted matrix
        
        // Perform binary search for the median
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            
            // Count elements <= mid using upper bound
            for (int i = 0; i < rows; i++) {
                count += countSmallEqual(mat[i], mid);
            }
            
            // Adjust search range
            if (count <= required) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    // Helper method to count elements <= x in a row
    private int countSmallEqual(int[] row, int x) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
