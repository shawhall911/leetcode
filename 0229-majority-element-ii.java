class Solution {
    public List<Integer> majorityElement(int[] nums) {        
        int a0 = -1;
        int a1 = -1;
        int cnt0 = 0;
        int cnt1 = 0;      
        for (int num : nums) {
            if (num == a0) {
                cnt0++;
            } else if (num == a1) {
                cnt1++;
            } else if (cnt0 == 0) {
                a0 = num;
                cnt0++;
            } else if (cnt1 == 0) {
                a1 = num;
                cnt1++;
            } else {
                cnt0--;
                cnt1--;
            }
        }
        
        cnt0 = 0;
        cnt1 = 0;
        for (int num : nums) {
            if (num == a0) {
                cnt0++;
            } else if (num == a1) {
                cnt1++;
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        if (cnt0 > nums.length / 3)  res.add(a0);
        if (cnt1 > nums.length / 3)  res.add(a1);
        
        return res;
    }
}
