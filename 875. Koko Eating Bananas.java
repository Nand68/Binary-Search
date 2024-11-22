class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int low = 0;
        int high = piles[n-1];
        int min = high;

        while ( low <= high){
            int mid = ( high + low) / 2;
            int ans = check(piles,mid);
            if (ans <= h ){
                high = mid - 1;
            }else{
                low = mid + 1;
            }        
        }
        return low;
    }
    public int check(int[] v,int hourly){
        int totalH = 0;
        for ( int i = 0; i < v.length; i++){
           totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }

        return totalH;
    }
}
