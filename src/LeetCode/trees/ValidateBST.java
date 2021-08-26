package LeetCode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(Integer[] arr) {
        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode t = arr[i] == null ? null : new TreeNode(arr[i]);
        root = t;
        q.add(root);
        i++;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode t1 = q.poll();
            if (t1 != null) {
                t1.left = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.left);
                i++;
                if (i >= arr.length) {
                    break;
                }
                t1.right = arr[i] == null ? null : new TreeNode(arr[i]);
                q.add(t1.right);
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ValidateBST v = new ValidateBST();
        TreeNode root = v.buildTree(new Integer[]{
                0,null,-1});
        System.out.println(v.isValidBST(root));

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max){
        if (root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }

        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }


}
