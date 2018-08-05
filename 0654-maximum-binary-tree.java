/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaxiBT(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaxiBT(int[] nums, int start, int end) {
        if (start > end) return null;
        
        int rootIndex = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                rootIndex = i;
                maxVal = nums[i];
            }
        }
        
        TreeNode node = new TreeNode(nums[rootIndex]);
        node.left = constructMaxiBT(nums, start, rootIndex - 1);
        node.right = constructMaxiBT(nums, rootIndex + 1, end);
        return node;
    }
}
