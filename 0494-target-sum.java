class Solution {
  
    
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        HashMap<Integer, Integer> tm = new HashMap<Integer, Integer>();
        
        tm.put(0, 1);
        
        for (int i = 0; i < n; i ++){
        
            //this temp map must be within the foor loop otherwise it will have concurrent exception
            HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();   
            
            for (Integer k : tm.keySet()) {
                
                int cnt = (int)tm.get(k);
            
                //on the same i, we will find multiple paths to the same key (what the question is about!), so add them up in the temp hashmap
                if(temp.containsKey(k+nums[i]))
                    temp.put(k+nums[i], temp.get(k+nums[i])+cnt);
                else 
                    temp.put(k+nums[i], cnt);
                
                if(temp.containsKey(k-nums[i]))
                    temp.put(k-nums[i], temp.get(k-nums[i])+cnt);
                else 
                    temp.put(k-nums[i], cnt);
                
            }
            tm = temp;
        }
        return tm.get(S) != null? tm.get(S) : 0;
        
    }
}
