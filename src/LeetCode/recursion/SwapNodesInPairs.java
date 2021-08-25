package LeetCode.recursion;

import LeetCode.dfs.addTwoNum;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs a = new SwapNodesInPairs();

        ListNode node4 = new ListNode(4,null);
        ListNode node3= new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        a.swapPairs(node1);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        return swap(head, 0);
    }

    public ListNode swap(ListNode head, int i){
        if(head == null){
            return null;
        }
        ListNode node = swap(head.next, i+1);
        if(node != null && i%2 == 0){
            head.next = node.next;
            node.next = head;
            return node;
        }else if(node != null && i%2 == 1){
            head.next = node;
            return head;
        }
        return head;
    }
}
