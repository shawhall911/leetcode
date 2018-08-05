class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        
        HashSet<Integer> hs1 = new HashSet<Integer>();
        for (int num : nums1) {
            if (!hs1.contains(num)) hs1.add(num);
        }
        
        HashSet<Integer> hs2 = new HashSet<Integer>();
        for (int num : nums2) {
            if (hs1.contains(num) && !hs2.contains(num)) hs2.add(num);
        }
        
        int[] res = new int[hs2.size()];
        Iterator<Integer> itr = hs2.iterator();
        int i = 0;
        while (itr.hasNext()) res[i++] = itr.next();
        return res;
    }
}
