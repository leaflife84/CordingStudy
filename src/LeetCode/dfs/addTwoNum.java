package LeetCode.dfs;

import java.math.BigInteger;

public class addTwoNum {

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

    public static void main(String[] args) {
        addTwoNum a = new addTwoNum();

        ListNode node3 = new ListNode(3,null);
        ListNode node4 = new ListNode(4,node3);
        ListNode node2 = new ListNode(2,node4);

        ListNode node5 = new ListNode(4,null);
        ListNode node6 = new ListNode(6,node5);
        ListNode node7 = new ListNode(5,node6);
        a.addTwoNumbers(node2,node7);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger number1 = new BigInteger(makeNumber(l1).toString());
        BigInteger number2 = new BigInteger(makeNumber(l2).toString());
        String result = String.valueOf(number1.add(number2));
        return makeNode(result,null,0);
    }

    public StringBuilder makeNumber(ListNode node){
        StringBuilder s = new StringBuilder();
        if(node == null){
            return s;
        }
        s.append(makeNumber(node.next));
        s.append(node.val);
        return s;

    }

    public ListNode makeNode(String s, ListNode n, int index){
        if(index == s.length()){
            return n;
        }
        int val = Integer.parseInt(String.valueOf(s.charAt(index)));
        if(n == null){
            ListNode node = new ListNode(val,null);
            return makeNode(s,node,index+1);
        }else{
            ListNode node = new ListNode(val,n);
            return makeNode(s,node,index+1);
        }
    }
}
