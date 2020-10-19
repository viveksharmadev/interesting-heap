// https://leetcode.com/problems/k-closest-points-to-origin/
class Solution {
   // tc-> n(quick select), sc-> k
  public int[][] kClosest(int[][] points, int K) {
   int len =  points.length, l = 0, r = len - 1;
   while (l <= r) {
       int mid = helper(points, l, r);
       if (mid == K) break;
       if (mid < K) {
           l = mid + 1;
       } else {
           r = mid - 1;
       }
   }
   return Arrays.copyOfRange(points, 0, K);
}

private int helper(int[][] A, int l, int r) {
   int[] pivot = A[l];
   while (l < r) {
       while (l < r && compare(A[r], pivot) >= 0) r--;
       A[l] = A[r];
       while (l < r && compare(A[l], pivot) <= 0) l++;
       A[r] = A[l];
   }
   A[l] = pivot;
   return l;
}

private int compare(int[] p1, int[] p2) {
   return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
}
}
 
class Solution {
   // tc -> nlogk, sc-> n
   public int[][] kClosest(int[][] points, int K) {
       int n = points.length;
       PriorityQueue<int[]> heap = new PriorityQueue<>(
           new Comparator<int[]>(){
               @Override
               public int compare(int[] a, int[] b){
                   return getDist(a) - getDist(b);
               }
           }
       );
       
       for(int[] point : points){
           heap.offer(point);            
       }
       
       List<int[]> res = new ArrayList<>();
       while(!heap.isEmpty() && res.size()<K){
           res.add(heap.poll());
       }
       
       return res.toArray(new int[][]{});
   }
   
   private int getDist(int[] point){
       return point[0]*point[0] + point[1]*point[1];
   }
}

// Not Optimized but another solution

class Solution {
    // tc -> nlogn, sc-> n
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, 
                    (p1, p2) -> (getDist(p1) - getDist(p2)));
        
        
        List<int[]> result = new LinkedList<>();
        
        for(int i=0; i<points.length && K-- >0; i++){
            result.add(points[i]);
        }
        
        return result.toArray(new int[][]{});
    }
    
    private int getDist(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}

