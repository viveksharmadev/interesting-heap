// https://leetcode.com/problems/task-scheduler/

class Solution {
    // tc -> nlogn, sc-> n
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap 
            = new HashMap<>();
        
        for(char c : tasks)
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        
        PriorityQueue<Integer> pq 
            = new PriorityQueue<>((a, b) -> (b-a));
        pq.addAll(freqMap.values());
        
        int result = 0;
        while(!pq.isEmpty()){
            
            List<Integer> tempList = new LinkedList<>();
            
            int timer = 0;
            
            for(int i=0; i<n+1 && !pq.isEmpty(); i++){
                tempList.add(pq.poll()-1);
                timer++;
            }
            
            for(int t : tempList){
                if(t > 0) pq.offer(t);
            }
            
            result += pq.isEmpty() ? timer : n+1;
        }
        
        
        return result;
    }
}
