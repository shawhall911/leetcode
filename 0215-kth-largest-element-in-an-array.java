class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            int index = patitionKth(nums, start, end);
            if (index == k - 1) return nums[index];
            else if (index < k - 1) start = index + 1;
            else end = index - 1;
        }
    }
    
    private static int patitionKth(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start + 1;
        int j = end;
        while (i < j) {
            while (i < j && nums[j] <= pivot) j--;
            while (i < j && nums[i] > pivot) i++;
            if (i < j) swap(nums, i, j);
        }
        if (nums[start] < nums[j]) {
            swap(nums, j, start);
            return j;
        } else {
            return start;
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
