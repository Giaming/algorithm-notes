package org.algo.双指针;

public class SwardOfferP22getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
