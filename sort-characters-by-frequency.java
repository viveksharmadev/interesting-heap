// https://leetcode.com/problems/sort-characters-by-frequency/

class sort-characters-by-frequency {
    // tc -> nlogn, sc-> n
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i),0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq 
            = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(freqMap.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> e = pq.poll();
            for(int i=0; i<e.getValue(); i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
    
    // tc -> n sc-> n
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }
        
        List<Character>[] buckets = new ArrayList[s.length()+1];
        for(char c : freqMap.keySet()){
            int freq = freqMap.get(c);
            if(buckets[freq]==null){
                buckets[freq] = new ArrayList<Character>();
            }
            buckets[freq].add(c);
           //System.out.println("freq=> "+ freq + " c=> " + c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int pos = buckets.length-1; pos>=0; pos--){
            if(buckets[pos]!=null){
             int freq = pos;
                //System.out.println("buckets[pos]=> " + buckets[pos]);
                ///System.out.println("freq=> "+ freq);
            List<Character> list = buckets[pos];
            for(int i=0; i<list.size(); i++){
                for(int j=0; j<freq; j++)
                sb.append(list.get(i));
            }
          }
        }
        
        return sb.toString();
    }
}
