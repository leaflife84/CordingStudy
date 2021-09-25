package LeetCode.recursion;

public class BuildListNode {
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }

  public ListNode buildList(Integer[] arr){
      return makeNode(arr,new ListNode(),0);
  }

  private ListNode makeNode(Integer[] arr, ListNode node, int i){
      if(i == arr.length){
          return node;
      }
      node = new ListNode();
      node.val = arr[i];
      node.next = makeNode(arr,node.next,i+1);
      return node;
  }
}
