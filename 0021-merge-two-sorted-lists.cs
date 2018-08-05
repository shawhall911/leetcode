/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
       ListNode node = new ListNode(0);
            var head = node;
            while (l1 != null && l2 != null)
            {
                if (l1.val < l2.val)
                {
                    node.next = l1;
                    l1 = l1.next;
                }
                else
                {
                    node.next = l2;
                    l2 = l2.next;
                }
                node = node.next;
            }

            if (l1 != null) node.next = l1;
            else node.next = l2;

            return head.next;
    }
}
