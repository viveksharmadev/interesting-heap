// https://leetcode.com/problems/last-stone-weight/

class Solution {
    // tc -> nlogn, sc-> n
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        
        for(int stone : stones){
            pq.offer(stone);
        }
        
        while(!pq.isEmpty() && pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first-second);
        }
        
        return pq.peek();
    }
}
