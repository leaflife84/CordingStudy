package LeetCode.recursion;


import java.util.Stack;

public class ReverseLinkedList extends BuildListNode {
    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode node = r.buildList(new Integer[]{1,2,3,4,5});
        ListNode result = r.reverseList(node);
    }
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.add(head);
            head = head.next;
        }
        ListNode node = new ListNode();
        return makeNode(stack);
    }

    public ListNode makeNode(Stack<ListNode> stack){
        if(stack.isEmpty()){
            return null;
        }
        ListNode node = stack.pop();
        node.next = makeNode(stack);
        return node;
    }
}
