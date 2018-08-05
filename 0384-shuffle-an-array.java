class Solution {
    private int[] original;
    
    public Solution(int[] nums) {
      this.original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
      return this.original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
      int[] res = this.original.clone();
      int len = res.length;
      Random random = new Random();
      for (int i = 0; i < len; ++i) {
        Double rand = random.nextDouble() * (len - i);
        int t = i + rand.intValue();
        swap(res, i, t);
      }
      return res;
    }
    
    private static void swap(int[] res, int i, int t) {
        int tmp = res[i];
        res[i] = res[t];
        res[t] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
