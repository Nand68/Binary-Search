class Solution {
    public static int findPages(int[] arr, int k) {
        int m = k;
        int n = arr.length;
        
        if (m > n)
            return -1;
            
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        int low = max;
        int high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public static int countStudents(int[] arr,int pages){
        int n = arr.length; 
        int students = 1;
        long pagesStudent = 0;
        for  ( int i = 0;  i< n; i ++){
            if (pagesStudent + arr[i] <= pages) {
                // add pages to current student
                pagesStudent += arr[i];
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr[i];
            }
        }
        return students;
    }
}
