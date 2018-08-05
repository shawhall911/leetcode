/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<int> InorderTraversal(TreeNode root) {
        List<int> result = new List<int>();
        
            //DoInorderTraversal(root, result);
        
            Stack<TreeNode> stack = new Stack<TreeNode>();
            var node = root;
            while (true)
            {
                while (node != null)
                {
                    stack.Push(node);
                    node = node.left;
                }

                if (stack.Count == 0) break;
                node = stack.Pop();
                result.Add(node.val);
                node = node.right;
            }

            return result;
    }
    
     private static void DoInorderTraversal(TreeNode node, List<int> result)
        {
            if (node == null) return;
            DoInorderTraversal(node.left, result);
            result.Add(node.val);
            DoInorderTraversal(node.right, result);
        }
}
