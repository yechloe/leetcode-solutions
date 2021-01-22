
/* 
Add two int with digits in reverse order in node lists 
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
*/

/* Definition for singly-linked list.*/
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.val + l2.val);
        l1 = l1.next;
        l2 = l2.next;
        ListNode temp = result;
        while(l1!=null || l2!=null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(val1+val2);
            temp = temp.next;
        }
        
        temp = result;
        while(temp != null) {
            if (temp.val >= 10) {
                temp.val = temp.val - 10;
                if (temp.next != null) {
                    temp.next.val++;
                } else {
                    temp.next = new ListNode(1);
                }
            }
            temp = temp.next;
        }
        return result;
    }
}