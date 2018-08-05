public class Solution {
    public int FourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Dictionary<int, int> map = new Dictionary<int, int>();
            for (int i = 0; i < A.Length; i++)
                for (int j = 0; j < B.Length; j++)
                {
                    int sum = A[i] + B[j];
                    if (!map.ContainsKey(sum)) map.Add(sum, 0);
                    map[sum]++;
                }

            int result = 0;
            for (int i = 0; i < C.Length; i++)
                for (int j = 0; j < D.Length; j++)
                {
                    int sum = 0 - (C[i] + D[j]);
                    if (map.ContainsKey(sum)) result += map[sum];
                }

            return result;
    }
}
