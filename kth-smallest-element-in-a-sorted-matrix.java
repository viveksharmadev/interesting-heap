// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
class Solution {
   // tc -> m*n*logk, sc-> m*n
   public int kthSmallest(int[][] matrix, int k) {
       PriorityQueue<Integer> pq = 
           new PriorityQueue<>();
       for(int i=0; i<matrix.length; i++){
           for(int j=0; j<matrix[0].length; j++){
               pq.offer(matrix[i][j]);
           }
       }
       
       int res = 0;
       int count = 0;
       while(!pq.isEmpty() && count<k){
           res = pq.poll();
           count++;
       }
       
       return res;
   }
}

// Avoiding count variable
class Solution {
    // tc -> m*nlogk, sc-> m*n
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a-b));
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                pq.offer(matrix[i][j]);                
            }
        }
        
        while(!pq.isEmpty() && --k>0){
            pq.poll();
        }
        
        return pq.peek();
    }
}
