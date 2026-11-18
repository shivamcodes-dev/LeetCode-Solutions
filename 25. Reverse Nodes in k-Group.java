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
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode temp = head;
      int c = 0;
        while(c < k ){
            if(temp == null) return head;
            c++;
            temp = temp.next;
        }
        ListNode preNode = reverseKGroup(temp, k); 
        temp = head;
        c = 0;
        while(c<k){
            ListNode upcome = temp.next;
            temp.next = preNode;
            preNode = temp;
            temp = upcome;
            c++;
        }
        return preNode;
    }
}