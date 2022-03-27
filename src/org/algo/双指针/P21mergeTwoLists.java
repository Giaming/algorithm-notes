package org.algo.双指针;

public class P21mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list2 != null) {
            list1 = list2;
        }
        cur.next = list1;
        return dummy.next;
    }
}
