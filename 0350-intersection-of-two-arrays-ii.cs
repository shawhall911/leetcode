public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
        List<int> result = new List<int>();
            if (nums1 == null || nums2 == null || !nums1.Any() || !nums2.Any()) return result.ToArray();

            int[] smaller = nums1.Length <= nums2.Length ? nums1 : nums2;
            int[] bigger = nums1.Length > nums2.Length ? nums1 : nums2;

            Dictionary<int, int> map = new Dictionary<int, int>();
            foreach (int num in smaller)
            {
                if (!map.ContainsKey(num)) map.Add(num, 0);
                map[num]++;
            }

            foreach (int num in bigger)
            {
                if (map.ContainsKey(num) && map[num] > 0)
                {
                    result.Add(num);
                    map[num]--;
                }
            }

            return result.ToArray();
    }
}
