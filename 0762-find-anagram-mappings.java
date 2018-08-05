class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            int num = B[i];
            if (!hm.containsKey(num)) hm.put(num, new ArrayList<Integer>());
            hm.get(num).add(i);
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = A[i];
            List<Integer> list = hm.get(num);
            result[i] = list.get(0);
            list.remove(0);
        }
        
        return result;
    }
}
