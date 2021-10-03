package WB_TEST.oct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test1 {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(char[] arr) {
        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode t = arr[i] == ' ' ? null : new TreeNode(arr[i]);
        root = t;
        q.add(root);
        i++;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode t1 = q.poll();
            if (t1 != null) {
                t1.left = arr[i] == ' ' ? null : new TreeNode(arr[i]);
                q.add(t1.left);
                i++;
                if (i >= arr.length) {
                    break;
                }
                t1.right = arr[i] == ' ' ? null : new TreeNode(arr[i]);
                q.add(t1.right);
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        t.solution("ABCDEF");
    }
    public String solution(String messgae){
        String answer = "";
        StringBuilder st = new StringBuilder();
        TreeNode root  = buildTree(messgae.toCharArray());
        Stack<TreeNode> sta = new Stack<>();
        sta.add(root);
        while(!sta.isEmpty()){
            root = sta.peek();
            if(root.left == null && root.right == null){
                root = sta.pop();
                st.append(root.val);
                continue;
            }
            if(root.right != null){
                sta.add(root.right);
                root.right = null;
            }
            if(root.left != null) {
                sta.add(root.left);
                root.left = null;
            }

        }
        return st.toString();
    }
}