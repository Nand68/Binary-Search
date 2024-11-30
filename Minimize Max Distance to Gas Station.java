// using priority queue
class Solution {
    
    public static double findSmallestMaxDist(int arr[], int k) {
        
        int n = arr.length; // size of array.
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        // insert the first n-1 elements into pq
        // with respective distance values:
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        // Pick and place k gas stations:
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            // Find the maximum section
            // and insert the gas station:
            Pair tp = pq.poll();
            int secInd = tp.second;

            // insert the current gas station:
            howMany[secInd]++;

            double inidiff = arr[secInd + 1] - arr[secInd];
            double newSecLen = inidiff / (double) (howMany[secInd] + 1);
            pq.add(new Pair(newSecLen, secInd));
        }

        return pq.peek().first;
    }
    
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

// using binary search

class Solution {
    public static double findSmallestMaxDist(int arr[], int k) {
        double low = 0;
        double high = arr[arr.length-1] - arr[0];
        double ans = 0;
        while ( low <= high){
            double mid = ( high + low) / 2;

            if (check(arr,k,mid)){
                ans = mid;
                high = mid-0.000001;
            }
            else{
                low = mid+0.000001;
            }
        }
        return ans;
    }
    
    public static boolean check(int[] arr,int k , double mid){
        int count = 0;
        for ( int i = 1; i < arr.length; i++){
            double dif = arr[i] - arr[i-1];
            if ( dif > mid){
                count +=  (int) dif / mid;
            }
        }
        if ( count > k){
            return false;
        }
        return true;
    }
}
