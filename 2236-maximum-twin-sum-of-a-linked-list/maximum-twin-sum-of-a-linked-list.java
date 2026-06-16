/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int pairSum(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead = reverseLL(slow);

        ListNode temp= head;
        ListNode temp2= revHead;
        int maxSum =Integer.MIN_VALUE;

        while(temp != null && temp2!=null){
            int sum = temp.val + temp2.val;

            if(sum > maxSum) maxSum = sum;

            temp = temp.next;
            temp2 = temp2.next;
        }

        return maxSum;
    }

    ListNode reverseLL(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode newHead = reverseLL(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
