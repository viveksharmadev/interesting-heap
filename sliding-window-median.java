// https://leetcode.com/problems/sliding-window-median/
class Solution {
    // tc -> nk (because of remove method), sc-> n
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n-k+1];
        PriorityQueue<Integer> low = new PriorityQueue<>((a,b)->b.compareTo(a));
        PriorityQueue<Integer> high = new PriorityQueue<>();
        
        int j = 0;
        for(int i=0; i<n; i++){
            low.offer(nums[i]);
            high.offer(low.peek());
            low.poll();
            if(low.size()<high.size()){
                low.offer(high.peek());
                high.poll();
            }
            if(low.size()+high.size()==k){
                res[j] = low.size()==high.size() 
                    ? ((long)low.peek() + (long)high.peek())/2.0
                    : (double)low.peek();
                if(!low.remove(nums[j])){
                    high.remove(nums[j]);
                }
                j++;
            }
        }
        return res;
    }
}
