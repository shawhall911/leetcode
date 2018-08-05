public class Solution {
    public int LongestSubstring(string s, int k) {
        int maxLen = 0;
            DoLongestSubstring(s, k, ref maxLen);
            return maxLen;
    }
    
    private static void DoLongestSubstring(string s, int k, ref int maxLen)
        {
            if (string.IsNullOrEmpty(s) || s.Length < k) return;

            Dictionary<char, int> map = new Dictionary<char, int>();
            foreach (char c in s)
            {
                if (!map.ContainsKey(c)) map.Add(c, 0);
                map[c]++;
            }

            List<char> separators = new List<char>();
            foreach (var pair in map)
            {
                if (pair.Value < k) separators.Add(pair.Key);
            }

            if (separators.Count == map.Count)
            {
                return;
            }
            else if (separators.Count == 0)
            {
                if (s.Length > maxLen) maxLen = s.Length;
            }
            else
            {
                string[] subs = s.Split(separators.ToArray());
                foreach (var sub in subs)
                {
                    DoLongestSubstring(sub, k, ref maxLen);
                }
            }
        }
}
