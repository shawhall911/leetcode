class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 1) return 0;
        int f = 1; //keep the next place to be filled

        int cur = nums[0]; //keep the number so we can find next different
        for(int i = 1; i < len; i ++){
            
            if(nums[i] != cur ) { //found a diff num
            //move
            if (f != i) nums[f] = nums[i];                  
            cur = nums[i];
            f ++;
            }  
        }
        return f;
    }
}
//test cases:
//1, 1, 2 --> 1, 2
//1, 2, 3, 4 -->pass
//1, 2, 2, 3 -->pass
//0, 0, 1, 1, 2, 3 --> pass
