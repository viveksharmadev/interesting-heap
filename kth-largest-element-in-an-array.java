// https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
    // tc -> nlogn, sc-> n
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        return nums[nums.length-k];
    }
}

class Solution {
    // tc -> nlogk, sc-> n
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq 
            = new PriorityQueue<>((a,b) -> (b-a));
        
        for(int num : nums) pq.offer(num);
        
        while(!pq.isEmpty() && --k > 0){
            pq.poll();
        }
        
        return pq.peek();
    }
}
